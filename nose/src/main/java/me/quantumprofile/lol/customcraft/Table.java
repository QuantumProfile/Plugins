package me.quantumprofile.lol.customcraft;

import me.quantumprofile.lol.Items.CustomItemsManager;
import me.quantumprofile.lol.Items.Nose;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;


public class Table extends CustomItemsManager{
    @Nose
    public  Table() {
       super(
               "custom_table",
               ChatColor.AQUA + "" + ChatColor.MAGIC + "a" +
                       net.md_5.bungee.api.ChatColor.of("#ab843c") + "" + ChatColor.BOLD + " Custom Crafting "
                       + ChatColor.AQUA + "" + ChatColor.MAGIC + "a"
       );
    }
    public ItemStack createItem() {
        ItemStack item = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta meta = item.getItemMeta();
        meta.addEnchant(Enchantment.LUCK, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }
    public ShapedRecipe createRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(getRecipeNamespace(),getItem());
        recipe.shape("AAA","BCB","BDB");
        recipe.setIngredient('A',Material.LEATHER);
        recipe.setIngredient('B',Material.OAK_PLANKS);
        recipe.setIngredient('C',Material.IRON_AXE);
        recipe.setIngredient('D',Material.SHEARS);
        return recipe;
    }
}
