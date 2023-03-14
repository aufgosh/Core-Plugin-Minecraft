package de.cedric.test.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import de.cedric.test.main.Main;
import utilities.utilitiesFunctions;



public class Spawn {
	
	private static HashMap<Player, BukkitTask> countdown;
	
	static {
		countdown = new HashMap<>();
	}
	
	private Player p;
	private int count;
	
	public Spawn(Player p)
	{
		this.p = p;
		this.count = 5;
	}
	
	public void start() {
		
		if(countdown.containsKey(p)) {
			return;
		}
		
		BukkitTask task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
			
			public void run() {
				if(count != 0) {
				
				p.sendMessage(Main.prefix +"§aDu wirst in§c " + count + " §asekunden teleportiert!");
				p.playSound(p.getLocation(), Sound.BLOCK_WOODEN_TRAPDOOR_OPEN, 3, 2);
				utilitiesFunctions.spawnParticleRingAroundPlayer(p, (((double)count/1.55) / 2.5), Particle.REDSTONE, Particle.REDSTONE, Color.FUCHSIA, Color.SILVER);
				}
				if(count == 0) {
					

					FileConfiguration cfg = Main.getPlugin().getConfig();
					World world = Bukkit.getWorld(cfg.getString("Spawn.World"));
					double x = cfg.getDouble("Spawn.X");
					double y = cfg.getDouble("Spawn.Y");
					double z = cfg.getDouble("Spawn.Z");
					float yaw = (float) cfg.getDouble("Spawn.Yaw");
					float pitch = (float) cfg.getDouble("Spawn.Pitch");
					
					Location loc = new Location(world, x, y, z, yaw, pitch);
					

					p.teleport(loc);
					p.sendMessage(Main.prefix +"§aDu wurdest erfolgreich teleportiert!");
					p.playSound(p.getLocation(),Sound.ENTITY_ENDERMAN_TELEPORT, 3, 2);
					
					countdown.get(p).cancel();
					countdown.remove(p);
					return;
					
				} count--;
				
				
			}
			}, 0, 20);
		
		
		countdown.put(this.p, task);
		
	}
	
	public void stop() {
		if(!countdown.containsKey(p)) {
			return;
		}
		
		countdown.get(this.p).cancel();
		p.sendMessage(Main.prefix +"§cTeleportvorgang abgebrochen!");
		p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
		countdown.remove(this.p);
	}
	
		
	

}
