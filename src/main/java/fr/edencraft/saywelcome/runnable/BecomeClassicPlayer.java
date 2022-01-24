package fr.edencraft.saywelcome.runnable;

import fr.edencraft.saywelcome.SayWelcome;
import fr.edencraft.saywelcome.utils.LuckPermsUtils;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.scheduler.BukkitRunnable;

public class BecomeClassicPlayer extends BukkitRunnable {

	private final NewPlayer newPlayer;

	public BecomeClassicPlayer(NewPlayer newPlayer) {
		this.newPlayer = newPlayer;
	}

	public void run() {
		if (!newPlayer.getPlayer().isOnline() || !SayWelcome.getINSTANCE().getNewPlayers().contains(newPlayer)) return;

		LuckPermsUtils.removePlayerSuffix(newPlayer.getPlayer(), " &#ff5cc3&lNEW");
		newPlayer.removeBossBar();
		SayWelcome.getINSTANCE().getNewPlayers().remove(newPlayer);
	}

}
