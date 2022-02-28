package com.pluralsight.bdd.loyalty;

public class MenuItem {
    public Integer points;
    public String category;
    public String drink;

    public MenuItem(String drink, String category, Integer points) {
        this.drink = drink;
        this.category = category;
        this.points = points;
    }
}
