package CharacterHandler;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public abstract class Character implements Player {

	public static File file = new File("plugins/Core", "Experience.yml");
	public static FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
	
	
	
	private static void saveCfg(File file) {
		try {
			cfg.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static int getAttackLevel(Player p) {
		if(cfg.getString(p.getName() + ".Attack") == null) {
			setAttackLevel(p, 1);
		}
		int attackLevel = cfg.getInt(p.getName() + ".AttackLevel");
		return attackLevel;
	}
	
	public static void addAttackLevel(Player p, double i) {
		cfg.set(p.getName() + ".AttackLevel", (getAttackLevel( p) + i));
		saveCfg(file);
		saveCfg(file);
		return;
	}
	
	public static void setAttackLevel(Player p, double i) {
		cfg.set(p.getName() + ".AttackLevel", i);
		saveCfg(file);
		return;
	}
	
	public static int getAttackExperience(Player p) {
		int attackXp = cfg.getInt(p.getName() + ".AttackXp");
		return attackXp;
	}
	
	public static void addAttackExperience(Player p, double i) {
		cfg.set(p.getName() + ".AttackXp", (getAttackExperience(p) + i));
		saveCfg(file);
		return;
	}
	
	public static void setAttackExperience(Player p, double i) {
		cfg.set(p.getName() + ".AttackXp", i);
		saveCfg(file);
		return;
	}

}
