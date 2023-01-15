package me.quantumprofile.lol.customcraft.events;

import me.quantumprofile.lol.Items.CustomItemsManager;
import me.quantumprofile.lol.Lol;
import me.quantumprofile.lol.customcraft.AboutOpeners.CCC;
import me.quantumprofile.lol.customcraft.AboutOpeners.CustomCraftOpener;
import me.quantumprofile.lol.customcraft.inventory.CustomCrafting;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class CrafteoCustom implements Listener {

    private int scheduleTaskID =-1;
    private CCC ccc;

    public CrafteoCustom() {
        this.ccc = new CCC();
    }
    @EventHandler
    public void onRightClick(PlayerInteractEvent event) {
        if(event.getAction() == Action.RIGHT_CLICK_AIR||event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getItem() != null) {
                ItemStack item = CustomItemsManager.getItem("custom_table");
                    if(event.getItem().getItemMeta().equals(item.getItemMeta())){
                        Player player = event.getPlayer();
                        CustomCrafting cc = new CustomCrafting();
                        player.openInventory(cc.getInventory());
                        if(event.getAction() == Action.RIGHT_CLICK_BLOCK){event.setCancelled(true);}
                }
                /*if(event.getItem().getItemMeta().equals(CustomItemsManager.CustomCT.getItemMeta())){
                    Player player = event.getPlayer();
                    CustomCrafting cc = new CustomCrafting();
                    player.openInventory(cc.getInventory());
                    if(event.getAction() == Action.RIGHT_CLICK_BLOCK){event.setCancelled(true);}
                }*/
            }
        }
    }
    @EventHandler
    public void onClick(InventoryClickEvent e){
        if(e.getClickedInventory() == null) {return;}
        if(e.getClickedInventory().getHolder() instanceof CustomCrafting) {
            if(e.getSlot() != 10 && e.getSlot() != 11 && e.getSlot() != 12 && e.getSlot() != 19
            && e.getSlot() != 20 && e.getSlot() != 21 && e.getSlot() != 28 && e.getSlot() != 29 && e.getSlot() != 30){
                e.setCancelled(true);
            }
            Player player = (Player) e.getWhoClicked();
        }
    }
    private Player player;
    CustomCrafting inv = new CustomCrafting();
    CustomCraftOpener opener = new CustomCraftOpener(player);
    public CustomCraftOpener getCustomCraftOpener(Player player){
        return opener;
    }
    @EventHandler
    public void onOpenInventory(InventoryOpenEvent event){
        if(event.getInventory().equals(CustomCrafting.inve)){
            /*Player player = (Player) event.getPlayer();
            CrafteoCustom que = new CrafteoCustom();
            que.setPlayer(player);
            que.setInCCMenu(true);*/
            Player player = (Player) event.getPlayer();
            ccc.addOpener(player);
            ccc.getOpener(player).setInCC(true);
            this.scheduleTaskID = ccc.getOpener(player).getScheduleTaskID();
            this.scheduleTaskID = Bukkit.getScheduler().runTaskTimerAsynchronously
                    (Lol.getInstance(),() -> {
                        if(ccc.getOpener(player).isInCC()){
                            Bukkit.broadcastMessage(ccc.getOpener(player).getPlayer().getDisplayName() +" " +
                                "tiene el inventario custom abierto");}
                    },20L,20L).getTaskId();
            ccc.getOpener(player).setScheduleTaskID(this.scheduleTaskID);
            //CustomCraftOpener opener = new CustomCraftOpener(player);
            //this.player = player;
        }
    }
    @EventHandler
    public void onCloseInventory(InventoryCloseEvent event){
        if(event.getInventory().equals(CustomCrafting.inve)){
            /*Player player = (Player) event.getPlayer();
            CrafteoCustom que = new CrafteoCustom();
            que.setPlayer(player);
            que.setInCCMenu(false);*/
            Player player = (Player) event.getPlayer();
            ccc.getOpener(player).setInCC(false);
            Bukkit.getScheduler().cancelTask(ccc.getOpener(player).getScheduleTaskID());
            ccc.removeOpener(player);
            //this.opener.setInCC(false);

            for(int i = 10;i<31;i++){
                if(i==10||i==11||i==12||i==19||i==20||i==21||i==28||i==29||i==30){
                    if(event.getInventory().getItem(i)!=null){
                        event.getPlayer().getInventory().addItem(event.getInventory().getItem(i));
                    }
                }
            }
        }
    }

    /*private boolean isInCCMenu;
    private Player player;
    public void setPlayer(Player player){
        this.player = player;
        this.isInCCMenu = false;
    }
    public void setInCCMenu(boolean isInCCMenu){
        this.isInCCMenu = isInCCMenu;
    }
    public boolean isInCCMenu(){
        return this.isInCCMenu;
    }*/
    /*public void Timer(){
        this.scheduleTaskID = Bukkit.getScheduler().runTaskTimerAsynchronously(Lol.getInstance(), () -> {
            Bukkit.broadcastMessage("asi es papus");
        }, 0L, 20L).getTaskId();
    }*/
}