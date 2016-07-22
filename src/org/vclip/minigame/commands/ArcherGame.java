package org.vclip.minigame.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.vclip.minigame.MiniGame;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * Created by vclip/trendies
 */
public class ArcherGame implements CommandExecutor{

    public boolean running;

    public boolean started;

    public boolean hosted;

    public int countdown;

    public Location arenaLocation;

   ArrayList<Player> joinedPlayers = new ArrayList<Player>();

    private void startGame()
    {
        for(Player players : this.joinedPlayers)
        {
        }
    }


    private void startCountdown()
    {
        this.countdown = 60; // change back to 60 after bebugging
        new BukkitRunnable()
        {
            public void run()
            {
                if(countdown == 0)
                {
                   startGame();
                    cancel();
                }

                if(countdown % 10 == 0 && countdown >0)
                {
                    Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&cArcher FFA will start in &b" + countdown + " seconds /ag join"));
                }
                countdown --;
            }
        }.runTaskTimer(MiniGame.plugin, 0L, 20L);
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command is only usable by players");
            return true;
        }
        Player p = (Player)sender;
        if(p.hasPermission("Minigame.archer.*"))
        {
            if(args.length == 0)
            {
                p.sendMessage(ChatColor.YELLOW + "=========");
                p.sendMessage(ChatColor.BLUE + "/ag <start> <stop> <setarena>");
                p.sendMessage(ChatColor.YELLOW + "=========");
            }
            else
            {
                if(args[0].equalsIgnoreCase("start"))
                {
                    if(running || started)
                    {
                        p.sendMessage(ChatColor.RED + " A game is already in progress");
                        return true;
                    }
                    running = true;
                    hosted = true;
                    startCountdown();
                }
                else if(args[0].equalsIgnoreCase("join"))
                {
                    if(started && !running)
                    {
                        p.sendMessage(ChatColor.RED + "Game has already started");
                        return true;
                    }
                    else if(!hosted)
                    {
                        p.sendMessage(ChatColor.RED + " No game is being hosted at the moment");
                        return true;
                    }
                        joinedPlayers.add(p);
                        p.sendMessage(ChatColor.GREEN + " You have joined Archer FFA");

                }
            }
        }
        return true;
    }
}
