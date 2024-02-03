package it.hns.randomdrops;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class RandomDrops extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        // List of all Matrials
        Material[] materials = Material.values();
        // Get a random Material
        Material randomMaterial = materials[(int) (Math.random() * materials.length)];
        // Drop the random Material
        event.getBlock().getWorld().dropItemNaturally(event.getBlock().getLocation(), new org.bukkit.inventory.ItemStack(randomMaterial));
        // Delete the block
        event.getBlock().setType(Material.AIR);
        // Set the drop to the random Material
        event.setDropItems(false);
    }
}
