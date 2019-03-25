package pl.c9f.deposit.utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import pl.c9f.deposit.builders.ItemStackBuilder;

import java.util.Arrays;
import java.util.Random;

public final class ItemUtil {

    private ItemUtil() {
    }

    private static final Random RANDOM = new Random();

    public static int getAmount(Player player, Material material, short durability) {
        return Arrays.stream(player.getInventory().getContents()).filter(itemStack -> itemStack != null && itemStack.getType() == material && itemStack.getDurability() == durability).mapToInt(ItemStack::getAmount).sum();
    }

    public static ItemStack getRandomGlass() {
        return new ItemStackBuilder(new ItemStack(Material.STAINED_GLASS_PANE, 1, (short) (RANDOM.nextInt(15 - 1) + 1))).setName(" ").build();
    }
}
