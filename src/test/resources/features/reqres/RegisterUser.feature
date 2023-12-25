Feature: Register User

  #  Scenario 17
  @Tugas
  Scenario Outline: Register user with valid email and password
    Given Post register user with json "<json>"
    When Send request post register user
    Then Status code should be 200
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                   | jsonSchema                   |
      | RegisterUserValid.json | RegisterUserValidSchema.json |

  #  Scenario 18
  @Tugas
  Scenario Outline: Register user with invalid email and password
    Given Post register user with json "<json>"
    When Send request post register user
    Then Status code should be 400
    And Response body error was "Note: Only defined users succeed registration"
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                          | jsonSchema                          |
      | RegisterUserInvalidEmail.json | RegisterUserUnsuccessfulSchema.json |

  #  Scenario 19
  @Tugas
  Scenario Outline: Register user with blank email
    Given Post register user with json "<json>"
    When Send request post register user
    Then Status code should be 400
    And Response body error was "Missing email or username"
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                        | jsonSchema                          |
      | RegisterUserBlankEmail.json | RegisterUserUnsuccessfulSchema.json |

  #  Scenario 20
  @Tugas
  Scenario Outline: Register user with blank password
    Given Post register user with json "<json>"
    When Send request post register user
    Then Status code should be 400
    And Validate json schema "<jsonSchema>"
    And Response body error was "Missing password"
    Examples:
      | json                           | jsonSchema                          |
      | RegisterUserBlankPassword.json | RegisterUserUnsuccessfulSchema.json |

  #  Scenario 21
  @Tugas
  Scenario Outline: Register user with email has been registered before
    Given Post register user with json "<json>"
    When Send request post register user
    Then Status code should be 409
    Examples:
      | json                                    |
      | RegisterUserEmailHasBeenRegistered.json |

  #  Scenario 22
  @Tugas
  Scenario Outline: Register user with blank email and blank password
    Given Post register user with json "<json>"
    When Send request post register user
    Then Status code should be 400
    And Response body error was "Missing email or username"
    And Validate json schema "<jsonSchema>"
    Examples:
      | json                                   | jsonSchema                          |
      | RegisterUserBlankEmailAndPassword.json | RegisterUserUnsuccessfulSchema.json |
