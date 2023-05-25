Feature: Login in Demoblaze

  Scenario: Login in Demoblaze with email and password
    Given I open 'STORE' from 'Demoblaze' page
    When I enter username 'testingSelenium@gmail.com' and password 'testing'
    Then I see the user is logged in