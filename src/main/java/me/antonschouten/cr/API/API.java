//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package me.antonschouten.cr.API;

import org.bukkit.Bukkit;
import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.block.BlockState;
import org.bukkit.block.Chest;
import org.bukkit.entity.Player;

public class API {
    public API() {
    }

    public static void clearChestWorld(Player p) {
        World w = p.getWorld();
        Chunk[] var5;
        int var4 = (var5 = w.getLoadedChunks()).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Chunk c = var5[var3];
            BlockState[] var9;
            int var8 = (var9 = c.getTileEntities()).length;

            for(int var7 = 0; var7 < var8; ++var7) {
                BlockState b = var9[var7];
                if (b instanceof Chest) {
                    Chest chest = (Chest)b;
                    chest.getInventory().clear();
                }
            }
        }

    }

    public static void clearChestChunk(Player p) {
        Chunk c = p.getLocation().getChunk();
        BlockState[] var5;
        int var4 = (var5 = c.getTileEntities()).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            BlockState b = var5[var3];
            if (b instanceof Chest) {
                Chest chest = (Chest)b;
                chest.getInventory().clear();
            }
        }

    }

    public static void clearChestServer(Player p) {
        World w = (World)Bukkit.getWorlds();
        Chunk[] var5;
        int var4 = (var5 = w.getLoadedChunks()).length;

        for(int var3 = 0; var3 < var4; ++var3) {
            Chunk c = var5[var3];
            BlockState[] var9;
            int var8 = (var9 = c.getTileEntities()).length;

            for(int var7 = 0; var7 < var8; ++var7) {
                BlockState b = var9[var7];
                if (b instanceof Chest) {
                    Chest chest = (Chest)b;
                    chest.getInventory().clear();
                }
            }
        }

    }
}
