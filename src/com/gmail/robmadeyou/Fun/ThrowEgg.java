package com.gmail.robmadeyou.Fun;

import org.bukkit.command.CommandSender;

import com.gmail.robmadeyou.Aber;
import com.gmail.robmadeyou.Body;
import com.gmail.robmadeyou.Function;

public class ThrowEgg extends Function{

	public ThrowEgg(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCall(Body plugin, CommandSender sender, String name, float s, float p, boolean S, String M, String T) {
		for(int i = 0; i < s; i++){
			plugin.getServer().getPlayer(name).throwEgg();
		}
	}
	
}
