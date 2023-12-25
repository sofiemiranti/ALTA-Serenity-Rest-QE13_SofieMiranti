Feature: Get List Users

  #  Scenario 5
  @Tugas
  Scenario: Get list users without parameter
    Given Get list users without parameter
    When Send request get list users without parameter
    Then Status code should be 200
    And Response body page should be 1
    And Validate json schema "ListUsersSchema.json"

  #  Scenario 6
  @Tugas
  Scenario: Get list users with invalid parameter
    Given Get list users with invalid parameter
    When Send request get list users with invalid parameter
    Then Status code should be 404

  #  Scenario 7
  @Tugas
  Scenario Outline: Get list users with page and per page parameter
    Given Get list users with page parameter <page> and per page parameter <per_page>
    When Send request get list users with page and per page parameter
    Then Status code should be 200
    And Response body page was <page> and per page was <per_page>
    And Response body data has amount was <per_page>
    And Validate json schema "<jsonSchema>"
    Examples:
      | page | per_page | jsonSchema                                    |
      | 2    | 3        | ListUsersWithPage2AndPerPage3ParamSchema.json |
      | 4    | 2        | ListUsersWithPage4AndPerPage2ParamSchema.json |