package pl.c9f.schowek.utils;

import java.util.Random;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RandomGlassUtil {
	static Random rand = new Random();
	public static ItemStack GetRandomGlass() {
		int r = rand.nextInt(15 - 1) + 1;
		ItemStack g = new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) r);{
			ItemMeta im = g.getItemMeta();
			im.setDisplayName(" ");
			g.setItemMeta(im);
			return g;
		}	
	}
}
