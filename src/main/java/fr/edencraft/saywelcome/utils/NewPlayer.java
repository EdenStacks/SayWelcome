package fr.edencraft.saywelcome.utils;

import org.bukkit.entity.Player;
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

	/**
	 * To build a {@link NewPlayer} you must use {@link NewPlayer#getFrom} method.
	 *
	 * @param player {@link Player} instance of the {@link NewPlayer}.
	 */
	private NewPlayer(Player player) {
		this.player = player;
		this.joinDate = System.currentTimeMillis();
		this.playersSaidWelcome = new ArrayList<>();
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

}
