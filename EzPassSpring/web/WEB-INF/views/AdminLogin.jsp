<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <title>Ez Pass Web Application</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/content.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
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
                    <a href = "${pageContext.request.contextPath}/AdminLogin" id = "active-link">Login</a>
                </nav>
                <main> 
                    <h1 align ="center">Admin Sign In</h1>
                    <form name="SignIn" action="${pageContext.request.contextPath}/AdminLoginControl" method ="post"> 
                        <label for="AdminID">Admin ID: </label>
                        <input type="text" name="AdminID"><br>
                        <label for="Name">Name: </label>
                        <input type="text" name="Name"><br>
                        <label for="Password">Password: </label>
                        <input type="password" name="Password"><br>
                        <input type="button" value="Login" onClick="checkInputs()">
                        <input type="reset" value="Reset">
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
            function checkInputs()
            {
                AdminID = document.SignIn.AdminID.value;
                Name = document.SignIn.Name.value;
                Password = document.SignIn.Password.value;
                if (AdminID == "" || Name == "" || Password == "") {
                    window.alert("One or more fields are empty! Please fill out all information!");
                } else {
                    document.SignIn.submit();
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
