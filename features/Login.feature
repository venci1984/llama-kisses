Feature: Login into the application

  In order to login
  As a user
  I want to have a login form

  Scenario: Login with invalid credentials
  Given that I am a registered user
  And I am entering invalid credentials in the login form
  When I am trying to login into the application
  Then I should get warning message "Invalid username or password!"

  Scenario: Login as an unregistered user
  Given that I am an unregistered user
  When I am trying to login into the application
  Then I should get warning message "Invalid username or password!"

  Scenario: Login as a registered user
  Given that I am a registered user
  And I am entering my valid credentials in the login form
  When I am trying to login into the application
  Then I should be allowed to use the functionalities of the application

  Scenario: Logout
  Given that I am logged into the application
  When I press the "Log Out" button
  Then I should be redirected to the home page of the application and see
       the message "You've been logged out successfully."
