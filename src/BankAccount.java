 import java.util.Scanner;
    public class BankAccount {
        private double accountBalance;
        private String accountName;
        private int accountNumber;

        public BankAccount(double accountBalance, String accountName, int accountNumber) {
            this.accountBalance = accountBalance;
            this.accountName = accountName;
            this.accountNumber = accountNumber;
        }

        public double getAccountBalance() {
            return accountBalance;
        }

        public int getAccountNumber() {
            return accountNumber;
        }

        public String getAccountName() {
            return accountName;
        }

        public BankAccount() {
            Scanner scanner = new Scanner(System.in);
            System.out.println("What is the name for the account?");
            this.accountName = scanner.nextLine();
            System.out.println("What is the beginning balance for the account?");
            this.accountBalance = scanner.nextDouble();
        }


        public void deposit ( double moneyAmount) {
            accountBalance = accountBalance + moneyAmount;
            System.out.println("You deposited " + moneyAmount + " into " + accountName + "'s account.");
        }

        public void withdrawal (double moneyAmount) {
            if (accountBalance >= moneyAmount) {
                accountBalance = accountBalance - moneyAmount;
                System.out.println("You withdrew " + moneyAmount);
            } else {
                System.out.println("Not enough funds. Please try again. ");
            }
        }

        public void accountDetails () {
            System.out.println(accountName + " account balance: " + accountBalance);
        }

        public void transfer(BankAccount destinationAccount, double transferAmount) {
            if (accountBalance >= transferAmount) {
                accountBalance -= transferAmount;
                destinationAccount.deposit(transferAmount);
                System.out.println("Transfer of $" + transferAmount + " to account " +
                        destinationAccount.getAccountNumber() + " is successful.");
            } else {
                System.out.println("Sorry, not enough funds. Please try again.");
            }
        }
    }
