package de.cedric.test.commands;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class messageCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		Player t = Bukkit.getPlayer(args[0]);
		
		StringBuilder builder = new StringBuilder();
		for (int i = 1; i < args.length; i++) {
		    builder.append(args[i]).append(" ");
		}
		String msg = builder.toString();
		
		p.sendMessage("§8[§c->§8]§a an §e"+t.getName()+"§7: §f" + msg);
		p.playSound(p.getLocation(),Sound.ENTITY_PUFFER_FISH_BLOW_OUT, 3, 2);
		
		t.sendMessage("§8[§a->§8]§a von §e"+p.getName()+"§7: §f" + msg);
		t.playSound(t.getLocation(),Sound.ENTITY_PUFFER_FISH_BLOW_UP, 3, 2);
		
		return false;
	}

}
