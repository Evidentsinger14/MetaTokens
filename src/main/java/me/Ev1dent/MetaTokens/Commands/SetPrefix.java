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
        if (label.equalsIgnoreCase("setprefix")) {
            if (args.length < 1) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aMetaTokens&8]"));
                return true;}

            String RawPrefix = args[0];
            //replaces all colors, and format codes excluding magic with ""
            String Filtered = RawPrefix.replaceAll("(?i)[§&][0-9A-FL-ORX]", "");
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            //checks Filtered for any a-z, A-Z, or 0-9
            Matcher match = pattern.matcher(Filtered);
            if (!match.matches()) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fYour prefix, " + RawPrefix + "&r&f doesn't work!"));
                return true;}
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&fYour prefix, " + RawPrefix + "&r&f works!"));
        }
        return true;
    }
}