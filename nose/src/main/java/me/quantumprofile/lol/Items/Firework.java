package me.quantumprofile.lol.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Firework {
    public static void Firework() {
        createItem();
    }
    public static ItemStack firework;
    private static void createItem() {
        ItemStack item = new ItemStack(Material.FIREWORK_ROCKET);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.MAGIC + "a" +
                ChatColor.RED + "" + ChatColor.BOLD + " Infinite Firework "
                + ChatColor.AQUA + "" + ChatColor.MAGIC + "a");
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "El cohete infinito");
        lore.add(ChatColor.WHITE + "" + ChatColor.RED + "" + ChatColor.MAGIC + "a"
                + ChatColor.WHITE + " ∞ " + ChatColor.RED + "" + ChatColor.MAGIC + "a");
        meta.setLore(lore);
        item.setItemMeta(meta);
        firework = item;
    }
}
