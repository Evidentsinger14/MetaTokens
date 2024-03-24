package dev.ev1dent.metatokens.events;

import dev.ev1dent.metatokens.utilities.Utils;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    Utils Utils = new Utils();

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.hasPlayedBefore()) {
            Utils.sendPlayerMessage(player, "");
            player.sendMessage("Welcome back, " + player);
        } else {
            player.sendMessage("Welcome to the server, " + player);
        }
    }
}
