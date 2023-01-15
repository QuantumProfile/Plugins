package me.quantumprofile.lol.customcraft.inventory;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomCrafting implements InventoryHolder {
    private Inventory inv;
    public CustomCrafting() {
        inv = Bukkit.createInventory(this, 45, ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + "a" +
                net.md_5.bungee.api.ChatColor.of("#8f6c2c") + "" + ChatColor.BOLD + " Custom Crafting "
                + ChatColor.DARK_AQUA + "" + ChatColor.MAGIC + "a");
        Inv();
    }
    private void Inv(){
        ItemStack item;
        for (int i = 0; i < 5; i++) {
            item = createItem(Material.LIME_STAINED_GLASS_PANE);
            inv.setItem(i,item);
        }
        for (int i = 36; i < 41; i++) {
            item = createItem(Material.LIME_STAINED_GLASS_PANE);
            inv.setItem(i,item);
        }
        for (int i = 41; i < 45; i++) {
            item = createItem(Material.BLUE_STAINED_GLASS_PANE);
            inv.setItem(i,item);
        }
        for (int i = 5; i < 9; i++) {
            item = createItem(Material.BLUE_STAINED_GLASS_PANE);
            inv.setItem(i,item);
        }
        for (int i = 14; i < 17; i++) {
            item = createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            inv.setItem(i,item);
        }
        for (int i = 32; i < 35; i++) {
            item = createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
            inv.setItem(i,item);
        }
        item = createItem(Material.LIME_STAINED_GLASS_PANE);
        inv.setItem(9,item);
        inv.setItem(18,item);
        inv.setItem(27,item);
        inv.setItem(13,item);
        inv.setItem(22,item);
        inv.setItem(31,item);
        item = createItem(Material.BLUE_STAINED_GLASS_PANE);
        inv.setItem(17,item);
        inv.setItem(26,item);
        inv.setItem(35,item);
        item = createItem(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        inv.setItem(23,item);
        inv.setItem(25,item);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.GRAY + "Introduce un crafteo custom");
        lore.add(ChatColor.GRAY + "válido, y aquí aparecerá");
        lore.add(ChatColor.GRAY + "el item que quieras craftear");
        item = new ItemStack(Material.BARRIER);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.BOLD + "Crafteo custom no válido.");
        meta.setLore(lore);
        item.setItemMeta(meta);
        inv.setItem(24,item);
        inve = inv;
    }
    private ItemStack createItem(Material mat) {
        ItemStack item = new ItemStack(mat, 1);
        ItemMeta meta = item.getItemMeta();
        item.setItemMeta(meta);
        return item;
    }
    public static Inventory inve;
    @Override
    public Inventory getInventory() {
        return inv;
    }
}
