Feature: Get Single Resource

  #  Scenario 13
  @Tugas
  Scenario Outline: Get single resource
    Given Get single resource with <id>
    When Send request get single resource
    Then Status code should be 200
    And Response body data id was <id>
    And Validate json schema "SingleResourceSchema.json"
    Examples:
      | id |
      | 1  |
      | 3  |

  #   Scenario 14
  @Tugas
  Scenario Outline: Get single resource not found
    Given Get single resource with <id>
    When Send request get single resource
    Then Status code should be 404
    Examples:
      | id |
      | 23 |
      | 54 |