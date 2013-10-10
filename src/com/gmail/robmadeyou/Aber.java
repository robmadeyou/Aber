package com.gmail.robmadeyou;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Aber {
	public static void broadcastLogin(Body plugin, PlayerJoinEvent event){
		plugin.getServer().broadcastMessage(ChatColor.GOLD + "Welcome: " + event.getPlayer().getName() + ChatColor.GOLD+ "!");
	}
	
	public static void printToAll(Body plugin, String message){
		plugin.getServer().broadcastMessage(message);
	}
	public static void manageInput(Body plugin, CommandSender sender, Command cmd, String label, String[] arguments){
		if(sender instanceof Player){
			if(arguments[0] != null){
				if(arguments[0].equals("-a") && arguments[1] != null){
					String message = "";
					for(int i = 1; i < arguments.length; i++){
						message += arguments[i] + " ";
					}
					printToAll(plugin, ChatColor.BLUE + sender.getName() + ChatColor.GREEN + " would like to tell you: " + ChatColor.GOLD + message);
				}else if(arguments[0].equals("potion")){
					if(arguments[1] != null){
						if(arguments[2].equals("jump")){
							plugin.getServer().getPlayer(arguments[1]).addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 20));
						}else if(arguments[2].equals("confuse")){
							plugin.getServer().getPlayer(arguments[1]).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2000, 500));
						}else if(arguments[2].equals("dig")){
							plugin.getServer().getPlayer(arguments[1]).addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2000, 500));
							
						}else if(arguments[2].equals("leave")){
							plugin.getServer().getPlayer(arguments[1]).leaveVehicle();
						}else if(arguments[2].equals("ignite")){
							plugin.getServer().getPlayer(arguments[1]).setFireTicks(50);;
						}
					}
				}
			}
		}else if(sender instanceof ConsoleCommandSender){
			if(arguments[0] != null){
				if(arguments[0].equals("-a") && arguments[1] != null){
					String message = "";
					for(int i = 1; i < arguments.length; i++){
						message += arguments[i] + " ";
					}
					printToAll(plugin, ChatColor.BLUE + sender.getName() + ChatColor.GREEN + " would like to tell you: " + ChatColor.GOLD + message);
				}else if(arguments[0].equals("potion")){
					if(arguments[1] != null){
						if(arguments[2].equals("jump")){
							plugin.getServer().getPlayer(arguments[1]).addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 200, 20));
						}else if(arguments[2].equals("confuse")){
							plugin.getServer().getPlayer(arguments[1]).addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 2000, 500));
						}else if(arguments[2].equals("dig")){
							plugin.getServer().getPlayer(arguments[1]).addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 2000, 500));
							
						}else if(arguments[2].equals("leave")){
							plugin.getServer().getPlayer(arguments[1]).leaveVehicle();
						}
					}
				}
			}
		}
	}
}
