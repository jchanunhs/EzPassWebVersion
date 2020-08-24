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
                    <a href='${pageContext.request.contextPath}/vehicle'>Vehicle</a>
                    <a href='${pageContext.request.contextPath}/eztag' id = "active-link">EzTags</a>
                    <a href='${pageContext.request.contextPath}/paytoll'>Pay Tolls</a>
                    <a href='${pageContext.request.contextPath}/transaction'>Transactions</a>
                </nav>               
                <main> 
                    <h1 align ="center">Ez Tags</h1>
                    <div id ="tabs">
                        <ul>
                            <li><a href="#tab-1">Your EzTags</a></li>
                            <li><a href="#tab-2">Add Tag</a></li>
                            <li><a href="#tab-3">Remove Tag</a></li>
                        </ul>
                        <div id = "tab-1">
                            <table>
                                <tr><th>Your Ez Tags</th></tr>
                                <c:forEach items="${eztaglist}" var="eztag">
                                    <tr><td>${eztag.tagCode}</td></tr>
                                </c:forEach>
                            </table>
                        </div>
                        <div id = "tab-2">
                            <form name="AddTag" action="${pageContext.request.contextPath}/addtag" method="post">
                                <label for="CustomerID">Customer ID:</label>
                                <input type="text" name="CustomerID" value="${sessionScope.CustomerID}"readonly><br>
                                <label for="TagCode">Tag Code:</label>
                                <input type="text" name="TagCode"><br>
                                <label for="TagType">Tag Type:</label>
                                <select name="TagType">
                                    <option value="">Please pick an option</option>
                                    <option value="Car">Car</option>
                                    <option value="Truck">Truck</option>
                                    <option value="Overload">Overload</option>
                                </select><br>
                                <input type="button" value="Add Tag" onClick="checkAddTagInputs()">
                                <input type="reset" value="Reset">
                            </form>
                        </div>
                        <div id = "tab-3">
                            <form name="RemoveTag" action="${pageContext.request.contextPath}/removetag" method="post">
                                <label for="CustomerID">Customer ID:</label>
                                <input type="text" name="CustomerID" value="${sessionScope.CustomerID}"readonly><br>
                                <label for="TagCode">Tag Code:</label>
                                <input type="text" name="TagCode"><br>
                                <input type="button" value="Remove Tag" onClick="checkRemoveTagInputs()">
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
            function checkAddTagInputs()
            {
                TagCode = document.AddTag.TagCode.value;
                TagType = document.AddTag.TagType.value;
                if (TagCode == "" || TagType == "") {
                    window.alert("One or more fields are empty! Please fill out all information!");
                } else {
                    document.AddTag.submit();
                }
            }

            function checkRemoveTagInputs()
            {
                TagCode = document.RemoveTag.TagCode.value;
                if (TagCode == "") {
                    window.alert("Please enter tag code you wish to remove!");
                } else {
                    document.RemoveTag.submit();
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
