package fr.edencraft.saywelcome.lang;


import fr.edencraft.saywelcome.utils.ColoredText;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.entity.Player;

import java.util.Arrays;
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
				"&Welcome &e" + newPlayersString + " &fhave fun on &dEden&eCraft&f.",
				"&fHey &e" + newPlayersString + " &fwelcome on &dEden&eCraft&f.",
				"&e" + newPlayersString + " &fgood game on &dEden&eCraft&f.",
				"&fHello &e" + newPlayersString + " &fhappy to see new heads !"
		);

		strings = strings.stream().map(s -> new ColoredText(s).treat()).toList();
		return strings;
	}

}
