package me.quantumprofile.lol.Items;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TotemLol extends CustomItemsManager{
    @Nose
    public TotemLol() {
        super(
                "totem",
                net.md_5.bungee.api.ChatColor.of("#00FFBB") + "" + "TotemLol",
                ChatColor.WHITE + "" + "Usos Restantes:4"
        );
    }
    @Override
    public ItemStack createItem() {
        ItemStack item = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
    @Override
    public ShapedRecipe createRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(getRecipeNamespace(),getItem());
        recipe.shape("AA","AA");
        recipe.setIngredient('A',Material.TOTEM_OF_UNDYING);
        return recipe;
    }
}
