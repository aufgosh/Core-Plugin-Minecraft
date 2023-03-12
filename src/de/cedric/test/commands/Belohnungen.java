package de.cedric.test.commands;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.cedric.test.main.Main;

public class Belohnungen implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		Inventory inv = Bukkit.createInventory(null, 27, "§cBelohnungen");
		
		
		
		ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);;
		ItemMeta GlassMeta = Glass.getItemMeta();
		Glass.setAmount(1);
	    GlassMeta.setDisplayName(" ");
		Glass.setItemMeta(GlassMeta);
		
		ItemStack daily = new ItemStack(Material.ENDER_CHEST);
		ItemMeta dailyMeta = daily.getItemMeta();
		dailyMeta.setDisplayName("§dGewöhnliche Kiste");
		ArrayList<String> dailyLore = new ArrayList<String>();
		dailyLore.add("§6Du kannst diese Kiste");
		dailyLore.add("§6mit einem Schlüssel öffnen,");
		dailyLore.add("§6welchen du durch §c/vote");
		dailyLore.add("§6erhalten kannst");
		dailyMeta.setLore(dailyLore);
		daily.setItemMeta(dailyMeta);
		
		ItemStack rare = new ItemStack(Material.ENDER_CHEST);
		ItemMeta rareMeta = rare.getItemMeta();
		rareMeta.setDisplayName("§dSeltene Kiste");
		ArrayList<String> rareLore = new ArrayList<String>();
	    rareLore.add("§6Du kannst diese Kiste");
		rareLore.add("§6mit einem Schlüssel öffnen,");
		rareLore.add("§6welchen du durch §c/vote");
		rareLore.add("§6erhalten kannst");
		rareMeta.setLore(rareLore);
		rare.setItemMeta(rareMeta);
		
		ItemStack epic = new ItemStack(Material.ENDER_CHEST);
		ItemMeta epicMeta = epic.getItemMeta();
		epicMeta.setDisplayName("§dEpische Kiste");
		ArrayList<String> epicLore = new ArrayList<String>();
	    epicLore.add("§6Du kannst diese Kiste");
		epicLore.add("§6mit einem Schlüssel öffnen,");
		epicLore.add("§6welchen du durch §c/vote");
		epicLore.add("§6erhalten kannst");
		epicMeta.setLore(epicLore);
		epic.setItemMeta(epicMeta);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		inv.setItem(0, Glass);
		inv.setItem(1, Glass);
		inv.setItem(2, Glass);
		inv.setItem(3, Glass);
		inv.setItem(4, Glass);
		inv.setItem(5, Glass);
		inv.setItem(6, Glass);
		inv.setItem(7, Glass);
		inv.setItem(8, Glass);
		inv.setItem(9, Glass);
		inv.setItem(10, Glass);
		inv.setItem(11, daily);
		inv.setItem(12, Glass);
		inv.setItem(13, rare);
		inv.setItem(14, Glass);
		inv.setItem(15, epic);
		inv.setItem(16, Glass);
		inv.setItem(17, Glass);
		inv.setItem(18, Glass);
		inv.setItem(19, Glass);
		inv.setItem(20, Glass); 	
		inv.setItem(21, Glass);
		inv.setItem(22, Glass);
		inv.setItem(23, Glass);
		inv.setItem(24, Glass);
		inv.setItem(25, Glass);
		inv.setItem(26, Glass);
		if(p.hasPermission("main.user")) {
		p.playSound(p.getLocation(), Sound.BLOCK_ENDER_CHEST_OPEN, 3, 2);
		p.openInventory(inv);
		} else {
			p.sendMessage(Main.prefix + "§cDu musst erst das Tutorial machen!");
			p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
		}
		return false;
	}

}
