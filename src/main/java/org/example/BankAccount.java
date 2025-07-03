package org.example;

public class BankAccount {
    private String accountNumber;
    private String accountHolderName;
    private double availableBalance;

    public BankAccount(String accountNumber, String accountHolderName, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        if (initialDeposit >= 0) {
            this.availableBalance = initialDeposit;
        } else {
            this.availableBalance = 0;  // Negative deposits are not allowed.
        }
    }

    public void deposit(double amount) {
        if (amount > 0) {
            availableBalance += amount;
            System.out.println("Deposited $" + amount + ". New Balance: $" + availableBalance);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    public void withdraw(double amount) {
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
}
