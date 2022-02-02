package me.Ev1dent.MetaTokens.Commands;

import me.Ev1dent.MetaTokens.MTMain;
import me.Ev1dent.MetaTokens.Utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetSuffix implements CommandExecutor {

    // This does stuff, don't ask me what.
    Utils Utils = new Utils();
    FileConfiguration Config = MTMain.plugin.getConfig();
    String Prefix = "&8[&aMetaTokens&8] ";
    final int length = Config.getInt("length");
    String RawUsage = Config.getString("Messages.Usage"), Usage = RawUsage.replace("{CMD}", "Suffix");
    int tokens = 0;

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        // Make sure the player can run the command
        if (!sender.hasPermission("MetaTokens.SetSuffix")) {
            sender.sendMessage(Utils.Color(Prefix + Config.getString("Messages.No-Perms")));
            return true;
        }

        // Checks if the person has reached the token amount to run command.
        if (tokens < 1) {
            sender.sendMessage(Utils.Color(Prefix + Config.getString("Messages.No-Tokens")));
            return true;
        }

        // Makes sure an argument is specified
        if (args.length < 1) {
            sender.sendMessage(Utils.Color(Prefix + Usage));
            return true;
        }

        // Word list (Eventually)

        // Sets the input to a string
        String Input = args[0];

        // This one replaces all codes, except for magic.
        String NoSymbols = Input.replaceAll("(?i)[§&][0-9A-FL-ORX]", "");

        // This one replaces *all* codes to check for length.
        String LengthCheck = Input.replaceAll("(?i)[§&][0-9A-FK-ORX]", "");

        // This should be Self-Explanatory (The filter makes sure that a-Z and 0-9 are the only characters included)
        Pattern DoesThisMatch = Pattern.compile("[a-zA-Z0-9]*");
        Matcher CheckSymbols = DoesThisMatch.matcher(NoSymbols);

        // I guess I should have something to check the length.
        if (LengthCheck.length() > length) {
            sender.sendMessage(Utils.Color(Config.getString("Messages.Length")));
            return true;
        }

        // Do *you* have invalid characters in your prefix? :eyes:
        if (!CheckSymbols.matches()) {
            sender.sendMessage(Utils.Color(Prefix + Config.getString("Messages.No-Perms")));
            return true;
        }

        sender.sendMessage(Utils.Color(Input));
        return true;
    }
}