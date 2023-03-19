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
	
	public static ItemStack[] getItemStacksHealthEnhancementUnlocked(Player p) {
		int damagelevel = skillCommand.cfg.getInt(p.getName() + ".Health");
		ItemStack[] skillpoints = new ItemStack[damagelevel];
		
		for(int num = 0; num<damagelevel; num++) {
			
			double hearts = (num +1);
			
			if(num == 8) {
				hearts = 10;
			}
			
			skillpoints[num] = new ItemStack(Material.GREEN_CONCRETE);
			ItemMeta nameMeta = skillpoints[num].getItemMeta();
			skillpoints[num].setAmount(1);
			nameMeta.setDisplayName("§alevel " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§6increases your total Health by");
			namelore.add("§6by §c" + hearts  + " §eHearts§8.");
			namelore.add("");
			namelore.add("§aYou have unlocked this§7.");
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		
		return skillpoints;
		
	}
	
	public static ItemStack[] getItemStacksHealthEnhancementLocked(Player p) {
		int damagelevel = skillCommand.cfg.getInt(p.getName() + ".Health");
		ItemStack[] skillpointslocked = new ItemStack[(9)];
				
		for(int num = damagelevel; num<9; num++) {
			
			double hearts = (num +1);
			
			if(num == 8) {
				hearts = 10;
			}
			
			skillpointslocked[num] = new ItemStack(Material.GRAY_CONCRETE);
			ItemMeta nameMeta = skillpointslocked[num].getItemMeta();
			skillpointslocked[num].setAmount(1);
			nameMeta.setDisplayName("§7level " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§8increases your total Health by");
			namelore.add("§8by §c" + hearts  + " §eHearts§8.");
			nameMeta.setLore(namelore);
			skillpointslocked[num].setItemMeta(nameMeta);
		}
		
		
		return skillpointslocked;
		
	}
	
	public static void openHealthLevelSkillMenu(Player p) {
		List<Integer> list=new ArrayList<Integer>();
		ItemStack[] skillpoints = new ItemStack[9];
		
		Inventory inv = Bukkit.createInventory(null, 27, "§cHealthpoint Enhancement");
		int damagelevel = skillCommand.cfg.getInt(p.getName() + ".Health");
		
		
		ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta GlassMeta = Glass.getItemMeta();
		Glass.setAmount(1);
	    GlassMeta.setDisplayName(" ");
		Glass.setItemMeta(GlassMeta);
		
		for(int listnum = 9; listnum<18; listnum++) {
			list.add(listnum);
		}
		
		
		for(int num = 0; num<damagelevel; num++) {
			
			double hearts = (num + 1);
			
			if(num == 9 ) {
				hearts = 10;
			}
			
			skillpoints[num] = new ItemStack(Material.GREEN_CONCRETE);
			ItemMeta nameMeta = skillpoints[num].getItemMeta();
			skillpoints[num].setAmount(1);
			nameMeta.setDisplayName("§alevel " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§6increases your total Health by");
			namelore.add("§6by §c" + hearts  + " §eHearts§8.");
			namelore.add("");
			namelore.add("§aYou have unlocked this§7.");
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		for(int num = damagelevel; num<9; num++) {
			
			double hearts = (num +1);
			
			if(num == 8) {
				hearts = 10;
			}
			
			skillpoints[num] = new ItemStack(Material.GRAY_CONCRETE);
			ItemMeta nameMeta = skillpoints[num].getItemMeta();
			skillpoints[num].setAmount(1);
			nameMeta.setDisplayName("§7level " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§8increases your total Health by");
			namelore.add("§8by §c" + hearts  + " §eHearts§8.");
			if(num == damagelevel) {
				if(skillCommand.getSkillpointsCore(p) >= 1) {
					namelore.add("§aUnlock this for §e1§a skillpoint§7.");
				} else {
					namelore.add("§cUnlock this for §e1§c skillpoint§7.");
				}
			} else {
				namelore.add("§cUnlock previous rank before");
				namelore.add("§cunlocking this one§7.");
			}
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		
		
		for(int i = 0; i<27; i++) {
			if (list.contains(i)) {
				inv.setItem(i, skillpoints[list.indexOf(i)]);
				
			} else {
				inv.setItem(i, Glass);
			}
		}
		
		p.openInventory(inv);
	}
	
	public static ItemStack[] getItemStacksDefensiveEnhancementUnlocked(Player p) {
		int damagelevel = skillCommand.cfg.getInt(p.getName() + ".Damagereduction");
		ItemStack[] skillpoints = new ItemStack[damagelevel];
		
		for(int num = 0; num<damagelevel; num++) {
			skillpoints[num] = new ItemStack(Material.GREEN_CONCRETE);
			ItemMeta nameMeta = skillpoints[num].getItemMeta();
			skillpoints[num].setAmount(1);
			nameMeta.setDisplayName("§alevel " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§6reduces your total damage taken");
			namelore.add("§6by enemys by §e" + ((num+1)*5) + "%§7.");
			namelore.add("");
			namelore.add("§aYou have unlocked this§7.");
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		
		return skillpoints;
		
	}
	
	public static ItemStack[] getItemStacksDefensiveEnhancementLocked(Player p) {
		int damagelevel = skillCommand.cfg.getInt(p.getName() + ".Damagereduction");
		ItemStack[] skillpointslocked = new ItemStack[(9)];
		
		
		for(int num = damagelevel; num<9; num++) {
			skillpointslocked[num] = new ItemStack(Material.GRAY_CONCRETE);
			ItemMeta nameMeta = skillpointslocked[num].getItemMeta();
			skillpointslocked[num].setAmount(1);
			nameMeta.setDisplayName("§7level " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§8reduces your total damage taken");
			namelore.add("§8by enemys by §e" + ((num+1)*5) + "%§8.");
			nameMeta.setLore(namelore);
			skillpointslocked[num].setItemMeta(nameMeta);
		}
		
		
		return skillpointslocked;
		
	}
	
	public static void openDefensiveLevelSkillMenu(Player p) {
		List<Integer> list=new ArrayList<Integer>();
		ItemStack[] skillpoints = new ItemStack[9];
		
		Inventory inv = Bukkit.createInventory(null, 27, "§9Defensive Enhancement");
		int damagelevel = skillCommand.cfg.getInt(p.getName() + ".Damagereduction");
		
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
			nameMeta.setDisplayName("§alevel " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§6reduces your total damage taken");
			namelore.add("§6by enemys by §e" + ((num+1)*5) + "%§7.");
			namelore.add("");
			namelore.add("§aYou have unlocked this§7.");
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		for(int num = damagelevel; num<9; num++) {
			skillpoints[num] = new ItemStack(Material.GRAY_CONCRETE);
			ItemMeta nameMeta = skillpoints[num].getItemMeta();
			skillpoints[num].setAmount(1);
			nameMeta.setDisplayName("§7level " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§8reduces your total damage done");
			namelore.add("§8by enemys by §e" + ((num+1)*5) + "%§8.");
			namelore.add("");
			if(num == damagelevel) {
				if(skillCommand.getSkillpointsCore(p) >= 1) {
					namelore.add("§aUnlock this for §e1§a skillpoint§7.");
				} else {
					namelore.add("§cUnlock this for §e1§c skillpoint§7.");
				}
			} else {
				namelore.add("§cUnlock previous rank before");
				namelore.add("§cunlocking this one§7.");
			}
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		
		
		for(int i = 0; i<27; i++) {
			if (list.contains(i)) {
				inv.setItem(i, skillpoints[list.indexOf(i)]);
				
			} else {
				inv.setItem(i, Glass);
			}
		}
		
		p.openInventory(inv);
	}
	
	public static ItemStack[] getItemStacksDamageEnhancementUnlocked(Player p) {
		int damagelevel = skillCommand.cfg.getInt(p.getName() + ".Damage");
		ItemStack[] skillpoints = new ItemStack[damagelevel];
		
		for(int num = 0; num<damagelevel; num++) {
			skillpoints[num] = new ItemStack(Material.GREEN_CONCRETE);
			ItemMeta nameMeta = skillpoints[num].getItemMeta();
			skillpoints[num].setAmount(1);
			nameMeta.setDisplayName("§alevel " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§6increases your total damage done");
			namelore.add("§6against enemys by §e" + ((num+1)*5) + "%§7.");
			namelore.add("");
			namelore.add("§aYou have unlocked this§7.");
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		
		return skillpoints;
		
	}
	
	public static ItemStack[] getItemStacksDamageEnhancementLocked(Player p) {
		int damagelevel = skillCommand.cfg.getInt(p.getName() + ".Damage");
		ItemStack[] skillpointslocked = new ItemStack[(9)];
		
		
		for(int num = damagelevel; num<9; num++) {
			skillpointslocked[num] = new ItemStack(Material.GRAY_CONCRETE);
			ItemMeta nameMeta = skillpointslocked[num].getItemMeta();
			skillpointslocked[num].setAmount(1);
			nameMeta.setDisplayName("§7level " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§8increases your total damage done");
			namelore.add("§8against enemys by §e" + ((num+1)*5) + "%§8.");
			nameMeta.setLore(namelore);
			skillpointslocked[num].setItemMeta(nameMeta);
		}
		
		
		return skillpointslocked;
		
	}
	
	public static void openDamageLevelSkillMenu(Player p) {
		List<Integer> list=new ArrayList<Integer>();
		ItemStack[] skillpoints = new ItemStack[9];
		
		Inventory inv = Bukkit.createInventory(null, 27, "§cDamage Enhancement");
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
			nameMeta.setDisplayName("§alevel " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§6increases your total damage done");
			namelore.add("§6against enemys by §e" + ((num+1)*5) + "%§7.");
			namelore.add("");
			namelore.add("§aYou have unlocked this§7.");
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		for(int num = damagelevel; num<9; num++) {
			skillpoints[num] = new ItemStack(Material.GRAY_CONCRETE);
			ItemMeta nameMeta = skillpoints[num].getItemMeta();
			skillpoints[num].setAmount(1);
			nameMeta.setDisplayName("§7level " + (num + 1));
			ArrayList<String> namelore = new ArrayList<String>();
			namelore.add("§8increases your total damage done");
			namelore.add("§8against enemys by §e" + ((num+1)*5) + "%§8.");
			namelore.add("");
			if(num == damagelevel) {
				if(skillCommand.getSkillpointsCore(p) >= 1) {
					namelore.add("§aUnlock this for §e1§a skillpoint§7.");
				} else {
					namelore.add("§cUnlock this for §e1§c skillpoint§7.");
				}
			} else {
				namelore.add("§cUnlock previous rank before");
				namelore.add("§cunlocking this one§7.");
			}
			nameMeta.setLore(namelore);
			skillpoints[num].setItemMeta(nameMeta);
		}
		
		
		
		
		for(int i = 0; i<27; i++) {
			if (list.contains(i)) {
				inv.setItem(i, skillpoints[list.indexOf(i)]);
				
			} else {
				inv.setItem(i, Glass);
			}
		}
		
		p.openInventory(inv);
	}
	
	public static void openConfirmationMenu(Player p) {
		Inventory inv = Bukkit.createInventory(null, 27, "§9Confirm Purchase");
		
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
		DeclineLore.add("§cDo you really want to buy");
		DeclineLore.add("§e1 Skillpoint§c for §e20 Level§7?");
		DeclineMeta.setLore(DeclineLore);
		Decline.setItemMeta(DeclineMeta);
		
		ItemStack Confirm = new ItemStack(Material.GREEN_CONCRETE);
		ItemMeta ConfirmMeta = Confirm.getItemMeta();
		Confirm.setAmount(1);
		ConfirmMeta.setDisplayName("§AConfirm");
		ArrayList<String> ConfirmLore = new ArrayList<String>();
		ConfirmLore.add("§aDo you really want to buy");
		ConfirmLore.add("§e1 Skillpoint§a for §e20 Level§7?");
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
	}
	
	public static void openSkillMenu(Player p) {
		Inventory inv = Bukkit.createInventory(null, 54, "§9Skillpoints§7: §e" + skillCommand.getSkillpointsCore(p));
		
		ItemStack Glass = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
		ItemMeta GlassMeta = Glass.getItemMeta();
		Glass.setAmount(1);
	    GlassMeta.setDisplayName(" ");
		Glass.setItemMeta(GlassMeta);
		
		ItemStack Damage = new ItemStack(Material.IRON_SWORD);
		ItemMeta DamageMeta = Damage.getItemMeta();
		Damage.setAmount(1);
		DamageMeta.setDisplayName("§cDamage Enhancement");
		ArrayList<String> DamageLore = new ArrayList<String>();
		DamageLore.add("§aincreases your total §edamage§a done");
		DamageLore.add("§aagainst enemys§7.");
		DamageMeta.setLore(DamageLore);
		Damage.setItemMeta(DamageMeta);
		
		ItemStack Healthpoint = new ItemStack(Material.REDSTONE);
		ItemMeta HealthpointMeta = Healthpoint.getItemMeta();
		Healthpoint.setAmount(1);
		HealthpointMeta.setDisplayName("§cHealthpoint Enhancement");
		ArrayList<String> HealthpointLore = new ArrayList<String>();
		HealthpointLore.add("§aincreases your total §eHealthpoints§7.");
		HealthpointMeta.setLore(HealthpointLore);
		Healthpoint.setItemMeta(HealthpointMeta);
		
		ItemStack Defense = new ItemStack(Material.SHIELD);
		ItemMeta DefenseMeta = Defense.getItemMeta();
		Defense.setAmount(1);
		DefenseMeta.setDisplayName("§9Defense Enhancement");
		ArrayList<String> DefenseLore = new ArrayList<String>();
		DefenseLore.add("§areduces your §edamage taken§a against enemys§7.");
		DefenseMeta.setLore(DefenseLore);
		Defense.setItemMeta(DefenseMeta);
		
		ItemStack Experience = new ItemStack(Material.EXPERIENCE_BOTTLE);
		ItemMeta ExperienceMeta = Experience.getItemMeta();
		Experience.setAmount(1);
		ExperienceMeta.setDisplayName("§eBuy Skillpoints");
		ArrayList<String> ExperienceLore = new ArrayList<String>();
		ExperienceLore.add("§aBuy §eSkillpoints§a with experience§7.");
		ExperienceLore.add("");
		ExperienceLore.add("§a1 §eSkillpoint §7= §a20 Level§7.");
		ExperienceMeta.setLore(ExperienceLore);
		Experience.setItemMeta(ExperienceMeta);
		
		for(int i = 0; i<54; i++) {
			if(!(i == 13 || i == 29 || i == 31 || i == 33)) {
			inv.setItem(i, Glass);
			} else {
				switch(i) {
				case 13:
					inv.setItem(i, Experience);
					break;
				case 29:
					inv.setItem(i, Damage);
					break;
				case 31:
					inv.setItem(i, Healthpoint);
					break;
				case 33:
					inv.setItem(i, Defense);
					break;
				}
			}
		}
		
		p.openInventory(inv);
	}
	
	

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		Player p = (Player) sender;
		openSkillMenu(p);
		return false;
	}

}
