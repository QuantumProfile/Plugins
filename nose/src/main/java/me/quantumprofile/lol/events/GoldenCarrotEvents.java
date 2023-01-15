package me.quantumprofile.lol.events;

import me.quantumprofile.lol.Items.CustomItemsManager;
import me.quantumprofile.lol.Lol;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;

public class GoldenCarrotEvents implements Listener {
    @EventHandler
    public void onCarrotConsume(PlayerItemConsumeEvent event) {
            /*if(event.getItem().getItemMeta().equals(CustomItemsManager.golden_carrot.getItemMeta())){
                Player player = event.getPlayer();
                Bukkit.getScheduler().scheduleSyncDelayedTask(Lol.getInstance(), () -> {
                    player.getInventory().addItem(CustomItemsManager.golden_carrot);
                }, 5L);
            }*/
        }
    }
