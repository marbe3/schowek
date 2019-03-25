package pl.c9f.schowek.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import pl.c9f.schowek.Main;
import pl.c9f.schowek.inventories.SchowekInv;
import pl.c9f.schowek.managers.User;
import pl.c9f.schowek.managers.UserManager;
import pl.c9f.schowek.utils.ColorUtil;

public class GuiClickEvent implements Listener {
	@EventHandler
	public void onClick(InventoryClickEvent e){
	    Player p = (Player)e.getWhoClicked();
	    if (e.getCurrentItem() == null) {
	      return;
	    }
	    if (e.getCurrentItem().getType().equals(Material.AIR)) {
	      return;
	    }
	    if (e.getCurrentItem().getItemMeta() == null) {
	      return;
	    }
	    if (e.getCurrentItem().getItemMeta().getDisplayName() == null) {
	      return;
	    }
	    if (e.getInventory().getTitle().equalsIgnoreCase(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("gui-nazwa")))) {
	      e.setCancelled(true);
	    }
	    if (e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("koxy-nazwa"))) || e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("refy-nazwa"))) || e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("perly-nazwa"))) || e.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("strzaly-nazwa")))){
	    	User u = UserManager.getUser(p.getName());
	    	if(e.getSlot() == 19) {
	    		if(u.getKoxy() > 0) {
	    			u.setKoxy(u.getKoxy() -1);
	    			p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1));
	    		}
	    	}
	    	if(e.getSlot() == 21) {
	    		if(u.getRefy() > 0) {
	    			u.setRefy(u.getRefy() -1);
	    			p.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 0));
	    		}
	    	}
	    	if(e.getSlot() == 23) {
	    		if(u.getPerly() > 0) {
	    			u.setPerly(u.getPerly() -1);
	    			p.getInventory().addItem(new ItemStack(Material.ENDER_PEARL, 1));
	    		}
	    	}
	    	if(e.getSlot() == 25) {
	    		if(u.getStrzaly() > 0) {
	    			u.setStrzaly(u.getStrzaly() -1);
	    			p.getInventory().addItem(new ItemStack(Material.ARROW, 1));
	    		}
	    	}
	    	SchowekInv.schowekgui(p);
	    }
	}
}
