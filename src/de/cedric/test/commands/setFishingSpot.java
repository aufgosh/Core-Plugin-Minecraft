package de.cedric.test.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import CharacterHandler.FishingSpot;
import utilities.utilitiesFunctions;

public class setFishingSpot implements CommandExecutor {
	
	File file = new File("plugins/Core", "fishingSpots.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	

	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission("main.admin")) {
			
			if(cfg.get("ID" + ".id") == null) {
				cfg.set("ID" + ".id", 1);
			}
			
			if(args.length == 2) {
				String world = p.getWorld().getName();
				double x = Math.round(p.getLocation().getBlockX());
				double y = Math.round(p.getLocation().getBlockY());
				double z = Math.round(p.getLocation().getBlockZ());
				String fish = args[0];
				int level = Integer.parseInt(args[1]);
				int id = FishingSpot.returnCurrentID();
				p.sendMessage("id before:" + id);
				id = id + 1;
				FishingSpot fishingSpot = new FishingSpot();
				fishingSpot.setId(id);
				fishingSpot.setLevel(level);
				fishingSpot.setFish(fish);
				fishingSpot.setWorld(world);
				fishingSpot.setX(x);
				fishingSpot.setY(y);
				fishingSpot.setZ(z);
				
				fishingSpot.setFishingSpot(id);
				
				p.sendMessage("id:" + id);
				p.sendMessage("fishingSpot set!");
				
			}

					
						
						
						
		}
		else {
			utilitiesFunctions.sendError(p);
		 }
					
				

		return true;
	}

}
