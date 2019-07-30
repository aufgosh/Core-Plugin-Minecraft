package de.cedric.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.cedric.test.main.Main;


public class ccCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
		    if(p.hasPermission("main.cc")) {
				if(args.length == 0) {
					
					for(int i = 0; i < 200; i++) {
						Bukkit.broadcastMessage(" ");
					}
					Bukkit.broadcastMessage("§aDer Chat wurde von §c" +p.getName() + "§a geleert!");
				}else
					p.sendMessage("§cBitte benutze /cc!");
		    } else
		    	p.sendMessage(Main.error);
		}
		return false;
	}

}
