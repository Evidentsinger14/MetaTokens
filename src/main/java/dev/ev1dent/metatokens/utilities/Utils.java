package dev.ev1dent.metatokens.utilities;

import dev.ev1dent.metatokens.MetaTokensPlugin;
import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.TextDecoration;
import net.kyori.adventure.text.minimessage.MiniMessage;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class Utils {

    public Component formatMM(String s) {
        return MiniMessage.miniMessage().deserialize(s).decorationIfAbsent(TextDecoration.ITALIC, TextDecoration.State.FALSE);
    }

    public void sendAdminMessage(CommandSender sender, String s){
        sender.sendMessage(formatMM(s));
    }
    public void sendPlayerMessage(CommandSender sender, String s){
        sender.sendMessage(formatMM(String.format("<grey>[<bold><dark_green>MetaTokens</bold>] <white>%s", s)));
    }

    public FileConfiguration Config() {
        return MetaTokensPlugin.plugin.getConfig();
    }

    public String getPluginVersion(){
        return MetaTokensPlugin.plugin.getPluginMeta().getDescription();
    }

    public String getServerVersion() {
        return Bukkit.getVersion();
    }

}
