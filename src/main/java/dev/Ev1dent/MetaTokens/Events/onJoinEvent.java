package dev.Ev1dent.MetaTokens.Events;

import dev.Ev1dent.MetaTokens.MTMain;
import dev.Ev1dent.MetaTokens.Utilities.Utils;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {
    Utils Utils = new Utils();
    private MTMain plugin;

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
            if(plugin.getConfig().getInt("tokens") > 0){
                e.getPlayer().sendMessage(Utils.Color("&aWelcome " + e.getPlayer().getName() + "!" ));
            }
    }
}