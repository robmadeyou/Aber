package com.gmail.robmadeyou;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class In implements CommandExecutor{

	private Body plugin;
	
	public In(Body plugin){
		this.plugin = plugin;
	}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] arguments) {
		Aber.manageInput(plugin, sender, cmd, label, arguments);
		return false;
	}

}
