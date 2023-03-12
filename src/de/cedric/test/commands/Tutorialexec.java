package de.cedric.test.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import de.cedric.test.main.Main;



public class Tutorialexec {
	
	private static HashMap<Player, BukkitTask> countdown;
	
	static {
		countdown = new HashMap<>();
	}
	
	private Player p;
	private int count;
	
	public Tutorialexec(Player p)
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
				
				p.sendMessage(Main.prefix +"�aDu wirst in�c " + count + " �asekunden teleportiert!");
				p.playSound(p.getLocation(), Sound.BLOCK_WOODEN_TRAPDOOR_OPEN, 3, 2);
				}
				if(count == 0) {
					

					FileConfiguration cfg = Main.getPlugin().getConfig();
					World world = Bukkit.getWorld(cfg.getString("tutorial.World"));
					double x = cfg.getDouble("tutorial.X");
					double y = cfg.getDouble("tutorial.Y");
					double z = cfg.getDouble("tutorial.Z");
					float yaw = (float) cfg.getDouble("tutorial.Yaw");
					float pitch = (float) cfg.getDouble("tutorial.Pitch");
					
					Location loc = new Location(world, x, y, z, yaw, pitch);
					

					p.teleport(loc);
					p.sendMessage(Main.prefix +"�aDu wurdest erfolgreich teleportiert!");
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
		p.sendMessage(Main.prefix +"�cTeleportvorgang abgebrochen!");
		p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
		countdown.remove(this.p);
	}
	
		
	

}


