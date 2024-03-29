package listener;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.cedric.test.commands.PlayerExperienceHandler;
import de.cedric.test.commands.skillCommand;
import de.cedric.test.commands.skillMenuCommand;
import de.cedric.test.main.Main;
import utilities.utilitiesFunctions;

public class skillMenuListener implements Listener {
	
	@EventHandler
	public void experience(PlayerExpChangeEvent e) {
		Player p = e.getPlayer();
		int xp = e.getAmount();
		
		if(p.hasPermission("main.admin")) {
			xp = xp * 2;
		}
		
		skillCommand.setPlayerExperience(p, (skillCommand.getPlayerExperience(p) + xp));
		utilitiesFunctions.drawXpDrop(p, xp);
		PlayerExperienceHandler.canUserLevelUp(p);
	}
	
	@EventHandler
	public void on(InventoryClickEvent e) {
		
		
		Inventory open = e.getClickedInventory();
		ItemStack item = e.getCurrentItem();
		Player p = (Player) e.getWhoClicked();
		
		ItemStack[] unlockedstack = skillMenuCommand.getItemStacksDamageEnhancementUnlocked(p);
		ItemStack[] lockedstack = skillMenuCommand.getItemStacksDamageEnhancementLocked(p);
		
		ItemStack[] unlockedstackDefensive = skillMenuCommand.getItemStacksDefensiveEnhancementUnlocked(p);
		ItemStack[] lockedstackDefensive = skillMenuCommand.getItemStacksDefensiveEnhancementLocked(p);
		
		ItemStack[] unlockedstackHealth = skillMenuCommand.getItemStacksHealthEnhancementUnlocked(p);
		ItemStack[] lockedstackHealth = skillMenuCommand.getItemStacksHealthEnhancementLocked(p);
		

		
		if(item.getItemMeta() == null) {
			return;
		}
		
		if(item.getItemMeta().getDisplayName().equals("§dEnchant Weapon§7:§c Bloodbath 1")) {
			e.setCancelled(true);
			e.getClickedInventory().remove(item);
			ItemMeta meta = p.getInventory().getItem(0).getItemMeta();
			p.sendMessage("Debug: " + p.getInventory().getItem(0));
		    ArrayList<String> lore = new ArrayList<String>();
		    if(p.getInventory().getItem(0).getItemMeta().getLore() != null) {
		    	lore = (ArrayList<String>) p.getInventory().getItem(0).getItemMeta().getLore();
		    }
			lore.add("");
			lore.add("§dEnchanted§7:§c Bloodbath 1");	
			meta.setLore(lore);
			p.getInventory().getItem(0).setItemMeta(meta);
		}
		
		if(item.getItemMeta().getDisplayName().equals("§dEnchant Boots§7:§c Breezewalker 1")) {
			e.setCancelled(true);
			ItemMeta meta = p.getInventory().getItem(0).getItemMeta();
		    ArrayList<String> lore = (ArrayList<String>) p.getInventory().getItem(0).getItemMeta().getLore();
			lore.add("");
			lore.add("§dEnchanted§7:§c Breezewalker 1");	
			meta.setLore(lore);
			p.getInventory().getItem(0).setItemMeta(meta);
			//lorestring.add(" ");
			//lorestring.add("§dEnchanted§7:§c Bloodbath 1");
			//p.getInventory().getItem(0).getItemMeta().setLore(lorestring);
		}
		
		
		if(e.getView().getTitle().equals("§9Confirm Random Teleport")) {
			
			e.setCancelled(true);
			
			if (open == null) {
				return;
			}
			
			if (item == null || !item.hasItemMeta()) {
				return;
			}
			
			
			if(item.getItemMeta().getDisplayName().equals("§aConfirm")) {
				if(p.getWorld().getName().equals("spawnworld")) {
					p.closeInventory();
					p.sendMessage(Main.prefix + "§eSending random teleport request§7...");
					p.playSound(p, Sound.ENTITY_PUFFER_FISH_BLOW_OUT, 3, 2);
					Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "rtp " + p.getName());	
				} else {
					utilitiesFunctions.sendErrorCustom(p, "§cRandom Teleport requests from Spawn only§7.");
				}
			}
			
			if(item.getItemMeta().getDisplayName().equals("§cDecline")) { 
				p.closeInventory();
			}
		}
		
		if(e.getView().getTitle().equals("§9Confirm Purchase")) {
			
			e.setCancelled(true);
			
			if (open == null) {
				return;
			}
			
			if (item == null || !item.hasItemMeta()) {
				return;
			}
			
			if(item.getItemMeta().getDisplayName().equals("§aConfirm")) {
				if(p.getLevel() >= 20) {
					p.setLevel((p.getLevel() - 20));
					skillCommand.setSkillpointsCore(p, (skillCommand.getSkillpointsCore(p)+1));
					p.sendMessage(Main.prefix + "§aYou have recieved one skillpoint§7.");
					p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
					skillMenuCommand.openSkillMenu(p);
				} else {
					p.sendMessage(Main.prefix + "§cYou do not have enough level§7.");
					p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
				}
				
			}
			
			if(item.getItemMeta().getDisplayName().equals("§cDecline")) {
				skillMenuCommand.openSkillMenu(p);
				
			}
		}
		
		if(e.getView().getTitle().equals("§9Skillpoints§7: §e" + skillCommand.getSkillpointsCore(p))) {
			
			e.setCancelled(true);
			
			if (open == null) {
				return;
			}
			
			if (item == null || !item.hasItemMeta()) {
				return;
			}
			
			if(item.getItemMeta().getDisplayName().equals("§eBuy Skillpoints")) {
				skillMenuCommand.openConfirmationMenu(p);
				
			}
			
			
			
			if(item.getItemMeta().getDisplayName().equals("§cDamage Enhancement")) {
				skillMenuCommand.openDamageLevelSkillMenu(p);
			}
			
			if(item.getItemMeta().getDisplayName().equals("§9Defense Enhancement")) {
				skillMenuCommand.openDefensiveLevelSkillMenu(p);
			}
			
			if(item.getItemMeta().getDisplayName().equals("§cHealthpoint Enhancement")) {
				skillMenuCommand.openHealthLevelSkillMenu(p);
			}
			
		}
		
		if(e.getView().getTitle().contains("§cHealthpoint Enhancement")) {

			e.setCancelled(true);
			
			if (open == null) {
				return;
			}
			
			if (item == null || !item.hasItemMeta()) {
				return;
			}
			
			
			for(int i = unlockedstackHealth.length; i<lockedstackHealth.length; i++ ) {
				if(item.getItemMeta().getDisplayName().equals(lockedstackHealth[i].getItemMeta().getDisplayName().toString())) {
					
					if(i != unlockedstackHealth.length) {
							p.sendMessage(Main.prefix + "§cYou need to unlock the previous rank first.");
							p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
					} else {
						if(skillCommand.getSkillpointsCore(p) >= 1) {
							skillCommand.setHealthCore(p, i + 1);
							skillMenuCommand.openHealthLevelSkillMenu(p);
							p.sendMessage(Main.prefix + "§aYou have unlocked §6" + e.getView().getTitle() + "§7: §a" + lockedstackHealth[i].getItemMeta().getDisplayName().toString());
							p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
							skillCommand.setSkillpointsCore(p, (skillCommand.getSkillpointsCore(p) - 1));
						} else {
							p.sendMessage(Main.prefix + "§cYou do not have enough skillpoints§7.");
							p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
						}
					}
					
				}
			}
			
		}
		
		
		if(e.getView().getTitle().contains("§9Defensive Enhancement")) {

			e.setCancelled(true);
			
			if (open == null) {
				return;
			}
			
			if (item == null || !item.hasItemMeta()) {
				return;
			}
			
			
			for(int i = unlockedstackDefensive.length; i<lockedstackDefensive.length; i++ ) {
				if(item.getItemMeta().getDisplayName().equals(lockedstackDefensive[i].getItemMeta().getDisplayName().toString())) {
					
					if(i != unlockedstackDefensive.length) {
						p.sendMessage(Main.prefix + "§cYou need to unlock the previous rank first.");
						p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
					} else {
						if(skillCommand.getSkillpointsCore(p) >= 1) {
							skillCommand.setDamageReductionCore(p, i + 1);
							skillMenuCommand.openDefensiveLevelSkillMenu(p);
							p.sendMessage(Main.prefix + "§aYou have unlocked §6" + e.getView().getTitle() + "§7: §a" + lockedstackDefensive[i].getItemMeta().getDisplayName().toString());
							p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
							skillCommand.setSkillpointsCore(p, (skillCommand.getSkillpointsCore(p) - 1));
						} else {
							p.sendMessage(Main.prefix + "§cYou do not have enough skillpoints§7.");
							p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
						}
					}
					
				}
			}
			
		}
		
		if(e.getView().getTitle().contains("§cDamage Enhancement")) {

			e.setCancelled(true);
			
			if (open == null) {
				return;
			}
			
			if (item == null || !item.hasItemMeta()) {
				return;
			}
			
			
			for(int i = unlockedstack.length; i<lockedstack.length; i++ ) {
				if(item.getItemMeta().getDisplayName().equals(lockedstack[i].getItemMeta().getDisplayName().toString())) {
					
					if(i != unlockedstack.length) {
						p.sendMessage(Main.prefix + "§cYou need to unlock the previous rank first.");
						p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
					} else {
						if(skillCommand.getSkillpointsCore(p) >= 1) {
							skillCommand.setDamageCore(p, (i + 1));
							skillMenuCommand.openDamageLevelSkillMenu(p);
							p.sendMessage(Main.prefix + "§aYou have unlocked §6" + e.getView().getTitle() + "§7: §a" + lockedstack[i].getItemMeta().getDisplayName().toString());
							p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
							skillCommand.setSkillpointsCore(p, (skillCommand.getSkillpointsCore(p) - 1));
						} else {
							p.sendMessage(Main.prefix + "§cYou do not have enough skillpoints§7.");
							p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
						}
					}
					
				}
			}
			
		}
	}
}
