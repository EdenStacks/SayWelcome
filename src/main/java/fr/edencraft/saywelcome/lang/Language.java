package fr.edencraft.saywelcome.lang;

import fr.edencraft.saywelcome.SayWelcome;
import fr.edencraft.saywelcome.utils.NewPlayer;
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

    /**
     * This message is called when a {@link Player} try to run
     * {@link fr.edencraft.saywelcome.command.WelcomeCommand#onWelcome(Player)} while there are no
     * {@link fr.edencraft.saywelcome.utils.NewPlayer}
     *
     * @return The message in a specific language.
     */
    String getNoNewPlayerToSayWelcome();

    /**
     * This message is called when a {@link Player} already said welcome to all
     * {@link fr.edencraft.saywelcome.utils.NewPlayer}.
     *
     * @return The message in a specific language.
     */
    String getAlreadySaidWelcomeToAll();

    /**
     * This message is called when a {@link NewPlayer} receive a welcome from a {@link Player}.
     *
     * @param playerSaidWelcome the player that said welcome.
     * @return The message in a specific language.
     */
    String getNewPlayerReceiveWelcome(Player playerSaidWelcome);

    /**
     * This message is called when a {@link Player} said welcome.
     *
     * @param playerSaidWelcome the player that said welcome.
     * @param newPlayersWelcomed list of {@link NewPlayer} that has been welcomed by playerSaidWelcome.
     * @return The message in a specific language.
     */
    String getPlayerSaidWelcomeWithSuccess(Player playerSaidWelcome, List<NewPlayer> newPlayersWelcomed);

    /**
     * Those messages are called when a player chat welcome message.
     *
     * @param player who said welcome.
     * @param newPlayers list of {@link NewPlayer} that has been welcomed by playerSaidWelcome.
     * @return The message in a specific language.
     */
    List<String> getPlayerWelcomeMessages(Player player, List<NewPlayer> newPlayers);
}
