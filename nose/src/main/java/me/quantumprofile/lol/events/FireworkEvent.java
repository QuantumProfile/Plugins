package me.quantumprofile.lol.events;

import me.quantumprofile.lol.Items.CustomItemsManager;
import me.quantumprofile.lol.Lol;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;

public class FireworkEvent implements Listener {
    @EventHandler
    public static void onRightClick(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (event.getItem() != null) {
                /*if (event.getItem().getItemMeta().equals(CustomItemsManager.firework.getItemMeta())) {
                    Player player = event.getPlayer();
                    Bukkit.getScheduler().scheduleSyncDelayedTask(Lol.getInstance(), () -> {
                        player.getInventory().addItem(CustomItemsManager.firework);
                    }, 5L);
                }*/
            }
        }
    }
    @EventHandler
    public void PlayerIsFlying(PlayerToggleFlightEvent event) {
        Player player = event.getPlayer();
        boolean isFlying = player.isFlying();
    }
    @EventHandler
    public static void onRightClickTest(PlayerInteractEvent event) {
        Player player = event.getPlayer();
    }
    @EventHandler
    public static void onRightClick2(PlayerInteractEvent event) {
        if (event.getAction() == Action.RIGHT_CLICK_AIR) {
            if (event.getItem() != null) {
                /*if (event.getItem().getItemMeta().equals(CustomItemsManager.firework.getItemMeta())) {
                    Player player = event.getPlayer();
                    if(player.getLocation().getBlock().getRelative(BlockFace.DOWN).getType() == Material.AIR) {
                        if(player.getInventory().getChestplate().getType().equals(Material.ELYTRA)){
                            Bukkit.getScheduler().scheduleSyncDelayedTask(Lol.getInstance(), () -> {
                                player.getInventory().addItem(CustomItemsManager.firework);
                            }, 5L);
                        }
                    }
                }*/
            }
        }
    }
}
