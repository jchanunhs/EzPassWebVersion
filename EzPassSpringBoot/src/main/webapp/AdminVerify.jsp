<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                    <a href = "${pageContext.request.contextPath}/Admin/VerifyInformation" id = "active-link">Verify</a>
                    <a href = "${pageContext.request.contextPath}/Logout">Logout</a>
                </nav>
                <main> 
                    <h1 align ="center">Verify Customer Identity</h1>
                    <form name="Verify" action="${pageContext.request.contextPath}/AdminVerificationInfoControl" method ="post"> 
                        <label for="CustomerID">Customer ID: </label>
                        <input type="text" name="CustomerID"><br>
                        <label for="CustUsername">Customer Username: </label>
                        <input type="text" name="CustUsername"><br>
                        <input type="button" value="Verify" onClick="checkInputs()">
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
                CustomerID = document.Verify.CustomerID.value;
                CustUsername = document.Verify.CustUsername.value;
                if (CustomerID == "" || CustUsername == "") {
                    window.alert("One or more fields are empty! Please fill out all information!");
                } else {
                    document.Verify.submit();
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