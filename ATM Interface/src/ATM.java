import java.util.HashMap;
import java.util.Map;

public class ATM {
    private Map<String, User> users;

    public ATM() {
        users = new HashMap<>();
    }

    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public User validateUser(String userId, String userPin) {
        User user = users.get(userId);
        if (user != null && user.getUserPin().equals(userPin)) {
            return user;
        }
        return null;
    }

    public void showTransactionHistory(User user) {
        System.out.println("Transaction History:");
        for (Transaction transaction : user.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    public void withdraw(User user, double amount) {
        if (user.getBalance() >= amount) {
            user.setBalance(user.getBalance() - amount);
            user.addTransaction(new Transaction("Withdraw", amount));
            System.out.println("Withdraw successful.");
            System.out.println("Balance: " + user.getBalance());
        } else {
            System.out.println("Insufficient balance.");
            System.out.println("Balance: " + user.getBalance());
        }
    }

    public void deposit(User user, double amount) {
        user.setBalance(user.getBalance() + amount);
        user.addTransaction(new Transaction("Deposit", amount));
        System.out.println("Deposit successful.");
        System.out.println("Balance: " + user.getBalance());
    }

    public void transfer(User fromUser, User toUser, double amount) {
        if (fromUser.getBalance() >= amount) {
            fromUser.setBalance(fromUser.getBalance() - amount);
            toUser.setBalance(toUser.getBalance() + amount);
            fromUser.addTransaction(new Transaction("Transfer to " + toUser.getUserId(), amount));
            toUser.addTransaction(new Transaction("Transfer from " + fromUser.getUserId(), amount));
            System.out.println("Transfer successful.");
            System.out.println("Your Balance: " + fromUser.getBalance());
        } else {
            System.out.println("Insufficient balance.");
            System.out.println("Balance: " + fromUser.getBalance());
        }
    }

    public User getUser(String userId) {
        return users.get(userId);
    }
}
