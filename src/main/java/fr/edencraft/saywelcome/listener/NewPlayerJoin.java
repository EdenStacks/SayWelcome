package fr.edencraft.saywelcome.listener;

import fr.edencraft.saywelcome.SayWelcome;
import fr.edencraft.saywelcome.event.NewPlayerJoinEvent;
import fr.edencraft.saywelcome.runnable.BecomeClassicPlayer;
import fr.edencraft.saywelcome.utils.LuckPermsUtils;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NewPlayerJoin implements Listener {

	@EventHandler
	public void onNewPlayerJoinEvent(NewPlayerJoinEvent event) {
		NewPlayer newPlayer = event.getNewPlayer();

		LuckPermsUtils.addPlayerSuffix(newPlayer.getPlayer(), " &#ff5cc3&lNEW", 0);
		newPlayer.initBossBar();
		BecomeClassicPlayer becomeClassicPlayer = new BecomeClassicPlayer(newPlayer);
		becomeClassicPlayer.runTaskLaterAsynchronously(SayWelcome.getINSTANCE(), 20 * 120);

		SayWelcome.getINSTANCE().getNewPlayers().add(newPlayer);
	}

}
