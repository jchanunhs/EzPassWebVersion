# EzPassSpring
Web-based version of the EzPassApplication and was created using Spring MVC.

- Users need to sign up for an account and create their profile.
- After profile is created, they can login again and view their main profile page. 
- Users are able to add/remove tag and vehicle, pay tolls and view transactions. When funds are low they need to recharge their account.

- error.jsp handles error 404.
- Home controller contains request mappings of the webpages that don't have forms.
- The other controllers handle form submissions and redirects users to back to their respective webpage. 
- Users will be redirected to the index controller if they try to access the user pages without logging in yet. 

- /EzPassSpring/src/java contains the controls and model objects.
- /EzPassSpring/web/WEB-INF/views contains the view objects (jsp).

Users will be required to sign up for an account. When they log in, they will be prompted to create their profile. After profile is created they will be able to access different webpages in the side bar. There are 5 URLs in the side bar.

Main
- Displays customer profile.
- Users will be able to recharge their account, change password and log off.

Vehicle
- Displays a list of vehicles.
- Users can add/remove a vehicle.

EzTag
- Displays a list of EzTags.
- User can add tag and remove tag.
- Note: If the tag is currently linked to a vehicle or has been used to pay tolls, they will not be able to remove it. They can choose not to use the tag anymore and add a new tag.

Pay Tolls
- A form page for user to pay tolls

Transactions
- Users can view all their transactions from paying tolls
- They can also enter specific date ranges to view transactions from that range.
