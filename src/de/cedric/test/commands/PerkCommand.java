package de.cedric.test.commands;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.DyeColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import de.cedric.test.main.Main;





public class PerkCommand implements CommandExecutor {
	
	public static HashMap<String, Long> cooldown = new HashMap<>();
	
	

	public static File file = new File("plugins/Test/Perks", "XP.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	public static File file1 = new File("plugins/Test/Perks", "Hunger.yml");
	public static FileConfiguration cfg1 = YamlConfiguration.loadConfiguration(file1);
	public static File file2 = new File("plugins/Test/Perks", "Ninja.yml");
	public static FileConfiguration cfg2 = YamlConfiguration.loadConfiguration(file2);
	public static File file3 = new File("plugins/Test/Perks", "Tank.yml");
	public static FileConfiguration cfg3 = YamlConfiguration.loadConfiguration(file3);
	public static File file4 = new File("plugins/Test/Perks", "undead.yml");
	public static FileConfiguration cfg4 = YamlConfiguration.loadConfiguration(file4);
	public static File file5 = new File("plugins/Test/Perks", "berserker.yml");
	public static FileConfiguration cfg5 = YamlConfiguration.loadConfiguration(file5);
	public static File file6 = new File("plugins/Test/Perks", "assasin.yml");
	public static FileConfiguration cfg6 = YamlConfiguration.loadConfiguration(file6);

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		long jetzt = System.currentTimeMillis();
		
		if(cooldown.containsKey(p.getName())) {
			long be = cooldown.get(p.getName());
			int rest = (int) ((be + (30*1000*60)) - jetzt);
			
			if(rest > 0 ) {
				int minute = rest/1000/60;
				rest = rest-(minute*1000*60);
				int sekunde = rest/1000;
				
				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
				p.sendMessage(Main.prefix +"§cDu musst noch§6 " +minute+(minute == 1 ? " Minute " : " Minuten ") + "§cund§6 "
				+sekunde+(sekunde == 1 ? " Sekunde " : " Sekunden " + "§cwarten, um deine passive Spezialfähigkeit zu ändern!"));
				return true;
			}
			
		}
		


		
		Inventory inv = Bukkit.createInventory(null, 9, "§cPassive Spezialfähigkeiten");
		
		
		
		
		ItemStack Glass = new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 7);;
		ItemMeta GlassMeta = Glass.getItemMeta();
		Glass.setAmount(1);
	    GlassMeta.setDisplayName(" ");
		Glass.setItemMeta(GlassMeta);
		

		ItemStack Hunger = new ItemStack(Material.RED_ROSE);
		ItemMeta HungerMeta = Hunger.getItemMeta();
		HungerMeta.setDisplayName("§6Photosynthesist");
		ArrayList<String> HungerLore = new ArrayList<String>();
		HungerLore.add("§aDu bekommst eins mit der Natur! ");
		HungerLore.add ("§aDein Körper nimmt nun genügend");
		HungerLore.add("§aMineralien durch das bloße herumlaufen auf,");
		HungerLore.add("§awo durch du nichts mehr essen musst!");
		HungerLore.add("");
		HungerLore.add("§7Du kannst immer nur eine Fähigkeit");
		HungerLore.add("§7aktiviert haben!");
		HungerMeta.setLore(HungerLore);
		Hunger.setDurability((short) 1);
		Hunger.setItemMeta(HungerMeta);
		
		
		ItemStack xp = new ItemStack(Material.EXP_BOTTLE);
		ItemMeta xpMeta = xp.getItemMeta();
		xpMeta.setDisplayName("§6Lernwillig");
		ArrayList<String> xpLore = new ArrayList<String>();
		xpLore.add("§aDu wirst sehr Lernwillig,");
		xpLore.add("§awo durch du doppelte Erfahrung");
		xpLore.add("§aaus allen Quellen erhälst!");
		xpLore.add("");
		xpLore.add("§7Du kannst immer nur eine Fähigkeit");
		xpLore.add("§7aktiviert haben!");
		xpMeta.setLore(xpLore);
		xp.setItemMeta(xpMeta);
		
		ItemStack ninja = new ItemStack(Material.MAGMA_CREAM);
		ItemMeta ninjaMeta = ninja.getItemMeta();
		ninjaMeta.setDisplayName("§6Chamäleon");
		ArrayList<String> ninjaLore = new ArrayList<String>();
		ninjaLore.add("§aDu lernst dich der Natur perfekt");
		ninjaLore.add("§aanzupassen, wodurch du nahe zu");
		ninjaLore.add("§aunsichtbar wirst, wenn du schleichst!");
		ninjaLore.add("");
		ninjaLore.add("§7Du kannst immer nur eine Fähigkeit");
		ninjaLore.add("§7aktiviert haben!");
		ninjaMeta.setLore(ninjaLore);
		ninja.setItemMeta(ninjaMeta);
		
		ItemStack Tank = new ItemStack(Material.SHIELD);
		ItemMeta TankMeta = Tank.getItemMeta();
		TankMeta.setDisplayName("§6Einstecker");
		ArrayList<String> TankLore = new ArrayList<String>();
		TankLore.add("§aDu hast gelernt, mit kleinen");
		TankLore.add("§aVerletzungen um zu gehen,");
		TankLore.add("§awo durch du weniger Schaden");
		TankLore.add("§aerhälst, wenn du oft hinter einander");
		TankLore.add("§ageschlagen wirst!");
		TankLore.add("");
		TankLore.add("§7Du kannst immer nur eine Fähigkeit");
		TankLore.add("§7aktiviert haben!");
		TankMeta.setLore(TankLore);
		Tank.setItemMeta(TankMeta);
		
		ItemStack undead = new ItemStack(Material.SKULL_ITEM, 1, (short) 0);
		ItemMeta undeadmeta = undead.getItemMeta();
		ArrayList<String> undeadLore = new ArrayList<String>();
		undeadLore.add("§aNach dem du eigentlich Stribst, erwachst du als");
		undeadLore.add("§amächtiger §6Untoter§a wieder!");
		undeadLore.add("§aDu wirst mit der Zeit schwächer, bis");
		undeadLore.add("§adu letztendlich nach einer Minute §cstirbst!");
	    undeadLore.add("");
		undeadLore.add("§7Du kannst immer nur eine Fähigkeit");
		undeadLore.add("§7aktiviert haben!");
		undeadmeta.setDisplayName("§6Untoter");
		undeadmeta.setLore(undeadLore);
		undead.setItemMeta(undeadmeta);
		
		ItemStack berserker = new ItemStack(Material.INK_SACK, 1, (short) 1);
		ItemMeta berserkerMeta = berserker.getItemMeta();
		ArrayList<String> berserkerLore = new ArrayList<String>();
		berserkerLore.add("§aUm so weniger Leben du hast,");
		berserkerLore.add("§aUm so wütender wirst du, wo durch");
		berserkerLore.add("§adu mehr Schaden austeilst!");
		berserkerLore.add("§7Du kannst immer nur eine Fähigkeit");
		berserkerLore.add("");
		berserkerLore.add("§7aktiviert haben!");
		berserkerMeta.setDisplayName("§6Berserker");
		berserkerMeta.setLore(berserkerLore);
		berserker.setItemMeta(berserkerMeta);
		
		ItemStack assasin = new ItemStack(Material.MAGMA);
		ItemMeta assasinMeta = assasin.getItemMeta();
		ArrayList<String> assasinLore = new ArrayList<String>();
		assasinLore.add("§aDu wirst zum §6Höllenmeister§a, wodurch");
		assasinLore.add("§aDu permanent keinen Fallschaden sowie");
		assasinLore.add("§akeinen Schaden durch lava oder Feuer");
		assasinLore.add("§aerhalten wirst!");
		assasinLore.add("");
		assasinLore.add("§7Du kannst immer nur eine Fähigkeit");
		assasinLore.add("§7aktiviert haben!");
		assasinMeta.setLore(assasinLore);
		assasinMeta.setDisplayName("§6Höllenmeister");
		assasin.setItemMeta(assasinMeta);
		
		
		
		
		
		
		inv.setItem(0, Hunger);
		inv.setItem(1, xp);
		inv.setItem(2, ninja);
		inv.setItem(3, Tank);
		inv.setItem(4, undead);
		inv.setItem(5, berserker);
		inv.setItem(6, assasin);
		inv.setItem(7, Glass);
		inv.setItem(8, Glass);
		if(p.hasPermission("main.user")) {
		p.playSound(p.getLocation(), Sound.BLOCK_ENDERCHEST_OPEN, 3, 2);
		p.openInventory(inv);
		}
		else {
			p.sendMessage(Main.prefix + "§cDu musst erst das Tutorial machen!");
			p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
		 }
		
		
		try {
			cfg.save(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return true;
		
	}



	
}
