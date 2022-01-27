Feature: Loyalty Card

  THE MORE YOU BUY, THE MORE YOU EARN!

  Background:
    Given the following drink categories:
      | Drink        | Category | Points |
      | Banana       | Regular  | 15     |
      | Triple Berry | Fancy    | 20     |
      | Earl Grey    | Tea      | 10     |

  Scenario Outline: Earning points on purchases
    Given Michael is a member
    When Michael purchases <Quantity> <Drink> drinks
    Then he should earn <Points> points
    Examples:
      | Drink        | Quantity | Points |
      | Banana       | 2        | 30     |
      | Triple Berry | 1        | 20     |
      | Earl Grey    | 3        | 30     |

  Scenario: Purchase multiple drinks
    Given Tina is a member
    When Tina purchases the following drinks
      | Banana       | 1 |
      | Earl Grey    | 2 |
      | Triple Berry | 1 |
    Then she should earn 55 points