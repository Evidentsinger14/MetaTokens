package me.Ev1dent.MetaTokens.Commands;

import me.Ev1dent.MetaTokens.Utilities.clr;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandMetaTokens implements CommandExecutor {
    clr clrs = new clr();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length < 1){
            sender.sendMessage(clrs.cm("testmessage"));
            return true;
        }
        return false;
    }
}
