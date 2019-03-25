package pl.c9f.deposit.listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import pl.c9f.deposit.Main;
import pl.c9f.deposit.inventories.DepositInventory;
import pl.c9f.deposit.objects.User;
import pl.c9f.deposit.utils.ColorUtil;

public class InventoryClickListener implements Listener {

    private final Main plugin;

    public InventoryClickListener(Main plugin) {
        this.plugin = plugin;
        this.plugin.getServer().getPluginManager().registerEvents(this, this.plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        if (event.getInventory() == null) return;
        if (event.getCurrentItem() == null) return;
        final Player player = (Player) event.getWhoClicked();
        final User user = this.plugin.getUserManager().getUser(player.getName());
        if (user != null && event.getInventory().getName().equalsIgnoreCase(ColorUtil.fixColor(this.plugin.getSettings().getGuiName()))) {
            event.setCancelled(true);
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.fixColor(this.plugin.getSettings().getKoxName()))) {
                if (user.getApplesOne() > 0) {
                    user.setApplesOne(user.getApplesOne() - 1);
                    player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE, 1, (short) 1));
                    new DepositInventory(this.plugin, user).open(player);
                }
            }
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.fixColor(this.plugin.getSettings().getGAppleName()))) {
                if (user.getApplesTwo() > 0) {
                    user.setApplesTwo(user.getApplesTwo() - 1);
                    player.getInventory().addItem(new ItemStack(Material.GOLDEN_APPLE));
                    new DepositInventory(this.plugin, user).open(player);
                }
            }
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.fixColor(this.plugin.getSettings().getPearlName()))) {
                if (user.getPearls() > 0) {
                    user.setPearls(user.getPearls() - 1);
                    player.getInventory().addItem(new ItemStack(Material.ENDER_PEARL));
                    new DepositInventory(this.plugin, user).open(player);
                }
            }
            if (event.getCurrentItem().hasItemMeta() && event.getCurrentItem().getItemMeta().getDisplayName().equalsIgnoreCase(ColorUtil.fixColor(this.plugin.getSettings().getArrowName()))) {
                if (user.getArrows() > 0) {
                    user.setArrows(user.getArrows() - 1);
                    player.getInventory().addItem(new ItemStack(Material.ARROW));
                    new DepositInventory(this.plugin, user).open(player);
                }
            }
        }
    }
}
