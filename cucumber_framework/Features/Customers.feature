Feature: Customer

Background:
	Given User launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view dashboard

@CreateUser
Scenario: Add a new Customer
	When User clicks on Customers menu
	And Click on Customers menu item
	And Click on add new button
	Then User can view add new customer page
	When User enter customer info
	And Click on save button
	Then User can view confirmation message "The new customer has been added successfully"
	And Close the browser
	
	
Scenario: Search customer by using emailID
	Given User launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then User can view dashboard
	When User clicks on Customers menu
	And Click on Customers menu item
	And Enter customer Email
	When Click on search button 
	Then User should found Email in the search table
	And Close the browser
	
	
	
	