package me.quantumprofile.lol.commands;

import me.quantumprofile.lol.Items.CustomItemsManager;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.*;
import net.md_5.bungee.api.chat.hover.content.Content;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.ArrayList;
import java.util.List;

public class GICC implements CommandExecutor {
    /**stands for Give Items Custom Command*/
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("chupala consola");
            return true;
        }
        Player player = (Player) sender;
        if(command.getName().equalsIgnoreCase("goldencarrot")) {
            TextComponent test = new TextComponent(ChatColor.RED+"test"+ChatColor.DARK_GREEN+"iii"+ org.bukkit.ChatColor.GRAY+"LOL");
            test.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, ChatColor.GREEN+"eeeeeeeeeeee"));
            BaseComponent[] builder = new BaseComponent[4];
            HoverEvent event2 = new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder(ChatColor.GOLD+"test: "+ChatColor.AQUA+""+ChatColor.BOLD+"test").create());
            HoverEvent event = new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    builder);
            test.setHoverEvent(event2);
            player.spigot().sendMessage(test);



            //player.getInventory().addItem(CustomItemsManager.golden_carrot);
            //player.getInventory().addItem(CustomItemsManager.firework);
        }
        return true;
    }
}
