package me.quantumprofile.lol;

import me.quantumprofile.lol.Items.CustomItemsManager;
import me.quantumprofile.lol.ScoresAndTeams.Teams;
import me.quantumprofile.lol.commands.GICC;
import me.quantumprofile.lol.commands.Reload;
import me.quantumprofile.lol.commands.mensajes.Rank;
import me.quantumprofile.lol.commands.mensajes.Say;
import me.quantumprofile.lol.commands.mensajes.Whisper;
import me.quantumprofile.lol.ScoresAndTeams.teamRemover;
import me.quantumprofile.lol.events.CocaDePiña;
import me.quantumprofile.lol.customcraft.events.CrafteoCustom;
import me.quantumprofile.lol.events.FireworkEvent;
import me.quantumprofile.lol.events.GoldenCarrotEvents;
import org.bukkit.command.CommandExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Lol extends JavaPlugin {
    private static Lol instance;
    FileConfiguration config;
    File configfile;
    public FileConfiguration getConfigur(){
        return config;
    }
    public File getConfigFile(){
        return configfile;
    }
    public void setConfig(FileConfiguration config){
        this.config = config;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        configfile = new File(getDataFolder(),"config.yml");

        System.out.println("Potato 🥔");
        instance = this;
        getServer().getPluginManager().registerEvents(new CocaDePiña(), this);
        getServer().getPluginManager().registerEvents(new CrafteoCustom(), this);
        getServer().getPluginManager().registerEvents(new GoldenCarrotEvents(), this);
        getServer().getPluginManager().registerEvents(new FireworkEvent(),this);
        CustomItemsManager.ItemBase();
        getCommand("goldencarrot").setExecutor(new GICC());
        getCommand("customsay").setExecutor(new Say());
        getCommand("lol").setExecutor((CommandExecutor) new Reload());
        getCommand("whisper").setExecutor(new Whisper());
        getCommand("rank").setExecutor(new Rank());
        getCommand("team").setExecutor(new teamRemover());
        Teams.TeamsCreator();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(":|");
    }
    public static Lol getInstance() {
        return instance;
    }
}