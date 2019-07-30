package de.cedric.test.commands;


import java.util.HashMap;

import org.bukkit.Bukkit;

import org.bukkit.Sound;

import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import de.cedric.test.main.Main;

 public class TpaAcceptCommand {
   

   
    public static HashMap<Player, BukkitTask> countdownx6;
   
    static {
        countdownx6 = new HashMap<>();
    }
   
    Player p;
    private int count;
    Player p2;
  
    public TpaAcceptCommand(Player p)
    {
        this.p = p;
        this.count = 5;
        this.p2 = Main.tpa.get(p);
    }
   
    public void start() {
       
        if(countdownx6.containsKey(p2)) {
            return;
        }
       
        BukkitTask task = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
           
            public void run() {
               if(count != 0) {
                p2.sendMessage(Main.prefix +"§aDu wirst in§c " + count + " §asekunden teleportiert!");
        		p2.playSound(p.getLocation(), Sound.BLOCK_WOODEN_TRAPDOOR_OPEN, 3, 2);
            }
                if(count == 0) {
                   
   
                   
                    p2.teleport(p.getLocation());
                    p.sendMessage(Main.prefix +"§aTeleport war erfolgreich!");
					p.playSound(p.getLocation(),Sound.ENTITY_ENDERMEN_TELEPORT, 3, 2);
                   
                    countdownx6.get(p2).cancel();
                    countdownx6.remove(p2);
                    Main.tpa.remove(p2);
                   
                } count--;
               
               
            }
            }, 0, 20);
       
       
        countdownx6.put(this.p2, task);
       
    }
   
    public void stop() {
        if(!countdownx6.containsKey(p)) {
            return;
        }
       
        countdownx6.get(this.p).cancel();
		p.sendMessage(Main.prefix +"§cTeleportvorgang abgebrochen!");
		p.playSound(p.getLocation(), Sound.ENTITY_ELDER_GUARDIAN_CURSE, 3, 2);
        countdownx6.remove(this.p);
    }
   
       
   

}