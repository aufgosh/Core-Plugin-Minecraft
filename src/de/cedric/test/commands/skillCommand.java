package de.cedric.test.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;


public class skillCommand implements CommandExecutor {
	
	public static File file = new File("plugins/Core", "skillpoints.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	private static void saveCfg(File file) {
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getHealthCore(Player p) {
		int health = cfg.getInt(p.getName() + ".Health");
		return health;
	}
	
	public static void setHealthCore(Player p, double i) {
		cfg.set(p.getName() + ".Health", i);
		updateHealthCore(p);
		saveCfg(file);
		return;
	}
	
	
	public static void updateHealthCore(Player p) {
		
		double health = getHealthCore(p);
		
		if(getHealthCore(p) == 9) {
			p.setMaxHealth(20 + ((getHealthCore(p) + 1)*2));
			p.setHealthScale(20 + ((getHealthCore(p) + 1)*2));	
		} else {
			p.setMaxHealth(20 + (getHealthCore(p)*2));
			p.setHealthScale(20 + (getHealthCore(p)*2));
		}
		
		p.sendMessage(health + "");
		return;
	}
	
	public static double getDamageCore(Player p) {
		double Damage = cfg.getInt(p.getName() + ".Damage");
		return Damage;
	}
	
	public static void setDamageCore(Player p, int i) {
		cfg.set(p.getName() + ".Damage", i);
		saveCfg(file);
		return;
	}
	
	public static int getSkillpointsCore(Player p) {
		int points = cfg.getInt(p.getName() + ".skillpoints");
		return points;
	}
	
	public static void setSkillpointsCore(Player p, int i) {
		cfg.set(p.getName() + ".skillpoints", i);
		saveCfg(file);
		return;
	}
	
	public static double getDamageReductionCore(Player p) {
		double Damage = cfg.getInt(p.getName() + ".Damagereduction");
		return Damage;
	}
	
	public static void setDamageReductionCore(Player p, double i) {
		cfg.set(p.getName() + ".Damagereduction", i);
		saveCfg(file);
		return;
	}
		
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(args[0].equalsIgnoreCase("sethealth")) {
			setHealthCore(p, Integer.valueOf(args[1]));
			p.sendMessage("health set to: " + args[1]);
		}
		
		if(args[0].equalsIgnoreCase("gethealth")) {
			p.sendMessage("current health: " + getHealthCore(p));
		}
		
		if(args[0].equalsIgnoreCase("getdamage")) {
			p.sendMessage("current Damagelevel: " + getDamageCore(p));
		}
		
		if(args[0].equalsIgnoreCase("setdamage")) {
			setDamageCore(p, Integer.valueOf(args[1]));
			p.sendMessage("damage set to: " + getDamageCore(p));
		}
		
		if(args[0].equalsIgnoreCase("setdamagereduc")) {
			setDamageReductionCore(p, Integer.valueOf(args[1]));
			p.sendMessage("damagereduc set to: " + getDamageReductionCore(p));
		}
		
		return false;
	}
	
}
