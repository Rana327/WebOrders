@Complete
Feature: WebOrders Website

Scenario: 1.Create Order
Given Navigate to the application
Then Verify the textbox for the Username, password and login button
When Login using the valid credentials
Then Verify the welcome text with the logged in user
When Navigate to the Orders page
And Enter the quantity as '5'
And Hit the calculate button 
Then Verify the value displayed correctly for the quantity and price
And Click on Reset button and assert that the quantity and total fields are ‘0’
When Enter the address for the order
And Enter a dummy credit card details
And Click Process
Then Verify the confirmation message for order placement
When Navigate to the View all Order
And Verify the order is placed or not
Then Edit the order and change the credit card expiry date as '12/19' and card type as Visa
And Click the update button
Then Verify the presence of the updated order

Scenario: 2.Update Details
Given Navigate to the application
Then Verify the textbox for the Username, password and login button
When Login using the valid credentials
Then Verify the welcome text with the logged in user
When navigate to the list of all orders
Then edit the order zip code and city
And click the update button
And verify the update details correctly displayed or not in view all orders
Then click on logout
And Verify and validating Logout successful or not

Scenario: 3.Verifying View all Products Page
Given Navigate to the application
Then Verify the textbox for the Username, password and login button
When Login using the valid credentials
Then Verify the welcome text with the logged in user
When Navigate to the View all products page
And Verify the value displayed correctly
Then Click on Logout
And Verifying and validating Logout successful or not











