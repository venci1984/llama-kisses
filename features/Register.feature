Feature: Register a new user

  In order to use the functionalities of the application
  as a user
  I want to go through registration process and get authorized to login

  Scenario: Register a new user successfully
  Given I am on the registration page
  When  I have entered my desired email "test@mail.com" and my password "abc123"
  And   I have confirmed my password "abc123"
  And   I have entered my name "Test Person"
  Then  I should get confirmation message "You've registered successfully."

  Scenario: Try to register a user with taken mail
  Given I am on the registration page
  When  I have entered an email that is already taken "venci@mail.bg" and my password "abc123"
  And   I have confirmed my password "abc123"
  And   I have entered my name "Test Person"
  Then  I should get warning message "Email already taken"

  Scenario: Try to register with password mismatch
  When  I have entered my desired email "test@mail.com" and my password "abc123"
  And   I have mistaken the confirmation password "abc1234"
  And   I have entered my name "Test Person"
  Then  I should get warning message "Password didn't match"

  Scenario: Try to register using no credentials at all
  Given I am on the registration page and I haven't entered any credentials at all
  When  I click on the Sign up button
  Then  I should get warning messages that tell me to fill all required fields
