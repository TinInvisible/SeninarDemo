Feature: feature to test edit profile functionally

  #Scenario: Validate editting profile is working
  #Given browser window is open
  #And user is on OrangeHRM, editting profile page
  #When user enters a new name
  #And hits edit
  #Then the name is change
  
  Scenario: Validate editting profile is working
    Given browser window is open
    And user is on OrangeHRM, editting profile page
    When user enters new <FName>, <MName>, <LName>
    And hits edit
    Then the name is change
    
   Examples:
   |FName|MName|LName|
   |A|Van|Nguyen|
   |B|Thi|Tran|
   
