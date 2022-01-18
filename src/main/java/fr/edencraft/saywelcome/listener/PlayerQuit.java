package fr.edencraft.saywelcome.listener;

import fr.edencraft.saywelcome.SayWelcome;
import fr.edencraft.saywelcome.event.NewPlayerQuitEvent;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.List;

public class PlayerQuit implements Listener {

	@EventHandler
	public void onPlayerQuitEvent(PlayerQuitEvent event) {
		List<NewPlayer> newPlayers = SayWelcome.getINSTANCE().getNewPlayers();

		newPlayers
				.stream()
				.filter(newPlayer1 -> newPlayer1.getPlayer().equals(event.getPlayer()))
				.findFirst()
				.ifPresent(newPlayer -> Bukkit.getPluginManager().callEvent(new NewPlayerQuitEvent(newPlayer)));

	}

}
