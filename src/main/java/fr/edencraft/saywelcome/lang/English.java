package fr.edencraft.saywelcome.lang;


import fr.edencraft.saywelcome.utils.ColoredText;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.entity.Player;

import java.util.List;

public class English implements Language {

	@Override
	public String getBossBarTitle(List<Player> playersSaidWelcome) {
		return new ColoredText(
				"&f&l» &6" + playersSaidWelcome.size() + " &esaid &dwelcome &e! &f&l«"
		).treat();
	}

	@Override
	public String getNoNewPlayerToSayWelcome() {
		return prefix + new ColoredText(
				"&cThere are no new player to say welcome."
		).treat();
	}

	@Override
	public String getAlreadySaidWelcomeToAll() {
		return prefix + new ColoredText(
				"&cYou have already said welcome to all new players."
		).treat();
	}

	@Override
	public String getNewPlayerReceiveWelcome(Player playerSaidWelcome) {
		return prefix + new ColoredText(
				"&d" + playerSaidWelcome.getName() + " &ewelcomed you !"
		).treat();
	}

	@Override
	public String getPlayerSaidWelcomeWithSuccess(Player playerSaidWelcome, List<NewPlayer> newPlayersWelcomed) {
		return prefix + new ColoredText(
				"&aYou welcomed &e" + newPlayersWelcomed.size() + "&a player(s)."
		).treat();
	}
}
