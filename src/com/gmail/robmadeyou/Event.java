package com.gmail.robmadeyou;

import net.minecraft.server.v1_6_R3.Item;

import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

public class Event implements Listener{
	
	private final Body plugin;
	
	public Event(Body plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJggoin(PlayerItemHeldEvent event){
		//Aber.broadcastLogin(plugin, "");
		
		if(plugin.getServer().getPlayer(event.getPlayer().getName()).getItemInHand().getTypeId() == Item.BOW.id){
			Block block = plugin.getServer().getPlayer(event.getPlayer().getName()).getTargetBlock(null, 20);
			Location loc = plugin.getServer().getPlayer(event.getPlayer().getName()).getLocation();
			World w = plugin.getServer().getPlayer(event.getPlayer().getName()).getWorld();
			block.setTypeId(20);
		}
		ItemStack i = new ItemStack(20);
		if(event.getNewSlot() == 2){
			event.getPlayer().setItemInHand(i);
		}
	}
}
