<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                <aside class = "navbar">
                    <div class = "navtitle">Website Directories</div>
                    <a href = "${pageContext.request.contextPath}/index" id = "active-link">Login</a>
                    <a href = "${pageContext.request.contextPath}/SignUp">Sign Up</a>
                    <a href = "${pageContext.request.contextPath}/faq">FAQ</a>
                </aside>

                <main> 
                    <h1 align ="center">Sign In</h1>
                    <form name="SignIn" action="${pageContext.request.contextPath}/LoginControl" method ="post"> 
                        <label for="Username">Username: </label>
                        <input type="text" name="Username"><br>
                        <label for="Password">Password: </label>
                        <input type="password" name="Password"><br>

                        <input type="button" value="Login" onClick="checkInputs()">
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
                Username = document.SignIn.Username.value;
                Password = document.SignIn.Password.value;

                if (Username == "" || Password == "") {
                    if (Username == "")
                        Prompts += "Please enter your username!\n";
                    if (Password == "")
                        Prompts += "Please enter your password!\n";
                    if (Prompts != "")
                        window.alert(Prompts);
                } else {
                    document.SignIn.submit();
                }
            }

        </script>

        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
        </script>
    </body> 
</html>