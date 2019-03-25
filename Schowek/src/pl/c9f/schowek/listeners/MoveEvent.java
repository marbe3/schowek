package pl.c9f.schowek.listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.inventory.ItemStack;

import pl.c9f.schowek.Main;
import pl.c9f.schowek.managers.User;
import pl.c9f.schowek.managers.UserManager;

public class MoveEvent implements Listener {
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Koxy(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location from = e.getFrom();
		Location to = e.getTo();
		if((from.getBlockX() != to.getBlockX()) || (from.getBlockY() != to.getBlockY()) || (from.getBlockZ() != to.getBlockZ())){
			ItemStack[] inv = p.getInventory().getContents();
			int cuantity = 0;
			for (int i = 0; i < inv.length; i++) {
				if ((inv[i] != null) && (inv[i].getData().getData() == 1) && (inv[i].getData().getItemType().equals(Material.GOLDEN_APPLE))){
					int cant = inv[i].getAmount();
					cuantity += cant;
				}
		    }
			int amount = cuantity;
			if (amount > Main.getPlugin().getConfig().getInt("koxy-limit")){
				int usun = amount - Main.getPlugin().getConfig().getInt("koxy-limit");
				ItemStack remove = new ItemStack(Material.GOLDEN_APPLE, 1, (short)1);
				remove.setAmount(usun);
				p.getInventory().removeItem(new ItemStack[] { remove });
				User u = UserManager.getUser(p.getName());
				u.setKoxy(u.getKoxy() + usun);
				return;
			}	
		} 
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Refy(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location from = e.getFrom();
		Location to = e.getTo();
		if((from.getBlockX() != to.getBlockX()) || (from.getBlockY() != to.getBlockY()) || (from.getBlockZ() != to.getBlockZ())){
			ItemStack[] inv = p.getInventory().getContents();
			int cuantity = 0;
			for (int i = 0; i < inv.length; i++) {
				if ((inv[i] != null) && (inv[i].getData().getData() == 0) && (inv[i].getData().getItemType().equals(Material.GOLDEN_APPLE))){
					int cant = inv[i].getAmount();
					cuantity += cant;
				}
		    }
			int amount = cuantity;
			if (amount > Main.getPlugin().getConfig().getInt("refy-limit")){
				int usun = amount - Main.getPlugin().getConfig().getInt("refy-limit");
				ItemStack remove = new ItemStack(Material.GOLDEN_APPLE, 1, (short)0);
				remove.setAmount(usun);
				p.getInventory().removeItem(new ItemStack[] { remove });
				User u = UserManager.getUser(p.getName());
				u.setRefy(u.getRefy() + usun);
				return;
			}	
		} 
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Perly(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location from = e.getFrom();
		Location to = e.getTo();
		if((from.getBlockX() != to.getBlockX()) || (from.getBlockY() != to.getBlockY()) || (from.getBlockZ() != to.getBlockZ())){
			ItemStack[] inv = p.getInventory().getContents();
			int cuantity = 0;
			for (int i = 0; i < inv.length; i++) {
				if ((inv[i] != null) && (inv[i].getData().getData() == 0) && (inv[i].getData().getItemType().equals(Material.ENDER_PEARL))){
					int cant = inv[i].getAmount();
					cuantity += cant;
				}
		    }
			int amount = cuantity;
			if (amount > Main.getPlugin().getConfig().getInt("perly-limit")){
				int usun = amount - Main.getPlugin().getConfig().getInt("perly-limit");
				ItemStack remove = new ItemStack(Material.ENDER_PEARL, 1, (short)0);
				remove.setAmount(usun);
				p.getInventory().removeItem(new ItemStack[] { remove });
				User u = UserManager.getUser(p.getName());
				u.setPerly(u.getPerly() + usun);
				return;
			}	
		} 
	}
	@SuppressWarnings("deprecation")
	@EventHandler
	public void Strzaly(PlayerMoveEvent e){
		Player p = e.getPlayer();
		Location from = e.getFrom();
		Location to = e.getTo();
		if((from.getBlockX() != to.getBlockX()) || (from.getBlockY() != to.getBlockY()) || (from.getBlockZ() != to.getBlockZ())){
			ItemStack[] inv = p.getInventory().getContents();
			int cuantity = 0;
			for (int i = 0; i < inv.length; i++) {
				if ((inv[i] != null) && (inv[i].getData().getData() == 0) && (inv[i].getData().getItemType().equals(Material.ARROW))){
					int cant = inv[i].getAmount();
					cuantity += cant;
				}
		    }
			int amount = cuantity;
			if (amount > Main.getPlugin().getConfig().getInt("strzaly-limit")){
				int usun = amount - Main.getPlugin().getConfig().getInt("strzaly-limit");
				ItemStack remove = new ItemStack(Material.ARROW, 1, (short)0);
				remove.setAmount(usun);
				p.getInventory().removeItem(new ItemStack[] { remove });
				User u = UserManager.getUser(p.getName());
				u.setStrzaly(u.getStrzaly() + usun);
				return;
			}	
		} 
	}
}
