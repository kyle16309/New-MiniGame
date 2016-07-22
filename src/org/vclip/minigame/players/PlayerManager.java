package org.vclip.minigame.players;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by vclip/trendies
 */
public class PlayerManager {
    private HashMap<UUID, ArcherPlayer> players = new HashMap<UUID, ArcherPlayer>();

    public ArcherPlayer getPlayer(Player player)
    {
        return players.get(player.getUniqueId());
    }



}
