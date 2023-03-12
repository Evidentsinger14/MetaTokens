package dev.ev1dent.metatokens.commands;

import dev.ev1dent.metatokens.metaTokensPlugin;
import dev.ev1dent.metatokens.utilities.utils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class commandSetMeta implements CommandExecutor {
    utils Utils = new utils();


    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length < 1) {
            return false;
        }
        Player player;
        if (sender instanceof ConsoleCommandSender) {
            if (args.length < 2) {
                sender.sendMessage("Please specify a player.");
            } else {
                player = Bukkit.getPlayer(args[1]);
            }
        }
        player = (Player) sender;
        int tokens = metaTokensPlugin.plugin.getTokens(player);

        if (tokens < 1) {
            sender.sendMessage(Utils.Color(Utils.Config().getString("Messages.No-Tokens", "&fYou do not have enough tokens to use this command!")));
            return true;
        }

        // Sanitization time!
        // This removes all allowed colors/formatting
        String sanitized = args[0].replaceAll("(?i)[§&][0-9A-FL-ORX]", "");

        // "Does this contain anything it shouldn't?"
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher match = pattern.matcher(sanitized);
        if (!match.matches()) {
            sender.sendMessage(Utils.Color(Utils.Config().getString("Messages.Magic", "&fYou cannot use special characters/magic in your tag.")));
            return true;
        } else {
            switch (command.getName().toLowerCase()) {
                case "setprefix":
                    String prefix = args[0];
                    if (Utils.Config().getBoolean("prefix.additions", true)) {
                        prefix = Utils.Config().getString("prefix.layout", "&7[{META}&7]").replace("{META}", args[0]);
                    }
                    metaTokensPlugin.plugin.setTokens(player, tokens - 1);
                    metaTokensPlugin.plugin.setPrefix(player, prefix);
                    break;

                case "setsuffix":
                    String suffix = args[0];
                    if (Utils.Config().getBoolean("suffix.additions", true)) {
                        suffix = Utils.Config().getString("suffix.layout", "&7[{META}&7]").replace("{META}", args[0]);
                    }
                    metaTokensPlugin.plugin.setTokens(player, tokens - 1);
                    metaTokensPlugin.plugin.setSuffix(player, suffix);
                    break;
            }
        }
        return true;
    }
}