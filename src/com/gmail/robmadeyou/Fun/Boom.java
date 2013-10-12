package com.gmail.robmadeyou.Fun;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;

import com.gmail.robmadeyou.Body;
import com.gmail.robmadeyou.Function;

public class Boom extends Function{

	public Boom(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCall(Body plugin, CommandSender sender, String name, float s, float p, boolean S, String M, String T) {
		
		if(T.equals("")){
			Location loc = plugin.getServer().getPlayer(name).getLocation();
			World w = loc.getWorld();
			w.createExplosion(loc, p);
		}else if(T.equals("all")){
			for(Entity e : plugin.getServer().getPlayer(sender.getName()).getWorld().getEntities()){
				Location loc = e.getLocation();
				World w = loc.getWorld();
				w.createExplosion(loc, p);
			}
		}
	
	}
	
}
