# Ez Pass Application (Web Version)
Web-based version of the EzPassApplication and was created using Spring Boot and Java EE.

Technologies used for front end: JSP to generate HTML and Javascript to check if the forms were submitted properly.
Technologies used for back end: Java (Data access object provides access to SQL Server).

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

