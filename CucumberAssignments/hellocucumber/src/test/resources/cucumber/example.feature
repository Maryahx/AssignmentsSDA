
#/*
#go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
#register account test with fluent page object approach
#*/

Feature: Register an account in Lambdataset playground site test

  Scenario: Register new account
    Given The browser is open
    When I enter my registration info
    And I subscribe to newsletter
    And I agree to the privacy policy
    And I click on the register button
    Then I should be registered successfully
