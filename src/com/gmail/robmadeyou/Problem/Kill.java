package com.gmail.robmadeyou.Problem;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.Zombie;

import com.gmail.robmadeyou.Aber;
import com.gmail.robmadeyou.Body;
import com.gmail.robmadeyou.Function;

public class Kill extends Function{

	public Kill(String name) {
		super(name);
	}

	@Override
	public void onCall(Body plugin, CommandSender sender, String name, float s, float p, boolean S, String M, String T) {
		Aber.printToAll(plugin, T);
		for(Entity e : plugin.getServer().getPlayer(sender.getName()).getWorld().getEntities()){
			if(T.equals("chicken")){
				if(e instanceof Chicken){
					if(!((Chicken) e).isLeashed()){
						((Chicken) e).remove();
					}
				}
			}else if(T.equals("cow")){
				if(e instanceof Cow){
					e.remove();
				}
			}else if(T.equals("pig")){
				if(e instanceof Pig){
					e.remove();
				}
			}else if(T.equals("zombie")){
				if(e instanceof Zombie){
					e.remove();
				}
			}else if(T.equals("creeper")){
				if(e instanceof Creeper){
					e.remove();
				}
			}else if(T.equals("skeleton")){
				if(e instanceof Skeleton){
					e.remove();
				}
			}
		}
	}
}
