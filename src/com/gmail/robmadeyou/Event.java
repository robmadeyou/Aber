package com.gmail.robmadeyou;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Event implements Listener{
	
	private final Body plugin;
	
	public Event(Body plugin) {
		this.plugin = plugin;
		plugin.getServer().getPluginManager().registerEvents(this, plugin);
	}
	
	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		Aber.broadcastLogin(plugin, event);
	}
}
