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
                    <a href='${pageContext.request.contextPath}/paytoll'>Pay Tolls</a>
                    <a href='${pageContext.request.contextPath}/transaction' id = "active-link">Transactions</a>
                </nav>
                <main> 
                    <h1 align ="center">Transactions</h1>
                    <form name="Transaction" action="${pageContext.request.contextPath}/transaction" method="post">
                        <label for="CustomerID">Customer ID:</label>
                        <input type="text" name="CustomerID" value="${sessionScope.CustomerID}"readonly><br>
                        <label for="before">Date from:</label>
                        <input type="text" name="before"><br>
                        <label for="after">Date to:</label>
                        <input type="text" name="after"><br>
                        <input type="submit" value="View Transaction">
                        <input type="reset" value="Reset">
                    </form>
                    <table>
                        <tr>
                            <th>Transaction ID</th>
                            <th>Tag Code</th>
                            <th>Transaction Date</th>
                            <th>Transaction Time</th>
                            <th>Toll Plaza</th>
                            <th>Toll Lane Number</th>
                            <th>Toll Amount</th>
                        </tr>
                        <c:forEach items="${transactionlist}" var="transaction">
                            <tr>
                                <td>${transaction.transactionID}</td>
                                <td>${transaction.tagCode}</td>
                                <td>${transaction.transactionDate}</td>
                                <td>${transaction.transactionTime}</td>
                                <td>${transaction.tollPlaza}</td>
                                <td>${transaction.tollLaneNumber}</td>
                                <td>${transaction.tollAmount}</td>
                            </tr>
                        </c:forEach>
                    </table>
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


