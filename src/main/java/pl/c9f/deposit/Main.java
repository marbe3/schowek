package pl.c9f.deposit;

import org.bukkit.plugin.java.JavaPlugin;
import pl.c9f.deposit.commands.DepositCommand;
import pl.c9f.deposit.inventories.DepositInventory;
import pl.c9f.deposit.listeners.InventoryClickListener;
import pl.c9f.deposit.listeners.PlayerJoinListener;
import pl.c9f.deposit.managers.DatabaseManager;
import pl.c9f.deposit.managers.UserManager;
import pl.c9f.deposit.managers.impl.DatabaseManagerImpl;
import pl.c9f.deposit.managers.impl.UserManagerImpl;
import pl.c9f.deposit.storage.Settings;
import pl.c9f.deposit.tasks.CheckTask;

public class Main extends JavaPlugin {

	private Settings settings;
	private DatabaseManager databaseManager;
	private UserManager userManager;

	public Settings getSettings() {
		return settings;
	}

	public DatabaseManager getDatabaseManager() {
		return databaseManager;
	}

	public UserManager getUserManager() {
		return userManager;
	}

	@Override
	public void onEnable(){
		this.databaseManager = new DatabaseManagerImpl(this);
		this.userManager = new UserManagerImpl(this);
	    this.settings = new Settings(this);
	    this.settings.load();
	    this.databaseManager.connect();
	    this.databaseManager.executeUpdate("CREATE TABLE IF NOT EXISTS `deposit_users` (`name` varchar(32) NOT NULL PRIMARY KEY, `applesOne` int(11) NOT NULL, `applesTwo` int(11) NOT NULL, `pearls` int(11) NOT NULL, `arrows` int(11) NOT NULL);");
	    this.userManager.loadUsers();
		new DepositCommand("schowek", this);
		new PlayerJoinListener(this);
		new InventoryClickListener(this);
		new CheckTask(this);
	}
}