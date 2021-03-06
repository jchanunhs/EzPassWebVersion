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
                    <a href='${pageContext.request.contextPath}/index'>Profile</a>
                    <a href='${pageContext.request.contextPath}/vehicle'>Vehicle</a>
                    <a href='${pageContext.request.contextPath}/eztag'>EzTags</a>
                    <a href='${pageContext.request.contextPath}/paytoll' id = "active-link">Pay Tolls</a>
                    <a href='${pageContext.request.contextPath}/transaction'>Transactions</a>
                </nav>
                <main> 
                    <h1 align ="center">Pay Toll</h1>
                    <form name="PayToll" action="${pageContext.request.contextPath}/paytoll" method="post">
                        <label for="CustomerID">Customer ID:</label>
                        <input type="text" name="CustomerID" value="${sessionScope.CustomerID}"readonly><br>
                        <label for="LicensePlateNumber">License Plate Number:</label>
                        <input type="text" name="LicensePlateNumber"><br>
                        <label for="TagCode">Tag Code:</label>
                        <input type="text" name="TagCode"><br>
                        <label for="TollPlaza">Toll Plaza:</label>
                        <input type="text" name="TollPlaza"><br>
                        <label for="TollLane">Toll Lane:</label>
                        <input type="text" name="TollLane"><br>
                        <label for="TollAmount">Toll Amount:</label>
                        <input type="text" name="TollAmount"><br>
                        <input type="button" value="Pay Toll" onClick="checkInputs()">
                        <input type="reset" value="Reset">
                    </form>
                    <c:if test="${not empty message}">
                    <div id="message">${message}</div>    
                    </c:if>
                    <div id = "date"> </div>
                </main>
            </div>
            <footer><small><em>
                        Copyright � 2020 EzPassWebApplication<br>
                        <a href = "mailto:jchanunh@student.fdu.edu">jchanunh@student.fdu.edu</a>
                    </em></small></footer>
        </div>
        <script>
            function checkInputs()
            {
                LicensePlateNumber = document.PayToll.LicensePlateNumber.value;
                TagCode = document.PayToll.TagCode.value;
                TollPlaza = document.PayToll.TollPlaza.value;
                TollLane = document.PayToll.TollLane.value;
                TollAmount = document.PayToll.TollAmount.value;
                if (isNaN(TollLane) || isNaN(TollAmount)) {
                    window.alert("Toll Lane and Toll Amount must be a number!");
                } else if (LicensePlateNumber == "" || TagCode == "" || TollPlaza == "" || TollLane == "" || TollAmount == "") {
                    window.alert("One or more fields are empty! Please fill out all information!");
                } else {
                    document.PayToll.submit();
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

