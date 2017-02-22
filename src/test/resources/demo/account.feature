Feature: Accounts

  Scenario: Accounts can be created
    Given the system has no accounts
    When the user adds the following accounts
      | Name       | Balance |
      | Chip Smith | 100.00  |
      | Randy Horn | 200.00  |
      | Zane High  | 300.00  |
    Then the system has the following accounts
      | Name       | Balance |
      | Chip Smith | 100.00  |
      | Randy Horn | 200.00  |
      | Zane High  | 300.00  |
    