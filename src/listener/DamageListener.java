package listener;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import de.cedric.test.commands.skillCommand;

public class DamageListener implements Listener {
	
	@EventHandler
	public void onDmg(EntityDamageByEntityEvent e) {
		
        Entity entity = e.getEntity();
		
			
			if(e.getDamager() instanceof Player) {
				
				Player damager = (Player) e.getDamager();
				int FinalDamage = (int) (e.getDamage() * ((100 + skillCommand.getDamageCore(damager))/100));
				e.setDamage(FinalDamage);
			}
			
			if(entity instanceof Player) {
				
				Player damaged = (Player) e.getEntity();
				double damagebefore = e.getDamage();
				double modifier = (100 - skillCommand.getDamageReductionCore(damaged))/100;
				double FinalDamage = (double) (e.getDamage() * modifier);
				e.setDamage(FinalDamage);
			}
			
		}
		
		
		
		
	}


