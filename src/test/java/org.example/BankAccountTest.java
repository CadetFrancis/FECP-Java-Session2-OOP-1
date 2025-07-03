package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    private BankAccount bankAccount;

    @BeforeEach
    void setup (){
         bankAccount = new BankAccount("101","Alice", 5000.0);
    }

    @Test
    void depositAValidAmount(){
        double actual = BankAccount.deposit(5000);
        assertEquals(10000,actual,0.001);
    }

    @Test
    void depositAnInvalidAmount(){
        double actual = BankAccount.deposit(-100);
        assertEquals(5000,actual,0.001);
    }

    @Test
    void withdrawAValidAmount(){
        double actual = BankAccount.withdraw(1000);
        assertEquals(4000,actual,0.001);
    }
    @Test
    void withdrawAnInvalidAmount1(){
        double actual = BankAccount.withdraw(-100);
        assertEquals(5000,actual,0.001);
    }
    @Test
    void withdrawMoreThanAvailableBalance(){
        double actual = BankAccount.withdraw(6000);
        assertEquals(5000,actual,0.001);
    }

    @Test
    void testGetAccountNumberMethod(){
        String expectedAccountNumber = "101";
        String actualAccountNumber = bankAccount.getAccountNumber();
        assertEquals(expectedAccountNumber, actualAccountNumber);
    }

    @Test
    void createAccountWithNoDeposits(){
        new BankAccount("104","Francis",0);
        assertEquals(0.0,bankAccount.getAvailableBalance(),0.001);
    }






}

