package de.cedric.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import de.cedric.test.main.Main;


public class HealCommand implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (sender instanceof Player) {
		Player p = (Player) sender;
		if(p.hasPermission("main.heal")) {
		if(args.length == 0) {
			if(p.hasPermission("main.heal")) {
			
		p.setHealth(p.getHealthScale());
		p.setFoodLevel(20);
		p.sendMessage("§aDu wurdest erfolgreich geheilt!");
			} else
				p.sendMessage(Main.error);
		
	}else if(args.length == 1) {
		Player target = Bukkit.getPlayer(args[0]);
		if(target != null) {
			if(p.hasPermission("main.heal")) {
				
			
			target.setHealth(target.getHealthScale());
			target.setFoodLevel(20);
			target.sendMessage("§aDu wurdest von �c" + p.getName() + "§a voll geheilt!");
			p.sendMessage("§aDu hast �c" + target.getName() +  "§a erfolgreich geheilt!");
			} else
				p.sendMessage(Main.error);
			
		} else {
			p.sendMessage("§cDer angegebene Spieler ist nicht online!");
		}
		
	} else {
		p.sendMessage(Main.syntax);
	}

		}
}
		return false;
	}
}
