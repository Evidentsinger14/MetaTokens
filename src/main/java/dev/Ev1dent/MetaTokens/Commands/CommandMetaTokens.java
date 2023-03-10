package dev.Ev1dent.MetaTokens.Commands;

import dev.Ev1dent.MetaTokens.Utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandMetaTokens implements CommandExecutor {
    Utils Utils = new Utils();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length < 1){
            sender.sendMessage(Utils.Color("testmessage"));
            return true;
        }
        return false;
    }
}
