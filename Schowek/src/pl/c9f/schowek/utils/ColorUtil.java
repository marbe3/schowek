package pl.c9f.schowek.utils;

import org.bukkit.ChatColor;

public class ColorUtil{
	public static String fixColor(String i){
		return ChatColor.translateAlternateColorCodes('&', i.replace(">>", "�").replace("<<", "�"));
	}
}

