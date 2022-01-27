package com.pluralsight.bdd.loyalty;

import java.util.HashMap;
import java.util.Map;

public class LoyaltyCardProgram {
    private final Map<String, String> drinkCategoryMap = new HashMap<>();
    private final Map<String, Integer> categoryPointsMap = new HashMap<>();

    public LoyaltyCardProgram() {
    }

    public void addMenuItem(String drink, String category, Integer points) {
        drinkCategoryMap.put(drink, category);
        categoryPointsMap.put(category, points);
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
