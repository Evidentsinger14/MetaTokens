package dev.Ev1dent.MetaTokens.Commands;

import dev.Ev1dent.MetaTokens.MTMain;
import dev.Ev1dent.MetaTokens.Utilities.Utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandMetaTokens implements CommandExecutor {
    Utils Utils = new Utils();
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if(args.length == 0){
            sender.sendMessage(Utils.Color("              &6&lMetaTokens             "));
            sender.sendMessage(Utils.Color("&m                                       "));
            sender.sendMessage(Utils.Color("&eThis server is running &a&nMetaTokens &av" + MTMain.plugin.getDescription().getVersion()));
            sender.sendMessage(Utils.Color("&e- &6Bukkit Version: " + Bukkit.getVersion()));
        }
        switch (args[0].toLowerCase()){
            case "reload":
                sender.sendMessage("Could not reload.");
//                MTMain.plugin.saveDefaultConfig();
//                MTMain.plugin.reloadConfig();
//                sender.sendMessage(Utils.Color("&2Config reloaded"));
//                MTMain.plugin.addTabCompletion();
                break;

            case "version":
                sender.sendMessage("v" + MTMain.plugin.getDescription().getVersion());
                break;

            default:
                sender.sendMessage("/<command> [reload/version]");
                break;
        }
        return false;
    }
}
