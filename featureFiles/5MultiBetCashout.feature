Feature: MultiBet Cashout

Scenario: Cashout from MultiBet
    Given I click on the Sports option MB
    When I click on the Game Category MB-FCout
    When I select one odds MB-FCout
    When I enable the Always Allow odd Changes option MB-FCout
    When I enter the amount MB-FCout
    When I click on the PlaceBet Success button MB-FCout
    When Click on Cashout MB-FCout
    When Click on Full Cashout Btn MB-FCout
    When Click on Confirm Full Cashout Btn MB-FCout
    #When Observe the Full Cashout Successful MB-FCout
    Then I select one odds MB-PCout
    Then I enable the Always Allow odd Changes option MB-PCout
    Then I enter the amount MB-PCout
    Then I click on the PlaceBet Success button MB-PCout
    Then Click on Cashout MB-PCout
    Then Click on Partial Cashout Btn MB-PCout
    Then Click on Confirm Partial Cashout Btn MB-PCout
    #Then Observe the Partial Cashout Successful MB-PCout