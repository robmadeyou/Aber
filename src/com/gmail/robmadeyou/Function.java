package com.gmail.robmadeyou;

import org.bukkit.command.CommandSender;

public abstract class Function {
	
	private String name;
	private float speed, power;
	public Function(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	public abstract void onCall(Body plugin, CommandSender sender, String name, float s, float p, boolean S, String M, String T);
}
