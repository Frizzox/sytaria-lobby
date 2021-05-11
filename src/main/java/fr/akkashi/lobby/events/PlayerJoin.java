package fr.akkashi.lobby.events;

import fr.akkashi.lobby.Main;
import fr.akkashi.lobby.commands.FlyCommand;
import fr.akkashi.lobby.utils.Perks;
import fr.akkashi.lobby.utils.helpful.ActionBar;
import fr.akkashi.lobby.utils.helpful.ItemBuilder;
import fr.akkashi.lobby.utils.Settings;
import fr.akkashi.lobby.utils.helpful.Title;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerJoin implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {

        e.setJoinMessage(null);
        Player player = e.getPlayer();
        ItemBuilder serverSelector = new ItemBuilder(Material.COMPASS).name("§dMenu Principal §5§l● §7(Clic-Droit)");
        ItemBuilder profile = new ItemBuilder(Material.SKULL_ITEM).name("§dProfil §5§l● §7(Clic-Droit)").setOwner(player).data(1);
        ItemBuilder hidePlayers = new ItemBuilder(Material.REDSTONE).name("§dCacher les joueurs §5§l● §7(Clic-Droit)");

        player.getInventory().clear();
        player.getEquipment().clear();
        player.setHealth(20);
        player.setFoodLevel(20);
        player.setLevel(0);
        player.setExp(0);
        player.setGameMode(GameMode.ADVENTURE);
        player.setAllowFlight(false);
        Title title = new Title("§5Bienvenue " + player.getName() + " !", "§d§oClique sur la boussole pour ouvrir le menu !");
        title.send(player, 1, 3, 1);
        for (Player p : Bukkit.getOnlinePlayers()) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    ActionBar.sendActionBar(p, "§f» §dBienvenue sur Sytaria ! §f«");
                }
            }.runTaskTimerAsynchronously(Main.getInstance(), 0, 5);
        }
        player.getInventory().setItem(0, serverSelector.build());
        player.getInventory().setItem(1, profile.build());
        player.getInventory().setItem(8, hidePlayers.build());

        if (player.hasPermission("sytaria.joinmsg")) {
            Perks.joinMessage(player);
        }
        if (player.hasPermission("sytaria.fly")) {
            if(Settings.autoFlyBoolean(player)) {
                Perks.fly(player);
            } else {
                player.setAllowFlight(true);
            }
        }
        if (player.hasPermission("sytaria.jump")) {
            if(Settings.autoJumpBoolean(player)) {
                Perks.doubleJump(player);
            } else {
                player.setAllowFlight(true);
            }
        }

    }
}
