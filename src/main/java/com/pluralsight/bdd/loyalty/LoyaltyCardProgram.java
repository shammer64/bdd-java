package com.pluralsight.bdd.loyalty;

import java.util.HashMap;
import java.util.Map;

public class LoyaltyCardProgram {
    private final Map<String, String> drinkCategoryMap = new HashMap<>();
    private final Map<String, Integer> categoryPointsMap = new HashMap<>();

    public LoyaltyCardProgram() {
        super();
    }

    public void addMenuItem(MenuItem menuItem) {
        drinkCategoryMap.put(menuItem.drink, menuItem.category);
        categoryPointsMap.put(menuItem.category, menuItem.points);
    }

    public int getPointValueForOrderItem(OrderItem orderItem) {
        return orderItem.quantity * getPointValueForDrink(orderItem.drink);
    }

    private int getPointValueForDrink(String drink) {
        String category = getCategoryFor(drink);
        return getPointsForCategory(category);
    }

    private int getPointsForCategory(String category) {
        return (int) categoryPointsMap.getOrDefault(category, 0);
    }

    private String getCategoryFor(String drink) {
        return drinkCategoryMap.get(drink);
    }
}
