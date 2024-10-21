package org.topplugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class TopPlugin extends JavaPlugin {
    private static TopPlugin instance;
    private PlayerManager playerManager;

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        playerManager = new PlayerManager(this);

        getServer().getPluginManager().registerEvents(new PlayerListener(this), this);
        getCommand("login").setExecutor(new LoginCommand(this));

        getLogger().info("TopPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("TopPlugin has been disabled!");
    }

    public static TopPlugin getInstance() {
        return instance;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public String getLoginCode() {
        return getConfig().getString("login-code", "defaultcode");
    }
}
