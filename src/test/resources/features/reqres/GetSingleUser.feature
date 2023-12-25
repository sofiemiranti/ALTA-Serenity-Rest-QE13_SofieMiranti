Feature: Get Single User

  #  Scenario 8
  @Tugas
  Scenario Outline: : Get single user with user id
    Given Get single user with user id <id>
    When Send request get single user
    Then Status code should be 200
    And Response body data id was <id>
    And Validate json schema "SingleUserSchema.json"
    Examples:
      | id |
      | 2  |
      | 3  |

  #  Scenario 9
  @Tugas
  Scenario Outline: Get unregistered user
    Given Get unregistered user with user id <id>
    When Send request get unregistered user
    Then Status code should be 404
    Examples:
      | id |
      | 50 |
      | 70 |