package fr.akkashi.lobby.events;

import fr.akkashi.lobby.utils.Settings;
import fr.akkashi.lobby.utils.VectorUtil;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

public class DoubleJumpEvent implements Listener {

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onJump(PlayerToggleFlightEvent e) {

        Player player = e.getPlayer();
        if (Settings.jumpOnboolean(player)) {
                e.setCancelled(true);
                // calculate jump
                Vector normal = VectorUtil.calculateLookVector(player.getLocation());

                normal.setY(0.75 + Math.abs(normal.getY()) * 0.5);
                e.getPlayer().setVelocity(normal);

                player.playSound(player.getLocation(), Sound.EXPLODE, 4, 4);
        }
    }
}
