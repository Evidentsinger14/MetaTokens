package dev.ev1dent.metatokens.commands;

import dev.ev1dent.metatokens.utilities.TokenUtil;
import dev.ev1dent.metatokens.utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandTokens implements CommandExecutor {

    Utils Utils = new Utils();
    TokenUtil TokenUtil = new TokenUtil();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof ConsoleCommandSender) {
            sender.sendMessage("Console cannot have a token amount.");
            return true;
        }

        Player player = (Player) sender;
        Utils.sendPlayerMessage(player, String.format("You have %sTokens.", TokenUtil.getTokens(player)));
        return true;
    }
}
