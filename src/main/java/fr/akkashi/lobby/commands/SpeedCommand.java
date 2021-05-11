package fr.akkashi.lobby.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCommand implements CommandExecutor {

    public static String prefix = "§d§lSPEED §f» ";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {

        if(sender instanceof Player) {
            Player player = (Player) sender;

            if(player.hasPermission("sytaria.speed")) {
                if(args.length == 1) {
                    if(args[0].equals("1")) {
                        player.sendMessage(prefix+ "§7Votre vitesse a été mise à §d1§7 !");
                        player.setWalkSpeed((float) 0.2);
                    } else if(args[0].equals("2")) {
                        player.sendMessage(prefix+ "§7Votre vitesse a été mise à §d2§7 !");
                        player.setWalkSpeed((float) 0.4);
                    } else if(args[0].equals("3")) {
                        player.sendMessage(prefix+ "§7Votre vitesse a été mise à §d3§7 !");
                        player.setWalkSpeed((float) 0.6);
                    } else if(args[0].equals("4")) {
                        player.sendMessage(prefix+ "§7Votre vitesse a été mise à §d4§7 !");
                        player.setWalkSpeed((float) 0.8);
                    } else if(args[0].equals("5")) {
                        player.sendMessage(prefix+ "§7Votre vitesse a été mise à §d5§7 !");
                        player.setWalkSpeed(1);
                    } else player.sendMessage(prefix+ "§cLa commande est /speed <1;2;3;4;5>");
                } else player.sendMessage(prefix+ "§cLa commande est /speed <1;2;3;4;5>");
            }

        } else sender.sendMessage("§cSeul un joueur peut executer cette commande");
        return false;
    }
}
