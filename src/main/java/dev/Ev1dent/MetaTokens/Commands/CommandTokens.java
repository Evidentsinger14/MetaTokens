package dev.Ev1dent.MetaTokens.Commands;

import dev.Ev1dent.MetaTokens.MTMain;
import dev.Ev1dent.MetaTokens.Utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

public class CommandTokens implements CommandExecutor {

    Utils Utils = new Utils();

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof ConsoleCommandSender){
            sender.sendMessage("Console cannot have a token amount.");
            return true;
        }

        Player player = (Player) sender;
        sender.sendMessage("You have " + MTMain.plugin.getTokens(player) + " Tokens.");
        return true;
    }
}
