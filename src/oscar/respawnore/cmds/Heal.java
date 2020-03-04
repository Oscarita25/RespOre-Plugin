package oscar.respawnore.cmds;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import oscar.respawnore.Main;

public class Heal implements CommandExecutor {
	
	static Main plugin;
	public Heal (Main main) {
		plugin = main;
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if ( label.equalsIgnoreCase("heal")) {
			if (sender.hasPermission("heal.use")) {
				if (args.length == 0) {
					if(sender instanceof Player) {
						Player p = (Player) sender;
						if(p.getHealth() == 20.0) {
							p.sendMessage(ChatColor.RED + "You already have full health");
							return true;
						}
						p.setHealth(20.0);
						p.sendMessage(ChatColor.BLUE + "You have been healed! hooray");
						return true;
					}
					sender.sendMessage(ChatColor.DARK_RED + "Try /heal <username>");
					return true;
				}
				if(args.length >= 1) {
					if (Bukkit.getPlayerExact(args[0]) != null) {
						Player target = Bukkit.getPlayer(args[0]);
						target.setHealth(20.0);
						target.sendMessage(ChatColor.BLUE + "You have been healed! hooray");
						sender.sendMessage(ChatColor.AQUA + "You healed "+ target.getName());
						return true;
						
					}
					sender.sendMessage(ChatColor.DARK_RED + "Player not found");
					return true;
				}
			}
			sender.sendMessage(ChatColor.DARK_RED + "Player not found");
			return true;
		}
		return false;
	}

}
