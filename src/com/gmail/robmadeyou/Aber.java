package com.gmail.robmadeyou;


import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;

import com.gmail.robmadeyou.Fun.ThrowEgg;
import com.gmail.robmadeyou.Problem.Kill;

public class Aber {
	
	static Function[] functionList = {new ThrowEgg("egg"), new Kill("kill")};
	
	public static String getPluginName(Body plugin){
		return ChatColor.DARK_RED + "[" + ChatColor.GOLD + plugin.getName() + ChatColor.DARK_RED + "] " + ChatColor.RESET;
	}
	
	public static void broadcastLogin(Body plugin, PlayerJoinEvent event){
		plugin.getServer().broadcastMessage(getPluginName(plugin) + ChatColor.GOLD + " Welcome: " + ChatColor.DARK_AQUA + event.getPlayer().getName() + ChatColor.GOLD+ "!" + ChatColor.RESET);
	}
	
	public static void printToAll(Body plugin, String message){
		plugin.getServer().broadcastMessage(getPluginName(plugin) + message);
	}
	
	public static String errorInput(){
		return ChatColor.AQUA + "Sorry.. something went wrong: " + ChatColor.GREEN;
	}
	
	public static void reply(Body plugin, CommandSender sender, String message){
		if(sender instanceof Player){
			plugin.getServer().getPlayer(sender.getName()).sendMessage(message);
		}else if(sender instanceof ConsoleCommandSender){
			plugin.getLogger().info(message);
		}
	}
	
	public static void replyAsPlugin(Body plugin, CommandSender sender, String message){
		if(sender instanceof Player){
			plugin.getServer().getPlayer(sender.getName()).sendMessage(getPluginName(plugin) + message);
		}else if(sender instanceof ConsoleCommandSender){
			plugin.getLogger().info(getPluginName(plugin) + message);
		}
	}
	
	public static void manageInput(Body plugin, CommandSender sender, Command cmd, String label, String[] arguments){
		boolean allPlayers = false;
		float power = 0;
		int duration = 0;
		float size = 0;
		boolean isSecret = false;
		String message = "";
		String type = "";
		String function = "";
		String player = "";
		boolean isPlayerOn = false;
		if(arguments.length > 0){
			for(Player p : plugin.getServer().getOnlinePlayers()){
				if(p.getName().equals(arguments[0])){
					isPlayerOn = true;
					break;
				}
			}
			if(arguments[0].equalsIgnoreCase("-ap")){
				allPlayers = true;
			}
			if(!isPlayerOn && !allPlayers && !arguments[0].equals("-")){
				reply(plugin, sender, errorInput() + "can't find " + ChatColor.RED + arguments[0] + ChatColor.GREEN + "    :(");
				return;
			}
		}else{
			reply(plugin, sender, errorInput() + "Please enter a valid target. " + ChatColor.GRAY + "(-ap, -op, -[username])");
			return;
		}
		for(int i = 2; i < arguments.length; i++){
			if(arguments[i].equals("-p")){
				power = Float.parseFloat(arguments[i + 1]);
			}else if(arguments[i].equals("-d")){
				duration = Integer.parseInt(arguments[i+1]);
			}else if(arguments[i].equals("-S")){
				isSecret = true;
			}else if(arguments[i].equals("-m")){
				for(int j = i; j < arguments.length; j++){
					message += " " + arguments[j];
				}
			}else if(arguments[i].equals("-t")){
				type = arguments[i + 1];
			}else if(arguments[i].equals("-s")){
				size = Float.parseFloat(arguments[i + 1]);
			}
		}
		
		if(arguments[1] != null){
			for(Function f : functionList){
				if(f.getName().equals(arguments[1])){
					if(allPlayers){
						for(Player p : plugin.getServer().getOnlinePlayers()){
							f.onCall(plugin, sender, p.getName(), size, power, isSecret, message, type);
						}
					}else{
						f.onCall(plugin, sender, arguments[0], size, power, isSecret, message, type);
					}
					break;
				}
			}
		}
		
	}
}
