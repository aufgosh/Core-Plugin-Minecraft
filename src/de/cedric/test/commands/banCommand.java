package de.cedric.test.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import de.cedric.test.main.Main;

public class banCommand implements CommandExecutor {
	
	public static File file = new File("plugins/Test", "bans.yml");
	public static FileConfiguration bancfg = YamlConfiguration.loadConfiguration(file);
	
	public static boolean banned = true;

	@Override
	public boolean onCommand(CommandSender sender, Command cmd,  String label,
			 String[] args) {
		
		if(sender.hasPermission("main.ban")) {
			Player t = Bukkit.getPlayer(args[0]);
			
		
			if(!(args.length >= 1)) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
				p.sendMessage(Main.prefix + "�cplease use /ban (player)");
				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
				}
			} else if(t.equals(sender)) {
				if(sender instanceof Player) {
					Player p = (Player) sender;
				p.sendMessage(Main.prefix + "�cYou cannot ban yourself!");
				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
				}
			} else {
				banPlayer(t);
				t.kickPlayer("�cYou were banned from the server.");
				sender.sendMessage("Player " + t + " banned.");
				if(sender instanceof Player) {
					Player p = (Player) sender;
				p.sendMessage(Main.prefix + "�cYou successfully banned player �7: �e" + t);
				p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
				} else {
					sender.sendMessage("Player " + t + " banned.");
				}
			}
		} else {
			if(sender instanceof Player) {
				Player p = (Player) sender;
			p.sendMessage(Main.error);
			p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
			}
		}
		
		return false;
	}

	public void banPlayer(Player target) {
		
		try {
			bancfg.load(file);
		} catch (IOException | InvalidConfigurationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		bancfg.set(target.getName() + ".BANNED:", banned);
		try {
			bancfg.save(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
