package pl.c9f.deposit.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import pl.c9f.deposit.Main;

public class PlayerJoinListener implements Listener {

    private final Main plugin;

    public PlayerJoinListener(Main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (this.plugin.getUserManager().getUser(event.getPlayer().getName()) == null) this.plugin.getUserManager().createUser(event.getPlayer().getName());
    }
}
