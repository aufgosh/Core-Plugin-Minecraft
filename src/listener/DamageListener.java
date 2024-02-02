package listener;

import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;

import de.cedric.test.commands.skillCommand;
import net.minecraft.world.entity.Entity;
import utilities.utilitiesFunctions;

public class DamageListener implements Listener {

	@EventHandler
	public void onDmg(EntityDamageByEntityEvent e) {
		
		

		LivingEntity entity = (LivingEntity) e.getEntity();

		if (e.getDamager() instanceof Firework) {
			Firework fw = (Firework) e.getDamager();
			e.setCancelled(true);
		}
		

		if (e.getDamager() instanceof Player) {

			Player damager = (Player) e.getDamager();
			int FinalDamage = (int) (e.getDamage() * (((100 + (skillCommand.getDamageCore(damager) * 5)) / 100)));
			e.setDamage(FinalDamage);
			
			if(e.getEntityType() != e.getEntityType().ARMOR_STAND) {
				utilitiesFunctions.drawDamageDrop( (LivingEntity) e.getEntity() , FinalDamage);
			}
			
			
			if (damager.getInventory().getItemInMainHand() != null && damager.getInventory().getItemInMainHand().getItemMeta() != null && damager.getInventory().getItemInMainHand().getItemMeta().getLore() != null) {
				if (damager.getInventory().getItemInMainHand().getItemMeta().getLore().contains("§dEnchanted§7:§c Bloodbath 1")) {
					new customEnchants(entity, 1).start();
				}
			}

		}

		if (entity instanceof Player) {

			Player damaged = (Player) e.getEntity();
			double modifier = (100 - (skillCommand.getDamageReductionCore(damaged) * 5)) / 100;
			double FinalDamage = (double) (e.getDamage() * modifier);
			e.setDamage(FinalDamage);
		}

	}
	

	

}
