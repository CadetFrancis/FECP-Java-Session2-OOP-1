package org.example;

public class BankAccount {
    private final String accountNumber;
    private final String accountHolderName;
    private static double availableBalance;

    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (initialDeposit >= 0) {
            availableBalance = initialDeposit;
        } else {
            availableBalance = 0;
        }
    }


    public static double deposit(double amount) {
        if (amount > 0) {
            availableBalance += amount;
            System.out.println("Deposited $" + amount + ". New Balance: $" + availableBalance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
        return availableBalance;
    }

    public static double withdraw(double amount) {
        if (amount > 0) {
            if (availableBalance >= amount) {
                availableBalance -= amount;
                System.out.println("Withdrew $" + amount + ". New Balance: $" + availableBalance);
            } else {
                System.out.println("Insufficient funds.");
            }
        } else {
            System.out.println("Withdrawal amount must be positive.");
        }
        return availableBalance;
    }

    public void displayInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Available Balance: $" + availableBalance);
        System.out.println("------------------------------------------------");
    }

    public String getAccountNumber() {
        return accountNumber;
    }
    public double getAvailableBalance() {return availableBalance;}
}
