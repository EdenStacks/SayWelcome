package fr.edencraft.saywelcome.filler;

import fr.edencraft.saywelcome.utils.CFGFiller;
import org.bukkit.configuration.file.FileConfiguration;

public class ConfigFiller implements CFGFiller {

    @Override
    public void fill(FileConfiguration fileConfiguration) {
        fileConfiguration.set("language", "fr");
    }

}
