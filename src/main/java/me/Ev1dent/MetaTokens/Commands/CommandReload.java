package me.Ev1dent.MetaTokens.Commands;

import me.Ev1dent.MetaTokens.MTMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import static me.Ev1dent.MetaTokens.MTMain.plugin;

public class CommandReload implements CommandExecutor {
    //Adds multi-class config support
    FileConfiguration config = MTMain.plugin.getConfig();
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(label.equalsIgnoreCase("mtreload")){
            if(sender.hasPermission("MetaTokens.reload")){
                plugin.reloadConfig();
            }else{

            }
        }
        return false;
    }
}
