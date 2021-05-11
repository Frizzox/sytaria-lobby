package fr.akkashi.lobby.events;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Cancels implements Listener {

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {

        Player player = e.getPlayer();

        if(e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            if(e.getClickedBlock().equals(Material.ENCHANTMENT_TABLE) || e.getClickedBlock().getType().equals(Material.ANVIL) || e.getClickedBlock().equals(Material.CHEST) || e.getClickedBlock().equals(Material.TRAPPED_CHEST) || e.getClickedBlock().equals(Material.ENDER_CHEST) || e.getClickedBlock().equals(Material.WORKBENCH) || e.getClickedBlock().equals(Material.TRAP_DOOR)) {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onMobSpawn(EntitySpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onFoodChanges(FoodLevelChangeEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof Player) {
            e.setCancelled(true);
        }
    }
}
