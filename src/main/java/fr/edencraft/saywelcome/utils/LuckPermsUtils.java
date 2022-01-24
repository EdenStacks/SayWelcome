package fr.edencraft.saywelcome.utils;

import fr.edencraft.saywelcome.SayWelcome;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.group.Group;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.InheritanceNode;
import net.luckperms.api.node.types.SuffixNode;
import org.bukkit.entity.Player;

import java.util.concurrent.TimeUnit;

public class LuckPermsUtils {

    private static final LuckPerms luckPermsAPI = SayWelcome.getINSTANCE().getLuckPermsAPI();

    public static boolean addPlayerGroup(Player player, String groupName) {
        if (!checkGroupExist(groupName)) return false;

        Group group = luckPermsAPI.getGroupManager().getGroup(groupName);
        luckPermsAPI.getUserManager().modifyUser(player.getUniqueId(), user -> {

            Node node = InheritanceNode.builder(group).build();
            user.data().add(node);
        });

        return true;
    }

    public static void removePlayerGroup(Player player, String groupName) {
        if (!checkGroupExist(groupName)) return;

        Group group = luckPermsAPI.getGroupManager().getGroup(groupName);
        luckPermsAPI.getUserManager().modifyUser(player.getUniqueId(), user -> {
            Node node = InheritanceNode.builder(group).build();
            user.data().remove(node);
        });
    }

    public static void addPlayerSuffix(Player player, String suffix, int priority) {
        luckPermsAPI.getUserManager().modifyUser(player.getUniqueId(), user -> {
            SuffixNode suffixNode = SuffixNode.builder(suffix, 0).build();
            suffixNode = suffixNode.toBuilder().expiry(120, TimeUnit.SECONDS).build();

            user.data().add(suffixNode);
        });
    }

    public static void removePlayerSuffix(Player player, String suffix) {
        luckPermsAPI.getUserManager().modifyUser(player.getUniqueId(), user -> {
            user.getNodes(NodeType.SUFFIX).forEach(suffixNode1 -> {
                if (suffixNode1.getMetaValue().equalsIgnoreCase(suffix)) {
                    user.data().remove(suffixNode1);
                }
            });
        });
    }

    public static boolean checkGroupExist(String groupName) {
        return luckPermsAPI.getGroupManager().getGroup(groupName) != null;
    }

}
