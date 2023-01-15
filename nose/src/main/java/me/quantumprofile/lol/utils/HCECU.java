package me.quantumprofile.lol.utils;

import me.quantumprofile.lol.ScoresAndTeams.Teams;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.entity.Player;

public class HCECU {
    /**stands for Hover and Click Events Chat Utils*/
    public static TextComponent getMessage(){
        TextComponent god = new TextComponent(Teams.getPrefix("Server")+"Server");
        god.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/whisper Server "));
        god.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Server\nType: God\nUnknown id").create()));
        return god;
    }
    public static TextComponent getMessage(Player player){
        if(!Teams.IsPlayerInTeam("BestAdmin",player)&&Teams.getPlayerTeam(player)!=null) {
            TextComponent prefix = new TextComponent(Teams.getPrefix(player));
            prefix.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell " + player.getDisplayName() + " "));
            prefix.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder(player.getDisplayName() + "\nType: Player\n" + player.getUniqueId()).create()));
            TextComponent name = new TextComponent(player.getDisplayName());prefix.addExtra(name);
            prefix.addExtra(Teams.getOptionalTC("cubito"));
            return prefix;
        }
        else if(Teams.IsPlayerInTeam("BestAdmin",player)){
            TextComponent name1 = new TextComponent(org.bukkit.ChatColor.GOLD+ ""+org.bukkit.ChatColor.BOLD+"[God]");
            TextComponent name2 = new TextComponent("[Best Admin] ");
            name2.setColor(ChatColor.of("#00ffbb"));name2.setBold(true);name1.addExtra(name2);
            name1.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell " + player.getDisplayName() + " "));
            name1.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder(player.getDisplayName() + "\nType: Player\n" + player.getUniqueId()).create()));
            name1.addExtra(ChatColor.RESET+player.getDisplayName());
            return name1;
        }
        else if(Teams.getPlayerTeam(player)==null){
            TextComponent nothing = new TextComponent(player.getDisplayName());
            nothing.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell " + player.getDisplayName() + " "));
            nothing.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder(player.getDisplayName() + "\nType: Player\n" + player.getUniqueId()).create()));
        }
        return null;
    }
    public static TextComponent getWhisper(){
        TextComponent god = new TextComponent(org.bukkit.ChatColor.GOLD+""+ org.bukkit.ChatColor.BOLD+"[God] "+
                ChatColor.RESET+"Server");
        god.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/whisper Server "));
        god.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder("Server\nType: God\nUnknown ID").create()));
        return god;
    }
    public static TextComponent getWhisper(Player player){
        if(!Teams.IsPlayerInTeam("BestAdmin",player)){
            TextComponent name = new TextComponent(org.bukkit.ChatColor.ITALIC+Teams.getPrefix(player)+player.getDisplayName());
            name.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell "+player.getDisplayName()+" "));
            name.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder(player.getDisplayName()+"\nType: Player\n"+player.getUniqueId()).create()));
            return name;
        }
        else if(Teams.getPlayerTeam(player)==null){
            TextComponent nothing = new TextComponent("");
            nothing.addExtra(player.getDisplayName());
            nothing.setColor(ChatColor.GRAY);
            nothing.setItalic(true);
            nothing.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell "+player.getDisplayName()+" "));
            nothing.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder(player.getDisplayName()+"\nType: Player\n"+player.getUniqueId()).create()));
            return nothing;
        }
        else if(Teams.IsPlayerInTeam("BestAdmin",player)){
            TextComponent name0 = new TextComponent("");name0.setItalic(true);
            TextComponent name1 = new TextComponent(org.bukkit.ChatColor.GOLD+ ""+org.bukkit.ChatColor.BOLD+"[God]");
            name0.addExtra(name1);
            TextComponent name2 = new TextComponent("[Best Admin] ");
            name2.setColor(ChatColor.of("#00ffbb"));name2.setBold(true);name0.addExtra(name2);
            name0.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND, "/tell " + player.getDisplayName() + " "));
            name0.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                    new ComponentBuilder(player.getDisplayName() + "\nType: Player\n" + player.getUniqueId()).create()));
            TextComponent name3 = new TextComponent(player.getDisplayName());
            name3.setColor(ChatColor.GRAY);name3.setBold(false);name0.addExtra(name3);
            return name0;
        }
        return null;
    }
}
