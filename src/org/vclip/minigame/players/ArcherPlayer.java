package org.vclip.minigame.players;

import org.bukkit.entity.Player;

/**
 * Created by vclip/trendies
 */
public class ArcherPlayer {

    private Player player;
    private boolean isJoined;

    public ArcherPlayer(Player player)
    {
        this.player = player;
    }

    public Player getPlayer()
    {
        return player;
    }

    public void setJoined(boolean joined)
    {
        this.isJoined = joined;
    }
}
