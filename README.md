# Ez Pass Application (Web Version)
Web-based version of the EzPassApplication and was created using Spring Boot and Java EE.

- Follows MVC design pattern
- JSP served as the view for the web application.
- JQueryUI was used to create the tabs and accordion for the webpage.
- CSS was used to style the web pages.
- Controllers handle http requests. Some controllers may redirect users to the login page, create profile page, or profile page depending on whether the user is logged in and created their profile.
- Data access object and entity object work together to create and modify contents in our database.
- Microsoft SQL Server was used to store user's data.

Customers are able to
- Create an account
- Change Password
- Recharge account
- Add/Remove EzTag 
- Add/Remove Vehicle
- Pay tolls (Session will be invalidated once the user pays toll to simulate them leaving the toll booth)
- View all transactions or view transactions based on dates specified by customer

Admin Functions
- Update customer profile information (address, email, phone number) 
- Update TagType
- Delete Account 

Note: Customer gives us their username and customer id to verify their identity. We do not ask for their password.

This web application uses session authentication.
- Stores Username and CustomerID when user is logged on and created profile. 
- Stores Username when user is logged on and needs to create a profile.
- Stores AdminID when Admin is logged in.
- Stores AdminID and CustomerID when Admin is currently working on a customer case.

