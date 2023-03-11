package dev.Ev1dent.MetaTokens.Commands;

import dev.Ev1dent.MetaTokens.MTMain;
import dev.Ev1dent.MetaTokens.Utilities.Utils;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.types.MetaNode;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SetCommand implements CommandExecutor {
    private final MTMain plugin;
    private final LuckPerms luckPerms;
    Utils Utils = new Utils();
    public SetCommand(MTMain plugin, LuckPerms luckPerms) {
        this.plugin = plugin;
        this.luckPerms = luckPerms;
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            if (args.length < 1) {
                return false;
            } else {

                // Start LuckPerms Stuff
                User user = null;
                if (sender instanceof ConsoleCommandSender) {
                    if (args.length < 2) {
                        sender.sendMessage("Please specify a player.");
                    } else {
                        Player player = (Player) this.plugin.getServer().getOfflinePlayer(args[2]);
                        user = luckPerms.getPlayerAdapter(Player.class).getUser(player);
                    }
                } else {
                    Player player = (Player) sender;
                    user = luckPerms.getPlayerAdapter(Player.class).getUser(player);

                }
                String metaValue = user.getCachedData().getMetaData().getMetaValue("MetaTokens_Value");
                if(metaValue == null){
                    Utils.LogWarn(user + " Has no MetaTokens_Value");
                }
                Integer value = Integer.valueOf(metaValue);

                if (value < 1) {
                    return true;
                }
                // End LuckPerms Stuff


                // Sanitization time!
                // This removes all allowed colors/formatting
                String sanatized = args[0].replaceAll("(?i)[§&][0-9A-FL-ORX]", "");

                // "Does this contain anything it shouldn't?"
                Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
                Matcher match = pattern.matcher(sanatized);
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
                            // LuckPerms NodeBuilder
                            sender.sendMessage("Formatted Puffix: " + Utils.Color(prefix));
                            sender.sendMessage("Unformatted Puffix: " + prefix);
                            break;
                        case "setsuffix":
                            String suffix = args[0];
                            if (Utils.Config().getBoolean("suffix.additions", true)) {
                                suffix = Utils.Config().getString("suffix.layout", "&7[{META}&7]").replace("{META}", args[0]);
                            }
                            // LuckPerms NodeBuilder
                            sender.sendMessage("Formatted Suffix: " + Utils.Color(suffix));
                            sender.sendMessage("Unformatted Suffix: " + suffix);
                            break;
                    }
                }
            }
        return true;
    }
}
