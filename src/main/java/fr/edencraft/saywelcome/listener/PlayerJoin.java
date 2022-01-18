package fr.edencraft.saywelcome.listener;

import fr.edencraft.saywelcome.event.NewPlayerJoinEvent;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent event) {
		if (event.getPlayer().hasPlayedBefore()) return;

		NewPlayer newPlayer = NewPlayer.getFrom(event.getPlayer());
		if (newPlayer == null) return;

		NewPlayerJoinEvent newPlayerJoinEvent = new NewPlayerJoinEvent(newPlayer);
		Bukkit.getPluginManager().callEvent(newPlayerJoinEvent);
	}

}
