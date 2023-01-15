package me.quantumprofile.lol.ScoresAndTeams;

import jdk.dynalink.beans.StaticClass;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.ComponentBuilder;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Teams {
    private static HashSet<Team> teams = new HashSet<>();
    private static Scoreboard board = Bukkit.getScoreboardManager().getMainScoreboard();
    private static HashSet<String> teamnames = new HashSet<>();
    public static HashSet<String> getTeams(){
        return teamnames;
    }
    private static void addTeam(String teamName){
        teamnames.add(teamName);
    }
    private static boolean IsRankTeam(Team team){
        for(String name : teamnames){
            if(team.getName().equals(name)){
                return true;
            }
        }
        return false;
    }
    private static void registerTeams(Scoreboard scoreboard,HashSet<String> teams){
        for(String name : teams){
            if(!contains(scoreboard,name)){
                scoreboard.registerNewTeam(name);
            }
        }
        for(Team team : scoreboard.getTeams()){
            if(IsRankTeam(team)){
                team.setPrefix(getPrefix(team.getName()));
                team.setSuffix(getSuffix(team.getName()));
                Teams.teams.add(team);
            }
        }
    }
    private static boolean contains(Scoreboard scoreboard, String teamName){
        return scoreboard.getTeams().contains(scoreboard.getTeam(teamName));
    }
    public static void createTeams(){
    }
    public static void TeamsCreator(){
        ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard scoreboard = scoreboardManager.getMainScoreboard();
        for(Team team : scoreboard.getTeams()){
            team.unregister();
        }
        String name1 = "LaConterNiceGang";
        if(!scoreboard.getObjectives().contains(scoreboard.getObjective(name1))){
            Objective objective= scoreboard.registerNewObjective(name1,"dummy",
                    ChatColor.DARK_AQUA+""+ChatColor.BOLD+name1);
            //objective.setDisplaySlot(DisplaySlot.SIDEBAR);
            Score score = objective.getScore("===="+ChatColor.RED +""+ChatColor.BOLD+"ADMINS"+ChatColor.RESET+"====");score.setScore(9);
            Score score1 = objective.getScore(ChatColor.GOLD+""+ChatColor.BOLD+"[God]"+ChatColor.RESET+" Server");score1.setScore(8);
            Score score2 = objective.getScore("QuantumProfile");score2.setScore(7);
            Score score3 = objective.getScore("Mauri_x_");score3.setScore(6);
            Score score4 = objective.getScore("===="+ChatColor.GREEN+""+ChatColor.BOLD+"MIEMBROS"+ChatColor.RESET+"====");score4.setScore(5);
            Score score5 = objective.getScore("x_cubito_x");score5.setScore(4);
            Score score6 = objective.getScore("Barowo");score6.setScore(3);
            Score score7 = objective.getScore("");score7.setScore(2);
            Score score8 = objective.getScore("LaConterNiceGang.Aternos.me");score8.setScore(1);
        }
        for(Player online : Bukkit.getOnlinePlayers()){
            online.setScoreboard(scoreboard);}
        registerTeamObjects();
        registerTeams(scoreboard,teamnames);
        board = scoreboard;
    }
    public static void onPlayerJoin(){
        for (Team t : teams){
            t.unregister();
        }
        teams.clear();
        registerTeams(board,teamnames);
        /*Team BestAdmin = board.registerNewTeam("BestAdmin");
        Team ADMIN = board.registerNewTeam("ADMIN");
        Team MIEMBRO = board.registerNewTeam("MIEMBRO");
        Team BUILDER = board.registerNewTeam("BUILDER");
        for(Team team : board.getTeams()){
            team.setPrefix(getPrefix(team.getName()));
            teams.add(team);
        }*/

        /*Scoreboard scoreboard = scoreboardManager.getNewScoreboard();
        Objective tab = scoreboard.registerNewObjective("tabList","dummy", org.bukkit.ChatColor.AQUA+"Tab");
        tab.setDisplaySlot(DisplaySlot.PLAYER_LIST);
        Score tab_score = tab.getScore(Teams.Emblema(player)+"Qp");
        Objective below_name = scoreboard.registerNewObjective("belowName","dummy", org.bukkit.ChatColor.AQUA+"Below Name");
        below_name.setDisplaySlot(DisplaySlot.BELOW_NAME);
        Score bn_score = below_name.getScore(Teams.Emblema(player)+"Qp");
        player.setScoreboard(scoreboard);*/
    }
    public static Team getTeamIfExists(String teamName){
        for(Team t: teams){
            if(t.getName().equals(teamName)){return t;}
        }
        return null;
    }
    public static void removePlayerFromTeam(String teamName,Player player){
        Team team = getTeam(teamName);
        team.removeEntry(player.getDisplayName());
    }
    public static void addPlayerToTeam(String teamName,Player player){
        Team team = getTeam(teamName);
        team.addEntry(player.getDisplayName());
    }
    private static Team getTeam(String teamName){
        for (Team team : teams){
            if(team.getName().equals(teamName)){return team;}
        }
        return null;
    }
    public static boolean IsPlayerInTeam(String teamName, Player player){
        Set<String> entries = getTeamIfExists(teamName).getEntries();
        List<Player> players = new ArrayList<>();
        for (String e : entries){
            players.add(Bukkit.getPlayer(e));
        }
        for(Player p :players){
            if(p.getDisplayName().equals(player.getDisplayName())){return true;}
        }
        return false;
    }
    public static Team getPlayerTeam(Player player){
        for (Team team : teams){
            if(IsPlayerInTeam(team.getName(),player)){return team;}
        }

        /*if(IsPlayerInTeam("ADMIN",player)){return getTeamIfExists("ADMIN");}
        else if(IsPlayerInTeam("MIEMBRO",player)){return getTeamIfExists("MIEMBRO");}
        else if(IsPlayerInTeam("BestAdmin",player)){return getTeamIfExists("BestAdmin");}
        else if(IsPlayerInTeam("BUILDER",player)){return getTeamIfExists("BUILDER");}*/
        return null;
    }
    /**=========================Team object========================================*/
    private static int teamssize = 5;
    private static String[] teamObjects = new String[teamssize];
    private static int[] teamLevels = new int[teamssize];
    private static String[] teamPrefixes = new String[teamssize];
    private static String[] teamSuffixes = new String[teamssize];
    private static String[] optionalHover = new String[teamssize];
    private static TextComponent[] optionalTC = new TextComponent[teamssize];

    private static void registerTeamObjects(){
        registerNewTeam("BestAdmin",4,0,
                ChatColor.GOLD+""+ ChatColor.BOLD+"[God]"+ChatColor.of("#00ffbb")+ ChatColor.BOLD
                        +"[BestAdmin] "+ ChatColor.RESET,"");
        registerNewTeam("ADMIN",3,1,
                org.bukkit.ChatColor.RED+""+ org.bukkit.ChatColor.BOLD+"[ADMIN] "+ org.bukkit.ChatColor.RESET,"");
        registerNewTeam("BUILDER",2,2,
                org.bukkit.ChatColor.DARK_AQUA+""+ org.bukkit.ChatColor.BOLD+"[BUILDER] "+ org.bukkit.ChatColor.RESET,"");
        registerNewTeam("MIEMBRO",1,3,
                org.bukkit.ChatColor.GREEN+""+ org.bukkit.ChatColor.BOLD+"[MIEMBRO] "+ org.bukkit.ChatColor.RESET,"");
        registerNewTeam("cubito",1,4,
                org.bukkit.ChatColor.GREEN+""+ org.bukkit.ChatColor.BOLD+"[MIEMBRO] " + org.bukkit.ChatColor.RESET,
                org.bukkit.ChatColor.AQUA + " ☺ "+ org.bukkit.ChatColor.RESET);
        setOptionalTCs();
    }
    private static void setOptionalTCs(){
        {TextComponent suffix = new TextComponent(Teams.getSuffix("cubito"));
        suffix.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT,
                new ComponentBuilder(org.bukkit.ChatColor.AQUA+""+org.bukkit.ChatColor.BOLD +"Medalla de\ncubito :3").create()));
        suffix.setClickEvent(new ClickEvent(ClickEvent.Action.SUGGEST_COMMAND,"☺"));suffix.setInsertion("☺");
        suffix.setClickEvent(new ClickEvent(ClickEvent.Action.COPY_TO_CLIPBOARD,"☺"));
        setOptionalTC("cubito",suffix);}
    }
    private static Integer getIndex(String teamName){
        for(int i=0;i<teamObjects.length;i++){
            if(teamObjects[i].equals(teamName)){
                return i;
            }
        }
        return null;
    }
    private static void registerNewTeam(String teamName,int teamLevel,int teamIndex,String teamPrefix,String teamSuffix){
        teamObjects[teamIndex] = teamName;
        teamLevels[teamIndex] = teamLevel;
        teamPrefixes[teamIndex] = teamPrefix;
        teamSuffixes[teamIndex] = teamSuffix;
        addTeam(teamName);
    }
    public static int getTeamLevel(String teamName){
        if(teamnames.contains(teamName)){
            return teamLevels[getIndex(teamName)];
        }
        else return 0;
    }
    public static int getMaxLevel(){
        int maxLevel = 0;
        for(int i=0;i<teamnames.size();i++){
            if(maxLevel<teamLevels[i]){
                maxLevel = teamLevels[i];
            }
        }
        return maxLevel;
    }
    public static int getMinLevel(){
        int minLevel = getMaxLevel();
        for(int i=0;i<teamnames.size();i++){
            if(minLevel>teamLevels[i]){
                minLevel = teamLevels[i];
            }
        }
        return minLevel;
    }
    public static String getPrefix(String teamName){
        if(teamnames.contains(teamName)){
            return teamPrefixes[getIndex(teamName)];
        }
        else return "";
    }
    public static String getSuffix(String teamName){
        if(teamnames.contains(teamName)){
            return teamSuffixes[getIndex(teamName)];
        }
        else return "";
    }
    public static void setOptionalTC(String teamName,TextComponent textComponent){
        optionalTC[getIndex(teamName)] = textComponent;
    }
    public static TextComponent getOptionalTC(String teamName){
        if(optionalTC[getIndex(teamName)]!=null){
            return optionalTC[getIndex(teamName)];
        }
        else {TextComponent tc = new TextComponent("");return tc;}
    }
    /**====================================================================================================================*/
    public static int getTeamLevel(Team team){
        if(team!=null){
            return getTeamLevel(team.getName());
        }
        else return 0;
    }
    public static String getPrefix(Player player){
        if(getPlayerTeam(player)!=null){
            return Teams.getPrefix(getPlayerTeam(player).getName());
        }
        return "";
    }
    public static String PorD(Team Left,Team Right,Player sender, Player target, String receiver){
        if (getTeamLevel(Left)>getTeamLevel(Right)){
            if(receiver.equals("sender")){
                return org.bukkit.ChatColor.DARK_GREEN +"You demoted "+target.getDisplayName()+" to "+Right.getName();
            }
            else if(receiver.equals("target")){
                return org.bukkit.ChatColor.GRAY+""+org.bukkit.ChatColor.ITALIC+sender.getDisplayName()+
                        " has demoted you to "+Right.getName();
            }
            else return "fail";
        }
        if (getTeamLevel(Left)<getTeamLevel(Right)){
            if(receiver.equals("sender")){
                return org.bukkit.ChatColor.GREEN +"You promoted "+target.getDisplayName()+" to "+Right.getName();
            }
            else if(receiver.equals("target")){
                return org.bukkit.ChatColor.GRAY+""+org.bukkit.ChatColor.ITALIC+sender.getDisplayName()+
                        " has promoted you to "+Right.getName();
            }
            else return "fail";
        }
        if(getTeamLevel(Left)==getTeamLevel(Right)){
            return org.bukkit.ChatColor.YELLOW +"Nothing has changed";
        }
        return ChatColor.RED+"An error has ocurred";
    }
    public static String PorD(Team Left,Team Right,Player target,String receiver){
        if (getTeamLevel(Left)>getTeamLevel(Right)){
            if(receiver.equals("sender")){
                return org.bukkit.ChatColor.DARK_GREEN +"You demoted "+target.getDisplayName()+" to "+Right.getName();
            }
            else if(receiver.equals("target")){
                return org.bukkit.ChatColor.GRAY+""+org.bukkit.ChatColor.ITALIC+"Server"+
                        " has demoted you to "+Right.getName();
            }
            else return "fail";
        }
        if (getTeamLevel(Left)<getTeamLevel(Right)){
            if(receiver.equals("sender")){
                return org.bukkit.ChatColor.GREEN +"You promoted "+target.getDisplayName()+" to "+Right.getName();
            }
            else if(receiver.equals("target")){
                return org.bukkit.ChatColor.GRAY+""+org.bukkit.ChatColor.ITALIC+"Server"+
                        " has promoted you to "+Right.getName();
            }
            else return "fail";
        }
        if(getTeamLevel(Left)==getTeamLevel(Right)){
            return org.bukkit.ChatColor.YELLOW +"Nothing has changed";
        }
        return ChatColor.RED+"An error has ocurred";
    }

    public static Player getPlayerInTeam(String teamName, Player player){
        Set<String> entries = getTeamIfExists(teamName).getEntries();
        List<Player> players = new ArrayList<>();
        for (String e : entries){
            players.add(Bukkit.getPlayer(e));
        }
        for(Player p :players){
            if(p.getDisplayName().equals(player.getDisplayName())){return p;}
        }
        return null;
    }
}
