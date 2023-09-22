Feature: Favourite

Scenario: Adding and Deleting Matches Favourite
    Given I click On the Sports option Fav
    Then I Select One Match To Favaurite Fav
    Then I Click On The Favourite Fav1
    Then I Observe Match Availablity Fav
    Then I Click On Live Now Fav
    Then I Un-Select Match Which Added To Favourite Fav
    Then I Again click On The Favourite Fav2
    Then I Observe Match Un-Availablity Fav