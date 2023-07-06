Feature: Login in Demoblaze

  Scenario: Login in Demoblaze with email and password
    Given I open 'STORE' from 'Demoblaze' page
    When I enter username 'testingSelenium@gmail.com' and password 'testing'
    Then I see the user is logged in

  Scenario: Login in Demoblaze with email and password wrong
    Given I open 'STORE' from 'Demoblaze' page
    When I enter username 'tSelenium@gmail.com' and password 'testin'
    Then I see an alert with the message 'User does not exist.'

  Scenario: Login in Demoblaze without email and password
    Given I open 'STORE' from 'Demoblaze' page
    When I enter username '' and password ''
    Then I see an alert with the message 'Please fill out Username and Password.'