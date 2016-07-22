package org.vclip.minigame;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.vclip.minigame.commands.ArcherGame;
import org.vclip.minigame.listeners.PlayerListener;
import org.vclip.minigame.players.PlayerManager;

/**
 * Created by vclip/trendies
 */
public class MiniGame extends JavaPlugin{

    public static MiniGame plugin;
    private PlayerManager playerManager;

    public void onEnable()
    {
        plugin = this;
        registerEvents();
        registerCmds();

    }

    public void onDisable()
    {

    }

    private void registerEvents()
    {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new PlayerListener(), this);
    }

    private void registerCmds()
    {
     getCommand("ag").setExecutor(new ArcherGame());
    }


    public static MiniGame getInstance()
    {
        return plugin;
    }

    public PlayerManager getPlayerManager()
    {
        return playerManager;
    }


}
