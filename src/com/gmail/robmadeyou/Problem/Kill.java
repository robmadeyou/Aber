package com.gmail.robmadeyou.Problem;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Ghast;
import org.bukkit.entity.Pig;
import org.bukkit.entity.PigZombie;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
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
		if(!T.equals("")){
			int amount = 0;
			boolean entityExists = false;
			if(T.equals("")){
				
			}
			for(Entity e : plugin.getServer().getPlayer(sender.getName()).getWorld().getEntities()){
				if(T.equals("chicken")){
					if(e instanceof Chicken){
						if(!((Chicken) e).isLeashed()){
							((Chicken) e).remove();
							amount++;
						}
					}
				}else if(T.equals("cow")){
					entityExists = true;
					if(e instanceof Cow){
						e.remove();
						amount++;
					}
				}else if(T.equals("pig")){
					entityExists = true;
					if(e instanceof Pig){
						e.remove();
						amount++;
					}
				}else if(T.equals("sheep")){
					entityExists = true;
					if(e instanceof Sheep){
						e.remove();
						amount++;
					}
				}else if(T.equals("zombie")){
					entityExists = true;
					if(e instanceof Zombie){
						e.remove();
						amount++;
					}
				}else if(T.equals("creeper")){
					entityExists = true;
					if(e instanceof Creeper){
						e.remove();
						amount++;
					}
				}else if(T.equals("skeleton")){
					entityExists = true;
					if(e instanceof Skeleton){
						e.remove();
						amount++;
					}
				}else if(T.equals("bad")){
					entityExists = true;
					if(e instanceof Zombie || e instanceof Creeper || e instanceof Skeleton || e instanceof PigZombie || e instanceof Ghast){
						e.remove();
						amount++;
					}
				}else if(T.equals("near")){
					entityExists = true;
					double size = 3;
					
					if(s != 0){
						size = s;
					}
					
					if(e.getLocation().distance(plugin.getServer().getPlayer(sender.getName()).getLocation()) <= size){
						if(!(e instanceof Player)){
							e.remove();
							amount++;
						}
					}
				}else if(T.equals("all")){
					entityExists = true;
					if(!(e instanceof Player)){
						e.remove();
						amount++;
					}
				}
			}
			if(entityExists){
				Aber.reply(plugin, sender, ChatColor.GREEN + "Succesfully removed " + ChatColor.RED + amount + ChatColor.GREEN + " entities.");
			}else{
				Aber.replyAsPlugin(plugin, sender, Aber.errorInput() + "Incorrect entity type: " + ChatColor.RED + T);
			}
		}else{
			Aber.replyAsPlugin(plugin, sender, Aber.errorInput() + "Sorry, no entity type defined. " + ChatColor.GRAY + "(Define with -t [type]");
		}
	}
}
