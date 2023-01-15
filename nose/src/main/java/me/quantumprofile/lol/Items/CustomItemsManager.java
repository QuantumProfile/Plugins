package me.quantumprofile.lol.Items;

import me.quantumprofile.lol.Lol;
import me.quantumprofile.lol.customcraft.Table;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.event.HandlerList;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;
import org.bukkit.inventory.meta.ItemMeta;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CustomItemsManager {

    private String internalName;
    private NamespacedKey recipe_namespace;
    private Recipe recipe;
    private ItemStack item;
    private static NamespacedKey key;
    public static CustomItemsManager CustomItem;
    private static HashSet<CustomItemsManager> items = new HashSet<>();
    public static void ItemBase() {
        /*CustomItemsManager sh = new StoneHelmet();
        items.add(sh);
        CustomItemsManager tl = new TotemLol();
        items.add(tl);
        CustomItemsManager t = new Table();
        items.add(t);
        CustomItemsManager sb = new StoneBoots();
        items.add(sb);*/
        items.add(new StoneHelmet());
        items.add(new TotemLol());
        items.add(new Table());
        items.add(new StoneBoots());
    }
    public CustomItemsManager(String internalName, String displayName, String... descriptions){
        this.internalName = internalName;
        recipe_namespace = new NamespacedKey(Lol.getInstance(),internalName);
        this.item = createItem();
        ItemMeta itemMeta = this.item.getItemMeta();
        if(displayName != null && !displayName.isEmpty()){
            itemMeta.setDisplayName(displayName);
        }
        ArrayList<String> lore = new ArrayList<>();
        if(descriptions.length >0){
            lore.addAll(Arrays.asList(descriptions));
        }
        itemMeta.setLore(lore);
        this.item.setItemMeta(itemMeta);
        recipe = createRecipe();
        registerRecipe();
        CustomItem = this;
        registerItem();
    }
    public NamespacedKey getRecipeNamespace(){
        return recipe_namespace;
    }
    public static ItemStack getItem(String internalName){
        for(CustomItemsManager item : items){
            if(item.getInternalName().equals(internalName)){
                return item.getItem();
            }
        }
        /*for (int i=0;i<items.size();i++){
            if(items.get(i).getInternalName().equals(internalName)){
                return items.get(i).getItem();
            }
        }*/
        return null;
    }
    public void registerItem(){
        if(this.item !=null){

        }
    }
    public String getInternalName(){
        return this.internalName;
    }
    public ItemStack getItem(){
        return this.item;
    }
    public ItemStack createItem(){
        return null;
    }
    public Recipe createRecipe(){
        return null;
    }
    public Recipe getRecipe(){
        return recipe;
    }

    public void registerRecipe(){
        if(this.recipe != null){
            Bukkit.getServer().addRecipe(getRecipe());
        }
    }
    public void unregisterRecipe(){
        if(this.recipe != null){
            Bukkit.removeRecipe(getRecipeNamespace());
        }
    }
}
