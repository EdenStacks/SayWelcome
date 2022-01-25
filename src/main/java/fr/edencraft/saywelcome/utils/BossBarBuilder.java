package fr.edencraft.saywelcome.utils;

import org.bukkit.Bukkit;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;

public class BossBarBuilder {

	private String message;
	private BarColor color;
	private BarStyle barStyle;


	/**
	 * Build a {@link BossBarBuilder} and call {@link BossBarBuilder#build()} to create a {@link BossBar}.
	 *
	 * @param message is the title of the {@link BossBar}.
	 * @param barColor {@link BarColor} of the {@link BossBar}.
	 * @param barStyle {@link BarStyle} of the {@link BossBar}.
	 */
	public BossBarBuilder(String message, BarColor barColor, BarStyle barStyle) {
		this.message = message;
		this.color = barColor;
		this.barStyle = barStyle;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setColor(BarColor color) {
		this.color = color;
	}

	public void setBarStyle(BarStyle barStyle) {
		this.barStyle = barStyle;
	}

	public String getMessage() {
		return message;
	}

	public BarColor getColor() {
		return color;
	}

	public BarStyle getBarStyle() {
		return barStyle;
	}

	/**
	 * @return a {@link BossBar}.
	 */
	public BossBar build() {
		return Bukkit.getServer().createBossBar(this.message, this.color, this.barStyle);
	}
}
