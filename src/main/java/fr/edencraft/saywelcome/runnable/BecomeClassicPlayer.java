package fr.edencraft.saywelcome.runnable;

import fr.edencraft.saywelcome.SayWelcome;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.scheduler.BukkitRunnable;

public class BecomeClassicPlayer extends BukkitRunnable {

	private final NewPlayer newPlayer;

	public BecomeClassicPlayer(NewPlayer newPlayer) {
		this.newPlayer = newPlayer;
	}

	public void run() {
		if (!newPlayer.getPlayer().isOnline() || !SayWelcome.getINSTANCE().getNewPlayers().contains(newPlayer)) return;

		SayWelcome.getINSTANCE().getNewPlayers().remove(newPlayer);
	}

}
