package fr.edencraft.saywelcome.event;

import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * It is simply a {@link org.bukkit.event.player.PlayerQuitEvent} but only for {@link org.bukkit.entity.Player} that
 * had joined for the first time.
 */
public class NewPlayerQuitEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private final NewPlayer newPlayer;

	/**
	 * Build a {@link NewPlayerQuitEvent}.
	 *
	 * @param newPlayer {@link NewPlayer}
	 */
	public NewPlayerQuitEvent(NewPlayer newPlayer) {
		this.newPlayer = newPlayer;
	}

	public static HandlerList getHandlerList() {
		return handlers;
	}

	@Override
	public @NotNull HandlerList getHandlers() {
		return handlers;
	}

	public NewPlayer getNewPlayer() {
		return newPlayer;
	}
}
