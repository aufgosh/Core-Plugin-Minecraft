package de.cedric.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;

import de.cedric.test.main.Main;
import net.minecraft.core.particles.Particles;
import net.minecraft.network.protocol.game.PacketPlayOutWorldParticles;
import utilities.utilitiesFunctions;

public class eventCommand implements CommandExecutor {
	
	public static void enderDragonKillBroadcast(Player killer) {
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			//Get our firework
			utilitiesFunctions.spawnParticleRingAroundPlayer(p, 0.1, Particle.REDSTONE, Particle.REDSTONE, Color.PURPLE, Color.FUCHSIA);
			Location loc = p.getLocation();
			
			double xcord = loc.getX();
			double ycord = loc.getY() + 4;
			double zcord = loc.getZ();
			
			Location test = new Location(p.getWorld(), xcord, ycord, zcord);
			
			
	        Firework fw = (Firework) p.getWorld().spawnEntity(test , EntityType.FIREWORK);
	        FireworkMeta fireworkMeta = fw.getFireworkMeta();

	        //Start builder
	        FireworkEffect.Builder builder = FireworkEffect.builder();
	       
	        //Colors
	        builder.withColor(Color.PURPLE);
	        builder.withColor(Color.FUCHSIA);

	        //Sparkly af
	        builder.withFlicker();

	        //Faded
	        builder.withFade(Color.SILVER);

	        //Boom chaca-laca
	        builder.with(FireworkEffect.Type.BURST);

	        //Trailing behind
	        builder.trail(true);

	        //Get dat effect
	        FireworkEffect effect = builder.build();

	        //Then apply the effect to the meta
	        fireworkMeta.addEffect(effect);

	        //Set it's power cause swag
	        fireworkMeta.setPower(0);

	        //Then apply this to our rocket
	        fw.setFireworkMeta(fireworkMeta);
	        //Make it go boom
	        fw.detonate();
		
	        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 3, 2);
	        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_DEATH, 3, 2);
	        p.giveExp(1500);
	}
		
		Bukkit.broadcastMessage(Main.prefix + "§dSpieler §e" + killer.getName() + "§d hat den§5 ENDERDRACHEN§d besiegt§c!");
		Bukkit.broadcastMessage(Main.prefix + "§dJeder Spieler wurde mit erfahrung belohnt§c.");
	}
	public static void wardenKillBroadcast(Player killer) {
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			//Get our firework
			utilitiesFunctions.spawnParticleRingAroundPlayer(p, 0.1, Particle.REDSTONE, Particle.REDSTONE, Color.BLUE, Color.AQUA);
			Location loc = p.getLocation();
			
			double xcord = loc.getX();
			double ycord = loc.getY() + 4;
			double zcord = loc.getZ();
			
			Location test = new Location(p.getWorld(), xcord, ycord, zcord);
			
			
	        Firework fw = (Firework) p.getWorld().spawnEntity(test , EntityType.FIREWORK);
	        FireworkMeta fireworkMeta = fw.getFireworkMeta();

	        //Start builder
	        FireworkEffect.Builder builder = FireworkEffect.builder();
	       
	        //Colors
	        builder.withColor(Color.BLUE);
	        builder.withColor(Color.AQUA);

	        //Sparkly af
	        builder.withFlicker();

	        //Faded
	        builder.withFade(Color.SILVER);

	        //Boom chaca-laca
	        builder.with(FireworkEffect.Type.BURST);

	        //Trailing behind
	        builder.trail(true);

	        //Get dat effect
	        FireworkEffect effect = builder.build();

	        //Then apply the effect to the meta
	        fireworkMeta.addEffect(effect);

	        //Set it's power cause swag
	        fireworkMeta.setPower(0);

	        //Then apply this to our rocket
	        fw.setFireworkMeta(fireworkMeta);
	        //Make it go boom
	        fw.detonate();
		
	        p.playSound(p.getLocation(), Sound.ENTITY_WARDEN_HURT, 3, 2);
	        p.playSound(p.getLocation(), Sound.ENTITY_WARDEN_DEATH, 3, 2);
	        p.giveExp(1500);
	}
		
		Bukkit.broadcastMessage(Main.prefix + "§dSpieler §e" + killer.getName() + "§d hat den§9 WARDEN§d besiegt§c!");
		Bukkit.broadcastMessage(Main.prefix + "§dJeder Spieler wurde mit erfahrung belohnt§c.");
	}
	
	public static void witherKillBroadcast(Player killer) {
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			
			utilitiesFunctions.spawnParticleRingAroundPlayer(p, 0.1, Particle.REDSTONE, Particle.REDSTONE, Color.BLACK, Color.GRAY);
			//Get our firework
			
			Location loc = p.getLocation();
			
			double xcord = loc.getX();
			double ycord = loc.getY() + 4;
			double zcord = loc.getZ();
			
			Location test = new Location(p.getWorld(), xcord, ycord, zcord);
			
			
	        Firework fw = (Firework) p.getWorld().spawnEntity(test , EntityType.FIREWORK);
	        FireworkMeta fireworkMeta = fw.getFireworkMeta();

	        //Start builder
	        FireworkEffect.Builder builder = FireworkEffect.builder();
	       
	        //Colors
	        builder.withColor(Color.BLACK);
	        builder.withColor(Color.GRAY);

	        //Sparkly af
	        builder.withFlicker();

	        //Faded
	        builder.withFade(Color.SILVER);

	        //Boom chaca-laca
	        builder.with(FireworkEffect.Type.BURST);

	        //Trailing behind
	        builder.trail(true);

	        //Get dat effect
	        FireworkEffect effect = builder.build();

	        //Then apply the effect to the meta
	        fireworkMeta.addEffect(effect);

	        //Set it's power cause swag
	        fireworkMeta.setPower(0);

	        //Then apply this to our rocket
	        fw.setFireworkMeta(fireworkMeta);
	        //Make it go boom
	        fw.detonate();
		
	        p.playSound(p.getLocation(), Sound.ENTITY_WITHER_SHOOT, 3, 2);
	        p.playSound(p.getLocation(), Sound.ENTITY_WITHER_DEATH, 3, 2);
	        p.giveExp(1500);
	}
		
		Bukkit.broadcastMessage(Main.prefix + "§dSpieler §e" + killer.getName() + "§d hat den§8 WITHER§d besiegt§c!");
		Bukkit.broadcastMessage(Main.prefix + "§dJeder Spieler wurde mit erfahrung belohnt§c.");
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		
		
		
		for (Player p : Bukkit.getOnlinePlayers()) {
			
			utilitiesFunctions.spawnParticleRingAroundPlayer(p, 0.1, Particle.REDSTONE, Particle.REDSTONE, Color.BLACK, Color.SILVER);
			
			Location loc = p.getLocation();

			
			//Get our firework
			double xcord = loc.getX();
			double ycord = loc.getY() + 4;
			double zcord = loc.getZ();
			
			Location test = new Location(p.getWorld(), xcord, ycord, zcord);
			
			
	        Firework fw = (Firework) p.getWorld().spawnEntity(test , EntityType.FIREWORK);
	        FireworkMeta fireworkMeta = fw.getFireworkMeta();

	        //Start builder
	        FireworkEffect.Builder builder = FireworkEffect.builder();
	       
	        //Colors
	        builder.withColor(Color.BLACK);
	        builder.withColor(Color.SILVER);

	        //Sparkly af
	        builder.withFlicker();

	        //Faded
	        builder.withFade(Color.SILVER);

	        //Boom chaca-laca
	        builder.with(FireworkEffect.Type.BURST);

	        //Trailing behind
	        builder.trail(true);

	        //Get dat effect
	        FireworkEffect effect = builder.build();

	        //Then apply the effect to the meta
	        fireworkMeta.addEffect(effect);

	        //Set it's power cause swag
	        fireworkMeta.setPower(0);

	        //Then apply this to our rocket
	        fw.setFireworkMeta(fireworkMeta);
	        //Make it go boom
	        fw.detonate();
			
		}
		
		return false;
	}


}
