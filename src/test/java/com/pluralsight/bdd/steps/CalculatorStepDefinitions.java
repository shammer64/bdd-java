package com.pluralsight.bdd.steps;

import com.pluralsight.bdd.calculator.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorStepDefinitions {

    private Calculator calculator;
    private int result;

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(int operand1, int operand2) {
        result = calculator.add(operand1, operand2);
    }

    @Then("I should get {int}")
    public void i_should_get(int expectedResult) {
        assertThat(result).isEqualTo(expectedResult);
    }

}
