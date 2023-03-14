package utilities;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

import de.cedric.test.main.Main;

public class utilitiesFunctions {
	
	//Plays Bad Sound and sends Error message
	public static void sendError(Player p) {
		p.sendMessage(Main.error);	
		p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
	}
	
	//Sends Player a Textwall of help
	public static void sendHelpMessage(Player p) {
		p.sendMessage(" ");
		p.sendMessage("§8=============================");
		p.sendMessage("");
		p.sendMessage(Main.prefix +"§a/spawn§7, §a/sethome§7, §a/home§7,");
		p.sendMessage(Main.prefix +"§a/tpa§7, §a/tpaccept (player)§7, §a/ping§7,");
		p.sendMessage(Main.prefix +"§a/tutorial§7, §a/shop§7, §a/vote§7,");
		p.sendMessage(Main.prefix +"§a/passive§7, §a/msg§7, §a/enderchest");
		p.sendMessage("");
		p.sendMessage("§8=============================");
		p.sendMessage(" ");
		p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 3, 2);
	}
	
	//Sends 200 Lines of empty messages to clear chat
	public static void clearPlayerChat(Player p) {
		int rows = 200;
		for (int i = 0; i < rows; i++) {
			p.sendMessage(" ");
		}
	}
	
public static void spawnParticleRingAroundPlayer(Player p, double yoffset, Particle particle1, Particle particle2, Color color1, Color color2) {
	Location location = p.getLocation();
	int size = 1;
    for (int d = 0; d <= 90; d += 1) {
        Location particleLoc = new Location(location.getWorld(), location.getX(), (location.getY()+yoffset), location.getZ());
        particleLoc.setX(location.getX() + Math.cos(d) * size);
        particleLoc.setZ(location.getZ() + Math.sin(d) * size);
        location.getWorld().spawnParticle(particle1, particleLoc, 1, new Particle.DustOptions(color1, 2));
        location.getWorld().spawnParticle(particle2, particleLoc, 1, new Particle.DustOptions(color2, 2));
    }
}
	

}
