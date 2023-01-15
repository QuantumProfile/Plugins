package me.quantumprofile.lol.commands.mensajes;

import me.quantumprofile.lol.ScoresAndTeams.Teams;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Team;

import java.util.ArrayList;
import java.util.List;

public class Rank implements TabExecutor {
    private static void getFunction(Player sender,Player player,String mode){
        if(mode.equals("promote")){
            if(Teams.IsPlayerInTeam("BestAdmin",player)){
                sender.sendMessage(ChatColor.DARK_AQUA+"Cannot promote any further");
            }
            else if(Teams.IsPlayerInTeam("ADMIN",player)){
                Teams.addPlayerToTeam("BestAdmin",player);
                Teams.removePlayerFromTeam("ADMIN",player);
                sender.sendMessage(ChatColor.GREEN+"You promoted "+player.getDisplayName()+" to Best Admin");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+(sender).getDisplayName()+
                        " has promoted you to Best Admin");
            }
            else if(Teams.IsPlayerInTeam("MIEMBRO",player)){
                Teams.addPlayerToTeam("ADMIN",player);
                Teams.removePlayerFromTeam("MIEMBRO",player);
                sender.sendMessage(ChatColor.GREEN+"You promoted "+player.getDisplayName()+" to ADMIN");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+(sender).getDisplayName()+
                        " has promoted you to ADMIN");
            }
            else {
                Teams.addPlayerToTeam("MIEMBRO",player);
                sender.sendMessage(ChatColor.GREEN+"You promoted "+player.getDisplayName()+" to MIEMBRO");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+(sender).getDisplayName()+
                        " has promoted you to MIEMBRO");
            }
        }
        if(mode.equals("demode")){
            if(Teams.IsPlayerInTeam("BestAdmin",player)){
                Teams.addPlayerToTeam("ADMIN",player);
                Teams.removePlayerFromTeam("BestAdmin",player);
                sender.sendMessage(ChatColor.DARK_GREEN+"You demoted "+player.getDisplayName()+" to ADMIN");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+((Player) sender).getDisplayName()+
                        " has demoted you to ADMIN");
            }
            else if(Teams.IsPlayerInTeam("ADMIN",player)){
                Teams.addPlayerToTeam("MIEMBRO",player);
                Teams.removePlayerFromTeam("ADMIN",player);
                sender.sendMessage(ChatColor.DARK_GREEN+"You demoted "+player.getDisplayName()+" to MIEMBRO");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+((Player) sender).getDisplayName()+
                        " has demoted you to MIEMBRO");
            }
            else if(Teams.IsPlayerInTeam("MIEMBRO",player)){
                Teams.removePlayerFromTeam("MIEMBRO",player);
                sender.sendMessage(ChatColor.DARK_GREEN+"You demoted "+player.getDisplayName());
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+((Player) sender).getDisplayName()+
                        " has demoted you");
            }
            else {
                sender.sendMessage(ChatColor.DARK_PURPLE+"You cannot demote any further");
            }
        }
    }
    private static void getFunction(Player player,String mode){
        if(mode.equals("promote")){
            if(Teams.IsPlayerInTeam("BestAdmin",player)){
                Bukkit.getServer().getLogger().info(ChatColor.DARK_AQUA+"Cannot promote any further");
            }
            else if(Teams.IsPlayerInTeam("ADMIN",player)){
                Teams.addPlayerToTeam("BestAdmin",player);
                Teams.removePlayerFromTeam("ADMIN",player);
                Bukkit.getServer().getLogger().info(ChatColor.GREEN+"You promoted "+player.getDisplayName()+" to Best Admin");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Server"+
                        " has promoted you to Best Admin");
            }
            else if(Teams.IsPlayerInTeam("MIEMBRO",player)){
                Teams.addPlayerToTeam("ADMIN",player);
                Teams.removePlayerFromTeam("MIEMBRO",player);
                Bukkit.getServer().getLogger().info(ChatColor.GREEN+"You promoted "+player.getDisplayName()+" to ADMIN");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Server"+
                        " has promoted you to ADMIN");
            }
            else {
                Teams.addPlayerToTeam("MIEMBRO",player);
                Bukkit.getServer().getLogger().info(ChatColor.GREEN+"You promoted "+player.getDisplayName()+" to MIEMBRO");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Server"+
                        " has promoted you to MIEMBRO");
            }
        }
        if(mode.equals("demode")){
            if(Teams.IsPlayerInTeam("BestAdmin",player)){
                Teams.addPlayerToTeam("ADMIN",player);
                Teams.removePlayerFromTeam("BestAdmin",player);
                Bukkit.getServer().getLogger().info(ChatColor.DARK_GREEN+"You demoted "+player.getDisplayName()+" to ADMIN");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Server"+
                        " has demoted you to ADMIN");
            }
            else if(Teams.IsPlayerInTeam("ADMIN",player)){
                Teams.addPlayerToTeam("MIEMBRO",player);
                Teams.removePlayerFromTeam("ADMIN",player);
                Bukkit.getServer().getLogger().info(ChatColor.DARK_GREEN+"You demoted "+player.getDisplayName()+" to MIEMBRO");
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Server"+
                        " has demoted you to MIEMBRO");
            }
            else if(Teams.IsPlayerInTeam("MIEMBRO",player)){
                Teams.removePlayerFromTeam("MIEMBRO",player);
                Bukkit.getServer().getLogger().info(ChatColor.DARK_GREEN+"You demoted "+player.getDisplayName());
                player.sendMessage(ChatColor.GRAY+""+ChatColor.ITALIC+"Server"+
                        " has demoted you");
            }
            else {
                Bukkit.getServer().getLogger().info(ChatColor.DARK_PURPLE+"You cannot demote any further");
            }
        }
    }
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            if(sender.isOp()){
                if(args.length>0){
                    if(args[0].equals("Promote")){
                        if(args.length>1){
                            Player player = Bukkit.getPlayer(args[1]);
                            if(player!=null){
                                getFunction((Player) sender,player,"promote");
                            }else {sender.sendMessage(ChatColor.RED+"Unknown player");}
                        } else {sender.sendMessage(ChatColor.RED+"Specify a player");}
                    }
                    else if(args[0].equals("Demote")){
                        if(args.length>1){
                            Player player = Bukkit.getPlayer(args[1]);
                            if(player!=null){
                                getFunction((Player) sender,player,"demote");
                            } else {sender.sendMessage(ChatColor.RED+"Unknown player");}
                        } else {sender.sendMessage(ChatColor.RED+"Specify a player");}
                    }
                    else if(args[0].equals("Modify")||args[0].equals("set")){
                        if(args.length>1){
                            Player player = Bukkit.getPlayerExact(args[1]);
                            if(player!=null){
                                if(args.length>2){
                                    for(String team : Teams.getTeams()){
                                        if(args[2].equals(team)){
                                            Player Sender = (Player) sender;
                                            Team Left = Teams.getPlayerTeam(player);
                                            Team Right = Teams.getTeamIfExists(team);
                                            if(Left!=null){Left.removeEntry(player.getDisplayName());}
                                            Teams.addPlayerToTeam(Right.getName(),player);
                                            sender.sendMessage(Teams.PorD(Left,Right,Sender,player,"sender"));
                                            if(Teams.getTeamLevel(Left)!=Teams.getTeamLevel(Right)){
                                                player.sendMessage(Teams.PorD(Left,Right,Sender,player,"target"));
                                            }
                                        }
                                    }
                                    if(!Teams.getTeams().contains(args[2])){
                                        sender.sendMessage(ChatColor.RED+"Invalid rank, please enter a valid rank");
                                    }
                                } else {sender.sendMessage(ChatColor.RED+"You need to specify a rank");}
                            } else {sender.sendMessage(ChatColor.RED+"Unknown player");}
                        } else {sender.sendMessage(ChatColor.RED+"Specify a player");}
                    }
                    else {sender.sendMessage(ChatColor.RED+"Invalid argument, use Promote, Demote or Modify (set)");}
                }
                else {
                    sender.sendMessage(ChatColor.RED+"Invalid argument, use Promote, Demote or Modify (set)");
                }
            }else {sender.sendMessage(ChatColor.RED+"Nope.");}
        }else {
            if(args.length>0){
                if(args[0].equals("Promote")){
                    if(args.length>1){
                        Player player = Bukkit.getPlayer(args[1]);
                        if(player!=null){
                            getFunction(player,"promote");
                        }else {sender.sendMessage(ChatColor.RED+"Unknown player");}
                    } else {sender.sendMessage(ChatColor.RED+"Specify a player");}
                }
                else if(args[0].equals("Demote")){
                    if(args.length>1){
                        Player player = Bukkit.getPlayer(args[1]);
                        if(player!=null){
                            getFunction(player,"demote");
                        } else {sender.sendMessage(ChatColor.RED+"Unknown player");}
                    } else {sender.sendMessage(ChatColor.RED+"Specify a player");}
                }
                else if(args[0].equals("Modify")||args[0].equals("set")){
                    if(args.length>1){
                        Player player = Bukkit.getPlayerExact(args[1]);
                        if(player!=null){
                            if(args.length>2){
                                for(String team : Teams.getTeams()){
                                    if(args[2].equals(team)){
                                        Team Left = Teams.getPlayerTeam(player);
                                        Team Right = Teams.getTeamIfExists(team);
                                        if(Left!=null){Left.removeEntry(player.getDisplayName());}
                                        Teams.addPlayerToTeam(Right.getName(),player);
                                        sender.sendMessage(Teams.PorD(Left,Right,player,"sender"));
                                        if(Teams.getTeamLevel(Left)!=Teams.getTeamLevel(Right)){
                                            player.sendMessage(Teams.PorD(Left,Right,player,"target"));
                                        }
                                    }
                                }
                                if(!Teams.getTeams().contains(args[2])){
                                    sender.sendMessage(ChatColor.RED+"Invalid rank, please enter a valid rank");
                                }
                            } else {sender.sendMessage(ChatColor.RED+"You need to specify a rank");}
                        } else {sender.sendMessage(ChatColor.RED+"Unknown player");}
                    } else {sender.sendMessage(ChatColor.RED+"Specify a player");}
                }
                else {sender.sendMessage(ChatColor.RED+"Invalid argument, use Promote, Demote or Modify (set)");}
            }
            else {
                sender.sendMessage(ChatColor.RED+"Invalid argument, use Promote, Demote or Modify (set)");
            }
        }
        return false;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        if(sender instanceof Player && sender.isOp()){
            if(args.length==1){
                List<String> arguments = new ArrayList<>();
                arguments.add("Promote");
                arguments.add("Demote");
                arguments.add("Modify");
                return arguments;
            }
            if(args.length==3&&(args[0].equals("Modify")||args[0].equals("set"))){
                List<String> arguments = new ArrayList<>();
                for(String team : Teams.getTeams()){
                    arguments.add(team);
                }
                return arguments;
            }
        }
        return null;
    }
}
