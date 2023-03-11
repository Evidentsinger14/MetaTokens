package dev.Ev1dent.MetaTokens.Utilities;

import dev.Ev1dent.MetaTokens.MTMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TabCompleter implements org.bukkit.command.TabCompleter {
    private final String[] mtArguments = { "reload", "version" };
    private final String[] setPrefixArgs = { "<prefix>", ""};
    private final String[] setSuffixArgs = { "<suffix>", ""};

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        final List<String> completions = new ArrayList<>();

        switch (command.getName().toLowerCase()) {
            case "setprefix": {
                switch (args.length) {
                    case 1 : {
                        StringUtil.copyPartialMatches(args[0], Arrays.asList(setPrefixArgs), completions);
                        Collections.sort(completions);
                        return completions;
                    }
                    case 2 : {
                        return null;
                    }
                }
            }
            case "setsuffix": {
                switch (args.length) {
                    case 1 : {
                        StringUtil.copyPartialMatches(args[0], Arrays.asList(setSuffixArgs), completions);
                        Collections.sort(completions);
                        return completions;
                    }
                    case 2 : {
                        return null;
                    }
                }
            }

            case "metatokens" :{
                StringUtil.copyPartialMatches(args[0], Arrays.asList(mtArguments), completions);
                Collections.sort(completions);
                return completions;
            }
        }
        return null;
    }
}