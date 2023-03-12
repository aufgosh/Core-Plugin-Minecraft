package de.cedric.test.commands;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SpawnerCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		ItemStack spawner = new ItemStack(Material.SPAWNER, 1, (short) 92);
		ItemMeta spawnerMeta = spawner.getItemMeta();
		spawner.setAmount(1);
		spawner.setItemMeta(spawnerMeta);
		if(p.hasPermission("main.admin")) {
			if(args[0].equalsIgnoreCase("cow")) {
				p.getInventory().addItem(spawner);
				
			}
			
			
			
		}
		
		
		
		
		return false;
	}

}
