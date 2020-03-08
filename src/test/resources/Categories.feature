@categories
Feature: scenarios to validate categories API functionality

  Scenario Outline: validate categories API
    When user sends a request to categories with given <queryParams>
    Then user validates response with parameters <name>, <CanRelist>, <promotionName>, <description>

    Examples: 
      | queryParams     | name           | CanRelist | promotionName | description     |
      | catalogue=false | Carbon credits | true      | Gallery       | 2x larger image |
