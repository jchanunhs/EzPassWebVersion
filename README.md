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

Current work: Replacing model with DAO and Entity.
- Entity objects uses a no argument constructor and getter/setters.
- DAO access database to retrieve, store and modify data. 

Problem Statement
- Having a model object with multiple constructors for different purposes makes it significantly difficult to add new features to the webpage.
- The old method of getting Transactions and Credit transactions requires multiple requests to the database. This is because each request sent to the database is for 1 column. Ex: Credit card transactions for the recharge would take 4 requests from the database to fetch the credit id, date, time and credit amount.

Solution Statement
- DAO takes in the entity object and arguments to make changes to database.
Ex: Create a customor entity object using CustomerDAO with the CustomerID input. Then pass the Customer object to jsp and use the get method to output the customer information to the textfields.
- To solve the multiple requests for transactions/credit transactions, we create an arraylist of transactions and fetch the arraylist from TransactionDAO using CustomerID. Then pass the arraylist of transactions to the views and use the get method to output the transaction's credit id, date, time and credit amount.
