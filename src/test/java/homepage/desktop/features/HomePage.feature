@homepage
Feature: homepage Test

   @P0Case
    Scenario: Guest users come to HomePage and visit to App Store page
    When  I go to HomePage
    And I click on Save Moreon App button
    Then I see pop up is display
    And I click on App Store icon
    Then I should land on App Store Page


  Scenario: Guest users come to HomePage and visit to Google Play page
    When  I go to HomePage
    And I click on Save Moreon App button
    Then I see pop up is display
    And I click on Google Play icon
    Then I should land on Google Play Page
  
  Scenario: Guest users come to HomePage and visit to App page
    When  I go to HomePage
    And I click on Save Moreon App button
    Then I see pop up is display
    And I click on App link
    Then I should land on App Page