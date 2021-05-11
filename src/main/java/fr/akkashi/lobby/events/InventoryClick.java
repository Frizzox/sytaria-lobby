package fr.akkashi.lobby.events;

import fr.akkashi.lobby.utils.helpful.ItemBuilder;
import fr.akkashi.lobby.utils.Settings;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static fr.akkashi.lobby.events.ItemsInteract.menuProfile;
import static fr.akkashi.lobby.events.ItemsInteract.settingsMenu;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {

        ItemStack item = e.getCurrentItem();
        Player player = (Player) e.getWhoClicked();
        Inventory inv = e.getInventory();

        if (item.getType().equals(null)) return;

        if (inv.getName().equals("§8Menu Principal")) {
            e.setCancelled(true);
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
                if (item.getItemMeta().getDisplayName().equals("§f» §aSurvie §7(§61.16.5§7)")) {
                    player.sendMessage("§cLe survie est actuellement fermé. Veuillez réessayer plus tard !");
                    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
                }
                if (item.getItemMeta().getDisplayName().equals("§f» §cBedwars §7(§61.8.x-1.16.5§7)")) {
                    player.sendMessage("§cLe bedwars est actuellement fermé. Veuillez réessayer plus tard !");
                    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
                }
                if (item.getItemMeta().getDisplayName().equals("§f» §bSmasher §7(§61.8.x-1.16.5§7)")) {
                    player.sendMessage("§cLe smasher est actuellement fermé. Veuillez réessayer plus tard !");
                    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
                }
                if (item.getItemMeta().getDisplayName().equals("§4» §cFermer")) {
                    player.closeInventory();
                }
            }
        }
        if (inv.getName().equals("§8Profil")) {
            e.setCancelled(true);
            if (item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
                if (item.getItemMeta().getDisplayName().equals("§e» §6Cosmétiques")) {
                    player.sendMessage("§cLes cosmétiques arriveront dans une prochaine mise à jour...");
                    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
                }
                if (item.getItemMeta().getDisplayName().equals("§e» §6Boutique")) {
                    player.sendMessage("§cLa boutique arrivera dans une prochaine mise à jour...");
                    player.playSound(player.getLocation(), Sound.ANVIL_BREAK, 3, 3);
                }
                if (item.getItemMeta().getDisplayName().equals("§e» §6Fermer")) {
                    player.closeInventory();
                }
                if(item.getItemMeta().getDisplayName().equals("§e» §6Paramètres")) {

                    ItemBuilder isVip = new ItemBuilder(Material.NAME_TAG).name("§b» §9Informations").addLore("§f§lVIP§7: " + Settings.isVip(player));
                    ItemBuilder fly = new ItemBuilder(Material.FEATHER).name("§b» §9Auto-Fly").addLore("§f§lACTIF§7: " +Settings.autoFlyString(player));
                    ItemBuilder jump = new ItemBuilder(Material.SLIME_BALL).name("§b» §9Auto-Jump").addLore("§f§lACTIF§7: " +Settings.autoJumpString(player));
                    ItemBuilder vitre = new ItemBuilder(Material.STAINED_GLASS_PANE).name("§7").data(11);
                    ItemBuilder goBack = new ItemBuilder(Material.ARROW).name("§b» §9Retour au Profil");

                    settingsMenu.setItems(0, 8, vitre.build());
                    settingsMenu.setItem(4, isVip.build());
                    settingsMenu.setItem(11, fly.build());
                    settingsMenu.setItem(15, jump.build());
                    settingsMenu.setItems(18, 26, vitre.build());
                    settingsMenu.setItem(22, goBack.build());

                    settingsMenu.open(player);
                }
            }
        }
        if(inv.getName().equals("§8Paramètres")) {
            e.setCancelled(true);
            if(item.hasItemMeta() && item.getItemMeta().hasDisplayName()) {
                if(item.getItemMeta().getDisplayName().equals("§b» §9Auto-Fly")) {
                    if(Settings.autoFlyBoolean(player)) {
                        Settings.autoFlyOn.remove(player.getUniqueId());
                    } else {
                        Settings.autoJumpOn.add(player.getUniqueId());
                    }
                }
                if(item.getItemMeta().getDisplayName().equals("§b» §9Auto-Jump")) {
                    if(Settings.autoJumpBoolean(player)) {
                        Settings.autoJumpOn.remove(player.getUniqueId());
                    } else {
                        Settings.autoJumpOn.add(player.getUniqueId());
                    }
                }
                if(item.getItemMeta().getDisplayName().equals("§b» §9Retour au Profil")) {
                    menuProfile.open(player);
                }
            }
        }
    }
}
