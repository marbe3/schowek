package pl.c9f.deposit.builders;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import pl.c9f.deposit.utils.ColorUtil;

import java.util.Arrays;

public class ItemStackBuilder {

    private final ItemStack itemStack;

    public ItemStackBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStackBuilder setName(String name) {
        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setDisplayName(ColorUtil.fixColor(name));
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStackBuilder setLore(String... lore){
        final ItemMeta itemMeta = this.itemStack.getItemMeta();
        itemMeta.setLore(ColorUtil.fixColor(Arrays.asList(lore)));
        this.itemStack.setItemMeta(itemMeta);
        return this;
    }

    public ItemStack build() {
        return this.itemStack;
    }
}
