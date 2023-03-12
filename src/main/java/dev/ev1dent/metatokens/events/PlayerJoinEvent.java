package dev.ev1dent.metatokens.events;

import dev.ev1dent.metatokens.utilities.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

public class PlayerJoinEvent implements Listener {
    dev.ev1dent.metatokens.utilities.Utils Utils = new Utils();

    @EventHandler
    public void onJoin(org.bukkit.event.player.PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (!player.hasPlayedBefore()) {
            player.sendMessage("Welcome to the server, " + player);
        } else {
            player.sendMessage("Welcome back, " + player);
        }
    }
}
