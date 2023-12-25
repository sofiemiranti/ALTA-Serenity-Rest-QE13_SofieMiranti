Feature: Login User

  #  Scenario 23
  @Tugas
  Scenario Outline: Login user with valid email and password
    Given Login user with json "<json>"
    When Send request post to login user
    Then Status code should be 200
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                 | jsonSchema                     |
      | LoginUserValidEmail.json | LoginUserSuccessfulSchema.json |

  #  Scenario 24
  @Tugas
  Scenario Outline: Login user with valid email and wrong password
    Given Login user with json "<json>"
    When Send request post to login user
    Then Status code should be 401
    And Response body error was "wrong password"
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                        | jsonSchema                       |
      | LoginUserWrongPassword.json | LoginUserUnsuccessfulSchema.json |

  #  Scenario 25
  @Tugas
  Scenario Outline: Login user with invalid email and password
    Given Login user with json "<json>"
    When Send request post to login user
    Then Status code should be 400
    And Response body error was "user not found"
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                       | jsonSchema                       |
      | LoginUserInvalidEmail.json | LoginUserUnsuccessfulSchema.json |

  #  Scenario 26
  @Tugas
  Scenario Outline: Login user with blank email
    Given Login user with json "<json>"
    When Send request post to login user
    Then Status code should be 400
    And Response body error was "Missing email or username"
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                     | jsonSchema                       |
      | LoginUserBlankEmail.json | LoginUserUnsuccessfulSchema.json |

  #  Scenario 27
  @Tugas
  Scenario Outline: Login user with blank password
    Given Login user with json "<json>"
    When Send request post to login user
    Then Status code should be 400
    And Response body error was "Missing password"
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                        | jsonSchema                       |
      | LoginUserBlankPassword.json | LoginUserUnsuccessfulSchema.json |

  #  Scenario 28
  @Tugas
  Scenario Outline: Login user with blank email and blank password
    Given Login user with json "<json>"
    When Send request post to login user
    Then Status code should be 400
    And Response body error was "Missing email or username"
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                                | jsonSchema                       |
      | LoginUserBlankEmailAndPassword.json | LoginUserUnsuccessfulSchema.json |
