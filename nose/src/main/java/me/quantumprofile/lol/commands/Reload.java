package me.quantumprofile.lol.commands;

import me.quantumprofile.lol.Lol;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.InvalidDescriptionException;
import org.bukkit.plugin.InvalidPluginException;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Reload implements TabExecutor {
    final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("Lol");
    public static Plugin getPluginByName(String name){
        for (Plugin plugin : Bukkit.getPluginManager().getPlugins()) {
            if (name.equalsIgnoreCase(plugin.getName()))
                return plugin;
        }
        return null;
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if(player.isOp()){
                if(args[0].equals("reload")){
                    player.sendMessage("Reloading \"Lol\"...");
                    /*Plugin plugin = getPluginByName("Lol");
                    PluginManager pluginManager = Bukkit.getPluginManager();
                    pluginManager.disablePlugin(plugin);
                    pluginManager.enablePlugin(plugin);*/
                    for (Player online : Bukkit.getOnlinePlayers())
                        online.updateCommands();
                    Bukkit.getPluginManager().getPlugin("Lol").reloadConfig();

                    /*File pluginDir = new File("plugins");
                    if(!pluginDir.isDirectory()){
                        player.sendMessage(ChatColor.RED + "Reload failed. error: unvalid directory");
                    }else {
                        File pluginFile = new File(pluginDir,plugin.getName()+".jar");
                        if(!pluginFile.isFile()){
                            player.sendMessage(ChatColor.RED + "Reload failed. error: unable to validate plugin file");
                        }else {
                            Plugin target=null;
                            try {
                                player.sendMessage("registering file...");
                                target = Bukkit.getPluginManager().loadPlugin(pluginFile);
                                player.sendMessage("file registered. File equals: "+target);
                            } catch (InvalidPluginException e) {
                                e.printStackTrace();
                            } catch (InvalidDescriptionException e) {
                                e.printStackTrace();
                            }
                            target.onLoad();
                            Bukkit.getPluginManager().enablePlugin(target);
                            player.sendMessage(ChatColor.GREEN + "Plugin reloaded succesfully");
                        }
                        player.sendMessage(ChatColor.RED +"Reload error. File not found or" +
                                "an internal error ocurred");
                    }*/
                    //Bukkit.getPluginManager().disablePlugin(Lol.getInstance());
                    player.sendMessage(ChatColor.GREEN+"Reload complete");
                    return true;
                }
                else {player.sendMessage(ChatColor.RED +"Invalid argument, " +
                        "use /lol reload");}
            }else {player.sendMessage(ChatColor.RED + "Nope.");}
        }else {
            if(args.length>0&&args[0] == "reload"){
                System.out.println("Reloading \"Lol\"...");
                Lol.getInstance().reloadConfig();
                System.out.println("Reload complete");
            }else {System.out.println("Invalid argument, use /lol reload");}
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1){
            List<String> arguments = new ArrayList<>();
            arguments.add("reload");
            return arguments;
        }
        return null;
    }
}
