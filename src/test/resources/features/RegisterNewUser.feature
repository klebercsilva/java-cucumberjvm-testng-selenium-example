Feature: Register New User
  [As a user] I want to Register New Users

  @RegisterNewUser
  Scenario Outline: Register a new user
    Given I want to register a new user
    When I fill in firstName with "<first_name>"
    And I fill in lastName with "<last_name>"
    And I select "Single" as a "<marital_status>"
    And I select "Cricket" as a "<hobby>"
    And I fill in country with "<country>"
    And I fill in birthday with "<birthday>"
    And I fill in phoneNumber with "<phone_number>"
    And I fill in username with "<username>"
    And I fill in password with "<password"
    And I fill in confirmPassword with "<password>"
    And I fill in email with "<email>"
    And I fill in profilePicture with "<profile_picture>"
    And I fill in description with "<description>"
   Then I press the submit button and register a new user

    Examples:
      | first_name | last_name | marital_status | hobby   | country       | birthday   | phone_number | username | password | email              | profile_picture        | description                       |
      | John       | Snow      | Married        | Reading | United States | 05/01/1992 | 12496547890  | johnsnow | john_123 | johnsnow@gmail.com | /Users/Public/logo.png | Just a Game of Thrones character. |