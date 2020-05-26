# EzPassSpring
Web-based version of the EzPassApplication and was created using Spring MVC.

- Users need to sign up for an account and create their profile.
- After profile is created, they can login again and view their main profile page. 
- Users are able to add/remove tag and vehicle, pay tolls and view transactions. When funds are low they need to recharge their account.

- error.jsp handles error 404.
- Home controller contains request mappings of the webpages that don't have forms.
- The other controllers handle form submissions and redirects users to back to their respective webpage. 
- Users will be redirected to the index page if they try to access the user pages without logging in yet. 

- /EzPassSpring/src/java contains the controls and model objects.
- /EzPassSpring/web/WEB-INF/views contains the view objects (jsp).
