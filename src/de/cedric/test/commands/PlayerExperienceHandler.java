package de.cedric.test.commands;


import java.util.HashMap;
import java.util.Map;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Horse;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import de.cedric.test.main.Main;
import org.bukkit.Material;
import utilities.utilitiesFunctions;


public class PlayerExperienceHandler implements CommandExecutor {
	
	
    public static int getLevelXPThreshold(int level) {
    int value = (int) (75+(400+(75*(Math.pow(2.11409,level)))));
    return value;
}

        
public static Map<Integer, Integer> getXPThresholds() {
    
    int maxLevel = 90;
    
    Map<Integer, Integer> levelXPThresholds = new HashMap<Integer, Integer>();


    for (int level = 1; level < maxLevel; level++) {
        int levelXP = getLevelXPThreshold(level);
        levelXPThresholds.put(level, levelXP);
    }
    
    return levelXPThresholds;
}

public static int canUserLevelUp(Player p) {
    
    int xp = skillCommand.getPlayerExperience(p);
    
    Map<Integer, Integer> levelXPThresholds = getXPThresholds();

    for (int levels : levelXPThresholds.keySet()) {
        
        if (!(xp >= levelXPThresholds.get(levels))) { 
                                
            if (skillCommand.getPlayerLevel(p) != levels) {
                
            	skillCommand.setPlayerLevel(p, levels);
            	eventCommand.LevelUp(p);
            	
            }
            
            int nextLevelXP = getLevelXPThreshold(levels); //<--- this means it will always return the level higher than the current user level based on xp value.
            return nextLevelXP -= xp;
            
        }
    }
    
    return 0;
}


@Override
public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

	Player p = (Player) sender;
		
	if(args.length == 0) {
		int xp = skillCommand.getPlayerExperience(p);
		p.sendMessage("Current xp: " + xp);
		return true;
	}
	
	
	if(args.length >= 1) {
		
		if(args[0].equalsIgnoreCase("add")) {
			int i = Integer.valueOf(args[1]);
			int xp = (skillCommand.getPlayerExperience(p) + i);
			skillCommand.setPlayerExperience(p, xp);
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage(i + " has been added, current xp: " + skillCommand.getPlayerExperience(p));
			canUserLevelUp(p);
		}
		
		if(args[0].equalsIgnoreCase("get")) {
			int xp = skillCommand.getPlayerExperience(p);
			int level = skillCommand.getPlayerLevel(p);
			skillCommand.setPlayerExperience(p, xp);
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("");
			p.sendMessage("current xp: " + xp + "/" + getLevelXPThreshold(skillCommand.getPlayerLevel(p)));
			p.sendMessage("missing xp: " + canUserLevelUp(p));
			p.sendMessage("current level: " + level);
			
		}
		
		
		if(args[0].equalsIgnoreCase("xpdrop")) {
			int xp = 5;
			skillCommand.setPlayerExperience(p, xp);

		        ArmorStand armorstand = (ArmorStand) p.getWorld().spawnEntity(p.getLocation().add(utilitiesFunctions.generateRandomNumber(0, 1), -0.95, utilitiesFunctions.generateRandomNumber(0, 1)), EntityType.ARMOR_STAND);
		        armorstand.setHealth(10);
		        armorstand.setGravity(false);
		        armorstand.setInvisible(true);
		        armorstand.setCustomName("§a+ §9" + xp + "xp");
		        armorstand.setCustomNameVisible(true);
		        
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        armorstand.remove();
                    }
                }.runTaskLater(Main.getPlugin(), 200);
		        
		        
		        
		}
		
		if(args[0].equals("mount")) {
			Horse h = (Horse) p.getPlayer().getWorld().spawnEntity(p.getPlayer().getLocation(), EntityType.HORSE); // Spawns the horse
			h.setCustomName("§f§l" + p.getName() + "'s pet");
	        h.setCustomNameVisible(true);
	        h.setRemoveWhenFarAway(false);
	        h.setDomestication(1);
	        h.setTamed(true);
	        h.setOwner(p);
	        h.setPassenger(p);
	        h.getInventory().setSaddle(new ItemStack(Material.SADDLE));
			
		}
		
		
		
	}
	


	
	
	return false;
}

}
