package me.quantumprofile.lol.Items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class GoldenCarrot {
    public static void GoldenCarrot() {
        createItem();
    }
    private static ItemStack golden_carrot;
    private static void createItem() {
        ItemStack item = new ItemStack(Material.GOLDEN_CARROT);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.AQUA + "" + ChatColor.MAGIC + "a" +
                ChatColor.GOLD + "" + ChatColor.BOLD + " Infinite Carrot "
                + ChatColor.AQUA + "" + ChatColor.MAGIC + "a");
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        List<String> lore = new ArrayList<>();
        lore.add(ChatColor.WHITE + "La zanahoria");
        lore.add(ChatColor.WHITE + "ininita " + ChatColor.GOLD + "" + ChatColor.MAGIC + "a"
        + ChatColor.WHITE + " ∞ " + ChatColor.GOLD + "" + ChatColor.MAGIC + "a");
        meta.setLore(lore);
        item.setItemMeta(meta);
        golden_carrot = item;
    }
}
