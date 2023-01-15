package me.quantumprofile.lol.Items;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.UUID;

public class StoneBoots extends CustomItemsManager{
    @Nose
    public StoneBoots() {
        super(
                "stone_boots",
                ChatColor.GRAY + "" + ChatColor.BOLD + "Stone Boots"
        );
    }
    public ItemStack createItem() {
        ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
        ItemMeta meta = item.getItemMeta();
        AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(),"defense",2,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
        AttributeModifier modifier2 = new AttributeModifier(UUID.randomUUID(),"slowness",-0.01,
                AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, modifier2);
        item.setItemMeta(meta);

        LeatherArmorMeta leathermeta = (LeatherArmorMeta) item.getItemMeta();
        leathermeta.setColor(Color.GRAY);
        item.setItemMeta(leathermeta);

        return item;
    }
    public ShapedRecipe createRecipe() {
        ShapedRecipe recipe = new ShapedRecipe(getRecipeNamespace(),getItem());
        recipe.shape("A A","A A");
        recipe.setIngredient('A',Material.STONE);
        return recipe;
    }
}
