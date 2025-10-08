package ua.opnu;

import ua.opnu.java.inheritance.bill.Employee;
import ua.opnu.java.inheritance.bill.GroceryBill;
import ua.opnu.java.inheritance.bill.Item;

public class DiscountBill2 {
    private GroceryBill bill;
    private boolean regularCustomer;
    private int discountCount;
    private double discountAmount;
    private double totalBeforeDiscount;

    public DiscountBill2(Employee clerk, boolean regularCustomer) {
        this.bill = new GroceryBill(clerk);
        this.regularCustomer = regularCustomer;
        this.discountCount = 0;
        this.discountAmount = 0.0;
        this.totalBeforeDiscount = 0.0;
    }

    // метод для додавання товару
    public void add(Item i) {
        bill.add(i);
        totalBeforeDiscount += i.getPrice();

        if (regularCustomer && i.getDiscount() > 0.0) {
            discountCount++;
            discountAmount += i.getDiscount();
        }
    }

    // повертає загальну суму з урахуванням знижок
    public double getTotal() {
        double total = regularCustomer ? totalBeforeDiscount - discountAmount : totalBeforeDiscount;
        // округлення до 2 знаків після коми
        total = Math.round(total * 100.0) / 100.0;
        return total;
    }

    // геттер для касира
    public Employee getClerk() {
        return bill.getClerk();
    }

    public int getDiscountCount() {
        return regularCustomer ? discountCount : 0;
    }

    public double getDiscountAmount() {
        double amount = regularCustomer ? discountAmount : 0.0;
        // округлення до 2 знаків після коми
        amount = Math.round(amount * 100.0) / 100.0;
        return amount;
    }

    public double getDiscountPercent() {
        if (!regularCustomer || totalBeforeDiscount == 0) return 0.0;
        double percent = 100 - (getTotal() * 100 / totalBeforeDiscount);
        // округлення до 13 знаків після коми
        percent = Math.round(percent * 1e13) / 1e13;
        return percent;
    }
}


