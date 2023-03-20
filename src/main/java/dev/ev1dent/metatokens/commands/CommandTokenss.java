package dev.ev1dent.metatokens.commands;

import dev.ev1dent.metatokens.MetaTokensPlugin;
import dev.ev1dent.metatokens.utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandTokenss implements CommandExecutor {

    Utils Utils = new Utils();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Console cannot have a token amount.");
            return true;
        }

        Player player = (Player) sender;
        sender.sendMessage(Utils.Color("&fYou have " + MetaTokensPlugin.plugin.getTokens(player) + " Tokens."));
        return true;
    }
}
