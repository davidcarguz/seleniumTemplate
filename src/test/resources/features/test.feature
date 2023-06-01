Feature: Google search

  Scenario: Google search for a word
    When I search for 'Colombia'
    Then I see results include the word 'Colombia'