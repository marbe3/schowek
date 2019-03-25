package pl.c9f.deposit.managers;

import pl.c9f.deposit.objects.User;

public interface UserManager {

    void loadUsers();

    void createUser(String name);

    User getUser(String name);
}
