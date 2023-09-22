Feature: SingleBet Cashout

Scenario: Cashout from SingleBet
    Given I click on the Sports option SB
    When I click on the Game Category SB-FCout
    When I select one odds SB-FCout
    When I enable the Always Allow odd Changes option SB-FCout
    When I enter the amount SB-FCout
    When I click on the PlaceBet Success button SB-FCout
    When Click on Cashout SB-FCout
    When Click on Full Cashout Btn SB-FCout
    When Click on Confirm Full Cashout Btn SB-FCout
    #When Observe the Full Cashout Successful SB-FCout
    Then I select one odds SB-PCout
    Then I enable the Always Allow odd Changes option SB-PCout
    Then I enter the amount SB-PCout
    Then I click on the PlaceBet Success button SB-PCout
    Then Click on Cashout SB-PCout
    Then Click on Partial Cashout Btn SB-PCout
    Then Click on Confirm Partial Cashout Btn SB-PCout
    #Then Observe the Partial Cashout Successful SB-PCout