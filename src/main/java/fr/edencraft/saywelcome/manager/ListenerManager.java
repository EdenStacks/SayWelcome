package fr.edencraft.saywelcome.manager;

import fr.edencraft.saywelcome.listener.*;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {

    public ListenerManager(Plugin plugin) {

        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerJoin(), plugin);
        pm.registerEvents(new PlayerQuit(), plugin);
        pm.registerEvents(new NewPlayerJoin(), plugin);
        pm.registerEvents(new NewPlayerQuit(), plugin);
    }
}
