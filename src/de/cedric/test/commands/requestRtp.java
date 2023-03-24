package de.cedric.test.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class requestRtp implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		Inventory inv = Bukkit.createInventory(null, 27, "§9Confirm Random Teleport");
		
		ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta GlassMeta = Glass.getItemMeta();
		Glass.setAmount(1);
	    GlassMeta.setDisplayName(" ");
		Glass.setItemMeta(GlassMeta);
		
		ItemStack Decline = new ItemStack(Material.RED_CONCRETE);
		ItemMeta DeclineMeta = Decline.getItemMeta();
		Decline.setAmount(1);
		DeclineMeta.setDisplayName("§cDecline");
		ArrayList<String> DeclineLore = new ArrayList<String>();
		DeclineLore.add("§7Do you really want to teleport");
		DeclineLore.add("§7into the wild?");
		DeclineLore.add("");
		DeclineLore.add("§4EVERYONE§c will be able to");
		DeclineLore.add("§4ATTACK YOU§7.");
		DeclineMeta.setLore(DeclineLore);
		Decline.setItemMeta(DeclineMeta);
		
		ItemStack Confirm = new ItemStack(Material.GREEN_CONCRETE);
		ItemMeta ConfirmMeta = Confirm.getItemMeta();
		Confirm.setAmount(1);
		ConfirmMeta.setDisplayName("§AConfirm");
		ArrayList<String> ConfirmLore = new ArrayList<String>();
		ConfirmLore.add("§7Do you really want to teleport");
		ConfirmLore.add("§7into the wild?");
		ConfirmLore.add("");
		ConfirmLore.add("§4EVERYONE§c will be able to");
		ConfirmLore.add("§4ATTACK YOU§7.");
		ConfirmMeta.setLore(ConfirmLore);
		Confirm.setItemMeta(ConfirmMeta);
		
		
		for(int i = 0; i<27; i++) {
			if(!(i == 12 || i == 14 )) {
			inv.setItem(i, Glass);
			} else {
				switch(i) {
				case 12:
					inv.setItem(i, Confirm);
					break;
				case 14:
					inv.setItem(i, Decline);
					break;
				}
			}
		}
		
		p.openInventory(inv);
		
		
		return false;
	}

}
