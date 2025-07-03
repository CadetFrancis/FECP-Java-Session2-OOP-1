package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private static ArrayList<BankAccount> accounts = new ArrayList<>();
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        showMenu();
        String returnToMenu = null;
        while (true) {

            int choice = getValidChoice();

            switch (choice) {
                case 1:
                    createAccount();
                    System.out.print("Would you like to return to the menu? (yes/no):");
                    returnToMenu = s.next().toLowerCase();
                    if (returnToMenu.equals("yes")){
                        showMenu();
                    }
                    break;
                case 2:
                    viewAllAccounts();
                    System.out.print("Would you like to return to the menu? (yes/no):");
                    returnToMenu = s.next().toLowerCase();
                    if (returnToMenu.equals("yes")){
                        showMenu();
                    }
                    break;
                case 3:
                    checkBalance();
                    System.out.print("Would you like to return to the menu? (yes/no):");
                    returnToMenu = s.next().toLowerCase();
                    if (returnToMenu.equals("yes")){
                        showMenu();
                    }
                    break;
                case 4:
                    deposit();
                    System.out.print("Would you like to return to the menu? (yes/no):");
                    returnToMenu = s.next().toLowerCase();
                    if (returnToMenu.equals("yes")){
                        showMenu();
                    }
                    break;
                case 5:
                    withdraw();
                    System.out.print("Would you like to return to the menu? (yes/no):");
                    returnToMenu = s.next().toLowerCase();
                    if (returnToMenu.equals("yes")){
                        showMenu();
                    }
                    break;
                case 6:
                    System.out.println("Thank you for using our Bank System. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\n*** Bank System Menu ***");
        System.out.println("1. Create Account");
        System.out.println("2. View All Accounts");
        System.out.println("3. Check Balance");
        System.out.println("4. Deposit");
        System.out.println("5. Withdraw");
        System.out.println("6. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getValidChoice() {
        while (!s.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number between 1 and 6.");
            s.next();
        }
        return s.nextInt();
    }

    private static void createAccount() {
        s.nextLine();

        System.out.print("Enter Account Number: ");
        String accountNumber = s.nextLine();

        System.out.print("Enter Account Holder Name: ");
        String accountHolderName = s.nextLine();

        double initialDeposit = 0;
        System.out.print("Do you want to make an initial deposit? (yes/no): ");
        String depositChoice = s.nextLine().toLowerCase();
        if (depositChoice.equals("yes")) {
            System.out.print("Enter deposit amount: ");
            while (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid deposit amount.");
                s.next();
            }
            initialDeposit = s.nextDouble();
            if (initialDeposit < 0) {
                initialDeposit = 0;
                System.out.println("Initial deposit cannot be negative. Account created with $0 balance.");
            }
        }

        BankAccount newAccount = new BankAccount(accountNumber, accountHolderName, initialDeposit);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    private static void viewAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
        } else {
            for (BankAccount account : accounts) {
                account.displayInfo();
            }
        }
    }

    private static void checkBalance() {
        System.out.print("Enter Account Number: ");
        String accountNumber = s.next();
        BankAccount account = findAccount(accountNumber);

        if (account != null) {
            account.displayInfo();
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void deposit() {
        System.out.print("Enter Account Number: ");
        String accountNumber = s.next();
        BankAccount account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            while (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid deposit amount.");
                s.next();
            }
            double amount = s.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        System.out.print("Enter Account Number: ");
        String accountNumber = s.next();
        BankAccount account = findAccount(accountNumber);

        if (account != null) {
            System.out.print("Enter withdrawal amount: ");
            while (!s.hasNextDouble()) {
                System.out.println("Invalid input. Please enter a valid withdrawal amount.");
                s.next();
            }
            double amount = s.nextDouble();
            account.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static BankAccount findAccount(String accountNumber) {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }
}
