# Ez Pass Application (Web Version)
Web-based version of the EzPassApplication and was created using Spring Boot and Java EE.

- JSP served as the view for the web application.
- JQueryUI was used to create the tabs and accordion for the webpage.
- SQL Server was used to store user's data.
- CSS was used to style the web pages.
- Responsive web design.

Web Configurations
- error page will be displayed when user enters invalid URL.
- Controllers grant access to certain webpages when user is logged on. We know a customer is not logged in if the session attributes for Customer ID or Username is null.
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
- Delete Account 

Note: Customer gives us their username and customer id to verify their identity. We do not ask for their password.

Admin restrictions
- Admin must login first before they can gain access to verify customer information page.
- Admin must be logged on and verify customer information successfully before they can gain access to UpdateCustomerProfile/EzTag page.
- After customer issue is resolved, admin must click on the finish link in the navbar to clear customer information from session before dealing with another customer.

This web application uses session authentication.
- Stores Username, Password and CustomerID when user is logged on and created password. 
- Stores Username and Password when user is logged on and needs to create a profile.
- Stores AdminID when Admin is logged in.
- Stores AdminID and CustomerID when Admin is currently working on a customer case.


