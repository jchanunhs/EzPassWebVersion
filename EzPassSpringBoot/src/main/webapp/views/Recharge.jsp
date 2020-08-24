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
                    <h1 align ="center">Recharge</h1>
                    <form name="Recharge" action="${pageContext.request.contextPath}/recharge" method="post">
                        <label for="CustomerID">Customer ID:</label>
                        <input type="text" name="CustomerID" value="${sessionScope.CustomerID}"readonly><br>
                        <label for="CurrentBalance">Current Balance:</label>
                        <input type="text" name="CurrentBalance" value="${customer.balance}"readonly><br>
                        <label for="CardNumber">Card Number:</label>
                        <input type="text" name="CardNumber"><br>
                        <label for="Name">Name on card:</label>
                        <input type="text" name="Name"><br>
                        <label for="EXP">EXP:</label>
                        <input type="text" name="EXP"><br>
                        <label for="CVV">CVV:</label>
                        <input type="text" name="CVV"><br>
                        <label for="Credit">Add to balance:</label>
                        <input type="text" name="Credit"><br>
                        <input type="button" value="Recharge" onClick="checkInputs()">
                        <input type="reset" value="Reset">
                    </form>
                    <c:if test="${not empty message}">
                        <div id="message">${message}</div>    
                    </c:if>
                    <table>
                        <tr>
                            <th>Credit ID</th>
                            <th>Date</th>
                            <th>Time</th>
                            <th>Credit Amount</th>
                        </tr>
                        <c:forEach items="${creditcardlist}" var="creditcard">
                            <tr>
                                <td>${creditcard.creditID}</td>
                                <td>${creditcard.date}</td>
                                <td>${creditcard.time}</td>
                                <td>${creditcard.creditAmount}</td>
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
            function checkInputs()
            {
                CardNumber = document.Recharge.CardNumber.value;
                Name = document.Recharge.Name.value;
                EXP = document.Recharge.EXP.value;
                CVV = document.Recharge.CVV.value;
                Credit = document.Recharge.Credit.value;
                if (isNaN(Credit)) {
                    window.alert("Add to balance must be a number!");
                } else if (CardNumber == "" || Name == "" || EXP == "" || CVV == "" || Credit == "") {
                    window.alert("One or more fields are empty! Please fill out all information!");
                } else {
                    document.Recharge.submit();
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

