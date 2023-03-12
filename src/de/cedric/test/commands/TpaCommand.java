package de.cedric.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import de.cedric.test.main.Main;

public class TpaCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args	) {
		
		Player p = (Player) sender;
		if(p.hasPermission("main.user")) {
		
		if(args.length == 1) {
			
			try {
				
			Player p2 = Bukkit.getPlayer(args[0]);
			Main.tpa.put(p2, p);
			
			p2.sendMessage(Main.prefix +"§aDer Spieler§e " + p.getName() + "§a möchte sich zu dir Teleportieren§7. §aDu hast 60 Sekunden§7,§a um die Anfrage mit §e/tpaccept§a anzunehmen!");
			
			p.sendMessage(Main.prefix + "§aDu hast dem Spieler §e" + p2.getName() + "§a eine Teleportanfrage gesendet! Diese hält 60 Sekunden.");
			
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
	            public void run() {
	            	if(Main.tpa.containsKey(p2)) {
	            		if(Main.tpa.containsKey(p)) {

	                p2.sendMessage(Main.prefix + "§cDie Teleportanfrage von§e "+ p.getName() +"§c ist abgelaufen!");
	                p.sendMessage(Main.prefix + "§cDeine Teleportanfrage ist abgelaufen!");
	            	Main.tpa.remove(p2, p);
	            		}
	            	}
	                
	             }
	            
	            
	            }, 1200);
			
			
			}
			catch(Exception ex) {
				p.sendMessage("§cDer Spieler§7 " + args[0] + "§c ist nicht online!");
			}
			
		} else {
			p.sendMessage("§cBitte benutze /tpa (SPIELERNAME)");
		}
	    } else {
			p.sendMessage(Main.prefix + "§cDu musst erst das Tutorial machen!");
			p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
		 }
		
		
		return false;
	}

}
