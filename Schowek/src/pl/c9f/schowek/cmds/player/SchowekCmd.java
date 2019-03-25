package pl.c9f.schowek.cmds.player;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.entity.Player;

import pl.c9f.schowek.inventories.SchowekInv;

public class SchowekCmd extends BukkitCommand{

	public SchowekCmd(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean execute(CommandSender sender, String arg1, String[] args) {
		if(!(sender instanceof Player)) {
			return true;
		}
		Player p = (Player) sender;
		SchowekInv.schowekgui(p);
		return false;
	}
}
