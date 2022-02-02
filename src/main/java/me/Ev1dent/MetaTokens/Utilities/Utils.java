package me.Ev1dent.MetaTokens.Utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class Utils {

    // Allows me to be lazy, and use colors cleanly. :)
    public String Color(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    // Logging
    public void LogInfo(String log){
        Bukkit.getLogger().info(log);
    }

    public void LogWarn(String log){
        Bukkit.getLogger().warning(log);
    }

    public void LogSevere(String log){
        Bukkit.getLogger().severe(log);
    }
}