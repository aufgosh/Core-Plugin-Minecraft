package utilities;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.cedric.test.commands.banCommand;

public class checkForBan {
	
	//Checks if Player is banned
	public static void banCheck(Player p) {
		
		try {
			banCommand.bancfg.load(banCommand.file);
		} catch (IOException | InvalidConfigurationException e1) {
			e1.printStackTrace();
		}
		
		
		if(!(banCommand.bancfg.contains(p.getName() + ".BANNED:"))) {
			 File file = new File("plugins/Test", "bans.yml");
			 FileConfiguration bancfg = YamlConfiguration.loadConfiguration(file);
			 
				try {
					bancfg.load(file);
				} catch (IOException | InvalidConfigurationException e1) {
					e1.printStackTrace();
				}
				
				boolean banned = false;
			 
				bancfg.set(p.getName() + ".BANNED:", banned);
				try {
					bancfg.save(file);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
		} else if(banCommand.bancfg.getBoolean(p.getName() + ".BANNED:", true)) {
			
			p.kickPlayer("§cYou were banned from the server.");
			return;
		}
		
	}

}