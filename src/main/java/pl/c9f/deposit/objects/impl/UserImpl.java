package pl.c9f.deposit.objects.impl;

import pl.c9f.deposit.Main;
import pl.c9f.deposit.objects.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserImpl implements User {

	private final Main plugin;
	private String name;
	private int applesOne;
	private int applesTwo;
	private int pearls;
	private int arrows;

	public UserImpl(Main plugin, String name){
		this.plugin = plugin;
		this.name = name;
		this.plugin.getDatabaseManager().executeUpdate("INSERT INTO `deposit_users` (`name`, `applesOne`, `applesTwo`, `pearls`, `arrows`) VALUES ('" + this.name + "','" + this.applesOne + "','" + this.applesTwo + "','" + this.pearls + "','" + this.arrows + "');");
	}

	public UserImpl(Main plugin, ResultSet resultSet) throws SQLException {
		this.plugin = plugin;
		this.name = resultSet.getString("name");
		this.applesOne = resultSet.getInt("applesOne");
		this.applesTwo = resultSet.getInt("applesTwo");
		this.pearls = resultSet.getInt("pearls");
		this.arrows = resultSet.getInt("arrows");
	}

	@Override
	public String getName(){
		return this.name;
	}

	@Override
	public int getApplesOne() {
		return applesOne;
	}

	@Override
	public int getApplesTwo() {
		return applesTwo;
	}

	@Override
	public int getPearls() {
		return pearls;
	}

	@Override
	public int getArrows() {
		return arrows;
	}

	@Override
	public void setApplesOne(int applesOne) {
		this.applesOne = applesOne;
		this.plugin.getDatabaseManager().executeUpdate("UPDATE `deposit_users` SET `applesOne` = '" + this.applesOne + "' WHERE `name` = '" + this.name + "'");
	}

	@Override
	public void setApplesTwo(int applesTwo) {
		this.applesTwo = applesTwo;
		this.plugin.getDatabaseManager().executeUpdate("UPDATE `deposit_users` SET `applesTwo` = '" + this.applesTwo + "' WHERE `name` = '" + this.name + "'");
	}

	@Override
	public void setPearls(int pearls) {
		this.pearls = pearls;
		this.plugin.getDatabaseManager().executeUpdate("UPDATE `deposit_users` SET `pearls` = '" + this.pearls + "' WHERE `name` = '" + this.name + "'");
	}

	@Override
	public void setArrows(int arrows) {
		this.arrows = arrows;
		this.plugin.getDatabaseManager().executeUpdate("UPDATE `deposit_users` SET `arrows` = '" + this.arrows + "' WHERE `name` = '" + this.name + "'");
	}
}
