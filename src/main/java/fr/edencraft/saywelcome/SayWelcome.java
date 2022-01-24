package fr.edencraft.saywelcome;

import fr.edencraft.saywelcome.lang.Language;
import fr.edencraft.saywelcome.manager.CommandManager;
import fr.edencraft.saywelcome.manager.ConfigurationManager;
import fr.edencraft.saywelcome.manager.ListenerManager;
import fr.edencraft.saywelcome.runnable.BecomeClassicPlayer;
import fr.edencraft.saywelcome.utils.ColoredText;
import fr.edencraft.saywelcome.utils.ConfigurationUtils;
import fr.edencraft.saywelcome.utils.NewPlayer;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

public final class SayWelcome extends JavaPlugin {

	// VAR
	private final List<NewPlayer> newPlayers = new ArrayList<>();

	// PLUGIN PREFIX
	private final String pluginPrefix = new ColoredText("&dEden&eWelcome &f&l» &r").treat();

	// MANAGER
	private ConfigurationManager configurationManager;

	// API
	private LuckPerms luckPermsAPI;

	// INSTANCE
	private static SayWelcome INSTANCE;

	@Override
	public void onEnable() {

		long delay = System.currentTimeMillis();

		INSTANCE = this;

		RegisteredServiceProvider<LuckPerms> provider = Bukkit.getServicesManager().getRegistration(LuckPerms.class);
		if (provider != null) {
			luckPermsAPI = provider.getProvider();
		}

		this.configurationManager = new ConfigurationManager(this);
		this.configurationManager.setupFiles();

		new CommandManager(this);
		new ListenerManager(this);

		log(Level.INFO, "SayWelcome enabled. (took " + (System.currentTimeMillis() - delay) + "ms)");
	}

	@Override
	public void onDisable() {
		configurationManager.saveFiles();
	}

	public void log(Level level, String message) {
		Bukkit.getLogger().log(level, "[" + getPlugin(SayWelcome.class).getName() + "] " + message);
	}

	public static SayWelcome getINSTANCE() {
		return INSTANCE;
	}

	public String getPluginPrefix() {
		return pluginPrefix;
	}

	public ConfigurationManager getConfigurationManager() {
		return configurationManager;
	}

	public Language getLanguage() {
		return (Language) ConfigurationUtils.getLanguage();
	}

	public List<NewPlayer> getNewPlayers() {
		return newPlayers;
	}

	public LuckPerms getLuckPermsAPI() {
		return luckPermsAPI;
	}
}
