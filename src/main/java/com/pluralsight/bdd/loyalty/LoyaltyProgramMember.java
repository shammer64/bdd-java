package com.pluralsight.bdd.loyalty;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LoyaltyProgramMember {
    private final String name;
    private final LoyaltyCardProgram cardProgram;
    private List<OrderItem> order = new ArrayList<>();

    public LoyaltyProgramMember(String name, LoyaltyCardProgram cardProgram) {
        this.name = name;
        this.cardProgram = cardProgram;
    }

    public void orders(OrderItem item) {
        this.order.add(item);
    }

    public int getPointsForOrder() {
        int points = order.stream()
                .map(orderItem -> Integer.valueOf(cardProgram.getPointValueForOrderItem(orderItem)))
                .collect(Collectors.summingInt(Integer::intValue));
        return points;
    }
}
