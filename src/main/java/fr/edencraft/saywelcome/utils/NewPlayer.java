package fr.edencraft.saywelcome.utils;

import fr.edencraft.saywelcome.SayWelcome;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

/**
 * <h1>What is a {@link NewPlayer} ?</h1>
 * <p>
 *     A {@link NewPlayer} is a {@link Player} that have never played on the server.<br>
 *     It is defined by his :
 *     <ul>
 *         <li>instance of {@link Player}</li>
 *         <li>date of (first) join</li>
 *     </ul>
 * </p>
 */
public class NewPlayer {

	private final Player player;
	private final long joinDate;

	private final List<Player> playersSaidWelcome;
	private BossBar bossBar;
	private boolean hasBossBarInit;

	/**
	 * To build a {@link NewPlayer} you must use {@link NewPlayer#getFrom} method.
	 *
	 * @param player {@link Player} instance of the {@link NewPlayer}.
	 */
	private NewPlayer(Player player) {
		this.player = player;
		this.joinDate = System.currentTimeMillis();
		this.playersSaidWelcome = new ArrayList<>();
		this.hasBossBarInit = false;
		this.bossBar = null;
	}

	public long getJoinDate() {
		return joinDate;
	}

	public List<Player> getPlayersSaidWelcome() {
		return playersSaidWelcome;
	}

	public void addPlayerSaidWelcome(Player player) {
		playersSaidWelcome.add(player);
	}

	public Player getPlayer() {
		return player;
	}

	/**
	 * Get a {@link NewPlayer} from a {@link Player}.<br>
	 * The return value is null if the given player has played before.
	 *
	 * @param player {@link Player}
	 * @return {@link NewPlayer}
	 */
	@Nullable
	public static NewPlayer getFrom(Player player) {
		if (player.hasPlayedBefore()) return null;
		return new NewPlayer(player);
	}

	/**
	 * Send a message in  {@link net.md_5.bungee.api.ChatMessageType#ACTION_BAR} of the {@link NewPlayer}.
	 *
	 * @param message The message to send. <b>Colors are not treated here !</b>
	 */
	public void sendActionBar(String message) {
		player.spigot().sendMessage(
				ChatMessageType.ACTION_BAR,
				TextComponent.fromLegacyText(message)
		);
	}

	/**
	 * Call this method to init the player {@link BossBar}.
	 * It required before use {@link NewPlayer#updateBossBar()}.
	 */
	public void initBossBar() {
		if (hasBossBarInit) return;

		hasBossBarInit = true;

		bossBar = new BossBarBuilder(
				SayWelcome.getINSTANCE().getLanguage().getBossBarTitle(playersSaidWelcome),
				BarColor.GREEN,
				BarStyle.SOLID
		).build();

		bossBar.setProgress(getProgress() / 100);
		bossBar.addPlayer(player);

		new BossBarRunnable(this)
				.runTaskTimerAsynchronously(SayWelcome.getINSTANCE(), 0, 1);
	}

	/**
	 * Update {@link BossBar} of the {@link NewPlayer}.
	 */
	public void updateBossBar() {
		if (!hasBossBarInit) return;
		bossBar.setTitle(SayWelcome.getINSTANCE().getLanguage().getBossBarTitle(playersSaidWelcome));

		bossBar.setProgress(getProgress() / 100);
		bossBar.setColor(getBarColor(getProgress()));
	}

	/**
	 * Remove the {@link BossBar} for the {@link NewPlayer}.
	 */
	public void removeBossBar() {
		bossBar.removeAll();
		hasBossBarInit = false;
	}

	/**
	 * @param progress progression before be no more considered as a {@link NewPlayer}.
	 * @return a BarColor.
	 */
	private BarColor getBarColor(double progress) {
		BarColor barColor;

		if (progress <= 25) {
			barColor = BarColor.GREEN;
		} else if (progress <= 50) {
			barColor = BarColor.YELLOW;
		} else if (progress <= 75) {
			barColor = BarColor.PINK;
		} else if (progress <= 100) {
			barColor = BarColor.RED;
		} else {
			barColor = BarColor.WHITE;
		}

		return barColor;
	}

	/**
	 * @return percentage before {@link NewPlayer} become a classic {@link Player}.
	 */
	private double getProgress() {
		return (double) (100 * ((System.currentTimeMillis() - joinDate)) / 120000);
	}

	/**
	 * This runnable update the {@link BossBar} of a {@link NewPlayer}.<br>
	 * If {@link NewPlayer#hasBossBarInit} is false, it will stop the runnable.
	 */
	private static class BossBarRunnable extends BukkitRunnable {

		private final NewPlayer newPlayer;

		public BossBarRunnable(NewPlayer newPlayer) {
			this.newPlayer = newPlayer;
		}

		@Override
		public void run() {
			if (!newPlayer.hasBossBarInit) {
				cancel();
				return;
			}
			newPlayer.updateBossBar();
		}

	}

}
