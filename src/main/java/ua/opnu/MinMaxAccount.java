package ua.opnu;

import ua.opnu.java.inheritance.account.BankingAccount;
import ua.opnu.java.inheritance.account.Credit;
import ua.opnu.java.inheritance.account.Debit;
import ua.opnu.java.inheritance.account.Startup;

public class MinMaxAccount extends BankingAccount {
    private int minBalance;
    private int maxBalance;

    public MinMaxAccount(Startup s) {
        super(s);
        int initialBalance = getBalance();
        minBalance = initialBalance;
        maxBalance = initialBalance;
    }

    @Override
    public void debit(Debit d) {
        super.debit(d);  // поповнення рахунку
        updateMinMax();
    }

    @Override
    public void credit(Credit c) {
        super.credit(c); // зняття з рахунку
        updateMinMax();
    }

    // Метод для оновлення мінімального та максимального значень
    private void updateMinMax() {
        int current = getBalance();
        if (current < minBalance) minBalance = current;
        if (current > maxBalance) maxBalance = current;
    }

    // Повертає мінімальне значення балансу
    public int getMin() {
        return minBalance;
    }

    // Повертає максимальне значення балансу
    public int getMax() {
        return maxBalance;
    }
}

