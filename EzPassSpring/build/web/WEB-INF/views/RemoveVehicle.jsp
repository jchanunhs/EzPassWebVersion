<!DOCTYPE html>
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

            <div class = "flexHorizontal">

                <div>
                    <aside>
                        <div class = "flexVertical">
                            <div class = "links">Website Directories</div>
                            <a href='${pageContext.request.contextPath}/Main'>Profile</a>
                            <a href='${pageContext.request.contextPath}/Vehicle'class = "active-link">Vehicle</a>
                            <a href='${pageContext.request.contextPath}/EzTag'>EzTags</a>
                            <a href='${pageContext.request.contextPath}/PayTolls'>Pay Tolls</a>
                            <a href='${pageContext.request.contextPath}/Transactions'>Transactions</a>
                        </div>
                    </aside>
                </div>



                <main> 
                    <h1 align ="center">Remove Vehicle</h1>

                    <form name="RemoveVehicle" action="${pageContext.request.contextPath}/RemoveVehicleControl" method="post">
                        <label for="LicensePlateNumber">License Plate Number:</label>
                        <input type="text" name="LicensePlateNumber"><br>

                        <input type="button" value="Remove Vehicle" onClick="checkInputs()">
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



        <script language="JavaScript">

            function checkInputs()
            {
                var Prompts = "";
                LicensePlateNumber = document.RemoveVehicle.LicensePlateNumber.value;
                if (LicensePlateNumber == "") {
                    window.alert("Please enter the license plate number for the vehicle you wish to remove!");
                } else {
                    document.RemoveVehicle.submit();
                }
            }

        </script>

        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
        </script>

    </body> 
</html>
