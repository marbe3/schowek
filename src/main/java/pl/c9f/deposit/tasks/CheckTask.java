package pl.c9f.deposit.tasks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;
import pl.c9f.deposit.Main;
import pl.c9f.deposit.objects.User;
import pl.c9f.deposit.utils.ItemUtil;

public class CheckTask extends BukkitRunnable {

    private final Main plugin;

    public CheckTask(Main plugin) {
        this.plugin = plugin;
        this.runTaskTimer(this.plugin, 200L, 200L);
    }

    @Override
    public void run() {
        this.plugin.getServer().getOnlinePlayers().forEach(player -> {
            final User user = this.plugin.getUserManager().getUser(player.getName());
            if (user != null) {
                final int koxAmount = ItemUtil.getAmount(player, Material.GOLDEN_APPLE, (short) 1);
                final int gAppleAmount = ItemUtil.getAmount(player, Material.GOLDEN_APPLE, (short) 0);
                final int pearlAmount = ItemUtil.getAmount(player, Material.ENDER_PEARL, (short) 0);
                final int arrowAmount = ItemUtil.getAmount(player, Material.ARROW, (short) 0);
                if (koxAmount > this.plugin.getSettings().getKoxLimit()) {
                    player.getInventory().removeItem(new ItemStack(Material.GOLDEN_APPLE, koxAmount - this.plugin.getSettings().getKoxLimit(), (short) 1));
                    user.setApplesOne(user.getApplesOne() + koxAmount - this.plugin.getSettings().getKoxLimit());
                }
                if (gAppleAmount > this.plugin.getSettings().getGAppleLimit()) {
                    player.getInventory().removeItem(new ItemStack(Material.GOLDEN_APPLE, gAppleAmount - this.plugin.getSettings().getGAppleLimit(), (short) 0));
                    user.setApplesTwo(user.getApplesTwo() + gAppleAmount - this.plugin.getSettings().getGAppleLimit());
                }
                if (pearlAmount > this.plugin.getSettings().getPearlLimit()) {
                    player.getInventory().removeItem(new ItemStack(Material.ENDER_PEARL, pearlAmount - this.plugin.getSettings().getPearlLimit(), (short) 0));
                    user.setPearls(user.getPearls() + pearlAmount - this.plugin.getSettings().getPearlLimit());
                }
                if (arrowAmount > this.plugin.getSettings().getArrowLimit()) {
                    player.getInventory().removeItem(new ItemStack(Material.ARROW, arrowAmount - this.plugin.getSettings().getArrowLimit(), (short) 0));
                    user.setArrows(user.getArrows() + arrowAmount - this.plugin.getSettings().getArrowLimit());
                }
            }
        });
    }
}
