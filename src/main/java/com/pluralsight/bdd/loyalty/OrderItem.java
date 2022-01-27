package com.pluralsight.bdd.loyalty;

public class OrderItem {
    protected final String drink;
    protected final Integer quantity;

    public OrderItem(String drink, Integer quantity) {
        this.drink = drink;
        this.quantity = quantity;
    }

    public String getDrink() {
        return drink;
    }
}
