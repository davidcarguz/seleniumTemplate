Feature: Google search

  Scenario: Google search for a word
    When I search for 'Colombia'
    Then I see results include the word 'Colombia'

  Scenario: Google search for another word
    When I search for 'Argentina'
    Then I see results include the word 'Argentina'
