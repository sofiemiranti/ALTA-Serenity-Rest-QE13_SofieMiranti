Feature: Modify User

  #  Scenario 15
  @Tugas
  Scenario Outline: Modify user job
    Given Modify user with id <id> and valid json "<json>"
    When Send request patch to modify
    Then Status code should be 200
    And Response body job was "<editJob>"
    And Validate json schema "<jsonSchema>"
    Examples:
      | id | json               | editJob | jsonSchema               |
      | 1  | ModifyUserJob.json | QA Lead | ModifyUserJobSchema.json |

  #  Scenario 16
  @Tugas
  Scenario Outline: Modify user name
    Given Modify user with id <id> and valid json "<json>"
    When Send request patch to modify
    Then Status code should be 200
    And Response body name was "<editName>"
    And Validate json schema "<jsonSchema>"
    Examples:
      | id | json                | editName | jsonSchema                |
      | 1  | ModifyUserName.json | Sophie   | ModifyUserNameSchema.json |