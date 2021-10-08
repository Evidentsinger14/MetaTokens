package me.Ev1dent.MetaTokens.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetPrefix implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("setprefix")) {
            if (args.length == 0) {
                player.sendMessage("Usage: /SetPrefix CustomPrefix");
            }
            String UMPrefix = args[0];
            String MPrefix = UMPrefix.replace("&0", "").replace("&1", "").replace("&2", "").replace("&3", "").replace("&4", "").replace("&5", "").replace("&6", "").replace("&7", "").replace("&8", "").replace("&9", "").replace("&a", "").replace("&b", "").replace("&c", "").replace("&d", "").replace("&e", "").replace("&f", "").replace("&l", "").replace("&k", "").replace("&n", "").replace("&m", "").replace("&o", "").replace("&r", "").replace("[", "").replace("]", "");
            String newPrefix = UMPrefix.replace("&k", "").replace("[", "").replace("]", "");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', newPrefix));
            if (MPrefix.length() > 10 || !MPrefix.matches("[a-zA-Z]")) {
                player.sendMessage("Your prefix must be less than 10 characters long, cannot contain non-alphanumeric characters.");
                return true;
            }
            return false;

        }
        return false;
    }
}
