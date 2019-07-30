package listener;



import org.bukkit.Bukkit;
import org.bukkit.Material;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.meta.ItemMeta;



public class Recipes {
	
	public void registerRecipes() {
		
		ItemStack TNT = new ItemStack(Material.TNT);
		ItemMeta TNTMeta = TNT.getItemMeta();
		TNT.setItemMeta(TNTMeta);
		ShapedRecipe TNTRecipe = new ShapedRecipe(TNT);
		TNTRecipe.shape("RRR", "RGR", "RRR");
		TNTRecipe.setIngredient('R', Material.REDSTONE);
		//TNTRecipe.setIngredient('G', Material.GUNPOWDER);
		
		Bukkit.addRecipe(TNTRecipe);
		
		
		ItemStack Emeraldsword = new ItemStack (Material.DIAMOND_SWORD);
		ItemMeta EmeraldswordMeta = Emeraldsword.getItemMeta();
		EmeraldswordMeta.setDisplayName("Emerald Sword");
		EmeraldswordMeta.addEnchant(Enchantment.DAMAGE_ALL, 2, true);
		Emeraldsword.setItemMeta(EmeraldswordMeta);
		ShapedRecipe EmeraldswordRecipe = new ShapedRecipe(Emeraldsword);
		EmeraldswordRecipe.shape("xEx","xEx","xSx");
	    EmeraldswordRecipe.setIngredient('E',Material.EMERALD);
		EmeraldswordRecipe.setIngredient('S',Material.STICK);
			
		Bukkit.addRecipe(EmeraldswordRecipe);
		
		ItemStack Crafted_Obsidian = new ItemStack (Material.OBSIDIAN, 8);
		ItemMeta Crafted_ObsidianMeta = Crafted_Obsidian.getItemMeta();
		Crafted_ObsidianMeta.setDisplayName("񗉵Crafted Obsidian");
		Crafted_Obsidian.setItemMeta(Crafted_ObsidianMeta);
		ShapedRecipe Crafted_ObsidianRecipe = new ShapedRecipe(Crafted_Obsidian);
		Crafted_ObsidianRecipe.shape("EEE","EXE","EEE");
		Crafted_ObsidianRecipe.setIngredient('E',Material.COBBLESTONE);
	    Crafted_ObsidianRecipe.setIngredient('X',Material.DIAMOND);
		
		Bukkit.addRecipe(Crafted_ObsidianRecipe);
		
		//ItemStack Wood_Pickaxe = new ItemStack (Material.WOODEN_PICKAXE);
		//Wood_Pickaxe.setItemMeta(Wood_PickaxeMeta);
		//ShapedRecipe Wood_PickaxeRecipe = new ShapedRecipe(Wood_Pickaxe);
	//	Wood_PickaxeRecipe.shape("WWW","xSx","xSx");
		//Wood_PickaxeRecipe.setIngredient('W', Material.OAK_PLANKS);
	//	Wood_PickaxeRecipe.setIngredient('S', Material.STICK);
		
	//	Bukkit.addRecipe(Wood_PickaxeRecipe);
		
		ItemStack Stone_Pickaxe = new ItemStack (Material.STONE_PICKAXE);
		ItemMeta Stone_PickaxeMeta = Stone_Pickaxe.getItemMeta();
		Stone_PickaxeMeta.setDisplayName("Stone Pickaxe");
		Stone_PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		Stone_Pickaxe.setItemMeta(Stone_PickaxeMeta);
		ShapedRecipe Stone_PickaxeRecipe = new ShapedRecipe(Stone_Pickaxe);
		Stone_PickaxeRecipe.shape("WWW","xSx","xSx");
		Stone_PickaxeRecipe.setIngredient('W', Material.COBBLESTONE);
		Stone_PickaxeRecipe.setIngredient('S', Material.STICK);
		
		Bukkit.addRecipe(Stone_PickaxeRecipe);
		
		ItemStack Iron_Pickaxe = new ItemStack (Material.IRON_PICKAXE);
		ItemMeta Iron_PickaxeMeta = Iron_Pickaxe.getItemMeta();
		Iron_PickaxeMeta.setDisplayName("Iron Pickaxe");
		Iron_PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		Iron_Pickaxe.setItemMeta(Iron_PickaxeMeta);
		ShapedRecipe Iron_PickaxeRecipe = new ShapedRecipe(Iron_Pickaxe);
		Iron_PickaxeRecipe.shape("WWW","xSx","xSx");
		Iron_PickaxeRecipe.setIngredient('W', Material.IRON_INGOT);
		Iron_PickaxeRecipe.setIngredient('S', Material.STICK);
		
		Bukkit.addRecipe(Iron_PickaxeRecipe);
		
		//ItemStack Gold_Pickaxe = new ItemStack (Material.GOLDEN_PICKAXE);
		//ItemMeta Gold_PickaxeMeta = Gold_Pickaxe.getItemMeta();
		//Gold_PickaxeMeta.setDisplayName("Iron Pickaxe");
		//Gold_PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		//Gold_Pickaxe.setItemMeta(Gold_PickaxeMeta);
		//ShapedRecipe Gold_PickaxeRecipe = new ShapedRecipe(Gold_Pickaxe);
		//Gold_PickaxeRecipe.shape("WWW","xSx","xSx");
		//Gold_PickaxeRecipe.setIngredient('W', Material.GOLD_INGOT);
		//Gold_PickaxeRecipe.setIngredient('S', Material.STICK);
		
		//Bukkit.addRecipe(Gold_PickaxeRecipe);
		
		ItemStack Diamond_Pickaxe = new ItemStack (Material.DIAMOND_PICKAXE);
		ItemMeta Diamond_PickaxeMeta = Diamond_Pickaxe.getItemMeta();
		Diamond_PickaxeMeta.setDisplayName("Diamond Pickaxe");
		Diamond_PickaxeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		Diamond_Pickaxe.setItemMeta(Diamond_PickaxeMeta);
		ShapedRecipe Diamond_PickaxeRecipe = new ShapedRecipe(Diamond_Pickaxe);
		Diamond_PickaxeRecipe.shape("WWW","xSx","xSx");
		Diamond_PickaxeRecipe.setIngredient('W', Material.DIAMOND);
		Diamond_PickaxeRecipe.setIngredient('S', Material.STICK);
		
		Bukkit.addRecipe(Diamond_PickaxeRecipe);
		
		
		//ItemStack Wood_axe = new ItemStack (Material.WOODEN_AXE);
		//ItemMeta Wood_axeMeta = Wood_axe.getItemMeta();
		//Wood_axeMeta.setDisplayName("Wooden Axe");
		//Wood_axeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		//Wood_axe.setItemMeta(Wood_axeMeta);
		//ShapedRecipe Wood_axeRecipe = new ShapedRecipe(Wood_axe);
		//Wood_axeRecipe.shape("WWx","WSx","xSx");
		//Wood_axeRecipe.setIngredient('W', Material.OAK_PLANKS);
		//Wood_axeRecipe.setIngredient('S', Material.STICK);
		
		//Bukkit.addRecipe(Wood_axeRecipe);
		
		
		ItemStack Stone_axe = new ItemStack (Material.STONE_AXE);
		ItemMeta Stone_axeMeta = Stone_axe.getItemMeta();
		Stone_axeMeta.setDisplayName("Stone Axe");
		Stone_axeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		Stone_axe.setItemMeta(Stone_axeMeta);
		ShapedRecipe Stone_axeRecipe = new ShapedRecipe(Stone_axe);
		Stone_axeRecipe.shape("WWx","WSx","xSx");
		Stone_axeRecipe.setIngredient('W', Material.COBBLESTONE);
		Stone_axeRecipe.setIngredient('S', Material.STICK);
		
		Bukkit.addRecipe(Stone_axeRecipe);
		
		ItemStack Iron_axe = new ItemStack (Material.IRON_AXE);
		ItemMeta Iron_axeMeta = Iron_axe.getItemMeta();
		Iron_axeMeta.setDisplayName("Iron Axe");
		Iron_axeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		Iron_axe.setItemMeta(Iron_axeMeta);
		ShapedRecipe Iron_axeRecipe = new ShapedRecipe(Iron_axe);
		Iron_axeRecipe.shape("WWx","WSx","xSx");
		Iron_axeRecipe.setIngredient('W', Material.IRON_INGOT);
		Iron_axeRecipe.setIngredient('S', Material.STICK);
		
		Bukkit.addRecipe(Iron_axeRecipe);
		
		//ItemStack GOLDEN_axe = new ItemStack (Material.GOLDEN_AXE);
		//ItemMeta GOLDEN_axeMeta = GOLDEN_axe.getItemMeta();
		//GOLDEN_axeMeta.setDisplayName("Golden Axe");
		//GOLDEN_axeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		//GOLDEN_axe.setItemMeta(GOLDEN_axeMeta);
		//ShapedRecipe GOLDEN_axeRecipe = new ShapedRecipe(GOLDEN_axe);
		//////GOLDEN_axeRecipe.setIngredient('S', Material.STICK);
		
		//Bukkit.addRecipe(GOLDEN_axeRecipe);

		ItemStack DIAMOND_axe = new ItemStack (Material.DIAMOND_AXE);
		ItemMeta DIAMOND_axeMeta = DIAMOND_axe.getItemMeta();
		DIAMOND_axeMeta.setDisplayName("Diamond Axe");
		DIAMOND_axeMeta.addEnchant(Enchantment.DIG_SPEED, 3, true);
		DIAMOND_axe.setItemMeta(DIAMOND_axeMeta);
		ShapedRecipe DIAMOND_axeRecipe = new ShapedRecipe(DIAMOND_axe);
		DIAMOND_axeRecipe.shape("WWx","WSx","xSx");
		DIAMOND_axeRecipe.setIngredient('W', Material.DIAMOND);
		DIAMOND_axeRecipe.setIngredient('S', Material.STICK);
		
		Bukkit.addRecipe(DIAMOND_axeRecipe);
		
		
				
	} 

}
