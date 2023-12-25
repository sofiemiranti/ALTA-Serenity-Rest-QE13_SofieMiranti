Feature: Serenity Rest QE 13

  #    Scenario 1
  @Latihan
  Scenario Outline: Get list user with valid page parameter
    Given Get list users with page parameter <page>
    When Send request get list users with page parameter
    Then Status code should be 200
    And Response body page should be <page>
    And Validate json schema "ListUsersSchema.json"
    Examples:
      | page |
      | 1    |
      | 2    |

  #    Scenario 2
  @Latihan
  Scenario: Post create user with valid json
    Given Post create user with valid json "CreateUser.json"
    When Send request post create user
    Then Status code should be 201
    And Response body name was "Sofie Miranti" and job was "QA Engineer"
    And Validate json schema "CreateUserSchema.json"

  #    Scenario 3
  @Latihan
  Scenario Outline: Update user with valid id and json
    Given Update user with valid id <id> and json "<json>"
    When Send request update user
    Then Status code should be 200
    And Response body name was "<name>" and job was "<job>"
    And Validate json schema "UpdateUserSchema.json"
    Examples:
      | id | json             | name                 | job                |
      | 1  | UpdateUser.json  | Sofie Miranti Edit   | QA Engineer Edit   |
      | 2  | UpdateUser2.json | Sofie Miranti Edit 2 | QA Engineer Edit 2 |

  #    Scenario 4
  @Latihan
  Scenario Outline: Delete user with valid id
    Given Delete user with valid id <id>
    When Send request delete user
    Then Status code should be 204
    Examples:
      | id |
      | 1  |
      | 2  |