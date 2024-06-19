import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<String, User> users;

    public Bank() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public User validateUser(String userId, String userPin) {
        User user = users.get(userId);
        if (user != null && user.getUserPin().equals(userPin)) {
            return user;
        }
        return null;
    }
}
