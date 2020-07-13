# EzPassSpring
Web-based version of the EzPassApplication and was created using Spring MVC and Java EE 7 Web.

- JSP served as the view for the web application.
- JQueryUI was used to create the tabs and accordion for the webpage.
- SQL Server was used to store user's data.
- CSS was used to style the web pages.
- Responsive web design.

Web Configurations
- error page will be displayed when user enters invalid URL.
- Controllers grant access to certain webpages when user is logged on.
(ex: if user tries to enter main page without logging in first, they will be redirected to login page).
- Controllers are also responsible for processing form submissions and redirects user to their respective webpages with a success or fail message.


Customers are able to
- Create an account
- Change Password
- Recharge account
- Add/Remove EzTag
- Add/Remove Vehicle
- Pay tolls (Form submission)
- View all transactions or view transactions based on dates specified by customer

Admin Functions
- Update customer profile information (address, email, phone number) 
- Update TagCode or TagType
Note: Customer gives us their username and customer id to verify their identity. We do not ask for their password.

Admin restrictions
- Admin must login first before they can gain access to verify customer information.
- Admin must be logged on and verify customer information successfully before they can gain access to UpdateCustomerProfile/EzTag.
- After customer issue is resolved, admin must click on the finish link in the sidenav to clear customer information from session before dealing with another customer.

