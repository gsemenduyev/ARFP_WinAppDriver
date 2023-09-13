@RelQa
Feature: Add New Workflow

  Background: Navigate to Workflows page
    * User lands on 'Order Status' page
    * Save current user
    * User hover over on hamburger 'Menu'
    * User clicks on 'Setup button'
    * User lands on 'Setup' page
    * User clicks on 'OneTIMConfiguration dropdown'
    * User clicks on 'Workflows button'
    * User lands on 'Workflows' page

  Scenario: Add New Workflow - Verify New Workflow
    * User clicks on 'New Workflow button' on 'Workflow page'
    * User verifies 'Add Workflow' window pops up
    * User inputs 4 digits long number into 'Add Workflow text box'
    * User clicks on 'Add Workflow "Add" button'
    * User inserts Newly created number into the 'Workflow Name text box'
    * User verifies newly created Workflow is added
    * User verifies 'Workflow Active check mark' is present
    * User clicks on 'Workflow check box'
    * User verifies 'Workflow Tracks form' is present
    * User clicks on 'Workflow Users Tab'
    * User verifies 'Workflow Select Users box' is empty
    * User verifies 'Workflow Created date field' is current date
    * User verifies 'Workflow Created By field' contains current user
    * User chose 2 options under 'Workflow Users Options'
    * User clicks on 'Workflow Users forward button'
    * User verifies 2 options under 'Workflow Selected Users Options' is present
    * User chose 2 options under 'Workflow Selected Users Options'
    * User clicks on 'Workflow Users backward button'
    * User verifies 'Workflow Selected Users Options' is empty