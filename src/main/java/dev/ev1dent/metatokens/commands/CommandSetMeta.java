package dev.ev1dent.metatokens.commands;

import dev.ev1dent.metatokens.utilities.TokenUtil;
import dev.ev1dent.metatokens.utilities.Utils;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.types.PrefixNode;
import net.luckperms.api.node.types.SuffixNode;
import net.luckperms.api.query.QueryOptions;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CommandSetMeta implements CommandExecutor {
    private final LuckPerms luckPerms;

    public CommandSetMeta(LuckPerms luckPerms) {
        this.luckPerms = luckPerms;
    }

    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, String[] args) {

        Utils Utils = new Utils();
        TokenUtil TokenUtil = new TokenUtil();
        if(!(sender instanceof Player player)){
            Utils.sendAdminMessage(sender, "This command can only be used in-game.");
            return true;
        }

        if (args.length < 1) return false; // send usage - no arguments are provided

        int tokens = TokenUtil.getTokens(player);

        if (tokens < 1) {
            Utils.sendPlayerMessage(sender, "You do not have enough tokens to use that.");
            return true;
        }

        if (passesSanitation(args[0])) {
            String meta = finalMeta(args[0], command);
            switch (command.getName().toLowerCase()) {
                case "setprefix":
                    setPrefix(player, meta);
                    break;

                case "setsuffix":
                    setSuffix(player, meta);
                    break;
            }
        } else {
            Utils.sendPlayerMessage(sender, Utils.Config().getString("Messages.Magic", "You cannot use special characters/magic in your tag."));
            return true;
        }
        return true;
    }

    private boolean passesSanitation(String meta){
        String sanitized = meta.replaceAll("(?i)[§&][0-9A-FL-ORX]", ""); // This will remove all color codes
        Pattern pattern = Pattern.compile("[a-zA-Z0-9]*");
        Matcher match = pattern.matcher(sanitized);
        return match.matches();
    }

    private String finalMeta(String meta, Command command){
        Utils Utils = new Utils();
        String finalMeta = meta;
        switch (command.getLabel().toLowerCase()){
            case "setprefix":
                if(Utils.Config().getBoolean("prefix.additions", true)){
                    finalMeta = Utils.Config().getString("prefix.layout", "&7[{META}&7]").replace("{META}", meta);
                }
                break;
            case "setsuffix":
                if(Utils.Config().getBoolean("suffix.additions", true)){
                    finalMeta = Utils.Config().getString("suffix.layout", "&7[{META}&7]").replace("{META}", meta);
                }
                break;

        }
        return finalMeta;
    }

    private void setPrefix(Player player, String prefix) {
        TokenUtil TokenUtil = new TokenUtil();
        Utils Utils = new Utils();
        this.luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {
            // checks weight of existing prefixes
            Map<Integer, String> currentPrefixes = user.getCachedData().getMetaData(QueryOptions.nonContextual()).getPrefixes();
            int priority = currentPrefixes.keySet().stream().mapToInt(i -> i + 10).max().orElse(1000);

            // Creates a node to be added to player.
            Node node = PrefixNode.builder(prefix, priority).build();
            // adds the node
            user.data().add(node);
            Utils.sendPlayerMessage(player, String.format("Prefix %s Added.", prefix));
            TokenUtil.subtractTokens(player, '1');
            Utils.sendPlayerMessage(player, String.format("You have %s Tokens left", TokenUtil.getTokens(player)));
        });
    }

    private void setSuffix(Player player, String suffix) {
        TokenUtil TokenUtil = new TokenUtil();
        Utils Utils = new Utils();
        this.luckPerms.getUserManager().modifyUser(player.getUniqueId(), (User user) -> {
            // checks weight of existing suffixes
            Map<Integer, String> currentSuffixes = user.getCachedData().getMetaData(QueryOptions.nonContextual()).getSuffixes();
            int priority = currentSuffixes.keySet().stream().mapToInt(i -> i + 1000).max().orElse(1000);

            // Creates a node to be added to player.
            Node node = SuffixNode.builder(suffix, priority).build();
            // adds the node
            user.data().add(node);
            Utils.sendPlayerMessage(player, String.format("Suffix %s Added.", suffix));
            TokenUtil.subtractTokens(player, '1');
            Utils.sendPlayerMessage(player, String.format("You have %s Tokens left", TokenUtil.getTokens(player)));
        });
    }
}
