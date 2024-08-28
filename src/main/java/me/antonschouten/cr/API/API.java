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

    private static void clearChestsInChunk(Chunk c) {
        BlockState[] tileEntities = c.getTileEntities();
        for (BlockState b : tileEntities) {
            if (b instanceof Chest chest) {
                chest.getInventory().clear();
            }
        }
    }

    public static void clearChestWorld(Player p) {
        World w = p.getWorld();
        Chunk[] loadedChunks = w.getLoadedChunks();
        for (Chunk c : loadedChunks) {
            clearChestsInChunk(c);
        }
    }
    public static void clearChestChunk(Player p){
        clearChestChunk(p,1);
    }
    public static void clearChestChunk(Player p, Integer radius) {
        if (radius <= 1) {
            Chunk c = p.getLocation().getChunk();
            clearChestsInChunk(c);
        } else {
            Chunk chunk = p.getLocation().getChunk();
            int chunkX = chunk.getX();
            int chunkZ = chunk.getZ();

            for (int x = chunkX - radius; x <= chunkX + radius; x++) {
                for (int z = chunkZ - radius; z <= chunkZ + radius; z++) {
                    Chunk c = p.getWorld().getChunkAt(x, z);
                    if (c.isLoaded()) {
                        clearChestsInChunk(c);
                    } else {
                        Bukkit.getLogger().info("Chunk at (" + x + ", " + z + ") is not loaded. Cannot clear chests.");
                    }
                }
            }
        }
    }

    public static void clearChestServer(Player p) {
        World w = (World) Bukkit.getWorlds();
        Chunk[] loadedChunks = w.getLoadedChunks();
        for (Chunk c : loadedChunks) {
            clearChestsInChunk(c);
        }
    }
}