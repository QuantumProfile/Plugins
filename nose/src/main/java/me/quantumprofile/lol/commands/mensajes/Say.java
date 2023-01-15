package me.quantumprofile.lol.commands.mensajes;

import me.quantumprofile.lol.ScoresAndTeams.Teams;
import me.quantumprofile.lol.utils.HCECU;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class Say implements TabExecutor {
    public static void SendMessage(Player player,String message){
        TextComponent emblema = new TextComponent("<");
        emblema.addExtra(HCECU.getMessage(player));
        emblema.addExtra("> "+message);
        for(Player online : Bukkit.getOnlinePlayers()){
            online.spigot().sendMessage(emblema);
        }
        Bukkit.getServer().getLogger().info("<"+Teams.getPrefix(player)+player.getDisplayName()+"> "+message);
    }
    public static void SendMessage(String message){
        TextComponent emblema = new TextComponent("<");
        emblema.addExtra(HCECU.getMessage());
        emblema.addExtra("> "+message);
        for(Player online : Bukkit.getOnlinePlayers()){
            online.spigot().sendMessage(emblema);
        }
        Bukkit.getServer().getLogger().info("<"+Teams.getPrefix("Server")+"Server> "+message);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender.hasPermission("sayandtell")){
            if(command.getName().equalsIgnoreCase("customsay")) {
                if(sender instanceof Player){
                    Player player = (Player) sender;
                    if(args.length >0 && args[0].equals("as")){
                        if(args.length>1) {
                            if (args[1].equals("Server")) {
                                if (args.length > 2) {
                                    String mensaje = args[2];
                                    for (int i = 3; i < args.length; i++) {
                                        mensaje = mensaje + " " + args[i];
                                    }
                                    SendMessage(mensaje);
                                } else {
                                    player.sendMessage(ChatColor.RED + "Escribe un mensaje pe");
                                }
                            }
                            else {
                                Player target = Bukkit.getPlayerExact(args[1]);
                                if (target != null) {
                                    if (args.length > 2) {
                                        String mensaje = args[2];
                                        for (int i = 3; i < args.length; i++) {
                                            mensaje = mensaje + " " + args[i];
                                        }
                                        Bukkit.broadcastMessage("<" + Teams.getPrefix(target) + target.getDisplayName()
                                                + "> " + mensaje);
                                    } else {player.sendMessage(ChatColor.RED + "Escribe un mensaje pe");}
                                } else {player.sendMessage(ChatColor.RED + "el jugador no está conectado o no existe");}
                            }
                        }else {player.sendMessage(ChatColor.RED + "Comando incompleto, " +
                                "se usa así: "+ "/customsay as "+ChatColor.WHITE+"<Jugador o Consola> <mensaje>");}
                    } else {player.sendMessage(ChatColor.RED + "Argumento incorrecto, " +
                            "se usa así: "+ "/customsay as "+ChatColor.WHITE+"<Jugador o Consola> <mensaje>");}
                }else if(args.length>0){
                    String mensaje = args[0];
                    for(int i=1;i< args.length;i++){
                        mensaje = mensaje + " "+ args[i];}
                    SendMessage(mensaje);
                    Bukkit.getServer().getLogger().info("test");
                }
                else {sender.sendMessage("escribe un mensaje pe");}
            }
        }else {sender.sendMessage(ChatColor.RED +"Nope.");}return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(args.length == 1){
            List<String> arguments = new ArrayList<>();
            arguments.add("as");
            return arguments;
        }
        else if(args.length == 2){
            List<String> playerNames = new ArrayList<>();
            Player[] players = new Player[Bukkit.getServer().getOnlinePlayers().size()];
            Bukkit.getServer().getOnlinePlayers().toArray(players);
            for(int i=0;i<players.length;i++){
                playerNames.add(players[i].getName());
            }
            playerNames.add("Server");
            return playerNames;
        }
        return null;
    }
}
