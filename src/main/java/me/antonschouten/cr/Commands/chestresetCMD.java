package me.antonschouten.cr.Commands;

import me.antonschouten.cr.Main;
import me.antonschouten.cr.API.API;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class chestresetCMD implements CommandExecutor {
    Player p;

    public chestresetCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        this.p = (Player)sender;
        if (!this.p.hasPermission("chestreset.cmd")) {
            this.p.sendMessage(Main.perms);
            return true;
        } else if (args.length == 0) {
            sendHelpMessage();
            return true;
        } else if (args[0].equalsIgnoreCase("world")) {
            API.clearChestWorld(this.p);
            this.p.sendMessage(Main.prefix + "All chest's in world§c " + this.p.getWorld().getName() + " §fare now reseted.");
            return true;
        } else if (args[0].equalsIgnoreCase("chunk")) {
            if (args.length == 1) {
                API.clearChestChunk(this.p);
                this.p.sendMessage(Main.prefix + "All chest's in your current chunk are now reseted.");
            } else {
                try {
                    int radius = Integer.parseInt(args[1]);
                    API.clearChestChunk(this.p, radius);
                    this.p.sendMessage(Main.prefix + "All chest's in the specified range of chunks are now reseted.");
                } catch (NumberFormatException e) {
                    this.p.sendMessage("§cInvalid input. Please enter a valid number for the radius.");
                    return true;
                }
            }
            return true;
        } else if (args[0].equalsIgnoreCase("server")) {
            API.clearChestServer(this.p);
            this.p.sendMessage(Main.prefix + "All chest's in the server are now reseted.");
            return true;
        } else {
            sendHelpMessage();
            return true;
        }
    }

    private void sendHelpMessage() {
        p.sendMessage("§f► §c/chestreset world §fClear all chest's in your current world.");
        p.sendMessage("§f► §c/chestreset chunk [radius] §fClear all chest's in the radius of your current chunk.");
        p.sendMessage("§f► §c/chestreset server §fClear all chest's in the server.");
        p.sendMessage("§2Plugin made by: §aAS-network");
    }
}