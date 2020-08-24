<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
                    <a href='${pageContext.request.contextPath}/index' id = "active-link">Profile</a>
                    <a href='${pageContext.request.contextPath}/vehicle'>Vehicle</a>
                    <a href='${pageContext.request.contextPath}/eztag'>EzTags</a>
                    <a href='${pageContext.request.contextPath}/paytoll'>Pay Tolls</a>
                    <a href='${pageContext.request.contextPath}/transaction'>Transactions</a>   
                </nav>
                <main> 
                    <h1 align ="center">Change Password</h1>
                    <form name="ChangePassword" action="${pageContext.request.contextPath}/changepassword" method="post"> 
                        <label for="Username">Username: </label>
                        <input type="text" name="Username" value="${sessionScope.Username}" readonly><br>
                        <label for="OldPassword">Old Password: </label>
                        <input type="password" name="OldPassword"><br>
                        <label for="NewPassword">New Password: </label>
                        <input type="password" name="NewPassword"><br>
                        <label for="NewPassword1">New Password(re-enter): </label>
                        <input type="password" name="NewPassword1"><br>
                        <input type="button" value="Change Password" onClick="checkInputs()">
                        <input type="reset" value="Reset">
                    </form>
                    <c:if test="${not empty message}">
                    <div id="message">${message}</div>    
                    </c:if>
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
                Old = document.ChangePassword.OldPassword.value;
                New = document.ChangePassword.NewPassword.value;
                New1 = document.ChangePassword.NewPassword1.value;
                if (Old == "" || New == "" || New1 == "") {
                    window.alert("One or more fields are empty! Please fill out all information!");
                } else if (New != New1) {
                    window.alert("Error: Unmatched new password!");
                } else {
                    document.ChangePassword.submit();
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


