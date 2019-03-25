package pl.c9f.deposit.utils;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public final class ColorUtil{

	private ColorUtil() {
	}

	public static String fixColor(String string) {
		return ChatColor.translateAlternateColorCodes('&', string.replace(">>", "»").replace("<<", "«"));
	}

	public static List<String> fixColor(List<String> lore) {
		return lore
				.stream()
				.map(ColorUtil::fixColor)
				.collect(Collectors.toList());
	}
}

