package me.Ev1dent.MetaTokens;

import me.Ev1dent.MetaTokens.Commands.CommandMetaTokens;
import me.Ev1dent.MetaTokens.Commands.CommandTokens;
import me.Ev1dent.MetaTokens.Commands.SetPrefix;
import me.Ev1dent.MetaTokens.Commands.SetSuffix;
import me.Ev1dent.MetaTokens.Events.onJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class MTMain extends JavaPlugin {
    //private LuckPerms luckperms;
    public static MTMain plugin;

    @Override
    public void onEnable() {
        plugin = this;
        //this.luckperms = getServer().getServicesManager().load(LuckPerms.class);
        this.getCommand("setprefix").setExecutor(new SetPrefix());
        this.getCommand("setsuffix").setExecutor(new SetSuffix());
        this.getCommand("tokens").setExecutor(new CommandTokens());
        this.getCommand("metatokens").setExecutor(new CommandMetaTokens());
        this.getServer().getPluginManager().registerEvents(new onJoinEvent(), this);
        this.getLogger().info("CustomPrefixTokens has been Enabled!");
    }
    @Override
    public void onDisable(){
        getLogger().info("CustomPrefixTokens has been Disabled!");
    }
}