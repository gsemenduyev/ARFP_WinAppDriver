
Feature: Read from data tables

Scenario Outline: Demonstrate table example
* User enter "<email>"
* User set "<password>"
* User enter "<email>" and "<password>"
Examples:
| email       | password |
| 1@gmail.com | 1111     |
| 2@gmail.com | 2222     |

Scenario: Demonstrate table example part 2
* User enter tex in the search bar
| 1@gmail.com |
| 2@gmail.com |