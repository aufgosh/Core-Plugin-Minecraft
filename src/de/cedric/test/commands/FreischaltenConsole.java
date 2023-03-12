package de.cedric.test.commands;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.cedric.test.main.Main;



public class FreischaltenConsole implements CommandExecutor {
	
	public static File free = new File("plugins/Test/", "free.yml");
	public static FileConfiguration cfgfree = YamlConfiguration.loadConfiguration(free);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
		
		if(!(cfgfree.contains(p.getName()))) {

		Bukkit.dispatchCommand(console, "lp user " + p.getName() + " group set Spieler");
		Bukkit.dispatchCommand(console, "key1 " + p.getName() + " epic");
		p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
		p.sendMessage(Main.prefix+"§aDu hast dich erfolgreich freigeschalten!");
		cfgfree.set(p.getName(), 1);
		try {
			cfgfree.save(free);
		} catch (IOException e) {
			e.printStackTrace();
		}
		FileConfiguration cfg = Main.getPlugin().getConfig();
		World world = Bukkit.getWorld(cfg.getString("Spawn.World"));
		double x = cfg.getDouble("Spawn.X");
		double y = cfg.getDouble("Spawn.Y");
		double z = cfg.getDouble("Spawn.Z");
		float yaw = (float) cfg.getDouble("Spawn.Yaw");
		float pitch = (float) cfg.getDouble("Spawn.Pitch");
		
		Location loc = new Location(world, x, y, z, yaw, pitch);
		
		for(int i = 0; i < 200; i++) {
			p.sendMessage(" ");
		}
		
		ItemStack diamond = new ItemStack(Material.DIAMOND);
		ItemMeta diamondMeta = diamond.getItemMeta();
		diamond.setAmount(3);
		diamond.setItemMeta(diamondMeta);
		
		ItemStack steak = new ItemStack(Material.COOKED_PORKCHOP);
		ItemMeta steakMeta = steak.getItemMeta();
		steak.setAmount(32);
		steak.setItemMeta(steakMeta);
		
		
		
		
		p.teleport(loc);
		p.getInventory().addItem(steak);
		} else {
			p.sendMessage(Main.prefix + "§cDu hast dich bereits freigeschalten!");
			p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
		}
		return false;
	}

}