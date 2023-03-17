package de.cedric.test.commands;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class skillMenuCommand implements CommandExecutor {
	
	List<Integer> list=new ArrayList<Integer>();
	ItemStack[] skillpoints = new ItemStack[9];
	int[] skilllevel = {5,10,15,20};
	
	
	
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		Inventory inv = Bukkit.createInventory(null, 27, "§cBelohnungen");
		int damagelevel = skillCommand.cfg.getInt(p.getName() + ".Damage");
		
		ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta GlassMeta = Glass.getItemMeta();
		Glass.setAmount(1);
	    GlassMeta.setDisplayName(" ");
		Glass.setItemMeta(GlassMeta);
		
		for(int listnum = 9; listnum<18; listnum++) {
			list.add(listnum);
		}
		
		
		for(int num = 0; num<damagelevel; num++) {
			skillpoints[num] = new ItemStack(Material.GREEN_CONCRETE);
			ItemMeta nameMeta = skillpoints[num].getItemMeta();
			skillpoints[num].setAmount(1);
			nameMeta.setDisplayName("§alevel" + num);
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§6increases your total damage done");
			namelore.add("§6against enemys by §e" + ((num+1)*5) + "%§7.");
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		for(int num = damagelevel; num<9; num++) {
			skillpoints[num] = new ItemStack(Material.GRAY_CONCRETE);
			ItemMeta nameMeta = skillpoints[num].getItemMeta();
			skillpoints[num].setAmount(1);
			nameMeta.setDisplayName("§7level" + num);
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§8increases your total damage done");
			namelore.add("§8against enemys by §e" + ((num+1)*5) + "%§8.");
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		
		
		for(int i = 0; i<27; i++) {
			if (list.contains(i)) {
				p.sendMessage("§anumber " + i + " is in the list");
				p.sendMessage("index: " + list.indexOf(i));
				inv.setItem(i, skillpoints[list.indexOf(i)]);
				
			} else {
				inv.setItem(i, Glass);
			}
		}
		
		p.openInventory(inv);
		
		return false;
	}

}
