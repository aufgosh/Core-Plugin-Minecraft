package de.cedric.test.commands;

import java.io.File;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import de.cedric.test.main.Main;

public class newHome {
	
	File file = new File("plugins/Test", "homes.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	private static HashMap<Player, BukkitTask> countdown;
	
	static {
		countdown = new HashMap<>();
	}
	
	private Player p;
	private int count;
	
	public newHome(Player p)
	{
		this.p = p;
		this.count = 5;
	}
	
	public void start() {
		
		if(countdown.containsKey(p)) {
			return;
		}
		
		BukkitTask task2 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
			
			public void run() {
				if(count != 0) {
				
				p.sendMessage(Main.prefix +"§aDu wirst in§c " + count + " §asekunden teleportiert!");
				p.playSound(p.getLocation(), Sound.BLOCK_WOODEN_TRAPDOOR_OPEN, 3, 2);
				}
				if(count == 0) {
					
	
					String world = cfg.getString(p.getName() + ".world");
					double x = cfg.getDouble(p.getName() + ".x");
					double y = cfg.getDouble(p.getName() + ".y");
					double z = cfg.getDouble(p.getName() + ".z");
					
					Location loc = new Location(Bukkit.getWorld(world), x, y, z);
					
					p.teleport(loc);
					p.sendMessage(Main.prefix +"§aDu wurdest erfolgreich teleportiert!");
					p.playSound(p.getLocation(),Sound.ENTITY_ENDERMEN_TELEPORT, 3, 2);
					
					countdown.get(p).cancel();
					countdown.remove(p);
					
				} count--;
				
				
			}
			}, 0, 20);
		
		
		countdown.put(this.p, task2);
		
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