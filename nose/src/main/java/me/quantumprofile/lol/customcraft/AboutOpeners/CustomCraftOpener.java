package me.quantumprofile.lol.customcraft.AboutOpeners;

import me.quantumprofile.lol.Lol;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitScheduler;

public class CustomCraftOpener {
    private Player player;
    private boolean isInCC;
    private int scheduleTaskID;
    public CustomCraftOpener(Player player){
        this.player = player;
        this.isInCC = false;
        this.scheduleTaskID =-1;
    }
    public Player getPlayer(){
        return this.player;
    }
    public void setInCC(boolean isInCC){
        this.isInCC = isInCC;
    }
    public boolean isInCC(){
        return this.isInCC;
    }
    public void setScheduleTaskID(int scheduleTaskID){
        this.scheduleTaskID = scheduleTaskID;
    }
    public int getScheduleTaskID(){
        return this.scheduleTaskID;
    }
    public void startScheduler(){
        this.scheduleTaskID = Bukkit.getScheduler().runTaskTimerAsynchronously(Lol.getInstance(),() -> {
            if(this.isInCC){Bukkit.broadcastMessage(this.player.getDisplayName() +" " +
                    "tiene el inventario custom abierto");}
                },20L,20L).getTaskId();
    }
    public void stopScheduler(){
        if(!this.isInCC){Bukkit.getScheduler().cancelTask(this.scheduleTaskID);}
    }
}
