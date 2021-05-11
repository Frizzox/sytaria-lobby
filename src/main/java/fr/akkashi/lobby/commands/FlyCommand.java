package fr.akkashi.lobby.commands;

import fr.akkashi.lobby.utils.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;


public class FlyCommand implements CommandExecutor {

    public static String prefix = "§d§lFLY §f» ";
    public static Set<UUID> flyOn = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("sytaria.fly")) {

                if (args.length == 0) {
                    if (flyOn.contains(player.getUniqueId())) {
                        player.setFlying(false);
                        flyOn.remove(player.getUniqueId());
                        player.sendMessage(prefix+ "§7Vous avez §ddésactivé§7 votre fly !");
                    } else {
                        player.setFlying(true);
                        flyOn.add(player.getUniqueId());
                        player.sendMessage(prefix+ "§7Vous avez §dactivé§7 votre fly !");
                    }
                } else player.sendMessage("La commande est /fly");
            } else {
                player.sendMessage(prefix+ "§7Vous devez avoir le grade §b§lVIP§7 ou §esupérieur§7 pour activer votre fly !");
            }

        } else {
            sender.sendMessage("§cSeul un joueur peut executer cette commande");
        }

        return false;
    }
}
