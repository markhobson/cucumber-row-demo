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
    
  Scenario: Current and savings accounts can be created
    Given the system has no accounts
    When the user adds the following accounts
      | Name       | Type    |
      | Chip Smith | CURRENT |
      | Randy Horn | SAVINGS |
    Then the system has the following accounts
      | Name       | Type    |
      | Chip Smith | CURRENT |
      | Randy Horn | SAVINGS |

  Scenario: Accounts have an opened date
    Given the system has no accounts
    When the user adds the following accounts
      | Name       |
      | Chip Smith |
    Then the system has the following accounts
      | Name       | Opened  |
      | Chip Smith | [today] |
