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
                    <a href = "${pageContext.request.contextPath}/faq" id = "active-link">FAQ</a>
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
                    <h1 align ="center">Welcome to My Ez Pass Application!</h1>
                    <div class="imgcontainer">
                        <img src="${pageContext.request.contextPath}/images/ezpassonly.jpg" alt="EzOnlyLogo" class="imgoverlay">
                        <div class="overlay">Make your toll experience easier!</div>
                    </div>
                    <h2>How it works</h2>
                    <ol>
                        <li>Sign up for your account by clicking on the <a href = "${pageContext.request.contextPath}/SignUp">sign up</a> link in the side bar</li>
                        <li><a href = "${pageContext.request.contextPath}/index">Login</a> to your account and create your profile.</li>
                        <li>Add your Ez Tag and link a vehicle to that Ez Tag</li>
                        <li>You're all set! Now you can pay tolls using your Ez Pass. <br>
                            Note: Make sure you remember to recharge your account when the balance is low.</li>
                    </ol>
                    <h2>Note</h2>
                    <ul>
                        <li>A vehicle can only have one Ez Tag linked to it.</li>
                        <li>An Ez Tag can have multiple vehicles linked to it</li>
                        <li>An Ez Tag may not be removed if it has been used to pay tolls or is linked to a vehicle.</li>
                        <li>If you need assistance with changing your address or changing your Tag Code/Type, please contact help desk for support.</li>
                    </ul>
                    <div id = "date"> </div>
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