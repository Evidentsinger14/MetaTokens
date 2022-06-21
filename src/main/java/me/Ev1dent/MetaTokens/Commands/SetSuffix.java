package me.Ev1dent.MetaTokens.Commands;

import me.Ev1dent.MetaTokens.MTMain;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetSuffix implements CommandExecutor {
    //Adds multi-class config support
    FileConfiguration config = MTMain.plugin.getConfig();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;
        if (label.equalsIgnoreCase("setsuffix")) {
            if (args.length < 1) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aMetaTokens&8] &fUsage: /setsuffix (Custom Suffix)"));
                return true;}
            String RawSuffix = args[0];
            //formats the suffix to include additions
            String Stage1 = config.getString("suffix-layout");
            String FormattedSuffix = Stage1.replace("{META}", RawSuffix);
            //replaces all colors, and format codes excluding magic with ""
            String Filtered = RawSuffix.replaceAll("(?i)[§&][0-9A-FL-ORX]", "");
            Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
            //checks Filtered for any a-z, A-Z, or 0-9
            Matcher match = pattern.matcher(Filtered);
            if (!match.matches()) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&8[&aMetaTokens&8] &fYou cannot use special characters/magic in your suffix."));
                return true;}
            if(config.getBoolean("include-suffix-additions")){
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', FormattedSuffix));
                return true;
            }
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', RawSuffix));
        }
        return false;
    }
}
