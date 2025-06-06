package com.leetcode.simple_bank_system_2043;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    private Bank bank;

    @BeforeEach
    void setUp() {
        // Initial balances: account 1 -> 100, account 2 -> 200, account 3 -> 300
        bank = new Bank(new long[]{100, 200, 300});
    }

    @Test
    void testValidDeposit() {
        assertTrue(bank.deposit(1, 50)); // account 1 balance becomes 150
    }

    @Test
    void testInvalidDeposit() {
        assertFalse(bank.deposit(4, 100)); // account 4 does not exist
    }

    @Test
    void testValidWithdraw() {
        assertTrue(bank.withdraw(2, 100)); // account 2 balance becomes 100
    }

    @Test
    void testInvalidWithdrawInsufficientFunds() {
        assertFalse(bank.withdraw(3, 500)); // account 3 has only 300
    }

    @Test
    void testInvalidWithdrawNonExistentAccount() {
        assertFalse(bank.withdraw(5, 10)); // account 5 does not exist
    }

    @Test
    void testValidTransfer() {
        var res = bank.transfer(1, 2, 50);
        assertTrue(res); // account 1: 50, account 2: 250
    }

    @Test
    void testInvalidTransferInsufficientFunds() {
        assertFalse(bank.transfer(1, 2, 500)); // account 1 has only 100 initially
    }

    @Test
    void testInvalidTransferNonExistentSource() {
        assertFalse(bank.transfer(4, 2, 50)); // account 4 does not exist
    }

    @Test
    void testInvalidTransferNonExistentDestination() {
        assertFalse(bank.transfer(1, 5, 50)); // account 5 does not exist
    }
}
