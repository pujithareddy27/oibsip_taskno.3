import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ATM atm = new ATM();

    public static void main(String[] args) {
        atm.addUser(new User("sai", "1234", 1000.0));
        atm.addUser(new User("puja", "5678", 2000.0));

        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter User PIN: ");
        String userPin = scanner.nextLine();

        User currentUser = atm.validateUser(userId, userPin);
        if (currentUser != null) {
            System.out.println("Login successful!");
            boolean quit = false;
            while (!quit) {
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Quit");
                System.out.print("Choose an option: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        atm.showTransactionHistory(currentUser);
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(currentUser, withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(currentUser, depositAmount);
                        break;
                    case 4:
                        System.out.print("Enter recipient User ID: ");
                        String recipientId = scanner.nextLine();
                        User recipientUser = atm.getUser(recipientId);
                        if (recipientUser != null) {
                            System.out.print("Enter amount to transfer: ");
                            double transferAmount = scanner.nextDouble();
                            atm.transfer(currentUser, recipientUser, transferAmount);
                        } else {
                            System.out.println("User not found.");
                        }
                        break;
                    case 5:
                        quit = true;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid option. Please try again.");
                        break;
                }
            }
        } else {
            System.out.println("Invalid user ID or PIN.");
        }

        scanner.close();
    }
}
