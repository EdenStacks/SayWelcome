package fr.edencraft.saywelcome.listener;

import fr.edencraft.saywelcome.event.NewPlayerQuitEvent;
import fr.edencraft.saywelcome.runnable.BecomeClassicPlayer;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class NewPlayerQuit implements Listener {

	@EventHandler
	public void onNewPlayerQuitEvent(NewPlayerQuitEvent event) {
		NewPlayer newPlayer = event.getNewPlayer();

		BecomeClassicPlayer becomeClassicPlayer = new BecomeClassicPlayer(newPlayer);
		becomeClassicPlayer.run();
	}

}
