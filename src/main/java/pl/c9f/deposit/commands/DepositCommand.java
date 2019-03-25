package pl.c9f.deposit.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.command.defaults.BukkitCommand;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;
import pl.c9f.deposit.Main;
import pl.c9f.deposit.inventories.DepositInventory;
import pl.c9f.deposit.objects.User;
import pl.c9f.deposit.utils.ColorUtil;

public class DepositCommand extends BukkitCommand{

	private final Main plugin;

	public DepositCommand(String name, Main plugin) {
		super(name);
		this.plugin = plugin;
		((CraftServer) this.plugin.getServer()).getCommandMap().register(name, this);
	}

	@Override
	public boolean execute(CommandSender sender, String arg1, String[] args) {
		if(!(sender instanceof Player)) {
			sender.sendMessage("Musisz byc graczem!");
			return true;
		}
		final Player player = (Player) sender;
		final User user = this.plugin.getUserManager().getUser(player.getName());
		if (user == null) {
			player.sendMessage(ColorUtil.fixColor("&cWystapil blad podczas wykonywania komendy!"));
			return true;
		}
		final DepositInventory inventory = new DepositInventory(this.plugin, user);
		inventory.open(player);
		return false;
	}
}
