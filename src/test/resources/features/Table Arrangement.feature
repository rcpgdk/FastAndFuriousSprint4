
@TRNS-415
Feature:

	Background:
		#@TRNS-410
		 Given the user logged in as "driver"
		 And the "driver" navigates to the "Fleet" and "Vehicles"
		

	#User Story :
	#
	#As a user, I should be able to arrange table data
	#
	#Acceptance Criteria:
	#
	#1-User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
	#2-The value of 'View Per Page' should be '25' by default
	#3-View Per Page' includes the values shown as below and the user can select each of them:
	#
	#->10
	#
	#->25
	#
	#->50
	#
	#->100
	#
	#4-User can sort a column in ascending or descending order by clicking the column name
	#5-User can reset the table by using the reset button
	@TRNS-411
	Scenario: Verify the value of 'View Per Page' should be '25' by default
		And user clicks on "view per page" button
		Then verify the value of view per page should be 25 by default	

	#User Story :
	#
	#As a user, I should be able to arrange table data
	#
	#Acceptance Criteria:
	#
	#1-User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
	#2-The value of 'View Per Page' should be '25' by default
	#3-View Per Page' includes the values shown as below and the user can select each of them:
	#
	#->10
	#
	#->25
	#
	#->50
	#
	#->100
	#
	#4-User can sort a column in ascending or descending order by clicking the column name
	#5-User can reset the table by using the reset button
	@TRNS-412
	Scenario: Verify reset button function
		  And user clicks any column name
		When the user clicks on reset button
		Then Verify user can reset the table	

	#User Story : 
	#
	#As a user, I should be able to arrange table data
	#
	# 
	#
	#Acceptance Criteria:
	#
	#1-User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
	#2-The value of 'View Per Page' should be '25' by default
	#3-View Per Page' includes the values shown as below and the user can select each of them:
	#
	#   ->10
	#
	#   ->25
	#
	#   ->50
	#
	#   ->100
	#
	#4-User can sort a column in ascending or descending order by clicking the column name
	#5-User can reset the table by using the reset button 
	@TRNS-413
	Scenario Outline: Verify user can select record number
		And verify the user can select each of "<value>" below
		Examples:
		|value|
		|10   |
		|25   |
		|50   |
		|100  |	

	#User Story : 
	#
	#As a user, I should be able to arrange table data
	#
	# 
	#
	#Acceptance Criteria:
	#
	#1-User can arrange rows/vehicle numbers to be displayed by clicking on 'View Per Page' button under Fleet-Vehicles module
	#2-The value of 'View Per Page' should be '25' by default
	#3-View Per Page' includes the values shown as below and the user can select each of them:
	#
	#   ->10
	#
	#   ->25
	#
	#   ->50
	#
	#   ->100
	#
	#4-User can sort a column in ascending or descending order by clicking the column name
	#5-User can reset the table by using the reset button 
	@TRNS-414
	Scenario: Verify"view per page"button
		  Then verify user can arrange displayed row numbers
		