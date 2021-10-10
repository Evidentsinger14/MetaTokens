package me.Ev1dent.MetaTokens.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetPrefix implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        //base command /setprefix
        if (label.equalsIgnoreCase("setprefix")) {
            if (args.length < 1) {
                //returns a usage message if no args are specified
//                int tokenamount = 0;
                player.sendMessage("Usage: /SetPrefix CustomPrefix");
                return true;
            }
            //Bandit is a fucking dumbass
            String RawPrefix = args[0];
            //start regex check
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            //(?i)[§&][0-9A-FL-ORX]
            Matcher match = pattern.matcher(RawPrefix);
            //checks if regex is met
            if (!match.matches()) {
                player.sendMessage("Your prefix doesn't work!");
                return true;
            }
            player.sendMessage("Your prefix works!");
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', RawPrefix));
        }
        return true;
    }
}
