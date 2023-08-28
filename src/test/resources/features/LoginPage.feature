Feature: Login

  Scenario Outline: Check validation for Email and Password fields
    Given Input data into Email and Password from "<SheetName>" and rowNumber <RowNumber>
    When Click Login button
    Then Verify validation message

    Examples:
      | SheetName | RowNumber |
      | Login     | 0         |
      | Login     | 1         |
      | Login     | 2         |
      | Login     | 3         |
      | Login     | 4         |
      | Login     | 5         |