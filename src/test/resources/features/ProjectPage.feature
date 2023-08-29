Feature: Project
  Scenario: Create new project success
    Given User is login success
    And Click Add project button
    And Verify Add project button is disabled
    When Enter valid data into Project Name
    And Enter valid data into Project Description
    And Enter valid data into Project Purpose
    And Verify Add project button is enabled
    And Click Add project button
    Then Verify success message is display
    And New project is added successfully