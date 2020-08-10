<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Ez Pass Web Application</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/content.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.ico">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Jason Chan">
        <meta name="description" content="Web implementation of the EzPassApplication">
    </head>
    <body>
        <div id="wrapper">
            <header>Ez Pass Web Application</header>
            <div id ="content-wrapper">
                <nav>
                    <div id = "navtitle">Website Directories</div>
                    <a href = "${pageContext.request.contextPath}/Admin/UpdateCustomerProfile">Update Profile</a>
                    <a href = "${pageContext.request.contextPath}/Admin/UpdateCustomerEzTag">Update Tag</a>
                    <a href = "${pageContext.request.contextPath}/Admin/DeleteAccount" id = "active-link">Delete account</a>
                    <a href = "${pageContext.request.contextPath}/Admin/Finish">Finish Updates</a>
                    <a href = "${pageContext.request.contextPath}/Logout">Logout</a>    
                </nav>               
                <main> 
                    <h1 align ="center">Delete User Account</h1>
                    <form name="DeleteAccount" action="${pageContext.request.contextPath}/DeleteAccountControl" method="post">
                        <label for="CustomerID">Customer ID:</label>
                        <input type="text" name="CustomerID" value="<%=session.getAttribute("AdminCIDInput")%>"readonly><br>
                        <h1>Please let the customer know that their decision is final and cannot be undone.</h1>
                        <input type="button" value="Delete Account" onClick="Warning()">
                    </form>
                    <% if (request.getAttribute("message") != null) {%>
                    <div id="message"><%=request.getAttribute("message")%></div>    
                    <%}%>  
                    <div id = "date"> </div>
                </main>
            </div>
            <footer><small><em>
                        Copyright © 2020 EzPassWebApplication<br>
                        <a href = "mailto:jchanunh@student.fdu.edu">jchanunh@student.fdu.edu</a>
                    </em></small></footer>
        </div>
        <script>
            function Warning()
            {
                var check = confirm("Is the customer certain that they want their account deleted?");
                if (check == true) {
                    document.DeleteAccount.submit();
                } else {
                    alert("Action Aborted.");
                    return false;
                }
            }
            
            clock();
            setInterval(clock, 1000);
            function clock() {
                var d = new Date();
                var dateString = d.toLocaleDateString();
                var timeString = d.toLocaleTimeString();
                var clockString = "Date and Time: " + dateString + " at " + timeString;
                document.getElementById("date").innerHTML = clockString;
            }
        </script>     
    </body> 
</html>
