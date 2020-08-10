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
                <%if(session.getAttribute("CID") == null){%>
                <nav>
                    <div id = "navtitle">Website Directories</div>
                    <a href = "${pageContext.request.contextPath}/index">Login</a>
                    <a href = "${pageContext.request.contextPath}/SignUp">Sign Up</a>
                    <a href = "${pageContext.request.contextPath}/faq">FAQ</a>
                </nav>
                <%} else{%>
                <nav>
                    <div id = "navtitle">Website Directories</div>
                    <a href='${pageContext.request.contextPath}/Profile'>Profile</a>
                    <a href='${pageContext.request.contextPath}/Vehicle'>Vehicle</a>
                    <a href='${pageContext.request.contextPath}/EzTag'>EzTags</a>
                    <a href='${pageContext.request.contextPath}/PayTolls'>Pay Tolls</a>
                    <a href='${pageContext.request.contextPath}/Transactions'>Transactions</a>
                </nav>
                <%}%>
                <main> 
                    <h1 align ="center">Invalid URL</h1>
                    <img src="${pageContext.request.contextPath}/images/404.jpg" alt="ErrorLogo" class = "animate transition">    
                    <div id = "date"></div>
                </main>
            </div>
            <footer><small><em>
                        Copyright © 2020 EzPassWebApplication<br>
                        <a href = "mailto:jchanunh@student.fdu.edu">jchanunh@student.fdu.edu</a>
                    </em></small></footer>
        </div>
        <script>
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