package oscar.respawnore;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Config {
	
    public static Plugin plugin;
    public static final String[] defaultBlocks = {"COAL_ORE","IRON_ORE","LAPIS_ORE","GOLD_ORE","REDSTONE_ORE","DIAMOND_ORE","EMERALD_ORE"};

	
	public void Config(JavaPlugin plugin) {
		this.plugin = plugin;
	}

	public static List<String> blocks = new ArrayList<String>();
	
	public static File ConfigFile = new File("plugins/respawnore","config.yml");
	
	public static FileConfiguration Config = YamlConfiguration.loadConfiguration(ConfigFile);
	
	public static void save() throws IOException{Config.save(ConfigFile);}
	
	public static void setdefaults() throws IOException{
		if(getBlocks().isEmpty()) {
			for(String s : defaultBlocks) {
				addBlocks(s);
			}
			setCreative(true);
		}
		
	}
		
	
	public static void setCreative(Boolean bool) throws IOException {
		Config.set("MineInCreative", bool);
		save();
	}
	
	public static void setBlocks(List<String> blocklist) throws IOException {
		Config.set("blocks", blocklist);
		save();
	}
	
	public static void addBlocks(String Blockname) throws IOException {
		blocks.add(Blockname);
		Config.set("blocks", blocks) ;
		save();
	}
	
	public static List<String> getBlocks() {
		blocks = Config.getStringList("blocks");
		return Config.getStringList("blocks");
	}
	
	public static Boolean getCreative() {
		return Config.getBoolean("MineInCreative");
	}
}
