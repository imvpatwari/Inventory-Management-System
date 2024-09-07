import java.util.*;

public class UserManager {
    private Map<String, User> users = new HashMap<>();

    public boolean registerUser(String username, String password, String role) {
        if (users.containsKey(username)) {
            return false;
        }

        User user = new User(username, password, role);
        users.put(username, user);
        return true;
    }

    public User authenticateUser(String username, String password) {
        User user = users.get(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}
