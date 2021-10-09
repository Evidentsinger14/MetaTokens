package me.Ev1dent.MetaTokens.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetPrefix implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        //base command /setprefix
        if (label.equalsIgnoreCase("setprefix")) {
            if (args.length < 1) {
                //returns a usage message if no args are specified
                player.sendMessage("Usage: /SetPrefix CustomPrefix");
                return true;
            }
            String RawPrefix = args[0];
            //check if the tag has alphanumeric characters (non 0-9 & a-z)
            if (RawPrefix.matches("[a-zA-Z]")) {
                player.sendMessage("Your prefix works!");
            }
            player.sendMessage("Your prefix Doesn't work!");
            return true;
        }
        return false;
    }
}
