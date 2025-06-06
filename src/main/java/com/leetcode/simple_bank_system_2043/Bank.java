package com.leetcode.simple_bank_system_2043;

import java.util.Arrays;

class Bank {
    private int[] accounts;

    public Bank(long[] balance) {
        accounts = Arrays.copyOf(Arrays.stream(balance).mapToInt(i -> {
            if (i > Integer.MAX_VALUE) throw new RuntimeException("Balance " + i + " too large to store in account");
            return (int) i;
        }).toArray(), balance.length);
    }

    public boolean transfer(int account1, int account2, long money) {
        if (accounts.length < account1) return false;
        if (accounts.length < account2) return false;
        // todo: wrap these in a transaction
        if (!hasSufficientFunds(account1, money)) return false;
        accounts[account1 - 1] = accounts[account1 - 1] - (int) money;
        // todo: make sure the addition doesn't cause integer overflow
        accounts[account2 - 1] = accounts[account2 - 1] + (int) money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (accounts.length < account) return false;
        // todo: make sure the addition doesn't cause integer overflow
        accounts[account - 1] = accounts[account - 1] + (int) money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (accounts.length < account) return false;
        if (!hasSufficientFunds(account, money)) return false;
        accounts[account - 1] = accounts[account - 1] - (int) money;
        return true;
    }

    private boolean hasSufficientFunds(int account, long money) {
        return (accounts[account - 1] >= (int) money);
    }
}