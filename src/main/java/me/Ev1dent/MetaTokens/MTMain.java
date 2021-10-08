package me.Ev1dent.MetaTokens;

import me.Ev1dent.MetaTokens.Commands.CommandTokens;
import me.Ev1dent.MetaTokens.Commands.SetPrefix;
import me.Ev1dent.MetaTokens.Commands.SetSuffix;
import org.bukkit.plugin.java.JavaPlugin;

public class MTMain extends JavaPlugin {
    @Override
    public void onEnable() {
        getCommand("setprefix").setExecutor(new SetPrefix());
        getCommand("setsuffix").setExecutor(new SetSuffix());
        getCommand("tokens").setExecutor(new CommandTokens());
        saveDefaultConfig();
        getLogger().info("CustomPrefixTokens has been Enabled!");
    }
    @Override
    public void onDisable(){
        getLogger().info("CustomPrefixTokens has been Disabled!");
    }
}
