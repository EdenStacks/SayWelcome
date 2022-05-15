package fr.edencraft.saywelcome.lang;

import fr.edencraft.saywelcome.utils.ColoredText;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class French implements Language {


	@Override
	public String getBossBarTitle(List<Player> playersSaidWelcome) {
		return new ColoredText(
				"&f&l» &6" + playersSaidWelcome.size() + " &#f948ffjou&#fa57eaeur&#fa66d4s t&#fa75bf'on&#fb84aat s&#fb9395ouh" +
						"&#fca180ait&#fdb06aé l&#fdbf55a b&#fdce40ien&#fedd2bven&#feec15ue &#fffb00! &f&l«"
		).treat();
	}

	@Override
	public String getNoNewPlayerToSayWelcome() {
		return prefix + new ColoredText(
				"&cIl n'y a aucun nouveau joueur à qui souhaiter la bienvenue."
		).treat();
	}

	@Override
	public String getAlreadySaidWelcomeToAll() {
		return prefix + new ColoredText(
				"&cTu as déjà dit bienvenue à tous les nouveaux joueurs."
		).treat();
	}

	@Override
	public String getNewPlayerReceiveWelcome(Player playerSaidWelcome) {
		return prefix + new ColoredText(
				"&d" + playerSaidWelcome.getName() + " &et'as souhaité la bienvenue !"
		).treat();
	}

	@Override
	public String getPlayerSaidWelcomeWithSuccess(Player playerSaidWelcome, List<NewPlayer> newPlayersWelcomed) {
		return prefix + new ColoredText(
				"&aTu as souhaité la bienvenue à &e" + newPlayersWelcomed.size() + "&a joueur(s)."
		).treat();
	}

	@Override
	public List<String> getPlayerWelcomeMessages(Player player, List<NewPlayer> newPlayers) {
		StringBuilder stringBuilder = new StringBuilder();
		if (newPlayers.size() == 1) {
			stringBuilder.append(newPlayers.get(0).getPlayer().getName());
		} else {
			for (int i=0; i < newPlayers.size(); i++) {
				if (i+1 == newPlayers.size()) {
					stringBuilder.append(" & " + newPlayers.get(i).getPlayer().getName());
				} else {
					stringBuilder.append(newPlayers.get(i).getPlayer().getName());
					if (i+2 != newPlayers.size()) {
						stringBuilder.append(", ");
					}
				}
			}
		}
		String newPlayersString = stringBuilder.toString();

		List<String> strings = Arrays.asList(
				"&fBienvenu &e" + newPlayersString + " &famusez vous bien sur &dEden&eCraft&f.",
				"&fHey &e" + newPlayersString + " &fbienvenu sur &dEden&eCraft&f.",
				"&e" + newPlayersString + " &fbon jeu sur &dEden&eCraft&f.",
				"&fHello &e" + newPlayersString + " &fcontent de voir de nouvelles têtes !"
		);

		strings = strings.stream().map(s -> new ColoredText(s).treat()).toList();
		return strings;
	}
}
