package fr.edencraft.saywelcome.command;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import fr.edencraft.saywelcome.SayWelcome;
import fr.edencraft.saywelcome.lang.Language;
import fr.edencraft.saywelcome.manager.ConfigurationManager;
import fr.edencraft.saywelcome.utils.ColoredText;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

@CommandAlias("welcome|bienvenue|b")
public class WelcomeCommand extends BaseCommand {

	private final static Language LANGUAGE = SayWelcome.getINSTANCE().getLanguage();
	private final static ConfigurationManager CM = SayWelcome.getINSTANCE().getConfigurationManager();

	private static final String basePermission = "saywelcome.command";

	@Default
	@CommandPermission(basePermission + ".welcome")
	public void onWelcome(Player player) {
		List<NewPlayer> newPlayers = SayWelcome.getINSTANCE().getNewPlayers();

		if (newPlayers.isEmpty()) {
			player.sendMessage(new ColoredText(
					"&cIl n'y a aucun nouveau joueur à qui souhaiter la bienvenue."
			).treat());
			return;
		}

		if (!hasNewInNewPlayers(player, newPlayers)) {
			player.sendMessage(new ColoredText(
					"&cTu as déjà dit bienvenue à tous les nouveaux joueurs."
			).treat());
			return;
		}

		List<String> playersName = new ArrayList<>();

		newPlayers.stream()
				.filter(newPlayer -> !newPlayer.getPlayersSaidWelcome().contains(player))
				.forEach(newPlayer -> {
					newPlayer.addPlayerSaidWelcome(player);
					newPlayer.sendActionBar(
							new ColoredText(player.getName() + " t'as souhaité la bienvenue !").treat()
					);
					newPlayer.updateBossBar();
					playersName.add(newPlayer.getPlayer().getName());
				});

		player.sendMessage(new ColoredText(
				"&aTu as souhaité la bienvenue à &e" + playersName.size() + "&a joueur(s)."
		).treat());
	}

	/**
	 * This method is used to determine if a {@link Player} can said welcome to a {@link NewPlayer} present in a
	 * list of {@link NewPlayer}.
	 *
	 * @param player Player who try to said welcome to a newPlayer.
	 * @param newPlayers List all of {@link NewPlayer}.
	 * @return true if player has not said welcome to one of {@link NewPlayer} in newPlayers else false.
	 */
	private boolean hasNewInNewPlayers(Player player, List<NewPlayer> newPlayers) {
		return newPlayers.stream().anyMatch(
				newPlayer -> !newPlayer.getPlayersSaidWelcome().contains(player)
				&& !newPlayer.getPlayer().equals(player)
		);
	}

}
