package oscar.respawnore.events;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.Plugin;

import oscar.respawnore.Config;

public class OreRegen implements Listener {

    
    public static Plugin plugin;
    
    public OreRegen(Plugin plugin) {
    	this.plugin = plugin;
    }
    
	
	@EventHandler
	public void onBlockBreakEvent(BlockBreakEvent e)  {
				
		
			
		for(String s : Config.getBlocks()) {
			if (e.getBlock().getType() == Material.getMaterial(s)) {
			
				if(e.getPlayer().getGameMode() == GameMode.CREATIVE && !Config.getCreative()) return;
				
				final Block block = e.getBlock();
				final Material material = block.getType(); 
			
				Bukkit.getScheduler().runTaskLater(plugin, new Runnable( ) {@Override public void run() {block.setType(material);}}, 3*20L);
				
			}
		}
	}
	
}
