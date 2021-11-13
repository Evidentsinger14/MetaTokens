package me.Ev1dent.MetaTokens.Events;

import me.Ev1dent.MetaTokens.MTMain;
import me.Ev1dent.MetaTokens.Utilities.clr;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {
    clr clrs = new clr();
    private MTMain plugin;
    public void onJoin(PlayerJoinEvent e){
        //Won't work :pensive:. need to check if player exists in sql database.
        //if(!e.getPlayer().hasPlayedBefore()){
            if(plugin.getConfig().getInt("tokens") > 0){
                //code to enter player into sql database.
                e.getPlayer().sendMessage(clrs.cm("&aWelcome " + e.getPlayer().getName() + "!" ));
            }
        //}
    }
}
