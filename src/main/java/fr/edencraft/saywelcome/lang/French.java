package fr.edencraft.saywelcome.lang;

import fr.edencraft.saywelcome.utils.ColoredText;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.entity.Player;

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
}
