#Author: Kleber Silva
Feature: Register new user
  I want to use this template to register a new user

  @RegisterNewUser
  Scenario: Register a new user
   Given I want to register a new user
   When I fill in firstName with 'John'
    And I fill in lastName with 'Snow'
    And I select 'Single' as a marital_status
    And I select 'Cricket' as a hobby
    And I fill in country with 'United States'
    And I fill in birthday with '05/01/1992'
    And I fill in phoneNumber with '12496547890'
    And I fill in username with 'johnsnow'
    And I fill in password with 'john_123'
    And I fill in confirmPassword with 'john_123'
    And I fill in email with 'johnsnow@gmail.com'
    And I fill in profilePicture with 'C:\\Users\\Public\\logo.png'
    And I fill in description with 'Just a Game of Thrones character.'
   Then I press the submit button and register a new user