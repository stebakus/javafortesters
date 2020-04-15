Feature: Groups

    Scenario Outline: Group creation
        Given a set of groups
        When I create a new group with name xxx, header yyy and footer zzz
        Then the new set if groups is equal to the old set with the added group

        Examples:
        | name      | header        | footer        |
        |test name  | test header   | test footer   |