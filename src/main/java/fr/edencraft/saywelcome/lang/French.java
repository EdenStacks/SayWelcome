package fr.edencraft.saywelcome.lang;

import fr.edencraft.saywelcome.utils.ColoredText;
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


}
