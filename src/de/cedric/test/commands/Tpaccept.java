package de.cedric.test.commands;



import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.cedric.test.main.Main;




public class Tpaccept implements CommandExecutor {
	

	

	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player p = (Player) sender;
		Player p2 = Main.tpa.get(p);

		if(sender instanceof Player) {
			if(p.hasPermission("main.user")) {
				if(args.length == 1) {
					Player target = Bukkit.getPlayer(args[0]);

					
					if(!(Main.tpa.containsKey(p))) {
						
							
							
								p.sendMessage(Main.prefix + "§cDu hast von diesem Spieler keine Teleportanfrage!");
								p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
							} else if (target == p2) {
								p2.sendMessage(Main.prefix+"§cTeleportvorgang gestartet, bewege dich nicht!");
								new TpaAcceptCommand(p).start();

							} else if(target != p2) {
								p.sendMessage(Main.prefix + "§cDu hast von diesem Spieler keine Teleportanfrage!");
								p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);

								
							}
			} else
			if(args.length == 0) {
				p.sendMessage(Main.prefix +"§cBenutze /Tpaccept (SPIELER)");
				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
	}

		}
			else {
				p.sendMessage(Main.prefix + "§cDu musst erst das Tutorial machen!");
				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
			 }
		}
		
			
		
		return true;}
}
