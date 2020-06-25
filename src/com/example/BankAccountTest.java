package com.example;


import org.junit.Before;

import static junit.framework.TestCase.*;

public class BankAccountTest {

    private BankAccount account;
    private static int count;

//    Runs only one time before all tests
    @org.junit.BeforeClass
    public static void beforeClass() {
        System.out.println("This executes before any test cases. Count = " + count++);
    }

//    Initialize each time before run the tests, so we musn't initialize BankAccount in every method that we are using. But when we have 4 test methods it will be running 4 times
    @org.junit.Before
    public void setup() {
        account = new BankAccount("Dawid", "Yaloza", 1000, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @org.junit.Test
    public void deposit() {
        double balance = account.deposit(200.00, true);
//        Checking result
        assertEquals(1200.00, balance, 0);
    }

    @org.junit.Test
    public void withdraw_branch() throws Exception{
        double balance = account.withdraw(600, true);
        assertEquals(400.00, balance, 0);
    }

//    Because it should be passed then exception has been thrown
    @org.junit.Test(expected = IllegalArgumentException.class)
    public void withdraw_notBranch() throws Exception {
        account.withdraw(600, false);
        fail("Should have thrown an IllegalArgumentException");
    }
//    The same as above
//    @org.junit.Test//(expected = IllegalArgumentException.class)
//    public void withdraw_notBranch() throws Exception {
//        try {
//            account.withdraw(600.00, false);
////            if test will be not passed the message will be shown
//            fail("Should have thrown an IllegalArgumentException");
//        } catch (IllegalArgumentException e) {
//
//        }
//    }

    @org.junit.Test
    public void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800.00, account.getBalance(), 0);
    }

    @org.junit.Test
    public void isChecking_true() {
//        Two ways to check if it's true.
//        assertEquals(true, account.isChecking());
//        Message will be showed when test won't be passed
        assertTrue("The account is NOT a checking account", account.isChecking());
    }

//    Runs only one time after all tests
    @org.junit.AfterClass
    public static void afterClass() {
        System.out.println("This executes after any test cases. Count = " + count++);
    }

    @org.junit.After
    public void teardown() {
        System.out.println("Count = " + count++);
    }

}
