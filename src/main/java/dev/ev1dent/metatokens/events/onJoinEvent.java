package dev.ev1dent.metatokens.events;

import dev.ev1dent.metatokens.utilities.utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {
    utils Utils = new utils();

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
