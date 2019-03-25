package pl.c9f.deposit.tasks;

import org.bukkit.Material;
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
                	ItemUtil.remove(player, Material.GOLDEN_APPLE, (short) 1, koxAmount - this.plugin.getSettings().getKoxLimit());
                    user.setApplesOne(user.getApplesOne() + koxAmount - this.plugin.getSettings().getKoxLimit());
                }
                if (gAppleAmount > this.plugin.getSettings().getGAppleLimit()) {
                	ItemUtil.remove(player, Material.GOLDEN_APPLE, (short) 0, gAppleAmount - this.plugin.getSettings().getGAppleLimit());
                    user.setApplesTwo(user.getApplesTwo() + gAppleAmount - this.plugin.getSettings().getGAppleLimit());
                }
                if (pearlAmount > this.plugin.getSettings().getPearlLimit()) {
                	ItemUtil.remove(player, Material.ENDER_PEARL, (short) 0, pearlAmount - this.plugin.getSettings().getPearlLimit());
                    user.setPearls(user.getPearls() + pearlAmount - this.plugin.getSettings().getPearlLimit());
                }
                if (arrowAmount > this.plugin.getSettings().getArrowLimit()) {
                	ItemUtil.remove(player, Material.ARROW, (short) 0, arrowAmount - this.plugin.getSettings().getArrowLimit());
                    user.setArrows(user.getArrows() + arrowAmount - this.plugin.getSettings().getArrowLimit());
                }
            }
        });
    }
}
