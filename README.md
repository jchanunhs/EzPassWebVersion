# EzPassSpring
Spring MVC version of EzPassWebApplication

- error.jsp handles error 404.

- Home controller contains request mappings of the webpages that don't have forms
- The other controllers handle form submissions and redirects users to back to the webpage. 
- Users will be redirected to the index page if they try to access the user pages without logging in yet. 

Database name = TangClass

Tables and attributes. 

Account
- varchar Username (PK)
- varchar Password
- varchar Name

Customer
- varchar CustomerID (PK)
- varchar Name
- varchar Street
- varchar City
- varchar State
- varchar Zip
- varchar Phone
- varchar Email
- float balance

EzTag
- varchar TagCode (PK)
- varchar TagType
- varchar IssueDate
- varchar CustomerID (FK)

Vehicle 
- varchar LicensePlateNumber (PK)
- varchar Make
- varchar Model
- varchar Year
- varchar Color
- varchar TagCode (FK)
- varchar CustomerID (FK)

CreditCard
- varchar CardNumber 
- varchar Name 
- varchar ExpirationDate
- varchar CVV
- varchar CustomerID (FK)
- varchar Date 
- varchar Time
- float CreditAmount
- Varchar CreditID (PK)

Transaction
- varchar TransactionID (PK)
- varchar TransactionDate
- varchar TransactionTime
- float TollAmount
- varchar TollPlaza
- int TollLaneNumber
- varchar TagCode (FK)
- varchar CustomerID (FK)

When users first login, they are prompt to create their customer profile. After its created, their next login they will see the MainWindows. The MainWindowsBO contains 5 tabs.

Profile
- Shows customer information (Name, address, balance on account, etc.)
- They are able to change their password, recharge their account using credit card information, logout.

Vehicle
- License plate is displayed in JList
- User can select the license plate and click remove vehicle button to delete it
- They can also add a vehicle to their account

EZ Tags
- Users can add ez tag or remove it.
- When user adds a vehicle, they also have to specify the ez tag associated with their vehicle

Pay Toll
- User can pay toll by entering their tag code, toll plaza, lane number and amount charged.
- It will be time stamped and transaction will be saved.

Transaction
- Transactions are displayed in a JTable.
- Users can also enter date intervals to view transactions on specific dates.
