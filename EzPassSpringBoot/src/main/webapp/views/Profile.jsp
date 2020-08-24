<!DOCTYPE html>
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
                    <h1 align ="center">Customer Profile</h1>
                    <form>
                        <label for="Name">Customer Name:</label>
                        <input type="text" name="Name" value="${customer.name}" readonly><br>
                        <label for="Street">Street:</label>
                        <input type="text" name="Street" value="${customer.street}" readonly><br>
                        <label for="City">City:</label>
                        <input type="text" name="City" value="${customer.city}" readonly><br>
                        <label for="State">State:</label>
                        <input type="text" name="State" value="${customer.state}" readonly><br>                                  
                        <label for="Zip">Zip:</label>
                        <input type="text" name="Zip" value="${customer.zip}" readonly><br>
                        <label for="Phone">Phone:</label>
                        <input type="text" name="Phone" value="${customer.phone}" readonly><br>
                        <label for="Email">Email:</label>
                        <input type="text" name="Email" value="${customer.email}" readonly><br>
                        <label for="Balance">Balance:</label>
                        <input type="text" name="Balance" value="${customer.balance}" readonly><br>        
                    </form>
                    <div align="center">
                        <a href='${pageContext.request.contextPath}/changepassword'>Change Password</a>
                        <a href='${pageContext.request.contextPath}/recharge'>Recharge Account</a>
                        <a href="${pageContext.request.contextPath}/logout">Log Off</a>
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



