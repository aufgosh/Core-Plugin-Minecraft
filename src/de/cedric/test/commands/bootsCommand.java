package de.cedric.test.commands;

import java.util.ArrayList;
import java.util.UUID;
import java.util.jar.Attributes;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import de.cedric.test.main.Main;

public class bootsCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		
		if(args[0].equalsIgnoreCase("Love")){
			
			ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
			// from Color:
			leatherArmorMeta.setColor(Color.RED);
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			meta.setDisplayName("§7Boots of §cLove");
			lore.add("");
			lore.add("§7Wear this item to display");
			lore.add("§7your §clove§7.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(leatherArmorMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("Thunder")){
			
			ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
			// from Color:
			leatherArmorMeta.setColor(Color.fromRGB(254,254,63));
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			meta.setDisplayName("§7Boots of §eThunder");
			lore.add("");
			lore.add("§7Wear this item to showcase");
			lore.add("§7mighty §eThunder§7.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(leatherArmorMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("Nature")){
			
			ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
			// from Color:
			leatherArmorMeta.setColor(Color.LIME);
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			meta.setDisplayName("§7Boots of §aNature");
			lore.add("");
			lore.add("§7Wear this item to showcase");
			lore.add("§7your love to §aNature§7.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(leatherArmorMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("Smoke")){
			
			ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
			// from Color:
			leatherArmorMeta.setColor(Color.GRAY);
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			meta.setDisplayName("§7Boots of §8Smoke");
			lore.add("");
			lore.add("§7Wear this item to showcase");
			lore.add("§7how §8smoky§7 you are.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(leatherArmorMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("Water")){
			
			ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
			// from Color:
			leatherArmorMeta.setColor(Color.AQUA);
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			meta.setDisplayName("§7Boots of §bWater");
			lore.add("");
			lore.add("§7These Boots seem to be §bwet§7...");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(leatherArmorMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("Sword")){
			
		    ItemStack item = new ItemStack(Material.LEATHER_HELMET);
		    ArrayList<String> itemLore = new ArrayList<String>();
			ItemMeta itemMeta = item.getItemMeta();
			itemMeta.setDisplayName("�dSeltener Schl�ssel");
			itemLore.add("�6Ein Schl�ssel womit du eine");
			itemLore.add("�6seltene Belohnungskiste �ffnen kannst!");
			itemLore.add("�6Gebe dazu �c/Belohnung�6 ein.");
			itemMeta.setLore(itemLore);
			AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
			itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifier);
			item.setAmount(1);
			
			item.setItemMeta(itemMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("ender_helm")){
			
			ItemStack item = new ItemStack(Material.LEATHER_HELMET);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
			
			
			AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
			meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
			AttributeModifier modifierarmor = new AttributeModifier(UUID.randomUUID(), "generic.armorTOUGHNESS", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
			meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifierarmor);
			
			AttributeModifier modifierhead = new AttributeModifier(UUID.randomUUID(), "generic.knockbackResistance", 0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
			meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifierhead);
			
			meta.setUnbreakable(true);
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			
			leatherArmorMeta.setColor(Color.fromRGB(204,0,250));
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName("§eEnder Helm");
			meta.setCustomModelData(1);
			lore.add("");
			lore.add("§7A magic Netherite Helmet infused with");
			lore.add("§7the power of §eEnder§7.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(leatherArmorMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("ender_chest")){
			
			ItemStack item = new ItemStack(Material.LEATHER_CHESTPLATE);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
			
			
			AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 9, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
			meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
			AttributeModifier modifierarmor = new AttributeModifier(UUID.randomUUID(), "generic.armorTOUGHNESS", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
			meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifierarmor);
			
			AttributeModifier modifierhead = new AttributeModifier(UUID.randomUUID(), "generic.knockbackResistance", 0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.CHEST);
			meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifierhead);
			
			meta.setUnbreakable(true);
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			
			leatherArmorMeta.setColor(Color.fromRGB(204,0,250));
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName("§eEnder Chestplate");
			meta.setCustomModelData(1);
			lore.add("");
			lore.add("§7A magic Netherite Chestplate infused with");
			lore.add("§7the power of §eEnder§7.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(leatherArmorMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("ender_legs")){
			
			ItemStack item = new ItemStack(Material.LEATHER_LEGGINGS);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
			
			
			AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 7, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
			meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
			AttributeModifier modifierarmor = new AttributeModifier(UUID.randomUUID(), "generic.armorTOUGHNESS", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
			meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifierarmor);
			
			AttributeModifier modifierhead = new AttributeModifier(UUID.randomUUID(), "generic.knockbackResistance", 0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.LEGS);
			meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifierhead);
			
			meta.setUnbreakable(true);
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			
			leatherArmorMeta.setColor(Color.fromRGB(204,0,250));
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName("§eEnder Leggings");
			meta.setCustomModelData(1);
			lore.add("");
			lore.add("§7A magic pair of Netherite Leggings infused");
			lore.add("§7with the power of §eEnder§7.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(leatherArmorMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("ender_boots")){
			
			ItemStack item = new ItemStack(Material.LEATHER_BOOTS);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) meta;
			
			
			AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
			meta.addAttributeModifier(Attribute.GENERIC_ARMOR, modifier);
			AttributeModifier modifierarmor = new AttributeModifier(UUID.randomUUID(), "generic.armorTOUGHNESS", 4, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
			meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, modifierarmor);
			
			AttributeModifier modifierhead = new AttributeModifier(UUID.randomUUID(), "generic.knockbackResistance", 0.2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.FEET);
			meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, modifierhead);
			
			meta.setUnbreakable(true);
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			
			leatherArmorMeta.setColor(Color.fromRGB(204,0,250));
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName("§eEnder Boots");
			meta.setCustomModelData(1);
			lore.add("");
			lore.add("§7A magic pair of Netherite Boots infused");
			lore.add("§7with the power of §eEnder§7.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(leatherArmorMeta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("ender_sword")){
			
			ItemStack item = new ItemStack(Material.NETHERITE_SWORD);
			ItemMeta meta = item.hasItemMeta() ? item.getItemMeta() : Bukkit.getItemFactory().getItemMeta(item.getType());
			
			
			AttributeModifier modifier = new AttributeModifier(UUID.randomUUID(), "generic.attackDamage", 10, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
			meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, modifier);
			AttributeModifier modifierarmor = new AttributeModifier(UUID.randomUUID(), "generic.attackSpeed", 2, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
			meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, modifierarmor);
			
			
			meta.setUnbreakable(true);
			meta.addItemFlags(ItemFlag.HIDE_DYE);
			
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName("§eEnder Sword");
			meta.setCustomModelData(1);
			lore.add("");
			lore.add("§7A magic Netherite Sword infused");
			lore.add("§7with the power of §eEnder§7.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(meta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		if(args[0].equalsIgnoreCase("key_boots")){
			
			ItemStack item = new ItemStack(Material.FEATHER);
			ItemMeta meta = item.getItemMeta();
			
		    ArrayList<String> lore = new ArrayList<String>();
			meta.setDisplayName("§dBoots Crate §7Key");
			meta.setCustomModelData(1010);
			lore.add("");
			lore.add("§eA Key used to open the §dBoots Crate§7.");
			meta.setLore(lore);
			item.setAmount(1);
			
			item.setItemMeta(meta);
			
			p.getPlayer().getInventory().addItem(item);
			
		}
		
		return false;
	}

}
