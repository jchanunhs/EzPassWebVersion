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
        <link href="${pageContext.request.contextPath}/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/jquery-ui-1.12.1/external/jquery/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/jquery-ui-1.12.1/jquery-ui.min.js"></script>
        <script type = "text/javascript">
            $(function () {
                $("#tabs").tabs();
            });
        </script>
    </head>
    <body>
        <div id="wrapper">
            <header>Ez Pass Web Application</header>
            <div id ="content-wrapper">
                <nav>
                    <div id = "navtitle">Website Directories</div>
                    <a href='${pageContext.request.contextPath}/index'>Profile</a>
                    <a href='${pageContext.request.contextPath}/vehicle' id = "active-link">Vehicle</a>
                    <a href='${pageContext.request.contextPath}/eztag'>EzTags</a>
                    <a href='${pageContext.request.contextPath}/paytoll'>Pay Tolls</a>
                    <a href='${pageContext.request.contextPath}/transaction'>Transactions</a>       
                </nav>
                <main> 
                    <h1 align ="center">Vehicles</h1>
                    <div id ="tabs">
                        <ul>
                            <li><a href="#tab-1">Your Vehicles</a></li>
                            <li><a href="#tab-2">Add Vehicle</a></li>
                        </ul>
                        <div id = "tab-1">
                            <table>
                                <tr><th>License Plate Number</th></tr>
                                        <c:forEach items="${vehiclelist}" var="vehicle">
                                    <tr>
                                        <td>${vehicle.licensePlateNumber}</td>
                                        <td><a href="${pageContext.request.contextPath}/removevehicle?LicensePlateNumber=${vehicle.licensePlateNumber}">Delete</a></td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </div>
                        <div id = "tab-2">
                            <form name="AddVehicle" action="${pageContext.request.contextPath}/addvehicle" method="post">
                                <label for="LicensePlateNumber">License Plate Number:</label>
                                <input type="text" name="LicensePlateNumber"><br>
                                <label for="Make">Make:</label>
                                <input type="text" name="Make"><br>
                                <label for="Model">Model:</label>
                                <input type="text" name="Model"><br>
                                <label for="Year">Year:</label>
                                <input type="text" name="Year"><br>                                  
                                <label for="Color">Color:</label>
                                <input type="text" name="Color"><br>
                                <label for="TagCode">Tag Code:</label>
                                <input type="text" name="TagCode"><br>
                                <input type="button" value="Add Vehicle" onClick="checkAddVehicleInputs()">
                                <input type="reset" value="Reset">
                            </form>
                        </div>
                    </div>
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
            function checkAddVehicleInputs()
            {
                LicensePlateNumber = document.AddVehicle.LicensePlateNumber.value;
                Make = document.AddVehicle.Make.value;
                Model = document.AddVehicle.Model.value;
                Year = document.AddVehicle.Year.value;
                Color = document.AddVehicle.Color.value;
                TagCode = document.AddVehicle.TagCode.value;

                if (LicensePlateNumber == "" || Make == "" || Model == "" || Year == "" || Color == "" || TagCode == "") {
                    window.alert("One or more fields are empty! Please fill out all information!");
                } else {
                    document.AddVehicle.submit();
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

