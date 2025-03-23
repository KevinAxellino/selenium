Feature: Buying a Product

  Scenario: User buys a product with quantity 2
    Given User opens the app
    When User selects Sauce Lab Back Packs
    And User selects blue color
    And User sets quantity to 2
    And User adds product to cart
    And User proceeds to checkout
    Then User should see product title "Sauce Lab Back Packs" and total price 59.98
