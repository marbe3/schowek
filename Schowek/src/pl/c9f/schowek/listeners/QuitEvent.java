package pl.c9f.schowek.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import pl.c9f.schowek.managers.User;
import pl.c9f.schowek.managers.UserManager;

public class QuitEvent implements Listener{
	@EventHandler
	public void OnQuit(PlayerQuitEvent e) {
		Player p = (Player) e.getPlayer();	
		if (UserManager.getUser(p.getName()) != null) {
			UserManager.removeUser(new User(p.getName()));
		}
		UserManager.SaveUser(p.getName());
	}

}
