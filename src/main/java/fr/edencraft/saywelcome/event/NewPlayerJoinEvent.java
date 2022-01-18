package fr.edencraft.saywelcome.event;

import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

/**
 * It is simply a {@link org.bukkit.event.player.PlayerJoinEvent} but only for {@link org.bukkit.entity.Player} that
 * join for the first time.
 */
public class NewPlayerJoinEvent extends Event {

	private static final HandlerList handlers = new HandlerList();

	private final NewPlayer newPlayer;

	/**
	 * Build a {@link NewPlayerJoinEvent}.
	 *
	 * @param newPlayer {@link NewPlayer}
	 */
	public NewPlayerJoinEvent(NewPlayer newPlayer) {
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
