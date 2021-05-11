package fr.akkashi.lobby.commands;

import fr.akkashi.lobby.utils.Settings;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class DoubleJumpCommand implements CommandExecutor {

    public static Set<UUID> doubleJumpActivated = new HashSet<>();
    public static String prefix = "§d§lJUMP §f» ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player) {
            Player player = (Player) sender;

            if (player.hasPermission("sytaria.jump")) {
                if (Settings.flyOnBoolean(player)) {
                    player.sendMessage(prefix + "§cVous ne pouvez pas activer le fly et le double-jump en même temps");
                } else if (doubleJumpActivated.contains(player.getUniqueId())) {
                    doubleJumpActivated.remove(player.getUniqueId());
                    player.sendMessage(prefix + "§7Vous avez §ddésactivé §7votre double-jump !");
                } else {
                    doubleJumpActivated.add(player.getUniqueId());
                    player.sendMessage(prefix + "§7Vous avez §dactivé §7votre double-jump !");
                }
            } else
                player.sendMessage(prefix + "§7Vous devez avoir le grade §b§lVIP§7 ou supérieur pour activer votre double-jump !");
        } else {
            sender.sendMessage("§cSeul un joueur peut executer cette commande");
        }

        return false;
    }
}
