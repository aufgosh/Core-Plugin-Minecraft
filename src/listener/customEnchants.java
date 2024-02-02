package listener;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Particle;
import org.bukkit.entity.LivingEntity;
import org.bukkit.scheduler.BukkitTask;

import de.cedric.test.main.Main;

import utilities.utilitiesFunctions;

public class customEnchants {
	
	
	private static HashMap<LivingEntity, BukkitTask> countdown;
	
	static {
		countdown = new HashMap<>();
	}
	
	private LivingEntity target;
	private double level;
	
	
	public customEnchants(LivingEntity target, int level)
	{
		this.target = target;
		this.level = 4;
	}
	

	public void BloodBath() {
		if(target != null)
		this.target.damage(level/2);
		utilitiesFunctions.spawnParticleRingAroundPlayer(target, (((double)level/1) / 1), Particle.REDSTONE, Particle.REDSTONE, Color.RED, Color.RED);
	}
	
	
	public void start() {
		
		
		BukkitTask task2 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
			
			public void run() {
				if(target != null)
				if(level != 0) {
					BloodBath();
				}
				if(level == 0) {
					if(countdown.get(target) != null) {
						BloodBath();
						countdown.get(target).cancel();
						countdown.remove(target);	
					} else {
						stop();
					}
					
					
				} level--;
				
				
			}
			}, 0, 20);
		
		
		countdown.put(this.target, task2);
		
	}
	
	public void stop() {
		if(!countdown.containsKey(target)) {
			return;
		}
		
	}
	
		
	

}