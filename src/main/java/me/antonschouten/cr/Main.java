//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.antonschouten.cr;

import me.antonschouten.cr.Commands.chestresetCMD;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static String prefix = "§c§l[§fChestReset§c§l] §f";
    public static String perms;
    public static Plugin pl;

    static {
        perms = prefix + "You don't have enough permissions.";
    }

    public Main() {
    }

    public void onEnable() {
        pl = this;
        this.registerCommands();
        Bukkit.getConsoleSender().sendMessage(prefix + "Plugin succesfully enabled.");
    }

    public void onDisable() {
        pl = null;
        Bukkit.getConsoleSender().sendMessage(prefix + "Plugin succesfully disabled.");
    }

    public void registerCommands() {
        this.getCommand("chestreset").setExecutor(new chestresetCMD());
    }
}
