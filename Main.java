import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a new bank account
        System.out.print("Enter account holder's name: ");
        String name = sc.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = sc.nextLine();

        System.out.print("Enter the interest rate for the account (0.02 for 2%): ");
        double interestRate = sc.nextDouble();

        BankAccount account = new BankAccount(name, accountNumber, interestRate);

        // Display menu for banking operations
        int option = 0;
        do {
            System.out.println("\n--- Banking System Menu ---\n"
                             + "1. Deposit Money\n"
                             + "2. Withdraw Money\n"
                             + "3. Check Balance\n"
                             + "4. Account Information\n"
                             + "5. Transaction History\n"
                             + "6. Apply Interest\n"
                             + "7. Exit\n"
                             + "Choose an option: ");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = sc.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double withdrawAmount = sc.nextDouble();
                    account.withdraw(withdrawAmount);
                    break;
                case 3:
                    account.checkBalance();
                    break;
                case 4:
                    account.getAccountInfo();
                    break;
                case 5:
                    account.getTransactionHistory();
                    break;
                case 6:
                    account.applyInterest();
                    break;
                case 7:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (option != 7);

        sc.close();
    }
}