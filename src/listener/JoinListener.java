package listener;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerCommandSendEvent;
import org.bukkit.event.player.PlayerExpChangeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.help.HelpTopic;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;


import de.cedric.test.commands.PerkCommand;
import de.cedric.test.commands.ReSpawn;
import de.cedric.test.commands.Spawn;

import de.cedric.test.commands.TpaAcceptCommand;
import de.cedric.test.commands.TutorialSpawn;
import de.cedric.test.commands.Tutorialexec;
import de.cedric.test.commands.newHome;
import de.cedric.test.main.Main;
import utilities.checkForBan;
import utilities.utilitiesFunctions;





public class JoinListener implements Listener {
	
	File file = new File("plugins/Test", "homes.yml");
	FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	
	private void resetCooldown(Player p) {
		p.getAttribute(Attribute.GENERIC_ATTACK_SPEED).setBaseValue(100D);
	}
	
	
	@EventHandler
	public void command(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		String msg = e.getMessage();
		
		//if(msg.equalsIgnoreCase("/pl") || msg.equals("/plugins") || msg.equalsIgnoreCase("/bukkit:pl") || msg.equalsIgnoreCase("/bukkit:plugins")) {
		
			//p.sendMessage(Main.error);	
		//	e.setCancelled(true);
	//	}
		
		if(msg.equalsIgnoreCase("/ver") || msg.equalsIgnoreCase("/version") || msg.equalsIgnoreCase("/bukkit:ver") || msg.equalsIgnoreCase("/bukkit:version")) {
			p.sendMessage(Main.error);	
			e.setCancelled(true);
		}
		if(msg.equalsIgnoreCase("/?") || msg.equalsIgnoreCase("/hilfe") || msg.equalsIgnoreCase("/help") || msg.equalsIgnoreCase("/minecraft:help") || msg.equalsIgnoreCase("/bukkit:?") || msg.equalsIgnoreCase("/bukkit:help") ) {
			e.setCancelled(true);
			utilitiesFunctions.sendHelpMessage(p);
		}
		}

	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e) {
		
		Player p = e.getPlayer();
		
		checkForBan.banCheck(p);
		
		e.setJoinMessage("§8[§a+§8] " + p.getName());

		utilitiesFunctions.clearPlayerChat(p);
		utilitiesFunctions.sendHelpMessage(p);
		p.sendTitle("§aWelcome!", "", 15,15,15);
	

		if(!p.hasPlayedBefore()) {
			new TutorialSpawn(p).start();
		    ItemStack food = new ItemStack(Material.BREAD);
			ItemMeta testMeta = food.getItemMeta();
			food.setAmount(16);
			
			ItemStack shovel = new ItemStack(Material.GOLDEN_SHOVEL);
			ItemMeta shovelmeta = shovel.getItemMeta();
			
			food.setItemMeta(testMeta);
			p.getPlayer().getInventory().addItem(food, shovel);
		}
	}
	
	
	
	@EventHandler
	public void onPlayerTab(PlayerCommandSendEvent e) {
		List<String> blockedCommands = new ArrayList<>();
		
		Player p = e.getPlayer();
		
		if((!p.hasPermission("main.admin"))) {
		
		blockedCommands.add("gamemode");
		blockedCommands.add("pl");
		blockedCommands.add("plugins");
		blockedCommands.add("boots");
		blockedCommands.add("belohnung");
		blockedCommands.add("freischalten");
		blockedCommands.add("aasdooqppaspdyymncxasdjaslde");
		blockedCommands.add("aosdohjkouppiahopdsbnfreelasdouasd");
		e.getCommands().removeAll(blockedCommands);
	}
	}
	
	@EventHandler
	public void regen(EntityRegainHealthEvent e) {
		if(!(e.getEntity() instanceof Player)) { return; }
		Entity en = e.getEntity();
		
		Player p = (Player) en;
		
		if(PerkCommand.cfg5.contains(p.getName())) {
			
			 if (p.getPlayer().getHealth() < 7) {
				p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 2));
			
			 
			 }if(p.getPlayer().getHealth() < 12) {
				p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 1));
			}if (p.getPlayer().getHealth() < 14) {
				p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 0));
			}
		
		}
		
		if(PerkCommand.cfg6.contains(p.getName())) {
			
			if(p.getPlayer().getHealth() < 20) {
				p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 4));
			}if (p.getPlayer().getHealth() < 21) {
				p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 4));
			}
		
		}
		
	}
	
	@EventHandler
	public void on(PlayerRespawnEvent e) {
		
		Player p = e.getPlayer();
		if(PerkCommand.cfg5.contains(p.getName())) {
			p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
			p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 0));
		}
		if(PerkCommand.cfg6.contains(p.getName())) {
			p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
			p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 4));
			
		}
		new BukkitRunnable() {
		@Override
		public void run() {
			resetCooldown(p);
		}
		}.runTaskLater(Main.getPlugin(), 20);
		}
	
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		e.setQuitMessage("§8[§c-§8] " + p.getName());
		new newHome(p).stop();
		new Spawn(p).stop();
		new TpaAcceptCommand(p).stop();
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {
	e.setDeathMessage("");
	}
	
	@EventHandler
	public void onMove(PlayerMoveEvent e) {
		if(e.getFrom().getBlockX() !=e.getTo().getBlockX() || e.getFrom().getBlockY() != e.getTo().getBlockY()|| e.getFrom().getBlockZ() !=e.getTo().getBlockZ()) {
			
			new Spawn(e.getPlayer()).stop();
			new newHome(e.getPlayer()).stop();
			new TpaAcceptCommand(e.getPlayer()).stop();
			new Tutorialexec(e.getPlayer()).stop();
			
			

		           
	        }

			
		}
	
	@EventHandler
	public void onUnknown(PlayerCommandPreprocessEvent e) {
		if(!(e.isCancelled())) {
		Player p = e.getPlayer();
		String msg = e.getMessage().split(" ") [0];
		HelpTopic topic = Bukkit.getServer().getHelpMap().getHelpTopic(msg);
		if(topic == null) {
			p.sendMessage(Main.prefix + "§cDieser Command existiert nicht!");
			p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
			e.setCancelled(true);
		}
		}
		}
		
	
	
	@EventHandler
	public void onDmg(EntityDamageEvent e) {
		
		if(!(e.getEntity() instanceof Player)) { return; }
		Player p= (Player) e.getEntity();
		
		if(e.getEntityType() == EntityType.PLAYER) {
			new Spawn((Player) e.getEntity()).stop();
			new newHome((Player) e.getEntity()).stop();
			new Tutorialexec((Player)e.getEntity()).stop();
			new TpaAcceptCommand((Player) e.getEntity()).stop();
		}
		if(PerkCommand.cfg6.contains(p.getName())) {
			if(e.getCause() == DamageCause.FALL) {
				e.setCancelled(true);
					
					if(p.getPlayer().getHealth() < 20) {
						p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 4));
					}if (p.getPlayer().getHealth() < 21) {
						p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
						p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 4));
					
				
				}
			}
			
			}
		
		
		
		
			if(PerkCommand.cfg3.contains(p.getName())) {

				

				p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 65, 1));

				}
			if(PerkCommand.cfg5.contains(p.getName())) {
				
				 if (p.getPlayer().getHealth() < 7) {
					p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 2));
				
				 
				 } else if(p.getPlayer().getHealth() < 12) {
					p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 1));
				} else if (p.getPlayer().getHealth() == 14) {
					p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 0));
				}
			
			}

				
			
		}
	
	
	
	@EventHandler
	public void on(InventoryClickEvent e) {
		
		Inventory open = e.getClickedInventory();
		ItemStack item = e.getCurrentItem();
		Player p = (Player) e.getWhoClicked();
		
		if(e.getView().getTitle().contains("§cBelohnungen")) {
			e.setCancelled(true);
			
			if (open == null) {
				return;
			}
			
			if (item == null || !item.hasItemMeta()) {
				return;
			}
			
                if(item.getItemMeta().getDisplayName().equals("§dGewöhnliche Kiste")) {
				
				
			    ItemStack test = new ItemStack(Material.TRIPWIRE_HOOK);
			    ArrayList<String> testLore = new ArrayList<String>();
				ItemMeta testMeta = test.getItemMeta();
				testMeta.setDisplayName("§dGewöhnlicher Schlüssel");
				testLore.add("§6Ein Schlüssel womit du eine");
				testLore.add("§6gew§hnliche Belohnungskiste §ffnen kannst!");
				testLore.add("§6Gebe dazu §c/Belohnung§6 ein.");
				testMeta.setLore(testLore);
				test.setAmount(1);
				
				test.setItemMeta(testMeta);
				
				ItemStack diamond = new ItemStack(Material.DIAMOND);
				ItemMeta diamondMeta = diamond.getItemMeta();
				diamond.setAmount(3);
				diamond.setItemMeta(diamondMeta);
				
				ItemStack Iron = new ItemStack(Material.IRON_INGOT);
				ItemMeta IronMeta = Iron.getItemMeta();
				Iron.setAmount(10);
				Iron.setItemMeta(IronMeta);
				
				ItemStack xp = new ItemStack(Material.EXPERIENCE_BOTTLE);
				ItemMeta xpMeta = xp.getItemMeta();
				xp.setAmount(16);
				xp.setItemMeta(xpMeta);
				
				
				

				
				if (p.getInventory().containsAtLeast(test, 1)) {
				p.getInventory().removeItem(test);
				p.getInventory().addItem(diamond);
				p.getInventory().addItem(Iron);
				p.getInventory().addItem(xp);
				p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
			      }else {
				     p.sendMessage(Main.prefix + "§cDu hast keinen passenden Schlüssel!");
				     p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
			         }
			         }
                
                if(item.getItemMeta().getDisplayName().equals("§dSeltene Kiste")) {
    				
    				
    			    ItemStack test = new ItemStack(Material.TRIPWIRE_HOOK);
    			    ArrayList<String> testLore = new ArrayList<String>();
    				ItemMeta testMeta = test.getItemMeta();
    				testMeta.setDisplayName("§dSeltener Schlüssel");
    				testLore.add("§6Ein Schlüssel womit du eine");
    				testLore.add("§6seltene Belohnungskiste öffnen kannst!");
    				testLore.add("§6Gebe dazu §c/Belohnung§6 ein.");
    				testMeta.setLore(testLore);
    				test.setAmount(1);
    				
    				test.setItemMeta(testMeta);
    				
    				ItemStack diamond = new ItemStack(Material.DIAMOND);
    				ItemMeta diamondMeta = diamond.getItemMeta();
    				diamond.setAmount(6);
    				diamond.setItemMeta(diamondMeta);
    				
    				ItemStack Iron = new ItemStack(Material.IRON_INGOT);
    				ItemMeta IronMeta = Iron.getItemMeta();
    				Iron.setAmount(32);
    				Iron.setItemMeta(IronMeta);
    				
    				ItemStack xp = new ItemStack(Material.EXPERIENCE_BOTTLE);
    				ItemMeta xpMeta = xp.getItemMeta();
    				xp.setAmount(40);
    				xp.setItemMeta(xpMeta);
    				
    				
    				

    				
    				if (p.getInventory().containsAtLeast(test, 1)) {
    				p.getInventory().removeItem(test);
    				p.getInventory().addItem(diamond);
    				p.getInventory().addItem(Iron);
    				p.getInventory().addItem(xp);
    				p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
    			}else {
    				p.sendMessage(Main.prefix + "§cDu hast keinen passenden Schlüssel!");
    				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
    			}
    			}
                
                if(item.getItemMeta().getDisplayName().equals("§dEpische Kiste")) {
    				
    				
    			    ItemStack test = new ItemStack(Material.TRIPWIRE_HOOK);
    			    ArrayList<String> testLore = new ArrayList<String>();
    				ItemMeta testMeta = test.getItemMeta();
    				testMeta.setDisplayName("§dEpischer Schlüssel");
    				testLore.add("§6Ein Schlüssel womit du eine");
    				testLore.add("§6epische Belohnungskiste öffnen kannst!");
    				testLore.add("§6Gebe dazu §c/Belohnung§6 ein.");
    				testMeta.setLore(testLore);
    				test.setAmount(1);
    				
    				test.setItemMeta(testMeta);
    				
    				ItemStack diamond = new ItemStack(Material.DIAMOND_BLOCK);
    				ItemMeta diamondMeta = diamond.getItemMeta();
    				diamond.setAmount(1);
    				diamond.setItemMeta(diamondMeta);
    				
    				ItemStack Iron = new ItemStack(Material.IRON_BLOCK);
    				ItemMeta IronMeta = Iron.getItemMeta();
    				Iron.setAmount(7);
    				Iron.setItemMeta(IronMeta);
    				
    				ItemStack xp = new ItemStack(Material.EXPERIENCE_BOTTLE);
    				ItemMeta xpMeta = xp.getItemMeta();
    				xp.setAmount(64);
    				xp.setItemMeta(xpMeta);
    				
    				
    				

    				
    				if (p.getInventory().containsAtLeast(test, 1)) {
    				p.getInventory().removeItem(test);
    				p.getInventory().addItem(diamond);
    				p.getInventory().addItem(Iron);
    				p.getInventory().addItem(xp);
    				p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
    			}else {
    				p.sendMessage(Main.prefix + "§cDu hast keinen passenden Schlüssel!");
    				p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
    			}
    			}



		}
		
		if(e.getView().getTitle().contains("§cPassive Spezialfähigkeiten")) {
			e.setCancelled(true);
		
		if (open == null) {
			return;
		}
		
		if (item == null || !item.hasItemMeta()) {
			return;
		}
		
			
		long jetzt = System.currentTimeMillis();
		
			
		  if(item.getItemMeta().getDisplayName().equals("§6Lernwillig")) {
				PerkCommand.cfg.set(p.getName(), 1);
				PerkCommand.cfg1.set(p.getName(), null);
				PerkCommand.cfg2.set(p.getName(), null);
				PerkCommand.cfg3.set(p.getName(), null);
				PerkCommand.cfg4.set(p.getName(), null);
				PerkCommand.cfg5.set(p.getName(), null);
				PerkCommand.cfg6.set(p.getName(), null);
				PerkCommand.cooldown.put(p.getName(), jetzt);
                p.setHealthScale(20);
                p.setMaxHealth(20);
				p.closeInventory();
				p.setAllowFlight(false);
				p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.sendMessage(Main.prefix + "§aDu hast die Fähigkeit §6Lernwillig§a erlernt!");
				p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
				try {
					PerkCommand.cfg.save(PerkCommand.file);
					PerkCommand.cfg1.save(PerkCommand.file1);
					PerkCommand.cfg2.save(PerkCommand.file2);
					PerkCommand.cfg3.save(PerkCommand.file3);
					PerkCommand.cfg4.save(PerkCommand.file4);
					PerkCommand.cfg5.save(PerkCommand.file5);
					PerkCommand.cfg6.save(PerkCommand.file6);
					PerkCommand.cfg5.set(p.getName(), null);
				} catch (IOException a) {

					a.printStackTrace();
				}
			}
			
			if(item.getItemMeta().getDisplayName().equals("§6Photosynthesist")) {
				PerkCommand.cfg1.set(p.getName(), 1); 
				PerkCommand.cfg.set(p.getName(), null);
				PerkCommand.cfg2.set(p.getName(), null);
				PerkCommand.cfg3.set(p.getName(), null);
				PerkCommand.cfg4.set(p.getName(), null);
				PerkCommand.cfg5.set(p.getName(), null);
				PerkCommand.cfg6.set(p.getName(), null);
				PerkCommand.cooldown.put(p.getName(), jetzt);
                p.setHealthScale(20);
                p.setMaxHealth(20);
				p.closeInventory();
				p.setAllowFlight(false);
				p.setFoodLevel(20);
				p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
				p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
				p.sendMessage(Main.prefix + "§aDu hast die Fähigkeit §6Photosynthesist§a erlernt!");
				p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
				try {
					PerkCommand.cfg.save(PerkCommand.file);
					PerkCommand.cfg1.save(PerkCommand.file1);
					PerkCommand.cfg2.save(PerkCommand.file2);
					PerkCommand.cfg3.save(PerkCommand.file3);
					PerkCommand.cfg4.save(PerkCommand.file4);
					PerkCommand.cfg5.save(PerkCommand.file5);
					PerkCommand.cfg6.save(PerkCommand.file6);
					
				} catch (IOException a) {

					a.printStackTrace();
				}
			}
			
			  if(item.getItemMeta().getDisplayName().equals("§6Chamäleon")) {
					PerkCommand.cfg.set(p.getName(), null);
					PerkCommand.cfg1.set(p.getName(), null);
					PerkCommand.cfg2.set(p.getName(), 1);
					PerkCommand.cfg3.set(p.getName(), null);
					PerkCommand.cfg4.set(p.getName(), null);
					PerkCommand.cfg5.set(p.getName(), null);
					PerkCommand.cfg6.set(p.getName(), null);
					PerkCommand.cooldown.put(p.getName(), jetzt);
	                p.setHealthScale(20);
	                p.setMaxHealth(20);
					p.closeInventory();
					p.setAllowFlight(false);
					p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.sendMessage(Main.prefix + "§aDu hast die Fähigkeit §6Chamäleon§a erlernt!");
					p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
					try {
						PerkCommand.cfg.save(PerkCommand.file);
						PerkCommand.cfg1.save(PerkCommand.file1);
						PerkCommand.cfg2.save(PerkCommand.file2);
						PerkCommand.cfg3.save(PerkCommand.file3);
						PerkCommand.cfg4.save(PerkCommand.file4);
						PerkCommand.cfg5.save(PerkCommand.file5);
						PerkCommand.cfg6.save(PerkCommand.file6);
					} catch (IOException a) {

						a.printStackTrace();
					}
				}
			  
			  if(item.getItemMeta().getDisplayName().equals("§6Einstecker")) {
					PerkCommand.cfg.set(p.getName(), null);
					PerkCommand.cfg1.set(p.getName(), null);
					PerkCommand.cfg2.set(p.getName(), null);
					PerkCommand.cfg3.set(p.getName(), 1);
					PerkCommand.cfg4.set(p.getName(), null);
					PerkCommand.cfg5.set(p.getName(), null);
					PerkCommand.cfg6.set(p.getName(), null);
					PerkCommand.cooldown.put(p.getName(), jetzt);
	                p.setHealthScale(26);
	                p.setMaxHealth(26);
	                p.setAllowFlight(false);
					p.closeInventory();
					p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.sendMessage(Main.prefix + "§aDu hast die Fähigkeit §6Einstecker§a erlernt!");
					p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
					try {
						PerkCommand.cfg.save(PerkCommand.file);
						PerkCommand.cfg1.save(PerkCommand.file1);
						PerkCommand.cfg2.save(PerkCommand.file2);
						PerkCommand.cfg3.save(PerkCommand.file3);
						PerkCommand.cfg4.save(PerkCommand.file4);
						PerkCommand.cfg5.save(PerkCommand.file5);
						PerkCommand.cfg6.save(PerkCommand.file6);
					} catch (IOException a) {

						a.printStackTrace();
					}
				}
			  
			  if(item.getItemMeta().getDisplayName().equals("§6Untoter")) {
					PerkCommand.cfg.set(p.getName(), null);
					PerkCommand.cfg1.set(p.getName(), null);
					PerkCommand.cfg2.set(p.getName(), null);
					PerkCommand.cfg3.set(p.getName(), null);
					PerkCommand.cfg5.set(p.getName(), null);
					PerkCommand.cfg4.set(p.getName(), 1);
					PerkCommand.cfg6.set(p.getName(), null);
					PerkCommand.cooldown.put(p.getName(), jetzt);
	                p.setHealthScale(20);
	                p.setMaxHealth(20);
	                p.setAllowFlight(false);
					p.closeInventory();
					p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.sendMessage(Main.prefix + "§aDu hast die Fähigkeit §6Untoter§a erlernt!");
					p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
					try {
						PerkCommand.cfg.save(PerkCommand.file);
						PerkCommand.cfg1.save(PerkCommand.file1);
						PerkCommand.cfg2.save(PerkCommand.file2);
						PerkCommand.cfg3.save(PerkCommand.file3);
						PerkCommand.cfg4.save(PerkCommand.file4);
						PerkCommand.cfg5.save(PerkCommand.file5);
						PerkCommand.cfg6.save(PerkCommand.file6);
					} catch (IOException a) {

						a.printStackTrace();
					}
			  }
			  
			  if(item.getItemMeta().getDisplayName().equals("§6Berserker")) {
					PerkCommand.cfg.set(p.getName(), null);
					PerkCommand.cfg1.set(p.getName(), null);
					PerkCommand.cfg2.set(p.getName(), null);
					PerkCommand.cfg3.set(p.getName(), null);
					PerkCommand.cfg5.set(p.getName(), 1);
					PerkCommand.cfg4.set(p.getName(), null);
					PerkCommand.cfg6.set(p.getName(), null);
					PerkCommand.cooldown.put(p.getName(), jetzt);
					p.closeInventory();
					p.setAllowFlight(false);
					p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 9999999, 0));
					p.sendMessage(Main.prefix +"§aDu hast die Fähigkeit §6Berserker§a erlernt!");
					p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
					p.setMaxHealth(14);
					p.setHealthScale(14);
					try {
						PerkCommand.cfg.save(PerkCommand.file);
						PerkCommand.cfg1.save(PerkCommand.file1);
						PerkCommand.cfg2.save(PerkCommand.file2);
						PerkCommand.cfg3.save(PerkCommand.file3);
						PerkCommand.cfg4.save(PerkCommand.file4);
						PerkCommand.cfg5.save(PerkCommand.file5);
						PerkCommand.cfg6.save(PerkCommand.file6);
					} catch (IOException a) {

						a.printStackTrace();
					}
			  }
			  
			  if(item.getItemMeta().getDisplayName().equals("§6Höllenmeister")) {
					PerkCommand.cfg.set(p.getName(), null);
					PerkCommand.cfg1.set(p.getName(), null);
					PerkCommand.cfg2.set(p.getName(), null);
					PerkCommand.cfg3.set(p.getName(), null);
					PerkCommand.cfg4.set(p.getName(), null);
					PerkCommand.cfg5.set(p.getName(), null);
					PerkCommand.cfg6.set(p.getName(), 1);
					PerkCommand.cooldown.put(p.getName(), jetzt);
	                p.setHealthScale(20);
	                p.setMaxHealth(20);
					p.closeInventory();
					p.getPlayer().removePotionEffect(PotionEffectType.FIRE_RESISTANCE);
					p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 9999999, 4));
					p.getPlayer().removePotionEffect(PotionEffectType.INCREASE_DAMAGE);
					p.sendMessage(Main.prefix +"§aDu hast die Fähigkeit §6Höllenmeister§a erlernt!");
					p.playSound(p.getLocation(),Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
					try {
						PerkCommand.cfg.save(PerkCommand.file);
						PerkCommand.cfg1.save(PerkCommand.file1);
						PerkCommand.cfg2.save(PerkCommand.file2);
						PerkCommand.cfg3.save(PerkCommand.file3);
						PerkCommand.cfg4.save(PerkCommand.file4);
						PerkCommand.cfg5.save(PerkCommand.file5);
						PerkCommand.cfg6.save(PerkCommand.file6);
					} catch (IOException a) {

						a.printStackTrace();
					}
				}
			
		}
	}
	

	




	long jetzt = System.currentTimeMillis();
	

	

		

	           
        
			
		
	
	
	@EventHandler
	public void on(PlayerExpChangeEvent e) {
		Player p = e.getPlayer();
		
		if(PerkCommand.cfg.contains(p.getName())) {
			e.setAmount(e.getAmount()*2);
	           
        }
	}
	
	@EventHandler
	public void on(FoodLevelChangeEvent e) {
		Entity en = e.getEntity();
		
		Player p = (Player) en;
		
		if(PerkCommand.cfg1.contains(p.getName())) {
			e.setCancelled(true);
			
	           
        }
	}
	
	HashMap<String, ItemStack[]> inv = new HashMap<String, ItemStack[]>();
	    @EventHandler()
	    public void onRespawn(PlayerRespawnEvent e){
	        
	    
}
	    
	    public static HashMap<String, Long> cooldown1 = new HashMap<>();
	   
		@EventHandler
	    public void onDeath(PlayerDeathEvent event) {
			Entity en = event.getEntity();
			Player p = (Player) en;
			


			
         
			
			long jetzt = System.currentTimeMillis();
			
	    	if(PerkCommand.cfg4.contains(p.getName())) {
	    		  inv.put(p.getName(), p.getInventory().getContents());
	    		  
	    		  
	    		  
	    		if(cooldown1.containsKey(p.getName())) {
	    			long be = cooldown1.get(p.getName());
	    			int rest = (int) ((be + (30*1000*60)) - jetzt);
	    			
	    			if(rest > 0 ) {
	    				int minute = rest/1000/60;
	    				rest = rest-(minute*1000*60);
	    				int sekunde = rest/1000;
						p.setHealthScale(20);
						new ReSpawn(p).stop();
	    				
	    				p.sendMessage("§cDu kannst erst in§6 " +minute+(minute == 1 ? " Minute " : " Minuten ") + "§cund§6 "
	    				+sekunde+(sekunde == 1 ? " Sekunde " : " Sekunden " + "§cwieder als §6Untoter§c erwachen!"));
	    			}
	    			
	    		} else {
	        Location l = p.getLocation();
	        l.setY(l.getY() + 1);
  		  event.getDrops().clear();
  		  p.getInventory().clear();
  		  p.getInventory().setArmorContents(null);
	        
	        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), new Runnable() {
	            public void run() {
	            	p.sendMessage("§aDu bist als m§chtiger§6 Untoter§a wieder gespawnt!");
	    	        p.spigot().respawn();
	                p.teleport(l);
	                p.getWorld().strikeLightning(l);
	                p.setHealthScale(15);
	                p.setMaxHealth(15);
	                
	                
	                cooldown1.put(p.getName(), jetzt);
	                p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 100, 2));
	                p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 1200, 1));
	                p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1200, 1));
	                p.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 80, 0));
	                p.getInventory().setContents(inv.get(p.getName()));
	                new ReSpawn(p).start();
	             }
	            
	            
	            }, 12);
	    		}

	 	        
	 	    		
	    } }

	

	

}

