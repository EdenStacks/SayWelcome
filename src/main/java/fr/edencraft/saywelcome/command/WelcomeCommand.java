package fr.edencraft.saywelcome.command;

import co.aikar.commands.BaseCommand;
import fr.edencraft.saywelcome.SayWelcome;
import fr.edencraft.saywelcome.lang.Language;
import fr.edencraft.saywelcome.manager.ConfigurationManager;

public class WelcomeCommand extends BaseCommand {

	private final static Language LANGUAGE = SayWelcome.getINSTANCE().getLanguage();
	private final static ConfigurationManager CM = SayWelcome.getINSTANCE().getConfigurationManager();

	private static final String basePermission = "saywelcome.command";

}
