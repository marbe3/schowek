package pl.c9f.deposit.managers;

import java.sql.ResultSet;

public interface DatabaseManager {


    void connect();

    void disconnect();

    ResultSet executeQuery(String query);

    void executeUpdate(String update);
}
