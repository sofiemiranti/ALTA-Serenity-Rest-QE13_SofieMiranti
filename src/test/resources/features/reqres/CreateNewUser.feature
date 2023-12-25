Feature: Create New User

  #  Scenario 10
  @Tugas
  Scenario: Create new user with blank name
    Given Post create user with json "CreateUserWithBlankName.json"
    When Send request post create user
    Then Status code should be 400

  #  Scenario 11
  @Tugas
  Scenario: Create new user with blank job
    Given Post create user with json "CreateUserWithBlankJob.json"
    When Send request post create user
    Then Status code should be 400