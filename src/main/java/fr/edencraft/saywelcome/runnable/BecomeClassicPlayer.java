package fr.edencraft.saywelcome.runnable;

import fr.edencraft.saywelcome.SayWelcome;
import fr.edencraft.saywelcome.utils.LuckPermsUtils;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * This runnable need to be run 120 seconds after (or before as you want) a {@link fr.edencraft.saywelcome.event.NewPlayerJoinEvent} to
 * do all actions that will make him become a classic {@link org.bukkit.entity.Player}.
 */
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
