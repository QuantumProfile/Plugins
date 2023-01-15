package me.quantumprofile.lol.customcraft.AboutOpeners;

import me.quantumprofile.lol.Lol;
import me.quantumprofile.lol.customcraft.AboutOpeners.CustomCraftOpener;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CCC {
    /**stands for Custom Crafting Command*/
    private int scheduleTaskID = -1;
    private List<Player> players;
    private List<CustomCraftOpener> openers;
    private List<Integer> scheduleIDs;
    public CCC (){
        this.openers = new ArrayList<>();

    }
    public CustomCraftOpener getOpener(Player player){
        for(int i=0;i<this.openers.size();i++){
            if(this.openers.get(i).getPlayer().equals(player)){
                return this.openers.get(i);
            }
        }
        return null;
    }
    public List<CustomCraftOpener> getOpeners(){
        return openers;
    }
    public void addOpener(Player player){
        CustomCraftOpener opener = new CustomCraftOpener(player);
        this.openers.add(opener);
    }
    public void removeOpener(Player player){
        List<CustomCraftOpener> openers = this.openers.stream().filter(p -> p.getPlayer().equals(player)).collect(Collectors.toList());
        if(openers.size() >0){
            this.openers.remove(openers.get(0));
        }
    }
    public void removeOpener2(CustomCraftOpener opener){
        if(this.openers.contains(opener)){
            this.openers.remove(opener);
        }
    }
    public void startSchedule(){
        this.scheduleTaskID = Bukkit.getScheduler().runTaskTimerAsynchronously(Lol.getInstance(),()->{

        },0L,20L).getTaskId();
    }
    public void stopSchedule() {
        Bukkit.getScheduler().cancelTask(this.scheduleTaskID);
    }
    public Integer getScheduleTaskID(CustomCraftOpener opener){
        int scheduleTaskID = opener.getScheduleTaskID();
        for (int i=0;i<scheduleIDs.size();i++){
            if(scheduleIDs.get(i) == scheduleTaskID){return scheduleIDs.get(i);}
        }
        return null;
    }
    public void addScheduler(int scheduler){
        scheduleIDs.add(scheduler);
    }
    public void removeScheduler(int scheduler){
        scheduleIDs.remove(scheduler);
    }
}
