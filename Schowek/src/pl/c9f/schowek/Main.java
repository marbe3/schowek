package pl.c9f.schowek;

import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import pl.c9f.schowek.cmds.player.SchowekCmd;
import pl.c9f.schowek.data.Config;
import pl.c9f.schowek.listeners.GuiClickEvent;
import pl.c9f.schowek.listeners.JoinEvent;
import pl.c9f.schowek.listeners.MoveEvent;
import pl.c9f.schowek.listeners.QuitEvent;
import pl.c9f.schowek.managers.User;
import pl.c9f.schowek.managers.UserManager;

public class Main extends JavaPlugin{
	private static Main plugin;  
	public static Main getPlugin(){
		return plugin;
	}  
	public void onEnable(){
		plugin = this;
	    saveDefaultConfig();
		((CraftServer) this.getServer()).getCommandMap().register("schowek", new SchowekCmd("schowek"));
		Bukkit.getPluginManager().registerEvents(new GuiClickEvent(), this);
		Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
		Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
		Bukkit.getPluginManager().registerEvents(new MoveEvent(), this);
	    Config.registerConfig("schowek", "schowek.yml", this);
	    Config.loadAll();
	    for (Player p : Bukkit.getOnlinePlayers()) {
	    	UserManager.DownloadUser(p.getName());
	    }
	}
	public void onDisable(){
        for (Player p : Bukkit.getOnlinePlayers()) {
        	UserManager.SaveUser(p.getName());
        }    
    }
	public void onLoad(){
		for (Player p : Bukkit.getOnlinePlayers()) {
			if (UserManager.getUser(p.getName()) == null) {
				UserManager.addUser(new User(p.getName()));		
			}
		}

	}
}