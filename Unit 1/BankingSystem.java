package First_Unit;
import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    private ArrayList<String> transactionHistory;

    public Account(String accountHolderName, String accountNumber) {
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        transactionHistory.add("Account created with balance: 0.0");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactionHistory.add("Deposited: " + amount + ", New Balance: " + balance);
            System.out.println("Deposit successful. New balance: " + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactionHistory.add("Withdrew: " + amount + ", New Balance: " + balance);
            System.out.println("Withdrawal successful. New balance: " + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public void displayTransactionHistory() {
        System.out.println("Transaction History for Account: " + accountNumber);
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }
}

public class BankingSystem {

    private static ArrayList<Account> accounts = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Banking System Menu ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    performDeposit();
                    break;
                case 3:
                    performWithdrawal();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    viewTransactionHistory();
                    break;
                case 6:
                    System.out.println("Thank you for using the banking system.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void createAccount() {
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter a unique account number: ");
        String accountNumber = scanner.nextLine();

        if (getAccountByNumber(accountNumber) != null) {
            System.out.println("Account number already exists. Try again with a unique number.");
            return;
        }

        accounts.add(new Account(name, accountNumber));
        System.out.println("Account created successfully for " + name + ".");
    }

    private static void performDeposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = getAccountByNumber(accountNumber);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void performWithdrawal() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = getAccountByNumber(accountNumber);

        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = getAccountByNumber(accountNumber);

        if (account != null) {
            System.out.println("Account holder: " + account.getAccountHolderName());
            System.out.println("Current balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void viewTransactionHistory() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();
        Account account = getAccountByNumber(accountNumber);

        if (account != null) {
            account.displayTransactionHistory();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static Account getAccountByNumber(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
