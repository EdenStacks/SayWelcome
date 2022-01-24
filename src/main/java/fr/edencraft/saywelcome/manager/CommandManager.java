package fr.edencraft.saywelcome.manager;

import co.aikar.commands.PaperCommandManager;
import fr.edencraft.saywelcome.command.SayWelcomeCommand;
import fr.edencraft.saywelcome.command.WelcomeCommand;
import org.bukkit.plugin.Plugin;

public class CommandManager {

    public CommandManager(Plugin plugin) {
        PaperCommandManager commandManager = new PaperCommandManager(plugin);
        commandManager.enableUnstableAPI("help");
        commandManager.registerCommand(new WelcomeCommand());
    }

}
