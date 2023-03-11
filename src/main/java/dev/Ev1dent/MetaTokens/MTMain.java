package dev.Ev1dent.MetaTokens;

import dev.Ev1dent.MetaTokens.Commands.CommandMetaTokens;
import dev.Ev1dent.MetaTokens.Commands.CommandTokens;
import dev.Ev1dent.MetaTokens.Commands.SetCommand;
import dev.Ev1dent.MetaTokens.Events.onJoinEvent;
import dev.Ev1dent.MetaTokens.Utilities.TabCompleter;
import dev.Ev1dent.MetaTokens.Utilities.Utils;
import org.bukkit.plugin.java.JavaPlugin;

public class MTMain extends JavaPlugin {

    Utils Utils = new Utils();
    public static MTMain plugin;

    @Override
    public void onEnable() {
        plugin = this;
        registerCommands();
        registerEvents();
        saveDefaultConfig();

    }
    @Override
    public void onDisable(){
        Utils.LogInfo("MetaTokens has been Disabled!");
    }

    public void registerCommands(){
        this.getCommand("setprefix").setExecutor(new SetCommand());
        this.getCommand("setsuffix").setExecutor(new SetCommand());
        this.getCommand("tokens").setExecutor(new CommandTokens());
        this.getCommand("metatokens").setExecutor(new CommandMetaTokens());
    }

    public void registerEvents(){
        this.getServer().getPluginManager().registerEvents(new onJoinEvent(), this);
    }

    public void addTabCompletion() {
        this.getCommand("metatokens").setTabCompleter(new TabCompleter());
    }

}