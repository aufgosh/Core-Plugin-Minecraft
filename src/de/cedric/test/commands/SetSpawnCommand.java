package de.cedric.test.commands;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import de.cedric.test.main.Main;

public class SetSpawnCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("main.setspawn")) {
				if(args.length == 0) {
					
					FileConfiguration cfg = Main.getPlugin().getConfig();
					Location loc = p.getLocation();
					
					cfg.set("Spawn.World", loc.getWorld().getName());
					cfg.set("Spawn.X", loc.getX());
					cfg.set("Spawn.Y", loc.getY());
					cfg.set("Spawn.Z", loc.getZ());
					cfg.set("Spawn.Yaw", loc.getYaw());
					cfg.set("Spawn.Pitch", loc.getPitch());
					Main.getPlugin().saveConfig();
					
					p.sendMessage("§aSpawn wurde erfolgreich gesetzt!");
					
				} else
					p.sendMessage("§cBitte benutze /setspawn !");
				
			} else
				p.sendMessage(Main.error);
		}
		return false;
	}

}
