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
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class Whisper implements TabExecutor {
    public static void SendWhisper(Player sender,Player receptor,String message){
        TextComponent receiver = new TextComponent("");
        receiver.setColor(net.md_5.bungee.api.ChatColor.GRAY);receiver.setItalic(true);
        receiver.addExtra(HCECU.getWhisper());
        receiver.addExtra(" whispers to you: "+message);
        receptor.spigot().sendMessage(receiver);

        TextComponent thrower = new TextComponent("You whisper to ");
        thrower.setColor(net.md_5.bungee.api.ChatColor.GRAY);thrower.setItalic(true);
        thrower.addExtra(HCECU.getWhisper(sender));
        thrower.addExtra(": "+message);
        sender.spigot().sendMessage(thrower);
    }
    public static void SendWhisper(Player player, String message,String mode){
        if(mode.equals("send")){
            TextComponent receiver = new TextComponent("");
            receiver.setColor(net.md_5.bungee.api.ChatColor.GRAY);receiver.setItalic(true);
            receiver.addExtra(HCECU.getWhisper());
            receiver.addExtra(" whispers to you: "+message);
            player.spigot().sendMessage(receiver);
            Bukkit.getServer().getLogger().info("You whisper to "+ Teams.getPrefix(player) +player.getDisplayName()+": "+message);
        }
        else if(mode.equals("receive")){
            System.out.println(player.getDisplayName() +" le dice a la consola: "+message);
            TextComponent receiver = new TextComponent("You whisper to ");
            receiver.setColor(net.md_5.bungee.api.ChatColor.GRAY);receiver.setItalic(true);
            receiver.addExtra(HCECU.getWhisper());
            receiver.addExtra(": "+message);
            player.spigot().sendMessage(receiver);
            player.sendMessage(ChatColor.DARK_GRAY+"Este comando hace que el mensaje se envíe" +
                    " directamente a la consola del servidor");
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(command.getName().equalsIgnoreCase("whisper")) {
            if(sender instanceof Player){
                Player player = (Player) sender;
                if(player.isOp()){
                    if(args.length>0){
                        if(args[0].equals("as")){
                            if(args.length>1 && args[1].equals("Server")){
                                if(args.length>2 && args[2].equals("to")){
                                    Player target = Bukkit.getPlayerExact(args[3]);
                                    if(target !=null){
                                        if(args.length>4){
                                            String mensaje = args[4];
                                            for(int i=5;i< args.length;i++){
                                                mensaje = mensaje + " "+ args[i];
                                            }
                                            SendWhisper(player,target,mensaje);
                                        }else {player.sendMessage(ChatColor.RED + "Escribe un mensaje pe");}
                                    }else {player.sendMessage(ChatColor.RED +"Sujeto no válido, " +
                                            "introduzca un jugador válido o \"Server\"");}
                                }else{player.sendMessage(ChatColor.RED + "Comando incompleto, " +
                                        "se usa así: "+ "/whisper as Server to "+ChatColor.WHITE+"<Jugador> <mensaje>");}
                            }else{player.sendMessage(ChatColor.RED + "Comando incompleto, " +
                                    "se usa así: "+ "/whisper as Server to "+ChatColor.WHITE+"<Jugador> <mensaje>");}
                        }else {
                            if(args[0].equals("Server")){
                                if(args.length>1){
                                    String mensaje = args[1];
                                    for(int i=2;i< args.length;i++){
                                        mensaje = mensaje + " "+ args[i];
                                    }
                                    SendWhisper(player,mensaje,"receive");
                                }else {player.sendMessage(ChatColor.RED +"escribe un mensaje pe");}
                            } else {player.sendMessage(ChatColor.RED + "Argumento incorrecto o incompleto, " +
                                    "se usa así: " +ChatColor.GRAY +"/whisper Server "+ChatColor.WHITE+"<mensaje>");}
                        }
                    }else {player.sendMessage(ChatColor.RED + "Argumento incorrecto o incompleto, " +
                            "se usa así: "+ "/whisper as Server to "+ChatColor.WHITE+"<Jugador> <mensaje>");}
                }else {
                    if(args.length>0 && args[0].equals("Server")){
                        if(args.length>1){
                            String mensaje = args[1];
                            for(int i=2;i< args.length;i++){
                                mensaje = mensaje + " "+ args[i];
                            }
                            SendWhisper(player,mensaje,"receive");
                        }else {player.sendMessage(ChatColor.RED +"escribe un mensaje pe");}
                    } else {player.sendMessage(ChatColor.RED + "Argumento incorrecto o incompleto, " +
                            "se usa así: " +ChatColor.GRAY +"/whisper Server "+ChatColor.WHITE+"<mensaje>");}
                }
            }else {
                Player target = Bukkit.getPlayer(args[0]);
                if(target !=null){
                    if(args.length>1){
                        String mensaje = args[1];
                        for(int i=2;i< args.length;i++){
                            mensaje = mensaje + " "+ args[i];
                        }
                        SendWhisper(target,mensaje,"send");
                    }else {sender.sendMessage("escribe un mensaje pe");}
                }else {sender.sendMessage("el jugador no está conectado o no existe");}
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(sender instanceof Player){
            Player player = (Player) sender;
            if (player.isOp()){
                if(args.length==1){
                    List<String> arguments = new ArrayList<>();
                    arguments.add("as");
                    arguments.add("Server");
                    return arguments;
                }
                if(args.length==2 && args[0].equals("as")){
                    List<String> arguments = new ArrayList<>();
                    arguments.add("Server");
                    return arguments;
                }
                if(args.length==3 && args[1].equals("Server") && args[0].equals("as")){
                    List<String> arguments = new ArrayList<>();
                    arguments.add("to");
                    return arguments;
                }
            }else {
                if(args.length==1){
                    List<String> arguments = new ArrayList<>();
                    arguments.add("Server");
                    return arguments;
                }
            }
        }
        return null;
    }
}
