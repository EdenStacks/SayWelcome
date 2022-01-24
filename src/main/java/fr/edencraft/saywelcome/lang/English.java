package fr.edencraft.saywelcome.lang;


import fr.edencraft.saywelcome.utils.ColoredText;
import org.bukkit.entity.Player;

import java.util.List;

public class English implements Language {

	@Override
	public String getBossBarTitle(List<Player> playersSaidWelcome) {
		return new ColoredText(
				"&f&l» &6" + playersSaidWelcome.size() + " &esaid &dwelcome &e! &f&l«"
		).treat();
	}
}
