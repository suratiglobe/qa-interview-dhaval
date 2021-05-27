@smokeTest
Feature: Rap Name generator
  As a user, I want to generate my rap name

  Background:
    Given I am on My Rap Name homePage
    And I see Input Fields

  Scenario: User views error when try to generate rap name without entering fist name

    When I click Suggest Male Rap Name
    Then I should see error 'You must enter your first name.'
    When I click Suggest Female Rap Name
    Then I should see error 'You must enter your first name.'
    When I enter my last initial 'S'
    And I click Suggest Male Rap Name
    Then I should see error 'You must enter your first name.'

  Scenario Outline: User views error when try to generate rap name with invalid name

    When I enter my first name '<FirstName>'
    And I click Suggest Male Rap Name
    Then I should see error 'You must enter your first name.'

    Examples:
      | FirstName    |
      | 1242546547   |
      | {}:>}        |
      | @@**         |
      | Dhaval@#$%^& |

  Scenario Outline: User can generate Rap Name with only first name

    When I enter my first name '<FirstName>'
    And I unselect nick name
    And I click <RapNameType>
    Then I should see my Rap name

    Examples:
      | FirstName | RapNameType             |
      | Jeremy    | Suggest Male Rap Name   |
      | Ashley    | Suggest Female Rap Name |
      | Matthew   | Suggest Male Rap Name   |

  Scenario: User views New Rap Name when select nick name and submit name for male

    When I enter my first name 'Dhaval'
    And I unselect nick name
    And I click Suggest Male Rap Name
    Then I should see my Rap name
    When I select nick name
    And I click Suggest Male Rap Name
    Then I should see new Rap name prepended

  Scenario: User views New Rap Name each time when submit name for female with last initial

    When I enter my first name 'Mariela'
    And I enter my last initial 'S'
    And I click Suggest Female Rap Name
    Then I should see my Rap name
    When I click Suggest Female Rap Name
    Then I should see new Rap name prepended
    When I click Suggest Female Rap Name
    Then I should see new Rap name prepended
    When I click Suggest Female Rap Name
    Then I should see new Rap name prepended
    When I click Suggest Female Rap Name
    Then I should see new Rap name prepended




