Feature: This feature will test ClickUp API

Scenario: Create new folder, list and task, and delete the task
  Given I create new folder and I check the folder name
  When I create list
  And I check the list name is "Test List"
  Then I create task
  And I check the task name is "Test Task"
  Then I remove the task "Test Task"
  And I check task with name "Test Task" can't be found