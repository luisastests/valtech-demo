Feature: Valtech Demo

  Background: User is logged in
    Given User opens the browser on EshopOnWeb Homepage
    And User clicks on login button
    When User submits username and password
    Then User should be logged in

  Scenario: User buys an item
    Given User adds an item to the basket
    When User clicks on checkout button
    And User fills the checkout details page
    Then User should finish the order