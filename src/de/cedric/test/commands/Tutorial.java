package de.cedric.test.commands;

import java.io.File;


import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.cedric.test.main.Main;

public class Tutorial implements CommandExecutor {
	
	File file = new File("plugins/Test", "tutorial.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		

					
		if(p.hasPermission("main.setspawn")) {
			if(args.length == 0) {
				
				FileConfiguration cfg = Main.getPlugin().getConfig();
				Location loc = p.getLocation();
				
				cfg.set("tutorial.World", loc.getWorld().getName());
				cfg.set("tutorial.X", loc.getX());
				cfg.set("tutorial.Y", loc.getY());
				cfg.set("tutorial.Z", loc.getZ());
				cfg.set("tutorial.Yaw", loc.getYaw());
				cfg.set("tutorial.Pitch", loc.getPitch());
				Main.getPlugin().saveConfig();
				
				p.sendMessage("§aTutorial wurde erfolgreich gesetzt!");
				
			} else
				p.sendMessage("§cBitte benutze /settut !");
			
		} else
			p.sendMessage(Main.error);
					
				

		return true;
	}
	
}
