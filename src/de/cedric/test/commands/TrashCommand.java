package de.cedric.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TrashCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if(sender instanceof Player) {
			Player p = (Player) sender;
			if(args.length == 0) {
				
				Inventory inv = Bukkit.createInventory(null, 9 * 3, "§cDer Mülleimer");
				p.openInventory(inv);
				p.sendMessage("§aDu hast den Mülleimer erfolgreich geöffnet!");
				
			}
		}

	return false;
	
	
}
}
