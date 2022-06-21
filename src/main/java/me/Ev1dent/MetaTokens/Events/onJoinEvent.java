package me.Ev1dent.MetaTokens.Events;

import me.Ev1dent.MetaTokens.MTMain;
import me.Ev1dent.MetaTokens.Utilities.clr;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {
    clr clrs = new clr();
    private MTMain plugin;

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
            if(plugin.getConfig().getInt("tokens") > 0){
                e.getPlayer().sendMessage(clrs.cm("&aWelcome " + e.getPlayer().getName() + "!" ));
            }
    }
}
