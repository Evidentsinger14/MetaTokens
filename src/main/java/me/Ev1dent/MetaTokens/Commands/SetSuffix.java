package me.Ev1dent.MetaTokens.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSuffix implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        //add booleans for prefix/suffix settings in config.
        Player player = (Player) sender;
        if(label.equalsIgnoreCase("setsuffix")) {
            if (player.hasPermission("cpt.setsuffix")) {
                sender.sendMessage(ChatColor.GREEN + "setsuffix is working!");
                return true;
            }
        }
        return false;
    }
}
