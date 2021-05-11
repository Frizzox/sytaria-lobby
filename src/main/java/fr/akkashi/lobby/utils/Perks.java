package fr.akkashi.lobby.utils;

import fr.akkashi.lobby.commands.DoubleJumpCommand;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class Perks {

    public static void fly(Player player) {
        if (Settings.jumpOnboolean(player)) {
            return;
        } else {
            player.setFlying(true);
            player.setAllowFlight(true);
        }
    }

    public static void doubleJump(Player player) {
        if (Settings.flyOnBoolean(player)) {
            return;
        } else {
            DoubleJumpCommand.doubleJumpActivated.add(player.getUniqueId());
        }
    }

    public static void joinMessage(Player player) {
        String joinMessage = "&8» %luckperms_prefix%" + player.getName() + " §7a rejoint le serveur §dLOBBY§7 !";
        joinMessage = PlaceholderAPI.setPlaceholders(player, joinMessage);
        Bukkit.broadcastMessage(joinMessage);
        for (Player p : Bukkit.getOnlinePlayers()) {
            p.playSound(player.getLocation(), Sound.AMBIENCE_THUNDER, 5, 5);
        }
    }
}
