package net.jirmjahu.r6mc.listener;

import lombok.RequiredArgsConstructor;
import net.jirmjahu.r6mc.player.GamePlayer;
import net.jirmjahu.r6mc.player.GamePlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

@RequiredArgsConstructor
public class PlayerMoveListener implements Listener {

    private final GamePlayerManager gamePlayerManager;

    @EventHandler
    public void handle(PlayerMoveEvent event) {
        GamePlayer gamePlayer = gamePlayerManager.getPlayer(event.getPlayer());

        if (gamePlayer.isInCam()) {
            event.setCancelled(true);
        }
    }
}
