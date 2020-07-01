# EzPassSpring
Web-based version of the EzPassApplication and was created using Spring MVC and Java EE 7 Web.

- JSP was used as the view for the web application.
- JQueryUI was used to create the tabs and accordion for the webpage.
- SQL Server was used to store user's data.
- error.jsp is displayed when user enters invalid url.
- Home controller contains request mappings of the webpages that don't have forms
- The other controllers handle form submissions and redirects users to back to their respective webpage with a success/fail message. 
- Users will be redirected to the index page if they try to access other pages without logging in yet. 
- When user is logged on, they will be redirected to their main profile page if they visit the signin and index page.

When the user logs on, there will be 5 URLs in the sidebar.

Main
- Displays customer profile.
- Users will be able to recharge their account, change password and log off.

Vehicle.
- Displays a list of vehicles.
- Users can add/remove a vehicle.
- Jquery UI to create tabs.

EzTag
- Displays a list of EzTags.
- User can add tag and remove tag.
- Jquery UI to create tabs.
Note: If the tag is currently linked to a vehicle or has been used to pay tolls, they will not be able to remove it. They can choose not to use the tag anymore and add a new tag.

Pay Tolls
- A form page for user to pay tolls.

Transactions
- Users can view all their transactions from paying tolls.
- They can also enter specific date ranges to view transactions from that range.

Other URLs that can be accessed in the index page.

Login
- Form for user to log into their account.

Sign up
- Form for user to sign up for their account.

FAQ
- Shows the frequently asked questions about how the Ez Tag works
- JQuery UI to create accordions.
- Created an overlay on an image.

Error page
- Is displayed when a user attempts to access an non-existent webpage.
- Created an animated and transitioned image that turns gray as time pass and increases in size as the user keeps their cursor over the image.



