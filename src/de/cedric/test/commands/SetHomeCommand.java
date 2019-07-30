package de.cedric.test.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.cedric.test.main.Main;

public class SetHomeCommand implements CommandExecutor {
	
	File file = new File("plugins/Test", "homes.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission("main.user")) {

					
						
						String world = p.getWorld().getName();
						double x = p.getLocation().getX();
						double y = p.getLocation().getY();
						double z = p.getLocation().getZ();
						double yaw = p.getLocation().getYaw();
						double pitch = p.getLocation().getPitch();
						
						cfg.set(p.getName() +".world", world);
						cfg.set(p.getName() + ".x", x);
						cfg.set(p.getName() + ".y", y);
						cfg.set(p.getName() + ".z", z);
						cfg.set(p.getName() + ".yaw", yaw);
						cfg.set(p.getName() + ".pitch", pitch);
						try {
								cfg.save(file);
							} catch (IOException e) {

								e.printStackTrace();
							}
						p.sendMessage("§aDein Home wurde gesetzt!");
						
		}
		else {
			p.sendMessage(Main.prefix + "§cDu musst erst das Tutorial machen!");
			p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
		 }
					
				

		return true;
	}
	
}
