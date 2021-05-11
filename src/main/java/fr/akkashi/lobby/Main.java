package fr.akkashi.lobby;

import fr.akkashi.lobby.commands.DoubleJumpCommand;
import fr.akkashi.lobby.commands.FlyCommand;
import fr.akkashi.lobby.commands.SpeedCommand;
import fr.akkashi.lobby.events.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public ConsoleCommandSender log = Bukkit.getConsoleSender();
    private static Main INSTANCE;

    @Override
    public void onEnable() {
        INSTANCE = this;
        registerListeners();
        registerCommands();
        log.sendMessage("§6Sytaria Lobby has been enabled !");
    }

    @Override
    public void onDisable() {
        log.sendMessage("§cSytaria Lobby has been disabled !");
    }

    public void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new Cancels(), this);
        getServer().getPluginManager().registerEvents(new ItemsInteract(), this);
        getServer().getPluginManager().registerEvents(new InventoryClick(), this);
        getServer().getPluginManager().registerEvents(new DoubleJumpEvent(), this);
    }

    public void registerCommands() {
        fastCmd("fly", new FlyCommand());
        fastCmd("jump", new DoubleJumpCommand());
        fastCmd("speed", new SpeedCommand());
    }

    private void fastCmd(String command, CommandExecutor executor) {
        getCommand(command).setExecutor(executor);
    }

    public static Main getInstance() {
        return INSTANCE;
    }

}
