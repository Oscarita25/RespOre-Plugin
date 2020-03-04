package oscar.respawnore;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import oscar.respawnore.cmds.Heal;
import oscar.respawnore.events.OreRegen;

public class Main  extends JavaPlugin{

    FileConfiguration config = getConfig();
    List<String> regblocks = new ArrayList<String>();
    
	
	@Override
	public void onEnable() {
		try {Config.setdefaults();} catch (IOException e) {e.printStackTrace();}
		registerCmds();
		registerEvents();
	}
	
	@Override
	public void onDisable() {}
	
	

	
	
	public void registerCmds() {this.getCommand("heal").setExecutor(new Heal(this));}
	
	public void registerEvents() {getServer().getPluginManager().registerEvents(new OreRegen(this), this);}
	
	

}
