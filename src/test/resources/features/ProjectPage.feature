Feature: Project Page

#  Background:  User is login success with valid data
#    Given Input valid data into Email and Password
#    When Click Login button
#    Then Login success and Project page is displayed

  @proj001
  Scenario: Create new project success
    Given Login success and Project page is displayed
    When Click Add project button
    And Verify Add project button is disabled
    And Enter valid data to all fields
    And Verify Add project button is enabled
    And Click Add project button
    Then Verify a success message is displayed
    And New project is added successfully

  @proj002
  Scenario Outline: Verify error message with different character counts at Project Name field
    When Click Add project button
    And Enter Project Name more than <character_count> characters
    Then Verify error message is display
    And Verify Add project button is disabled

    Examples:
      | character_count |
      | 61              |

  @proj003
  Scenario: Verify error message when Project Name is duplicate
    Given Login success and Project page is displayed
    When Retrieves exist project titles
    And Click Add project button
    And Enter Project Name is duplicate
    And Click Add project button
    Then Verify duplicate error message is display
