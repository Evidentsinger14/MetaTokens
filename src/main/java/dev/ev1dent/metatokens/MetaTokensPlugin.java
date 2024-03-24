package dev.ev1dent.metatokens;

import dev.ev1dent.metatokens.commands.CommandMetaTokens;
import dev.ev1dent.metatokens.commands.CommandTokens;
import dev.ev1dent.metatokens.commands.CommandSetMeta;
import dev.ev1dent.metatokens.events.PlayerJoinListener;
import dev.ev1dent.metatokens.utilities.TabCompletion;
import net.luckperms.api.LuckPerms;
import org.bukkit.plugin.java.JavaPlugin;

public class MetaTokensPlugin extends JavaPlugin {

    public static MetaTokensPlugin plugin;
    private LuckPerms luckPerms;

    public MetaTokensPlugin(LuckPerms luckPerms) {
        this.luckPerms = luckPerms;
    }

    @Override
    public void onEnable() {
        plugin = this;
        luckPerms = getServer().getServicesManager().load(LuckPerms.class);
        registerCommands();
        registerEvents();
        saveDefaultConfig();
    }

    public void registerCommands() {
        this.getCommand("setprefix").setExecutor(new CommandSetMeta(luckPerms));
        this.getCommand("setsuffix").setExecutor(new CommandSetMeta(luckPerms));
        this.getCommand("tokens").setExecutor(new CommandTokens());
        this.getCommand("metatokens").setExecutor(new CommandMetaTokens());
        addTabCompletion();
    }

    public void registerEvents() {
        this.getServer().getPluginManager().registerEvents(new PlayerJoinListener(), this);
    }

    public void addTabCompletion() {
        this.getCommand("metatokens").setTabCompleter(new TabCompletion());
    }

}