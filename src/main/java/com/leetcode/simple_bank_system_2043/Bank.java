package com.leetcode.simple_bank_system_2043;

import java.util.Arrays;

class Bank {
    private long[] accounts;

    public Bank(long[] balance) {
        accounts = Arrays.copyOf(balance, balance.length);
    }

    public boolean transfer(int account1, int account2, long money) {
        if (!allValidAccounts(account1, account2)) return false;
        // todo: wrap these in a transaction
        if (!hasSufficientFunds(account1, money)) return false;
        accounts[account1 - 1] = accounts[account1 - 1] - money;
        // todo: make sure the addition doesn't cause integer overflow
        accounts[account2 - 1] = accounts[account2 - 1] + money;
        return true;
    }

    public boolean deposit(int account, long money) {
        if (!isValidAccount(account)) return false;
        // todo: make sure the addition doesn't cause integer overflow
        accounts[account - 1] = accounts[account - 1] + money;
        return true;
    }

    public boolean withdraw(int account, long money) {
        if (!isValidAccount(account)) return false;
        if (!hasSufficientFunds(account, money)) return false;
        accounts[account - 1] = accounts[account - 1] - money;
        return true;
    }

    private boolean hasSufficientFunds(int account, long money) {
        return (accounts[account - 1] >= money);
    }

    private boolean allValidAccounts(int... accounts) {
        return Arrays.stream(accounts).allMatch(this::isValidAccount);
    }

    private boolean isValidAccount(int account) {
        return account >= 1 && account <= accounts.length;
    }
}