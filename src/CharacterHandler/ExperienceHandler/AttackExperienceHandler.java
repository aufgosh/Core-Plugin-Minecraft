package CharacterHandler.ExperienceHandler;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import CharacterHandler.Character;


public class AttackExperienceHandler implements Listener {
	
	@EventHandler
	public void onDmg(EntityDamageByEntityEvent e) {

		if (e.getDamager() instanceof Player) {

			Player p = (Player) e.getDamager();
			
			int xpdrop = (int) (e.getFinalDamage() * 2);
			Character.addAttackExperience(p, xpdrop);
			
			
		}


	}

}
