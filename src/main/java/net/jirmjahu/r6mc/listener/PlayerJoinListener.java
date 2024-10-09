package net.jirmjahu.r6mc.listener;

import lombok.RequiredArgsConstructor;
import net.jirmjahu.r6mc.player.GamePlayerManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

@RequiredArgsConstructor
public class PlayerJoinListener implements Listener {

    private final GamePlayerManager gamePlayerManager;

    @EventHandler
    public void handle(PlayerJoinEvent event) {
        gamePlayerManager.addPlayer(event.getPlayer());
    }
}
