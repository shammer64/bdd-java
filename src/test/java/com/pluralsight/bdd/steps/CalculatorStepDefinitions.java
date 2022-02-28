package com.pluralsight.bdd.steps;

import com.pluralsight.bdd.calculator.Calculator;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorStepDefinitions {

    private final CalculatorContext calculatorContext;

    public CalculatorStepDefinitions(CalculatorContext calculatorContext) {
        this.calculatorContext = calculatorContext;
    }

    @Given("I have a calculator")
    public void i_have_a_calculator() {
        calculatorContext.calculator = new Calculator();
    }

    @When("I add {int} and {int}")
    public void i_add_and(int operand1, int operand2) {
        calculatorContext.result = calculatorContext.calculator.add(operand1, operand2);
    }

    @Then("I should get {int}")
    public void i_should_get(int expectedResult) {
        assertThat(calculatorContext.result).isEqualTo(expectedResult);
    }

}
