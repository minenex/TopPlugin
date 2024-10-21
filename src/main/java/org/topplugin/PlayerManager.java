package org.topplugin;

import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class PlayerManager {
    private final TopPlugin plugin;
    private final Set<UUID> loggedInPlayers;

    public PlayerManager(TopPlugin plugin) {
        this.plugin = plugin;
        this.loggedInPlayers = new HashSet<>();
    }

    public void loginPlayer(Player player) {
        loggedInPlayers.add(player.getUniqueId());
    }

    public void logoutPlayer(Player player) {
        loggedInPlayers.remove(player.getUniqueId());
    }

    public boolean isPlayerLoggedIn(Player player) {
        return loggedInPlayers.contains(player.getUniqueId());
    }
}
