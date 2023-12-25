Feature: Get List Resource

  #  Scenario 12
  @Tugas
  Scenario: Get list resource
    Given Get list resource
    When Send request get list resource
    Then Status code should be 200
    And Response body page was 1, per page was 6, total was 12, and total page was 2
    And Validate json schema "ListResourceSchema.json"