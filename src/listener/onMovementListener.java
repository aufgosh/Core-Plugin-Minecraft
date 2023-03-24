package listener;

import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class onMovementListener implements Listener {

	
	@EventHandler
	public void onPlayerMovement(PlayerMoveEvent e) {
		Player p = e.getPlayer();
	
		
		String Boots = "";
		
		if(p.getInventory().getBoots() != null) {
			Boots = p.getInventory().getBoots().getItemMeta().getDisplayName();
		}
		
		switch(Boots) {
		case "§7Boots of §cLove":
			p.getWorld().spawnParticle(Particle.HEART, p.getLocation().add(0,0.5,0), 1);
			break;
		case "§7Boots of §eThunder":
			p.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, p.getLocation().add(0,0.5,0), 1);
			break;
		case "§7Boots of §aNature":
			p.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, p.getLocation().add(0,0.5,0), 1);
			break;
		case "§7Boots of §8Smoke":
			p.getWorld().spawnParticle(Particle.WHITE_ASH, p.getLocation().add(0,0.5,0), 8);
			p.getWorld().spawnParticle(Particle.ASH, p.getLocation().add(0,0.5,0), 8);
			p.getWorld().spawnParticle(Particle.WHITE_ASH, p.getLocation(), 8);
			p.getWorld().spawnParticle(Particle.ASH, p.getLocation(), 8);
			//p.getWorld().playEffect(p.getLocation().add(0,0.5,0), Effect.SMOKE, 1);
			break;
		case "§7Boots of §bWater":
			p.getWorld().spawnParticle(Particle.DOLPHIN, p.getLocation().add(0,0.5,0), 4);
			p.getWorld().spawnParticle(Particle.DOLPHIN, p.getLocation().add(0.5,0,0), 4);
			p.getWorld().spawnParticle(Particle.DOLPHIN, p.getLocation().add(-0.5,0,0), 4);
			p.getWorld().spawnParticle(Particle.DOLPHIN, p.getLocation().add(0,0,0.5), 4);
			p.getWorld().spawnParticle(Particle.DOLPHIN, p.getLocation().add(0,0,-0.5), 4);
			break;
		}
		
	}
}
