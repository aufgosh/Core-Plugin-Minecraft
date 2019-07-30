package de.cedric.test.commands;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.cedric.test.main.Main;

public class Testobject

implements CommandExecutor{


	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		if(p.hasPermission("main.admin")) {
		if(args.length == 2) {
			Player target = Bukkit.getPlayer(args[0]);
			if(target != null){
			if(args[1].equalsIgnoreCase("common")){
				
			    ItemStack test = new ItemStack(Material.TRIPWIRE_HOOK);
			    ArrayList<String> testLore = new ArrayList<String>();
				ItemMeta testMeta = test.getItemMeta();
				testMeta.setDisplayName("§dGewöhnlicher Schlüssel");
				testLore.add("§6Ein Schlüssel womit du eine");
				testLore.add("§6gewöhnliche Belohnungskiste öffnen kannst!");
				testLore.add("§6Gebe dazu §c/Belohnung§6 ein.");
				testMeta.setLore(testLore);
				test.setAmount(1);
				
				test.setItemMeta(testMeta);
				
				target.getPlayer().getInventory().addItem(test);
				target.sendMessage(Main.prefix+"§aDu hast einen gewöhnlichen Schlüssel erhalten!");
				target.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
				
			} else if(args[1].equalsIgnoreCase("rare")){
				
			    ItemStack test1 = new ItemStack(Material.TRIPWIRE_HOOK);
			    ArrayList<String> test1Lore = new ArrayList<String>();
				ItemMeta test1Meta = test1.getItemMeta();
				test1Meta.setDisplayName("§dSeltener Schlüssel");
				test1Lore.add("§6Ein Schlüssel womit du eine");
				test1Lore.add("§6seltene Belohnungskiste öffnen kannst!");
				test1Lore.add("§6Gebe dazu §c/Belohnung§6 ein.");
				test1Meta.setLore(test1Lore);
				test1.setAmount(1);
				
				test1.setItemMeta(test1Meta);
				
				target.getPlayer().getInventory().addItem(test1);
				target.sendMessage(Main.prefix+"§aDu hast dir einen seltenen Schlüssel gegeben!"); 
				target.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
				
			} else if(args[1].equalsIgnoreCase("epic")){
				
			    ItemStack test2 = new ItemStack(Material.TRIPWIRE_HOOK);
			    ArrayList<String> test2Lore = new ArrayList<String>();
				ItemMeta test2Meta = test2.getItemMeta();
				test2Meta.setDisplayName("§dEpischer Schlüssel");
				test2Lore.add("§6Ein Schlüssel womit du eine");
				test2Lore.add("§6epische Belohnungskiste öffnen kannst!");
				test2Lore.add("§6Gebe dazu §c/Belohnung§6 ein.");
				test2Meta.setLore(test2Lore);
				test2.setAmount(1);
				
				test2.setItemMeta(test2Meta);
				
				target.getPlayer().getInventory().addItem(test2);
				target.sendMessage(Main.prefix+"§aDu hast dir einen epischen Schlüssel gegeben!");
				target.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
				
			}
			
		} else {
			p.sendMessage(Main.prefix + "§cBenutze /key Spieler common/rare/epic");
			p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
		} } else {
			p.sendMessage(Main.prefix + "§cDieser Command existiert nicht!");
			p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
		}
		}
		

	
		return false;
	

}


}
