package fr.akkashi.lobby.events;

import fr.akkashi.lobby.commands.FlyCommand;
import fr.akkashi.lobby.utils.helpful.FastInv;
import fr.akkashi.lobby.utils.helpful.ItemBuilder;
import fr.akkashi.lobby.utils.Settings;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemsInteract implements Listener {

    public static FastInv menuProfile = new FastInv(54, "§8Profil");
    public static FastInv menuInventory = new FastInv(54, "§8Menu Principal");
    public static FastInv settingsMenu = new FastInv(27, "§8Paramètres");

    @EventHandler
    public void onInteractOnItem(PlayerInteractEvent e) {

        ItemStack item = e.getItem();
        Player player = e.getPlayer();

        if (item == null) return;

        if (e.getAction().equals(Action.RIGHT_CLICK_BLOCK) || e.getAction().equals(Action.RIGHT_CLICK_AIR)) {

            e.setCancelled(true);

            if (item.getItemMeta().getDisplayName().equals("§dMenu Principal §5§l● §7(Clic-Droit)")) {


                ItemBuilder vitre = new ItemBuilder(Material.STAINED_GLASS_PANE).data(6).name("§7");
                ItemBuilder survie = new ItemBuilder(Material.GRASS).name("§f» §aSurvie §7(§61.16.5§7)").addLore("§7Cliquez ici pour vous connecter", "§7au serveur §aSurvie§7 !");
                ItemBuilder bedwars = new ItemBuilder(Material.BED).name("§f» §cBedwars §7(§61.8.x-1.16.5§7)").addLore("§7Cliquez ici pour vous connecter", "§7au serveur §cBedwars§7 !");
                ItemBuilder smasher = new ItemBuilder(Material.ARROW).name("§f» §bSmasher §7(§61.8.x-1.16.5§7)").addLore("§7Cliquez ici pour vous connecter", "§7au serveur §bSmasher§7 !");
                ItemBuilder close = new ItemBuilder(Material.BARRIER).name("§4» §cFermer");

                menuInventory.setItems(menuInventory.getCorners(), vitre.build());
                menuInventory.setItem(13, survie.build());
                menuInventory.setItem(20, smasher.build());
                menuInventory.setItem(24, bedwars.build());
                menuInventory.setItem(49, close.build());
                menuInventory.open(player);
                player.playSound(player.getLocation(), Sound.ORB_PICKUP, 3, 3);

            }
            if (item.getItemMeta().getDisplayName().equals("§dProfil §5§l● §7(Clic-Droit)")) {

                String grade = "§d» §7§lGRADE§7: %luckperms_highest_group_by_weight%";
                grade = PlaceholderAPI.setPlaceholders(player, grade);
                ItemBuilder info = new ItemBuilder(Material.PAPER).name("§e» §6Informations").addLore("§d» §7§lPSEUDO§7: §fAkkashi", grade, "§d» §7§lPRIORITÉ§7: §fSoon...");
                ItemBuilder close = new ItemBuilder(Material.BARRIER).name("§e» §6Fermer");
                ItemBuilder vitre = new ItemBuilder(Material.STAINED_GLASS_PANE).data(4).name("§7");
                ItemBuilder fly = new ItemBuilder(Material.FEATHER).name("§e» §6Fly").addLore("§d» §7§lPERMISSION§7: " + Settings.hasFlyPermission(player), "§d» §7§lFLY ACTIF§7: " + Settings.flyOnString(player));
                ItemBuilder doubleJump = new ItemBuilder(Material.SLIME_BALL).name("§e» §6Double-Jump").addLore("§d» §7§lPERMISSION§7: " + Settings.hasJumpPermission(player), "§d» §7§lJUMP ACTIF§7: " + Settings.jumpOnString(player));
                ItemBuilder speed = new ItemBuilder(Material.SUGAR).name("§e» §6Vitesse").addLore("§d» §7§lPERMISSION§7: " + Settings.hasSpeedPermission(player), "§d» §7§lVITESSE§7: §f" + Settings.getPlayerSpeed(player));
                ItemBuilder cosmetics = new ItemBuilder(Material.EMERALD).name("§e» §6Cosmétiques").addLore("§d» §7§lSoon...");
                ItemBuilder store = new ItemBuilder(Material.GOLD_INGOT).name("§e» §6Boutique").addLore("§d» §7§lSoon...");
                ItemBuilder settings = new ItemBuilder(Material.COMMAND).name("§e» §6Paramètres").addLore("§d» §7Clique ici pour ouvrir les paramètres.");

                menuProfile.setItems(menuProfile.getCorners(), vitre.build());
                menuProfile.setItem(13, info.build());
                menuProfile.setItem(22, settings.build());
                menuProfile.setItem(29, cosmetics.build());
                menuProfile.setItem(31, doubleJump.build());
                menuProfile.setItem(30, store.build());
                menuProfile.setItem(32, speed.build());
                menuProfile.setItem(33, fly.build());
                menuProfile.setItem(49, close.build());
                menuProfile.open(player);
                player.playSound(player.getLocation(), Sound.CLICK, 3, 3);

            }
        }
    }

}
