package listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import de.cedric.test.commands.PerkCommand;

public class Stealth implements Listener{
	
	@EventHandler

	public void onShift(PlayerToggleSneakEvent e){
		Player p = e.getPlayer();
		
	
	if(PerkCommand.cfg2.contains(p.getName())) {

	if(e.isSneaking()){

	e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 99999, 1));

	}else{

	e.getPlayer().removePotionEffect(PotionEffectType.INVISIBILITY);

	}
	}
	}
}
	


