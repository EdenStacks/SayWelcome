package fr.edencraft.saywelcome.utils;

import fr.edencraft.saywelcome.SayWelcome;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.SuffixNode;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

/**
 * {@link LuckPermsUtils} lists all useful methods related to {@link LuckPerms}.
 */
public class LuckPermsUtils {

    private static final LuckPerms luckPermsAPI = SayWelcome.getINSTANCE().getLuckPermsAPI();

    /**
     * This method add to a {@link Player} a {@link SuffixNode} temporally.
     *
     * @param player to add a {@link SuffixNode}.
     * @param suffix value of the suffix to add to the {@link Player}.
     * @param expiry time before the {@link SuffixNode} expire.
     * @param unit the {@link TimeUnit} of expiry value.
     * @param priority the {@link SuffixNode} priority.
     */
    public static void addPlayerExpirySuffix(Player player, String suffix, long expiry, TimeUnit unit, int priority) {
        luckPermsAPI.getUserManager().modifyUser(player.getUniqueId(), user -> {
            SuffixNode suffixNode = SuffixNode.builder(suffix, 0).build();
            suffixNode = suffixNode.toBuilder().expiry(120, TimeUnit.SECONDS).build();

            user.data().add(suffixNode);
        });
    }

    /**
     * This method remove a {@link SuffixNode} depending on the value of the suffix.
     *
     * @param player to remove a {@link SuffixNode}
     * @param suffix value of the suffix.
     */
    public static void removePlayerSuffix(Player player, String suffix) {
        luckPermsAPI.getUserManager().modifyUser(player.getUniqueId(), user -> {
            user.getNodes(NodeType.SUFFIX).forEach(suffixNode1 -> {
                if (suffixNode1.getMetaValue().equalsIgnoreCase(suffix)) {
                    user.data().remove(suffixNode1);
                }
            });
        });
    }

}
