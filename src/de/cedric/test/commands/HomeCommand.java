package de.cedric.test.commands;



import java.io.File;

import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.cedric.test.main.Main;




public class HomeCommand implements CommandExecutor {
	
	File file = new File("plugins/Test", "homes.yml");
	

	

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		
		
		if(sender instanceof Player) {
			if(p.hasPermission("main.user")) {
				FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
				if(cfg.contains(p.getName())) {
			if(args.length == 0) {
				p.sendMessage(Main.prefix+"§cTeleportvorgang gestartet, bewege dich nicht!");
				new newHome(p).start();
		
		
	}

		}
			else {
				p.sendMessage(Main.prefix + "§cDu musst erst ein Home setzen!");
				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
			} } else {
				p.sendMessage(Main.prefix + "§cDu musst erst das Tutorial machen!");
				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
			}
		}
		return true;}





}
