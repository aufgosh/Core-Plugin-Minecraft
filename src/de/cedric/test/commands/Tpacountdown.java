package de.cedric.test.commands;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitTask;

import de.cedric.test.main.Main;

public class Tpacountdown {
   

   
    public static HashMap<Player, BukkitTask> countdownx3;
   
    static {
        countdownx3 = new HashMap<>();
    }
   
    private Player p;
    private int count;
    Player p2;
  
    public Tpacountdown(Player p)
    {
        this.p = p;
        this.count = 60;
        this.p2 = Main.tpa.get(p);
    }
   
    public void start() {
       
        if(countdownx3.containsKey(p2)) {
            return;
        }
       
        BukkitTask task5 = Bukkit.getScheduler().runTaskTimer(Main.getPlugin(), new Runnable() {
           
            public void run() {
              
                if(count == 0) {
                   
   
                   
                    p2.sendMessage(Main.prefix + "§cDie Teleportanfrage ist abgelaufen!");
                    p.sendMessage(Main.prefix + "§cDie Teleportanfrage ist abgelaufen!");
                    
                    


                    Main.tpa.remove(p2);
                } count--;
               
               
            }
            }, 0, 20);
       
       
        countdownx3.put(this.p2, task5);
       
    }
   
    public void stop() {
        if(!countdownx3.containsKey(p)) {
            return;
        }
       
        countdownx3.get(this.p).cancel();
        countdownx3.remove(this.p);
    }
   
       
   

}