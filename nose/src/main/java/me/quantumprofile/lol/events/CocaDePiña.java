package me.quantumprofile.lol.events;
import me.quantumprofile.lol.Items.CustomItemsManager;
import me.quantumprofile.lol.ScoresAndTeams.Teams;
import me.quantumprofile.lol.utils.HCECU;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scoreboard.Team;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class CocaDePiña implements Listener {
    @EventHandler
    public void onPlayerBreakBlock(BlockBreakEvent event) {
        Block blockBroken = event.getBlock();
        if (blockBroken.getType() == Material.DIRT) {
            event.setCancelled(true);
            blockBroken.setType(Material.AIR);
            ItemStack queseyo = new ItemStack(Material.DIRT, 1);
            ItemMeta meta = queseyo.getItemMeta();
            meta.setDisplayName(net.md_5.bungee.api.ChatColor.of("#7d4814") + "" + ChatColor.BOLD + ChatColor.ITALIC + "Tierra Premium, test");
            queseyo.setItemMeta(meta);
            blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), queseyo);
        }
        if (blockBroken.getType() == Material.GRASS_BLOCK) {
            event.setCancelled(true);
            blockBroken.setType(Material.AIR);
            ItemStack queseyo = new ItemStack(Material.GRASS_BLOCK, 1);
            ItemMeta meta = queseyo.getItemMeta();
            meta.setDisplayName(net.md_5.bungee.api.ChatColor.of("#5bba5d") + "" + ChatColor.BOLD + ChatColor.ITALIC + "Pasto Premium");
            queseyo.setItemMeta(meta);
            blockBroken.getWorld().dropItemNaturally(blockBroken.getLocation(), queseyo);
        }
    }
    @EventHandler
    public void onStoneHelmetUse(PlayerItemDamageEvent event) {
        if(event.getItem().hasItemMeta() && event.getItem().getItemMeta().hasCustomModelData()){
            if(event.getItem().getItemMeta().getCustomModelData() == 1 &&
                    event.getItem().getType().equals(Material.LEATHER_HELMET)){
                ItemStack item =event.getItem();
                event.setCancelled(true);
                if(Math.random() <= 0.4545){
                    short actualUses = item.getDurability();
                    item.setDurability((short) (actualUses + 1));
                }
                ItemMeta meta = item.getItemMeta();
                List<String> lore = new ArrayList<>();
                short actualDurability = (short) ((55 - item.getDurability())*2.2);
                lore.add(ChatColor.WHITE+"Durability: "+ actualDurability+" / 121");
                meta.setLore(lore);
                item.setItemMeta(meta);
                if(item.getDurability()>= item.getType().getMaxDurability()){
                    event.getPlayer().getInventory().setHelmet(null);
                }
            }
        }
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();
        String message = event.getMessage();
        event.setCancelled(true);
        TextComponent emblema = new TextComponent("<");
        emblema.addExtra(HCECU.getMessage(player));
        emblema.addExtra("> "+message);
        for(Player online : Bukkit.getOnlinePlayers()){
            online.spigot().sendMessage(emblema);
        }
        Bukkit.getServer().getLogger().info("<"+Teams.getPrefix(player)+player.getDisplayName()+"> "+message);
    }
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event){
        if(event.getPlayer().getDisplayName().equals("x_cubito_x")){
            if(!Teams.getTeamIfExists("cubito").getEntries().contains("x_cubito_x")){
                Teams.addPlayerToTeam("cubito",event.getPlayer());
                event.getPlayer().sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Server"+
                        " has promoted you to cubito");
            }
        }
    }
}
