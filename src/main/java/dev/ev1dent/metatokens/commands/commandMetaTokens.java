package dev.ev1dent.metatokens.commands;

import dev.ev1dent.metatokens.metaTokensPlugin;
import dev.ev1dent.metatokens.utilities.utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class commandMetaTokens implements CommandExecutor {
    utils Utils = new utils();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(Utils.Color("              &6&lMetaTokens             "));
            sender.sendMessage(Utils.Color("&m                                       "));
            sender.sendMessage(Utils.Color("&eThis server is running &a&nMetaTokens &av" + metaTokensPlugin.plugin.getDescription().getVersion()));
            sender.sendMessage(Utils.Color("&e- &6Bukkit Version: " + Bukkit.getVersion()));
        }
        switch (args[0].toLowerCase()) {
            case "reload":
                sender.sendMessage("Could not reload. No reload feature at this moment, searching for a good implementation to preserve comments. Restart your server.");
//                MTMain.plugin.saveDefaultConfig();
//                MTMain.plugin.reloadConfig();
//                sender.sendMessage(Utils.Color("&2Config reloaded"));
//                MTMain.plugin.addTabCompletion();
                break;

            case "version":
                sender.sendMessage("v" + metaTokensPlugin.plugin.getDescription().getVersion());
                break;

            default:
                sender.sendMessage("/<command> [reload/version]");
                break;
        }
        return false;
    }
}
