package pl.c9f.schowek.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

import pl.c9f.schowek.Main;
import pl.c9f.schowek.managers.User;
import pl.c9f.schowek.managers.UserManager;
import pl.c9f.schowek.utils.ColorUtil;
import pl.c9f.schowek.utils.ItemBuilder;
import pl.c9f.schowek.utils.RandomGlassUtil;

public class SchowekInv {
	
	public static Inventory inv;
	public static void schowekgui(Player p){
		inv = Bukkit.createInventory(null, 45, ColorUtil.fixColor(Main.getPlugin().getConfig().getString("gui-nazwa")));{
			User u = UserManager.getUser(p.getName());
			for (int i = 0; i < 45; i++) {
				inv.setItem(i, RandomGlassUtil.GetRandomGlass());
			}
			inv.setItem(19, new ItemBuilder(Material.GOLDEN_APPLE, 1).setName(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("koxy-nazwa"))).setLore(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("limit-opis")) + Main.getPlugin().getConfig().getInt("koxy-limit"), ColorUtil.fixColor(Main.getPlugin().getConfig().getString("ilosc-opis")) + u.getKoxy()).toItemStack());
			inv.setItem(21, new ItemBuilder(Material.GOLDEN_APPLE, 1).setName(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("refy-nazwa"))).setLore(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("limit-opis")) + Main.getPlugin().getConfig().getInt("refy-limit"), ColorUtil.fixColor(Main.getPlugin().getConfig().getString("ilosc-opis")) + u.getRefy()).toItemStack());
			inv.setItem(23, new ItemBuilder(Material.ENDER_PEARL, 1).setName(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("perly-nazwa"))).setLore(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("limit-opis")) + Main.getPlugin().getConfig().getInt("perly-limit"), ColorUtil.fixColor(Main.getPlugin().getConfig().getString("ilosc-opis")) + u.getPerly()).toItemStack());
			inv.setItem(25, new ItemBuilder(Material.ARROW, 1).setName(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("strzaly-nazwa"))).setLore(ColorUtil.fixColor(Main.getPlugin().getConfig().getString("limit-opis")) + Main.getPlugin().getConfig().getInt("strzaly-limit"), ColorUtil.fixColor(Main.getPlugin().getConfig().getString("ilosc-opis")) + u.getStrzaly()).toItemStack());
			p.openInventory(inv);
		}
	}	
}
