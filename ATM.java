import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ATM {
    private static Map<String, Integer> accounts = new HashMap<>();
    private static String currentUser;

    public static void main(String[] args) {
    
        accounts.put("user1", 1234);
        accounts.put("user2", 5678);

        Scanner scanner = new Scanner(System.in);
        boolean isAuthenticated = false;

        while (!isAuthenticated) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine();
            System.out.print("Enter PIN: ");
            int pin = scanner.nextInt();
            scanner.nextLine(); 

            if (authenticate(username, pin)) {
                isAuthenticated = true;
                currentUser = username;
                System.out.println("Login successful.");
            } else {
                System.out.println("Invalid username or PIN. Please try again.");
            }
        }

        while (true) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    depositMoney(scanner);
                    break;
                case 3:
                    withdrawMoney(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private static boolean authenticate(String username, int pin) {
        return accounts.containsKey(username) && accounts.get(username) == pin;
    }

    private static void checkBalance() {
        System.out.println("Your current balance is: $1000"); 
    }

    private static void depositMoney(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        int amount = scanner.nextInt();
        System.out.println("Deposited: $" + amount);
    }

    private static void withdrawMoney(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        int amount = scanner.nextInt();
        System.out.println("Withdrew: $" + amount);
    }
}
