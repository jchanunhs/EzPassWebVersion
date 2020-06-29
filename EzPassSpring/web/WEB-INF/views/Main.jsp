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

            <div id ="content-wrapper">

                <aside>
                    <div class = "navbar">
                        <div class = "navtitle">Website Directories</div>
                        <a href='${pageContext.request.contextPath}/Main'id = "active-link">Profile</a>
                        <a href='${pageContext.request.contextPath}/Vehicle'>Vehicle</a>
                        <a href='${pageContext.request.contextPath}/EzTag'>EzTags</a>
                        <a href='${pageContext.request.contextPath}/PayTolls'>Pay Tolls</a>
                        <a href='${pageContext.request.contextPath}/Transactions'>Transactions</a>
                    </div>
                </aside>

                <main> 
                    <h1 align ="center">Customer Profile</h1>

                    <form>
                        <label for="Name">Customer Name:</label>
                        <input type="text" name="Name" value="<%= session.getAttribute("Name")%>" readonly><br>
                        <label for="Street">Street:</label>
                        <input type="text" name="Street" value="<%= session.getAttribute("Street")%>" readonly><br>
                        <label for="City">City:</label>
                        <input type="text" name="City" value="<%= session.getAttribute("City")%>" readonly><br>
                        <label for="State">State:</label>
                        <input type="text" name="State" value="<%= session.getAttribute("State")%>" readonly><br>                                  
                        <label for="Zip">Zip:</label>
                        <input type="text" name="Zip" value="<%= session.getAttribute("Zip")%>" readonly><br>
                        <label for="Phone">Phone:</label>
                        <input type="text" name="Phone" value="<%= session.getAttribute("Phone")%>" readonly><br>
                        <label for="Email">Email:</label>
                        <input type="text" name="Email" value="<%= session.getAttribute("Email")%>" readonly><br>
                        <label for="Balance">Balance:</label>
                        <input type="text" name="Balance" value="<%=String.valueOf(session.getAttribute("Balance"))%>" readonly><br>        
                    </form>
                    <div align="center">
                        <a href='${pageContext.request.contextPath}/ChangePassword'>Change Password</a>
                        <a href='${pageContext.request.contextPath}/Recharge'>Recharge Account</a>
                        <a href="${pageContext.request.contextPath}/LogOutControl">Log Off</a>
                    </div>
                    <div id = "date"> </div>

                </main>

            </div>

            <footer><small><em>
                        Copyright © 2020 EzPassWebApplication<br>
                        <a href = "mailto:jchanunh@student.fdu.edu">jchanunh@student.fdu.edu</a>
                    </em></small></footer>
        </div>
        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
        </script>
    </body> 
</html>



