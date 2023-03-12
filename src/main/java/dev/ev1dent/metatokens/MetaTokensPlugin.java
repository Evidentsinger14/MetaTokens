package dev.ev1dent.metatokens;

import dev.ev1dent.metatokens.commands.CommandMetaTokens;
import dev.ev1dent.metatokens.commands.commandTokens;
import dev.ev1dent.metatokens.commands.commandSetMeta;
import dev.ev1dent.metatokens.events.PlayerJoinEvent;
import dev.ev1dent.metatokens.utilities.TabCompletion;
import dev.ev1dent.metatokens.utilities.Utils;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.cacheddata.CachedMetaData;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.NodeType;
import net.luckperms.api.node.types.MetaNode;
import net.luckperms.api.node.types.PrefixNode;
import net.luckperms.api.node.types.SuffixNode;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class MetaTokensPlugin extends JavaPlugin {

    Utils Utils = new Utils();
    public static MetaTokensPlugin plugin;
    private LuckPerms luckPerms;

    @Override
    public void onEnable() {
        plugin = this;
        this.luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        registerCommands();
        registerEvents();
        saveDefaultConfig();
        Utils.LogInfo("MetaTokens has been loaded!");
    }

    @Override
    public void onDisable() {
        Utils.LogInfo("MetaTokens has been Disabled!");
    }

    public void registerCommands() {
        this.getCommand("setprefix").setExecutor(new commandSetMeta());
        this.getCommand("setsuffix").setExecutor(new commandSetMeta());
        this.getCommand("tokens").setExecutor(new commandTokens());
        this.getCommand("metatokens").setExecutor(new CommandMetaTokens());
    }

    public void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoinEvent(), this);
    }

    public void addTabCompletion() {
        this.getCommand("metatokens").setTabCompleter(new TabCompletion());
    }

    public int getTokens(Player player) {
        CachedMetaData metaData = luckPerms.getPlayerAdapter(Player.class).getMetaData(player);
        return metaData.getMetaValue("metatokens", Integer::parseInt).orElse(0);
    }

    public void setTokens(Player player, int MetaTokens) {
        User user = luckPerms.getPlayerAdapter(Player.class).getUser(player);
        MetaNode node = MetaNode.builder("metatokens", Integer.toString(MetaTokens)).build();
        user.data().clear(NodeType.META.predicate(mn -> mn.getMetaKey().equals("metatokens")));
        user.data().add(node);
        luckPerms.getUserManager().saveUser(user);
    }

    public void setPrefix(Player player, String prefix) {
        this.luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {
            // checks weight of existing prefixes
            Map<Integer, String> currentPrefixes = user.getCachedData().getMetaData(QueryOptions.nonContextual()).getPrefixes();
            int priority = currentPrefixes.keySet().stream().mapToInt(i -> i + 10).max().orElse(1000);

            // Creates a node to be added to player.
            Node node = PrefixNode.builder(prefix, priority).build();
            // adds the node
            user.data().add(node);
            player.sendMessage("You have successfully received the prefix: " + prefix);
            player.sendMessage("You have " + MetaTokensPlugin.plugin.getTokens(player) + " Tokens left.");
        });
    }

    public void setSuffix(Player player, String suffix) {
        this.luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {
            // checks weight of existing suffixes
            Map<Integer, String> currentSuffixes = user.getCachedData().getMetaData(QueryOptions.nonContextual()).getSuffixes();
            int priority = currentSuffixes.keySet().stream().mapToInt(i -> i + 1000).max().orElse(1000);

            // Creates a node to be added to player.
            Node node = SuffixNode.builder(suffix, priority).build();
            // adds the node
            user.data().add(node);
            player.sendMessage("You have successfully received the suffix: " + suffix);
            player.sendMessage("You have " + MetaTokensPlugin.plugin.getTokens(player) + " Tokens left.");
        });
    }

}