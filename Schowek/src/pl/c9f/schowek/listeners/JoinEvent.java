package pl.c9f.schowek.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import pl.c9f.schowek.managers.User;
import pl.c9f.schowek.managers.UserManager;

public class JoinEvent implements Listener{
	@EventHandler
	public void onJoin(PlayerJoinEvent e) {
		Player p = (Player) e.getPlayer();	
		if (UserManager.getUser(p.getName()) == null) {
			UserManager.addUser(new User(p.getName()));
		}
		UserManager.DownloadUser(p.getName());
	}
}
