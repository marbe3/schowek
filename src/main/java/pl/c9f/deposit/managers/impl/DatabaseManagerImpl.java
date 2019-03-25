package pl.c9f.deposit.managers.impl;

import pl.c9f.deposit.Main;
import pl.c9f.deposit.managers.DatabaseManager;

import java.sql.*;

public class DatabaseManagerImpl implements DatabaseManager {

    private final Main plugin;
    private Connection connection;

    public DatabaseManagerImpl(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void connect() {
        try {
            this.connection = DriverManager.getConnection("jdbc:mysql://" + this.plugin.getSettings().getMysqlHost() + ":" + this.plugin.getSettings().getMysqlPort() + "/" + this.plugin.getSettings().getMysqlBase(), this.plugin.getSettings().getMysqlUser(), this.plugin.getSettings().getMysqlPassword());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void disconnect() {
        try {
            if (this.connection != null) this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ResultSet executeQuery(String query) {
        try {
            if (this.connection != null) return this.connection.createStatement().executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void executeUpdate(String update) {
        try {
            if (this.connection != null) this.connection.createStatement().executeUpdate(update);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
