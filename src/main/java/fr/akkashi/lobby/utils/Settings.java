package fr.akkashi.lobby.utils;

import fr.akkashi.lobby.commands.DoubleJumpCommand;
import fr.akkashi.lobby.commands.FlyCommand;
import org.bukkit.entity.Player;

import java.util.*;

public class Settings {

    public static Set<UUID> autoFlyOn = new HashSet<>();
    public static Set<UUID> autoJumpOn = new HashSet<>();

    public static String hasFlyPermission(Player player) {
        if (player.hasPermission("sytaria.fly")) {
            return "§a§lOUI";
        } else {
            return "§c§lNON";
        }
    }
    public static String flyOnString(Player player) {

        if (FlyCommand.flyOn.contains(player.getUniqueId())) {
            return "§a§lOUI";
        } else {
            return "§c§lNON";
        }
    }
    public static boolean flyOnBoolean(Player player) {

        if (FlyCommand.flyOn.contains(player.getUniqueId())) {
            return true;
        } else {
            return false;
        }
    }
    public static String autoFlyString(Player player) {
        if (autoFlyOn.contains(player.getUniqueId())) {
            return "§a§lOUI";
        } else {
            return "§c§lNON";
        }
    }
    public static boolean autoFlyBoolean(Player player) {
        if (autoFlyOn.contains(player.getUniqueId())) {
            return true;
        } else {
            return false;
        }
    }

    public static String hasJumpPermission(Player player) {
        if (player.hasPermission("sytaria.jump")) {
            return "§a§lOUI";
        } else {
            return "§c§lNON";
        }
    }
    public static boolean jumpOnboolean(Player player) {
        return DoubleJumpCommand.doubleJumpActivated.contains(player.getUniqueId());
    }
    public static String jumpOnString(Player player) {
        if (jumpOnboolean(player)) {
            return "§a§lOUI";
        } else {
            return "§c§lNON";
        }
    }
    public static String autoJumpString(Player player) {
        if (autoJumpOn.contains(player.getUniqueId())) {
            return "§a§lOUI";
        } else {
            return "§c§lNON";
        }
    }
    public static boolean autoJumpBoolean(Player player) {
        if (autoJumpOn.contains(player.getUniqueId())) {
            return true;
        } else {
            return false;
        }
    }

    public static String hasSpeedPermission(Player player) {
        if (player.hasPermission("sytaria.speed")) {
            return "§a§lOUI";
        } else {
            return "§c§lNON";
        }
    }
    public static float getPlayerSpeed(Player player) {
        return player.getWalkSpeed() * 10 / 2;
    }

    public static String isVip(Player player) {
        if (player.hasPermission("group.vip") || player.hasPermission("group.vip+") || player.hasPermission("group.famous") || player.hasPermission("group.staff") || player.hasPermission("group.helpeur") || player.hasPermission("group.modo") || player.hasPermission("group.resp") || player.hasPermission("group.admin") || player.isOp()) {
            return "§a§lOUI";
        } else {
            return "§c§lNON";
        }
    }
}
