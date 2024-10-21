package org.topplugin;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {
    private final TopPlugin plugin;

    public PlayerListener(TopPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.sendMessage("Привет! Введите /login <код> чтобы войти.");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        plugin.getPlayerManager().logoutPlayer(event.getPlayer());
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (!plugin.getPlayerManager().isPlayerLoggedIn(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!plugin.getPlayerManager().isPlayerLoggedIn(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if (!plugin.getPlayerManager().isPlayerLoggedIn(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        if (!plugin.getPlayerManager().isPlayerLoggedIn(event.getPlayer())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event) {
        if (!plugin.getPlayerManager().isPlayerLoggedIn(event.getPlayer())) {
            event.setCancelled(true);
            event.getPlayer().sendMessage("Вы должны войти в систему, прежде чем общаться.");
        }
    }
}
