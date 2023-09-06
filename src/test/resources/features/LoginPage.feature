Feature: Login Page

  @log001
  Scenario Outline: Check validation for Email and Password fields
    Given Input data into Email and Password from sheetName "<SheetName>" and rowNumber <RowNumber>
    When Click Login button
    Then Verify validation message from sheetName "<SheetName>" and rowNumber <RowNumber>

    Examples:
      | SheetName | RowNumber |
      | Login     | 0         |
      | Login     | 1         |
      | Login     | 2         |
      | Login     | 3         |
      | Login     | 4         |

  @log002
  Scenario: User is login success with valid data
    Given Input valid data into Email and Password
    When Click Login button
    Then Login success and Project page is displayed
