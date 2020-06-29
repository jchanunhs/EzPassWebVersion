# EzPassSpring
Web-based version of the EzPassApplication and was created using Spring MVC and Java EE 7 Web.

- error.jsp is displayed when user enters invalid url.
- Home controller contains request mappings of the webpages that don't have forms
- The other controllers handle form submissions and redirects users to back to their respective webpage with a success/fail message. 
- Users will be redirected to the index page if they try to access other pages without logging in yet. 

There are 5 URLs in the sidebar

Main
- Displays customer profile.
- Users will be able to recharge their account, change password and log off.

Vehicle.
- Displays a list of vehicles.
- Users can add/remove a vehicle.

EzTag
- Displays a list of EzTags.
- User can add tag and remove tag.
Note: If the tag is currently linked to a vehicle or has been used to pay tolls, they will not be able to remove it. They can choose not to use the tag anymore and add a new tag.

Pay Tolls
- A form page for user to pay tolls.

Transactions
- Users can view all their transactions from paying tolls.
- They can also enter specific date ranges to view transactions from that range.

