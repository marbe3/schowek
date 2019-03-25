package pl.c9f.deposit.inventories;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import pl.c9f.deposit.Main;
import pl.c9f.deposit.builders.ItemStackBuilder;
import pl.c9f.deposit.objects.User;
import pl.c9f.deposit.utils.ColorUtil;
import pl.c9f.deposit.utils.ItemUtil;

import java.util.Random;
import java.util.stream.IntStream;

public class DepositInventory {

	private final Main plugin;
	private ItemStackBuilder kox;
	private ItemStackBuilder gApple;
	private ItemStackBuilder pearl;
	private ItemStackBuilder arrow;

	public DepositInventory(Main plugin, User user) {
		this.plugin = plugin;
		this.kox = new ItemStackBuilder(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1)).setName(this.plugin.getSettings().getKoxName()).setLore(this.plugin.getSettings().getLimitLore().replace("{LIMIT}", String.valueOf(this.plugin.getSettings().getKoxLimit())), this.plugin.getSettings().getNumberLore().replace("{AMOUNT}", String.valueOf(user.getApplesOne())));
		this.gApple = new ItemStackBuilder(new ItemStack(Material.GOLDEN_APPLE)).setName(this.plugin.getSettings().getGAppleName()).setLore(this.plugin.getSettings().getLimitLore().replace("{LIMIT}", String.valueOf(this.plugin.getSettings().getGAppleLimit())), this.plugin.getSettings().getNumberLore().replace("{AMOUNT}", String.valueOf(user.getApplesTwo())));
		this.pearl = new ItemStackBuilder(new ItemStack(Material.ENDER_PEARL)).setName(this.plugin.getSettings().getPearlName()).setLore(this.plugin.getSettings().getLimitLore().replace("{LIMIT}", String.valueOf(this.plugin.getSettings().getPearlLimit())), this.plugin.getSettings().getNumberLore().replace("{AMOUNT}", String.valueOf(user.getPearls())));
		this.arrow = new ItemStackBuilder(new ItemStack(Material.ENDER_PEARL)).setName(this.plugin.getSettings().getArrowName()).setLore(this.plugin.getSettings().getLimitLore().replace("{LIMIT}", String.valueOf(this.plugin.getSettings().getArrowLimit())), this.plugin.getSettings().getNumberLore().replace("{AMOUNT}", String.valueOf(user.getArrows())));
	}

	public void open(Player player) {
		final Inventory inventory = Bukkit.createInventory(player, 45, ColorUtil.fixColor(this.plugin.getSettings().getGuiName()));
		IntStream.range(0, inventory.getSize()).forEach(i -> inventory.setItem(i, ItemUtil.getRandomGlass()));
		inventory.setItem(19, this.kox.build());
		inventory.setItem(21, this.gApple.build());
		inventory.setItem(23, this.pearl.build());
		inventory.setItem(25, this.arrow.build());
		player.openInventory(inventory);
	}	
}
