package de.cedric.test.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Sound;

import org.bukkit.entity.Player;



import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitTask;

import de.cedric.test.main.Main;

public class ReSpawn{

	
	
	public static HashMap<Player, BukkitTask> countdownx1;
	
	static {
		countdownx1 = new HashMap<>();
	}
	
	private Player p;
	private int count;
	
	public ReSpawn(Player p)
	{
		this.p = p;
		this.count = 60;
	}
	
	public void start() {
		
		if(countdownx1.containsKey(p)) {
			return;
		}
		
		BukkitTask task3 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
			
			public void run() {
				
				
				if(count == 55) {
			    p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 1100, 0));
				}
				
				if(count == 0) {
					
	

					p.setHealth(0);
					p.sendMessage("§cDu bist an deinem Fluch erlegen!");
					p.playSound(p.getLocation(),Sound.ENTITY_ELDER_GUARDIAN_DEATH, 3, 2);
					countdownx1.get(p).cancel();
					countdownx1.remove(p);
	                p.setHealthScale(20);
	                p.setMaxHealth(20);
					
				} count--;
				
				
			}
			}, 0, 20);
		
		
		countdownx1.put(this.p, task3);
		
	}
	
	public void stop() {
		if(!countdownx1.containsKey(p)) {
			return;
		}
		
		countdownx1.get(this.p).cancel();
		countdownx1.remove(this.p);
	}
	
		
	

}