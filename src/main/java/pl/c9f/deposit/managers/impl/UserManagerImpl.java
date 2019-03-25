package pl.c9f.deposit.managers.impl;

import pl.c9f.deposit.Main;
import pl.c9f.deposit.managers.UserManager;
import pl.c9f.deposit.objects.User;
import pl.c9f.deposit.objects.impl.UserImpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManagerImpl implements UserManager {

    private final Main plugin;
    private Map<String, User> userMap = new ConcurrentHashMap<>();

    public UserManagerImpl(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public void loadUsers() {
        final ResultSet resultSet = this.plugin.getDatabaseManager().executeQuery("SELECT * FROM `deposit_users`");
        try {
            while (resultSet.next()) {
                final User user = new UserImpl(this.plugin, resultSet);
                this.userMap.put(user.getName(), user);
            }
            this.plugin.getLogger().info("Loaded " + this.userMap.size() + " users!");
        }catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void createUser(String name) {
        this.userMap.put(name, new UserImpl(this.plugin, name));
    }

    @Override
    public User getUser(String name) {
        return this.userMap
                .values()
                .stream()
                .filter(user -> user.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }
}
