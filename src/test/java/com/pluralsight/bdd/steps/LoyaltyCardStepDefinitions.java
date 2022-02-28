package com.pluralsight.bdd.steps;

import com.pluralsight.bdd.loyalty.LoyaltyCardProgram;
import com.pluralsight.bdd.loyalty.LoyaltyProgramMember;
import com.pluralsight.bdd.loyalty.MenuItem;
import com.pluralsight.bdd.loyalty.OrderItem;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class LoyaltyCardStepDefinitions {

    private final LoyaltyCardContext loyaltyCardContext;

    public LoyaltyCardStepDefinitions(LoyaltyCardContext loyaltyCardContext) {
        this.loyaltyCardContext = loyaltyCardContext;
    }

    @Given("the following drink categories:")
    public void the_following_drink_categories(List<Map<String, String>> drinkCategoryInfo) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        if (loyaltyCardContext.cardProgram == null) {
            loyaltyCardContext.cardProgram = new LoyaltyCardProgram();
            drinkCategoryInfo.stream().forEach(
                    drinkCategory -> {
                        String drink = drinkCategory.get("Drink");
                        String category = drinkCategory.get("Category");
                        Integer points = Integer.parseInt(drinkCategory.get("Points"));
                        MenuItem menuItem = new MenuItem(drink, category, points);
                        loyaltyCardContext.cardProgram.addMenuItem(menuItem);
                    }
            );
        }
    }

    @Given("^(.*) is a member")
    public void michael_is_a_member(String name) {
        loyaltyCardContext.member = new LoyaltyProgramMember(name, loyaltyCardContext.cardProgram);
    }

    @Then("^s?he should earn (\\d+) points")
    public void he_should_earn_points(Integer expectedPoints) {
        assertThat(loyaltyCardContext.member.getPointsForOrder()).isEqualTo(expectedPoints);
    }

    @When("^(.*) purchases (\\d+) (.*) drinks?")
    public void michael_purchases_drinks(String name, Integer quantity, String drink) {
        loyaltyCardContext.member.orders(new OrderItem(drink, quantity));
    }

    @When("^(.*) purchases the following drinks")
    public void tina_purchases_the_following_drinks(String name, Map<String, Integer> orderItems) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        orderItems.forEach((drink, quantity) -> {
            loyaltyCardContext.member.orders(new OrderItem(drink, quantity));
        });
    }

}
