package dev.Ev1dent.MetaTokens.Commands;

import dev.Ev1dent.MetaTokens.MTMain;
import dev.Ev1dent.MetaTokens.Utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class CommandTokens implements CommandExecutor {

    Utils Utils = new Utils();
    FileConfiguration Config = MTMain.plugin.getConfig();

    public boolean onCommand(final CommandSender sender, final Command command, final String label, final String[] args) {
        if (!sender.hasPermission("MetaTokens.MetaTokens")) {
            sender.sendMessage(Utils.Color(Config.getString("Messages.No-Perms")));
        }
        sender.sendMessage(Utils.Color("&dYou have permissions!"));
        return false;
    }
}
