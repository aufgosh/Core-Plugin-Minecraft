package CharacterHandler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class FishingSpot {
	
	public static ArrayList<ArmorStand> armors = new ArrayList<ArmorStand>();
	
	
	 static File file = new File("plugins/Core", "fishingSpots.yml");
	 static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	private  int id;
	private static  int level;
	private static String fish;
	
	private static Location spotLoc;
	
	private  static String world;
	private  static double x;
	private  static double y;
	private  static double z;
	
	public void setId(int id) {
		this.id = (id + 1);
	}
	
	public int getId() {
		return id;
	}
	
	public static void returnList(Player p) {
		
		for(int i = 0; i < (returnCurrentID() + 1); i++) {
			if(cfg.getInt(i + ".level") != 0) {
				
				//ArmorStand ar = armors.get(i);
				//ar.remove();
				//armors.remove(i);
				
				FishingSpot fishingSpot = getFishingSpot(i);
				fishingSpot.setLevel(cfg.getInt(i + ".level"));
				p.sendMessage("Required fishing level: " + fishingSpot.getLevel() + fishingSpot.getWorld());
				
				Location armorLoc =  fishingSpot.getLocation(fishingSpot);
				
				ArmorStand armorstand;
				armorstand = (ArmorStand) Bukkit.getWorld(fishingSpot.getWorld()).spawnEntity(armorLoc, EntityType.ARMOR_STAND);
			    armorstand.setPersistent(false);
			    
			    armorstand.setHealth(1);
			    armorstand.setGravity(false);
			    armorstand.setInvisible(true);
			    armorstand.setCustomName("§9Fishingspot");
			    armorstand.setCustomNameVisible(true);
			}
		}
	}
	
	public static int returnCurrentID() {
		int x = cfg.getInt("ID" + ".id") + 1;
		try {
			cfg.save(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		return x;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}
	public int getLevel() {
		return level;
	}
	
	public void setFish(String fish) {
		this.fish = fish;
	}
	
	public void setWorld(String world) {
		this.world = world;
	}
	
	public String getWorld() {
		return world;
	}
	
	public void setX(double x) {
		this.x = x;
	}
	
	public Double getX() {
		return x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	public Double getY() {
		return y;
	}
	
	public void setZ(double z) {
		this.z = z;
	}
	
	public Double getZ() {
		return z;
	}
	
	public Location getLocation(FishingSpot fishingSpot) {
		Location spotLoc = new Location(Bukkit.getServer().getWorld(fishingSpot.getWorld()), fishingSpot.getX(), fishingSpot.getY(), fishingSpot.getZ());
		return spotLoc;
	}
	
	public static FishingSpot getFishingSpot(int id) {
		level = cfg.getInt(id + ".level");
		fish = cfg.getString(id + ".fish");
		world = cfg.getString(id + ".world");
		x = cfg.getDouble(id + ".x");
		y =cfg.getDouble(id + ".y") + 3;
		z = cfg.getDouble(id + ".z");
		
		FishingSpot fishingSpot = new FishingSpot();
		fishingSpot.setId(id);
		fishingSpot.setLevel(level);
		fishingSpot.setFish(fish);
		fishingSpot.setWorld(world);
		fishingSpot.setX(x);
		fishingSpot.setY(y);
		fishingSpot.setZ(z);
		
		return fishingSpot;
	}
	
	public void setFishingSpot(int id) {
		cfg.set("ID" + ".id", cfg.getInt("ID" + ".id") + 1);
		try {
			cfg.save(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
		cfg.set(id + ".level", level);
		cfg.set(id + ".fish", fish);
		cfg.set(id + ".world", world);
		cfg.set(id + ".x", x);
		cfg.set(id + ".y", y);
		cfg.set(id + ".z", z);
		try {
			cfg.save(file);
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
