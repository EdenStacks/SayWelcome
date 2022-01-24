package fr.edencraft.saywelcome.lang;

import fr.edencraft.saywelcome.SayWelcome;
import org.bukkit.entity.Player;

import java.util.List;

public interface Language {

    String prefix = SayWelcome.getINSTANCE().getPluginPrefix();

    /**
     * This message is called when a {@link org.bukkit.boss.BossBar} is displayed/updated
     * for a {@link fr.edencraft.saywelcome.utils.NewPlayer}.
     *
     * @param playersSaidWelcome list of all players that said welcome
     *                           the {@link fr.edencraft.saywelcome.utils.NewPlayer}.
     * @return The message in a specific language.
     */
    String getBossBarTitle(List<Player> playersSaidWelcome);

}
