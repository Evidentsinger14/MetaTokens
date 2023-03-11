package dev.Ev1dent.MetaTokens.Events;

import dev.Ev1dent.MetaTokens.Utilities.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {
    Utils Utils = new Utils();

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPlayedBefore()) {
            player.sendMessage("Welcome to the server, " + player);
        } else {
            player.sendMessage("Welcome back, " + player);
        }
    }
}
