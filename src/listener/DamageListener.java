package listener;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import de.cedric.test.commands.skillCommand;

public class DamageListener implements Listener {
	
	@EventHandler
	public void onDmg(EntityDamageByEntityEvent e) {
		
        Entity entity = e.getEntity();
		
			
			if(e.getDamager() instanceof Player) {
				Player damager = (Player) e.getDamager();
				int FinalDamage = (int) (e.getDamage() * ((100 + skillCommand.getDamageCore(damager))/100));
				e.setDamage(FinalDamage);
				damager.sendMessage("modifier" + ((100 + skillCommand.getDamageCore(damager))/100));
				damager.sendMessage("damage: " + FinalDamage);
			}
			
			if(entity instanceof Player) {
				Player damaged = (Player) e.getEntity();
				
				double damagebefore = e.getDamage();
				damaged.sendMessage(damagebefore + "");
				double modifier = (100 - skillCommand.getDamageReductionCore(damaged))/100;
				double FinalDamage = (double) (e.getDamage() * modifier);
				e.setDamage(FinalDamage);
				damaged.sendMessage("modifier" + modifier);
				damaged.sendMessage("damage taken: " + FinalDamage);
			}
			Bukkit.broadcastMessage("entity: " + e.getEntity());
			
		}
		
		
		
		
	}


