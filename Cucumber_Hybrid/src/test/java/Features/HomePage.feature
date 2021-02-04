Feature: HomePage Feature

Background:
Given User has logged in to application
|username   |password|
|mngr303687  |rUgYpuh|


# below is the example of "EXAMPLE TABLE" by using this we can run our scenario for multiple set
# of test data

@Customer
Scenario Outline: Add Customer
When user clicks on the New Customer tab.
And Enters the Customer Details
|customer name|address|city|state|pin|mobile number|e-mail|password|
|<c>            |<a>      |<ci>  |<s>    |<p>  |<m>            |<e>     |<pw>      |
And Clicks on the submit
Then Cutsomer should register successfully with message "Customer Registered Successfully!!!"

Examples:
|c     |a    |ci |s        |p     |m         |e             |pw          |
|asasao|bnglr|BNG|karnataka|560021|8789652679|ertww@mail.com|Samastha@009|



Scenario Outline: Add Account
When user click on the New Account tab
And Enters the Account details
|customer id|Account type|Deposit|
|<C>|<A>|<D>|
And Clicks on the submit button
Then Account get genrated successfully with message "Account Generated Successfully!!!"
And Capture the Account id

Examples:
|C    |A      |D   |
|37810|Savings|1000|
|59370|Current|1000|
