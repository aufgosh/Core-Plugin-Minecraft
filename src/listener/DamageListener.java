package listener;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.scheduler.BukkitRunnable;

import de.cedric.test.commands.skillCommand;
import de.cedric.test.main.Main;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.world.entity.Entity;
import utilities.utilitiesFunctions;

public class DamageListener implements Listener {

	@EventHandler
	public void onDmg(EntityDamageByEntityEvent e) {
		
		
		int hpInPercent = 0;
		

		LivingEntity entity = (LivingEntity) e.getEntity();
		
		if(e.getEntityType() == EntityType.ARMOR_STAND) {
			e.setCancelled(true);
		}

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
		
		if(entity instanceof Player == false) {
			if(e.getEntityType() != e.getEntityType().ARMOR_STAND) {
				hpInPercent = (int) (((entity.getMaxHealth() - entity.getHealth()) / entity.getMaxHealth() * 100) - ((entity.getMaxHealth() - e.getFinalDamage() / entity.getMaxHealth() * 100)));
			    
			    
			    if(entity.getCustomName() != null) {
				    String entityName = entity.getCustomName();
				    String[] arrayOfCustomName = entityName.split("\\|");
				    if(arrayOfCustomName.length == 3) {
					    entity.setCustomName("§l§7[§4❤" + (100 - hpInPercent) + "%§7] |" + arrayOfCustomName[1] + "§7|" + arrayOfCustomName[2]);	
				    }
				    else {
				    	entity.setCustomName("§l§7[§4❤" + (100 - hpInPercent) + "%§7]");	
				    }
			    } else {
			    	entity.setCustomName("§l§7[§4❤" + (100 - hpInPercent) + "%§7]");	
			    }

			}
		}

	}
	

	

}
