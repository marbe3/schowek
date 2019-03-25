package pl.c9f.schowek.managers;

import java.util.ArrayList;

public class UserManager {
	public static ArrayList<User> users = new ArrayList<User>();
	public static void addUser(User u){
		users.add(u);
	}  
	public static void removeUser(User u){
		users.remove(u);
	}  
	public static User getUser(String name){
		User toret = null;
		for (User u : users) {
			if (u.getName().equalsIgnoreCase(name)) {
				toret = u;
			}
		}
		return toret;
	}
	public static void DownloadUser(String name) {
		User u = UserManager.getUser(name);
		u.setKoxy(ConfigManager.getKoxy(name));
		u.setRefy(ConfigManager.getRefy(name));
		u.setPerly(ConfigManager.getPerly(name));
		u.setStrzaly(ConfigManager.getStrzaly(name));
	}
	public static void SaveUser(String name) {
		User u = UserManager.getUser(name);
		ConfigManager.setKoxy(name, u.getKoxy());
		ConfigManager.setRefy(name, u.getRefy());
		ConfigManager.setPerly(name, u.getPerly());
		ConfigManager.setStrzaly(name, u.getStrzaly());
	}
}
