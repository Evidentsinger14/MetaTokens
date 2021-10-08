package me.Ev1dent.MetaTokens.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTokens implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if(label.equalsIgnoreCase("tokens")) {
            if (player.hasPermission("cpt.tokens")) {
                sender.sendMessage(ChatColor.GREEN + "Tokens is working!");
                return true;
            }
        }
        return false;
    }
}
