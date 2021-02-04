Feature: LoginPage feature


Scenario: LoginPage Title
Given user is on the loginpage
When user gets the page title
Then page title should be "Guru99 Bank Home Page"

@Sanity
Scenario: Forgot Link Password On The LoginPage
Given user is on the loginpage
Then forgot link password should be displayed


Scenario: Login with Correct Credentials
Given user is on the loginpage
When user enters the username "mngr303687"
And user enters the password "rUgYpuh"
And user clicks on the login button
Then user gets the page title
And page title should be "Guru99 Bank Manager HomePage"