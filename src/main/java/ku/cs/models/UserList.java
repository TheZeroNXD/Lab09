package ku.cs.models;

import java.util.ArrayList;

public class UserList {
    private ArrayList<User> users;

    public UserList() {
        users = new ArrayList<>();
    }

    public User findUserByUsername(String username) {
        for (User user : users) {
            if (user.isUsername(username)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(String username, String password) {
        User exist = findUserByUsername(username);
        if (exist == null) {
            users.add(new User(username, password));
        }
    }

    // Implements this method to change user's password to newPassword by verifying oldPassword
    // Return true if the process is completed, otherwise return false
    public boolean changePassword(String username, String oldPassword, String newPassword) {
        User user = findUserByUsername(username);
        if (user != null && user.isPassword(oldPassword)) {
            user.setPassword(newPassword);
            return true;
        }
        return false;
    }

    // Implements this method to find a user in users with a valid password
    // Return User object if username and password are correct, otherwise return null
    public User login(String username, String password) {
        User user = findUserByUsername(username);
        if (user != null && user.isPassword(password)) {
            return user;
        }
        return null;
    }
}
