Feature: Project Page

#  Background:  User is login success with valid data
#    Given Input valid data into Email and Password
#    When Click Login button
#    Then Login success and Project page is displayed

  @proj001
  Scenario: Verify user is able to create a project successfully with valid data
    Given Login is successful and Project page is displayed
    When Click Add project button
    And Verify Add project button is disabled
    And Enter valid data to all fields
    And Verify Add project button is enabled
    And Click Add project button
    Then Verify a successful message is displayed
    And New project is added successfully

  @proj002
  Scenario Outline: Verify the error message is displayed when Project Name exceeds the maximum character limit
    When Click Add project button
    And Enter Project Name more than <character_count> characters
    Then Verify error message is displayed
    And Verify Add project button is disabled

    Examples:
      | character_count |
      | 61              |

  @proj003
  Scenario: Verify the error message is displayed when user enters Project Name is duplicated
    Given Login is successful and Project page is displayed
    When Retrieves exist project titles
    And Click Add project button
    And Enter Project Name is duplicated
    And Click Add project button
    Then Verify duplicated error message is displayed

  @proj004
  Scenario: Verify user is able to edit project successfully
    Given New project is added successfully
    When Click Edit button
    And Enter valid data to all fields
    And Click Save Project button
    Then Verify project is edited successfully

  @proj005
  Scenario: Verify is able to delete project successfully
    Given New project is added successfully
    When Click Delete icon
    And Click Confirm button in confirm popup
    Then Verify successful message is displayed
    And Project is deleted successful

  @proj006
  Scenario: Verify user is able to add requirement successfully
    Given New project is added successfully
    When Click View button
    And Click Add Requirement button