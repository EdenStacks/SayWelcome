package fr.edencraft.saywelcome.listener;

import fr.edencraft.saywelcome.SayWelcome;
import fr.edencraft.saywelcome.event.NewPlayerJoinEvent;
import fr.edencraft.saywelcome.runnable.BecomeClassicPlayer;
import fr.edencraft.saywelcome.utils.LuckPermsUtils;
import fr.edencraft.saywelcome.utils.NewPlayer;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.concurrent.TimeUnit;

public class NewPlayerJoin implements Listener {

	@EventHandler
	public void onNewPlayerJoinEvent(NewPlayerJoinEvent event) {
		NewPlayer newPlayer = event.getNewPlayer();

		LuckPermsUtils.addPlayerExpirySuffix(
				newPlayer.getPlayer(),
				" &#ff5cc3&lNEW",
				120,
				TimeUnit.SECONDS,
				0
		);
		newPlayer.initBossBar();

		Firework firework = (Firework) newPlayer.getPlayer().getLocation().getWorld()
				.spawnEntity(newPlayer.getPlayer().getLocation(), EntityType.FIREWORK);
		firework = customFirework(firework);
		firework.detonate();

		BecomeClassicPlayer becomeClassicPlayer = new BecomeClassicPlayer(newPlayer);
		becomeClassicPlayer.runTaskLaterAsynchronously(SayWelcome.getINSTANCE(), 20 * 120);

		SayWelcome.getINSTANCE().getNewPlayers().add(newPlayer);
	}

	/**
	 * @param firework firework to custom.
	 * @return customized firework.
	 */
	private Firework customFirework(Firework firework) {
		FireworkMeta fwm = firework.getFireworkMeta();
		FireworkEffect.Builder builder = FireworkEffect.builder();
		fwm.addEffect(builder.flicker(true).withColor(Color.FUCHSIA).build());
		fwm.addEffect(builder.trail(true).build());
		fwm.addEffect(builder.withFade(Color.YELLOW).build());
		fwm.addEffect(builder.with(FireworkEffect.Type.BURST).build());
		fwm.setPower(30);
		firework.setFireworkMeta(fwm);

		return firework;
	}

}
