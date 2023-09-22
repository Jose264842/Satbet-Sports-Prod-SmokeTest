Feature: Live Count and Game Status
Scenario: Live Count Validation and Game Status 
Given I click on the Sports option LcS
When I Verify the Available Games equal to Game Count LcS
Then I select one odds LcS
Then I enable the Always Allow odd Changes option LcS
Then I enter the amount LcS
Then I click on the PlaceBet Success button LcS
Then I click on Bet History LcS
Then I Verify the Status LcS
