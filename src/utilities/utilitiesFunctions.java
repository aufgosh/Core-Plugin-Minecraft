package utilities;

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
		p.sendMessage(Main.prefix +"§a/spawn, /sethome, /home");
		p.sendMessage(Main.prefix +"§a/tpa, /tpaccept (player), /ping");
		p.sendMessage(Main.prefix +"§a/tutorial, /shop, /vote");
		p.sendMessage(Main.prefix +"§a/passive");
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
	

}
