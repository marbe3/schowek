package pl.c9f.schowek.managers;

import java.io.IOException;

import pl.c9f.schowek.data.Config;

public class ConfigManager {
	public static void setKoxy(String name, int number) {
		Config.getConfig("schowek").set(name + ".koxy", Integer.valueOf(number));
		try {
			Config.getConfig("schowek").save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setRefy(String name, int number) {
		Config.getConfig("schowek").set(name + ".refy", Integer.valueOf(number));
		try {
			Config.getConfig("schowek").save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setPerly(String name, int number) {
		Config.getConfig("schowek").set(name + ".perly", Integer.valueOf(number));
		try {
			Config.getConfig("schowek").save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void setStrzaly(String name, int number) {
		Config.getConfig("schowek").set(name + ".strzaly", Integer.valueOf(number));
		try {
			Config.getConfig("schowek").save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	  public static int getKoxy(String name){
	    return Config.getConfig("schowek").getInt(name + ".koxy");
	  }
	  public static int getRefy(String name){
		    return Config.getConfig("schowek").getInt(name + ".refy");
		  }
	  public static int getPerly(String name){
		    return Config.getConfig("schowek").getInt(name + ".perly");
		  }
	  public static int getStrzaly(String name){
		    return Config.getConfig("schowek").getInt(name + ".strzaly");
		  }
}
