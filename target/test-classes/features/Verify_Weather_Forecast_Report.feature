Feature: To verify different functionalities /features in report

  @runSmoke @runRegression
  Scenario Outline: Verify user can see five day weather forecast report. Verify all fields displayed.


    Given I have entered the city as "<City>" to know weather forecast report
    When  I see weather forecast report
    Then  I should be able to see all fields for five days

    Examples:
      |City  |
      |Glasgow|


  @runSmoke @runRegression
  Scenario Outline:Verify user can see three hourly report if user clicks on day

    Given I have entered the city as "<City>" to know weather forecast report
    When  I click on day in row number "<Day Number>"
    Then  I should be able to see three hourly dividation of day report for row "<Day Number>"

    Examples:
      |City   |Day Number|
      |Glasgow|one       |
      |Glasgow|two       |
      |Glasgow|three     |
      |Glasgow|four      |
      |Glasgow|five      |


