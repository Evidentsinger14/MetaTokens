package dev.ev1dent.metatokens.utilities;

import dev.ev1dent.metatokens.MetaTokensPlugin;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;

public class Utils {

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
        return MetaTokensPlugin.plugin.getConfig();
    }

}
//if you're reading this, no you're not.