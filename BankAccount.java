// Jvdroid-main: Main.java
// BankAccount.java
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    // Fields (attributes)
    private String accountHolderName;
    private String accountNumber;
    private double balance;
    private double interestRate;
    private int withdrawalsToday;
    private final int dailyLimit = 3;
    private List<String> transactionHistory = new ArrayList<>();
    
    // Constructor
    public BankAccount(String accountHolderName, String accountNumber, double interestRate) {
        this.setAccountHolderName(accountHolderName);
        this.setAccountNumber(accountNumber);
        this.balance = 0.0; // Initial balance is 0
        this.interestRate = interestRate; // Interest rate for the account
        this.withdrawalsToday = 0;
    }

    public void setAccountHolderName(String accountHolderName) {
        if (!accountHolderName.isEmpty()) {
            this.accountHolderName = accountHolderName;
        } else {
            System.out.println("Account holder name cannot be empty.");
        }
    }

    public String getAccountHolderName() {
        return this.accountHolderName;
    }

    // Setter and Getter for accountNumber
    public void setAccountNumber(String accountNumber) {
        if (!accountNumber.isEmpty()) {
            this.accountNumber = accountNumber;
        } else {
            System.out.println("Account number cannot be empty.");
        }
    }

    public String getAccountNumber() {
        return this.accountNumber;
    }

    // Getter for balance (no setter to ensure controlled updates via deposit/withdraw methods)
    public double getBalance() {
        return this.balance;
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            this.balance += amount;
            String transaction = "Deposited " + amount + " on " + LocalDate.now();
            transactionHistory.add(transaction);
            System.out.println("Successfully deposited " + amount + ". Current balance: " + this.getBalance());
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Method to withdraw money with daily withdrawal limit
    public void withdraw(double amount) {
        if (withdrawalsToday < dailyLimit) {
            if (amount > 0 && amount <= this.getBalance()) {
                this.balance -= amount;
                withdrawalsToday++;
                String transaction = "Withdrew " + amount + " on " + LocalDate.now();
                transactionHistory.add(transaction);
                System.out.println("Successfully withdrew " + amount + ". Current balance: " + this.getBalance());
            } else if (amount > this.getBalance()) {
                System.out.println("Insufficient balance!");
            } else {
                System.out.println("Withdrawal amount must be positive.");
            }
        } else {
            System.out.println("Daily withdrawal limit reached. You can only withdraw " + dailyLimit + " times per day.");
        }
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current balance: " + this.getBalance());
    }

    // Method to get account information
    public void getAccountInfo() {
        System.out.println("Account Holder: " + this.getAccountHolderName());
        System.out.println("Account Number: " + this.getAccountNumber());
        System.out.println("Current Balance: " + this.getBalance());
    }

    // Method to print transaction history
    public void getTransactionHistory() {
        if (transactionHistory.isEmpty()) {
            System.out.println("No transactions have been made yet.");
        } else {
            System.out.println("--- Transaction History ---");
            for (String transaction : transactionHistory) {
                System.out.println(transaction);
            }
        }
    }

    // Method to apply interest to the account balance
    public void applyInterest() {
        double interest = balance * interestRate;
        balance += interest;
        String transaction = "Applied interest: " + interest + " on " + LocalDate.now();
        transactionHistory.add(transaction);
        System.out.println("Interest applied: " + interest + ". Current balance: " + this.getBalance());
    }
}