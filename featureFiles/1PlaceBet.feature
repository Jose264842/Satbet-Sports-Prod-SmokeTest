Feature: Placing bets on a live event

Scenario: Placing a bet with a specific amount
    Given I click on the Sports option PB
    When I click on the Game Category PB-S
    When I select one odds PB-S
    When I enable the Always Allow odd Changes option PB-S
    When I enter the amount PB-S
    When I click on the PlaceBet Success button PB-S
    Then I select one odds PB-M
    Then I enable the Always Allow odd Changes option PB-M
    Then I enter the amount PB-M
    Then I click on the PlaceBet Success button PB-M
    #Then I click on the Live Now option PB-M
    #Then I select one odds PB-M
    #Then I enable the Always Allow odd Changes option PB-M
    #Then I click on the Max PB-M
    #Then I click on the PlaceBet Max button PB-M