package com.example;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static junit.framework.TestCase.assertEquals;

//Annotation for parametrized test class
@RunWith(Parameterized.class)
public class BankAccountTestParametrized {
    private BankAccount account;
    private double amount;
    private boolean branch;
    private double expected;

    public BankAccountTestParametrized(double amount, boolean branch, double expected) {
        this.amount = amount;
        this.branch = branch;
        this.expected = expected;
    }

    @org.junit.Before
    public void Setup() {
        account = new BankAccount("Dawid", "Yaloza", 1000, BankAccount.CHECKING);
        System.out.println("Running a test...");
    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions() {
        return Arrays.asList(new Object[][] {
                {100.00, true, 1100.00},
                {200.00, true, 1200.00},
                {325.14, true, 1325.14},
                {489.33, true, 1489.33},
                {1000.00, true, 2000.00}
        });
    }

    @org.junit.Test
    public void deposit() {
        account.deposit(amount, branch);
        assertEquals(expected, account.getBalance(), .01);
    }

}
