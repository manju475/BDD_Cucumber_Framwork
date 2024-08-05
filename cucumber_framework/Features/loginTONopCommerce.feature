Feature: Login

Scenario: Successful Login with Valid Credentials
	Given User launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "admin@yourstore.com" and Password as "admin"
	And Click on Login
	Then Validate the page title as "Dashboard / nopCommerce administration"
	When Click on the logout link
	Then Page title should be "Your store. Login"
	And Close the browser
	
	
	
Scenario Outline: Login data-driven 
	Given User launch Chrome browser
	When User opens URL "https://admin-demo.nopcommerce.com/login"
	And User enters Email as "<email>" and Password as "<password>"
	And Click on Login
	Then Validate the page title as "Dashboard / nopCommerce administration"
	When Click on the logout link
	Then Page title should be "Your store. Login"
	And Close the browser
	
	Examples:
	|email | password |
	|admin@yourstore.com | admin |
	|adminnn@yourstore.com | admin |
	