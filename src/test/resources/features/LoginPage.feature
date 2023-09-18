Feature: Login Page

  @log001
  Scenario Outline: Verify the error message is displayed when user enters incorrect email or password
    Given User is at login screen
    When Input invalid data into Email and Password from sheetName "<SheetName>" and rowNumber <RowNumber>
    And Click Login button
    Then Verify the error message is displayed from sheetName "<SheetName>" and rowNumber <RowNumber>

    Examples:
      | SheetName | RowNumber |
      | Login     | 0         |
      | Login     | 1         |
      | Login     | 2         |
      | Login     | 3         |
      | Login     | 4         |

  @log002
  Scenario: Verify user is able to login successfully with valid data
    Given Input valid data into Email and Password
    When Click Login button
    Then Login is successful and Project page is displayed
