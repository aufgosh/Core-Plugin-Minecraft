package de.cedric.test.commands;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.cedric.test.main.Main;

public class enchantBook implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(args[0].equalsIgnoreCase("bloodbath1")){
		    ItemStack test = new ItemStack(Material.ENCHANTED_BOOK);
		    ArrayList<String> testLore = new ArrayList<String>();
			ItemMeta testMeta = test.getItemMeta();
			testMeta.setDisplayName("§dEnchant Weapon§7:§c Bloodbath 1");
			testLore.add("§aEnchants your Weapon§7,§a to sometimes");
			testLore.add("§acause your enemy to §cBleed§a for");
			testLore.add("§e2§c Damage §aover the course of §e4 §eseconds§7.");
			testMeta.setLore(testLore);
			test.setAmount(1);
			
			test.setItemMeta(testMeta);
			
			p.getInventory().addItem(test);
			p.sendMessage(Main.prefix+"§aDu hast ein verfluchtes Buch erhalten");
		}
		
		if(args[0].equalsIgnoreCase("Breezewalker1")){
		    ItemStack test = new ItemStack(Material.ENCHANTED_BOOK);
		    ArrayList<String> testLore = new ArrayList<String>();
			ItemMeta testMeta = test.getItemMeta();
			testMeta.setDisplayName("§dEnchant Boots§7:§c Breezewalker 1");
			testLore.add("§aEnchants your Boots§7 §a to gain");
			testLore.add("§7+§e10%§a movement speed§7.");
			testMeta.setLore(testLore);
			test.setAmount(1);
			
			test.setItemMeta(testMeta);
			
			p.getInventory().addItem(test);
			p.sendMessage(Main.prefix+"§aDu hast ein verfluchtes Buch erhalten");
		}
		
		
		
		return false;
	}

}
