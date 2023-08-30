Feature: Project

  Scenario Outline: Create new project success
#    Given User is login success
    And Click Add project button
    And Verify Add project button is disabled
    When Enter valid data from from "<SheetName>" and rowNumber <RowNumber> to fields
    And Verify Add project button is enabled
    And Click Add project button
    Then Verify success message is display
    And New project is added successfully

    Examples:
      | SheetName   | RowNumber |
      | Add Project | 0         |