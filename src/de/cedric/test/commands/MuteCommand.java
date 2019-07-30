package de.cedric.test.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import de.cedric.test.main.Main;

public class MuteCommand implements CommandExecutor, Listener {
	
	private static ArrayList<Player> mutedPlayers = new ArrayList<>();
	
	@EventHandler
	public void handlePlayerChat(AsyncPlayerChatEvent e) {
		Player p = e.getPlayer();
		if(mutedPlayers.contains(p)) {
			p.sendMessage("§cDu bist gemuted!");
			e.setCancelled(true);
			
		}
		
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(p.hasPermission("main.mod")){
				if(args.length == 1) {
					
					Player target = Bukkit.getPlayer(args[0]);
					if(target != null) {
						if(!mutedPlayers.contains(target)) {
							mutedPlayers.add(target);
							p.sendMessage("§aDu hast den Spieler §e" + target.getName() + "§a erfolgreich §c§ngemuted§r§7. §aGebe nochmal §e/mute§a ein§7,§a um ihn wieder zu entmuten§7.");
							target.sendMessage("§cDu wurdest gemuted!");
							p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
							target.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
							
						}else {
							mutedPlayers.remove(target);
							p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
							p.sendMessage("§aDu hast den Spieler §e§n" + target.getName() + "§r§a entmuted§7.");
							target.sendMessage("§aDu wurdest entmuted!");
							target.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
						}
						
						
					} else
						p.sendMessage("§cDieser Spieler ist nicht online!");
					p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
				}else
					p.sendMessage("§cBenutze /mute (Spielername)");
				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
				
				
			} else
				p.sendMessage(Main.error);
			
		}
		
		
		
		return false;
	}
	

}
