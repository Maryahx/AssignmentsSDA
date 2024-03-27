
#/*
#go to url : https://ecommerce-playground.lambdatest.io/index.php?route=account/register
#register account test with fluent page object approach
#*/

Feature: Register an account in Lambdatest playground site test

  Background:
    Given The browser is open

  Scenario: Register new account
    When I navigate to LambdatestPlayground site
    And I enter my registration info "Maria", "Saeed", "<email>", "1234567890", "password123"
    Then I should be registered successfully

