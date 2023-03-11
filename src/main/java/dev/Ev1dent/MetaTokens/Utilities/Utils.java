package dev.Ev1dent.MetaTokens.Utilities;

import dev.Ev1dent.MetaTokens.MTMain;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.MetaNode;
import net.luckperms.api.node.types.PrefixNode;
import net.luckperms.api.node.types.SuffixNode;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.Map;

public class Utils {

    private LuckPerms luckPerms;

    // Allows me to be lazy, and use colors cleanly. :)
    public String Color(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    // Logging
    public void LogInfo(String log) {
        Bukkit.getLogger().info(log);
    }

    public void LogWarn(String log) {
        Bukkit.getLogger().warning(log);
    }

    public void LogSevere(String log) {
        Bukkit.getLogger().severe(log);
    }

    public FileConfiguration Config() {
        return MTMain.plugin.getConfig();
    }

    public int getTokens(Player player) {
        CachedMetaData metaData = luckPerms.getPlayerAdapter(Player.class).getMetaData(player);
        return metaData.getMetaValue("MetaTokens", Integer::parseInt).orElse(0);
    }

    public void setTokens(Player player, int MetaTokens) {
        User user = luckPerms.getPlayerAdapter(Player.class).getUser(player);
        MetaNode node = MetaNode.builder("MetaTokens", Integer.toString(MetaTokens)).build();
        user.data().clear(NodeType.META.predicate(mn -> mn.getMetaKey().equals("MetaTokens")));
        user.data().add(node);
        luckPerms.getUserManager().saveUser(user);
    }

    public void setPrefix(Player player, String prefix){
        this.luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {
            // checks weight of existing prefixes
            Map<Integer, String> currentPrefixes = user.getCachedData().getMetaData(QueryOptions.nonContextual()).getPrefixes();
            int priority = currentPrefixes.keySet().stream().mapToInt(i -> i + 10).max().orElse(1000);

            // Creates a node to be added to player.
            Node node = PrefixNode.builder(prefix, priority).build();
            // adds the node
            user.data().add(node);
            player.sendMessage("You have successfully received the prefix: " + prefix);
        });
    }

    public void setSuffix(Player player, String suffix){
        this.luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {
            // checks weight of existing suffixes
            Map<Integer, String> currentSuffixes = user.getCachedData().getMetaData(QueryOptions.nonContextual()).getSuffixes();
            int priority = currentSuffixes.keySet().stream().mapToInt(i -> i + 10).max().orElse(1000);

            // Creates a node to be added to player.
            Node node = SuffixNode.builder(suffix, priority).build();
            // adds the node
            user.data().add(node);
            player.sendMessage("You have successfully received the suffix: " + suffix);
        });
    }

}
//if you're reading this, no you're not.