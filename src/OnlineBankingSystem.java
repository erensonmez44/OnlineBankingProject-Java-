import java.util.HashMap;
import java.util.Scanner;

public class OnlineBankingSystem {
    private HashMap<String, Account> accounts;
    private Account currentUser;
    private Scanner scanner;

    public OnlineBankingSystem(){
        accounts = new HashMap<>();
        scanner = new Scanner(System.in);
    }
    public void signUp() {
        System.out.println("Create username and password:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        System.out.println("Enter initial balance:");
        double initialBalance = scanner.nextDouble();
        scanner.nextLine();

        User user = new User(username,password);
        Account account = new Account(user, initialBalance);
        accounts.put(username, account);
        System.out.println("Account created.");
    }

    public void login() {
        System.out.println("Username:");
        String username = scanner.nextLine();
        System.out.println("Password:");
        String password = scanner.nextLine();
        System.out.println("Entry successful.");

        if (accounts.containsKey(username)) {
            User user = accounts.get(username).getUser();

            if (user.getPassword().equals(password)) {
                currentUser = accounts.get(username);
                System.out.println("Entry successful.");
            } else {
                System.out.println("Incorrect password.");
            }
        } else {
            System.out.println("User not found.");
        }
    }

        public void checkBalance () {
            if (currentUser == null) {
                System.out.println("You have to log in first.");
                return;
            }
            System.out.println("Your Balance: " + currentUser.getBalance());
        }


        public void transferMoney () {
            if (currentUser == null) {
                System.out.println("You have to log in first.");
                return;
            }
            System.out.println("The username you want to transfer:");
            String recipientUsername = scanner.nextLine();
            System.out.println("Amount of transfer:");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            if (accounts.containsKey(recipientUsername)) {
                Account recipient = accounts.get(recipientUsername);
                currentUser.transfer(recipient, amount);
            } else {
                System.out.println("Invalid recipient.");
            }
        }


    public void logout() {
        currentUser = null;
        System.out.println("Exit succesfully.");
    }
    public void information(){
        currentUser = null;
        System.out.println("This project is created by Eren Sönmez.");
    }

    public static void main(String[] args) {
        OnlineBankingSystem bankingSystem = new OnlineBankingSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Balance Check");
            System.out.println("4. Money Transfer");
            System.out.println("5. Information");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

                switch (choice) {
                    case 1:
                        bankingSystem.signUp();
                        break;
                    case 2:
                        bankingSystem.login();
                        break;
                    case 3:
                        bankingSystem.checkBalance();
                        break;
                    case 4:
                        bankingSystem.transferMoney();
                        break;
                    case 5:
                        bankingSystem.information();
                        break;
                    case 6:
                        bankingSystem.logout();
                        break;
                    default:
                        System.out.println("Invalid option.");
                }
            }
        }
    }
