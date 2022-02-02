package me.Ev1dent.MetaTokens;

import me.Ev1dent.MetaTokens.Commands.CommandMetaTokens;
import me.Ev1dent.MetaTokens.Commands.CommandTokens;
import me.Ev1dent.MetaTokens.Commands.SetPrefix;
import me.Ev1dent.MetaTokens.Commands.SetSuffix;
import me.Ev1dent.MetaTokens.Events.onJoinEvent;
import me.Ev1dent.MetaTokens.Utilities.Utils;
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
        this.getCommand("setprefix").setExecutor(new SetPrefix());
        this.getCommand("setsuffix").setExecutor(new SetSuffix());
        this.getCommand("tokens").setExecutor(new CommandTokens());
        this.getCommand("metatokens").setExecutor(new CommandMetaTokens());
    }

    public void registerEvents(){
        this.getServer().getPluginManager().registerEvents(new onJoinEvent(), this);
    }
}