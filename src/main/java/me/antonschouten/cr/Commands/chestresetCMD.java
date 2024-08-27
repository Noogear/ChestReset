//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

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
            this.p.sendMessage("§f► §c/chestreset world §fClear all chest's in your current world.");
            this.p.sendMessage("§f► §c/chetstrest chunk §fClear all chest's in your current chunk.");
            this.p.sendMessage("§f► §c/chestreset server §fClear all chest's in the server.");
            this.p.sendMessage("§2Plugin made by: §aAS-network");
            return true;
        } else if (args[0].equalsIgnoreCase("world")) {
            API.clearChestWorld(this.p);
            this.p.sendMessage(Main.prefix + "All chest's in world§c " + this.p.getWorld().getName() + " §fare now reseted.");
            return true;
        } else if (args[0].equalsIgnoreCase("chunk")) {
            API.clearChestChunk(this.p);
            this.p.sendMessage(Main.prefix + "All chest's in your current chunk are now reseted.");
            return true;
        } else if (args[0].equalsIgnoreCase("server")) {
            API.clearChestServer(this.p);
            this.p.sendMessage(Main.prefix + "All chest's in the server are now reseted.");
            return true;
        } else {
            this.p.sendMessage("§f► §c/chestreset world §fClear all chest's in your current world.");
            this.p.sendMessage("§f► §c/chetstrest chunk §fClear all chest's in your current chunk.");
            this.p.sendMessage("§f► §c/chestreset server §fClear all chest's in the server.");
            this.p.sendMessage("§2Plugin made by: §aAS-network");
            return true;
        }
    }
}
