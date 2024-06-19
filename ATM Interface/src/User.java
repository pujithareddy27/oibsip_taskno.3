import java.util.ArrayList;
import java.util.List;

public class User {
    private String userId;
    private String userPin;
    private double balance;
    private List<Transaction> transactionHistory;

    public User(String userId, String userPin, double balance) {
        this.userId = userId;
        this.userPin = userPin;
        this.balance = balance;
        this.transactionHistory = new ArrayList<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getUserPin() {
        return userPin;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactionHistory;
    }

    public void addTransaction(Transaction transaction) {
        transactionHistory.add(transaction);
    }
}
