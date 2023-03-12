package de.cedric.test.commands;



import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import org.bukkit.entity.Player;

import de.cedric.test.main.Main;




public class Tutorialtp implements CommandExecutor {
	

	

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		if(sender instanceof Player) {
			if(args.length == 0) {
				p.sendMessage(Main.prefix+"§cTeleportvorgang gestartet, bewege dich nicht!");
				new Tutorialexec(p).start();
		
		
	}

		}
		return true;}
}
