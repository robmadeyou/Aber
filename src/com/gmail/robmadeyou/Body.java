package com.gmail.robmadeyou;

import org.bukkit.plugin.java.JavaPlugin;

public class Body extends JavaPlugin{
	
	@Override
	public void onLoad() {
		super.onLoad();
	}
	
	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	@Override
	public void onEnable() {
		new Event(this);
		getCommand("aber").setExecutor(new In(this));
		getLogger().info("Aber has loadad!");
		super.onEnable();
	}
}
