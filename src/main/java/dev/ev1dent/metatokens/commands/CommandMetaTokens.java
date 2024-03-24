package dev.ev1dent.metatokens.commands;

import dev.ev1dent.metatokens.utilities.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class CommandMetaTokens implements CommandExecutor {
    Utils Utils = new Utils();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (args.length == 0) {
            Utils.sendAdminMessage(sender, "              <green><bold>MetaTokens</bold></green>             ");
            Utils.sendAdminMessage(sender, "<strikethrough>                                            </strikethrough>");
            Utils.sendAdminMessage(sender, "<yellow>- <green>MetaTokens Version: v" + Utils.getPluginVersion());
            Utils.sendAdminMessage(sender, "<yellow>- <green>Bukkit Version: " + Utils.getServerVersion());
        }
        switch (args[0].toLowerCase()) {
            case "reload":
                Utils.sendPlayerMessage(sender, "Reload command not implemented. Restart your server to apply changes.");
                break;

            case "version":
                Utils.sendPlayerMessage(sender, String.format("v%s", Utils.getPluginVersion()));
                break;

            default:
                Utils.sendPlayerMessage(sender, "/<command> [reload/version]");
                break;
        }
        return false;
    }
}
