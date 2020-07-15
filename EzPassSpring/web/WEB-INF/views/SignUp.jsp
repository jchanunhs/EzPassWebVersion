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
                <nav>
                    <div id = "navtitle">Website Directories</div>
                    <a href = "${pageContext.request.contextPath}/index" >Login</a>
                    <a href = "${pageContext.request.contextPath}/SignUp" id = "active-link">Sign Up</a>
                    <a href = "${pageContext.request.contextPath}/faq">FAQ</a>
                </nav>
                <main> 
                    <h1 align ="center">Sign Up</h1>
                    <form name="SignUp" action="${pageContext.request.contextPath}/SignUpControl" method ="post"> 
                        <label for="Username">Username: </label>
                        <input type="text" name="Username"><br>
                        <label for="Password">Password: </label>
                        <input type="password" name="Password"><br>
                        <label for="Password1">Re-enter Password: </label>
                        <input type="password" name="Password1"><br>
                        <label for="Name">Name: </label>
                        <input type="text" name="Name"><br>
                        <input type="button" value="Create Account" onClick="checkInputs()">
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
                Username = document.SignUp.Username.value;
                Password = document.SignUp.Password.value;
                Password1 = document.SignUp.Password1.value;
                Name = document.SignUp.Name.value;
                if (Username == "" || Password == "" || Password1 == "" || Name == "") {
                    if (Username == "")
                        Prompts += "Please enter your username!\n";
                    if (Password == "")
                        Prompts += "Please enter your password!\n";
                    if (Password1 == "")
                        Prompts += "Please re-enter your password!\n";
                    if (Name == "")
                        Prompts += "Please enter your name!\n";
                    if (Prompts != "")
                        window.alert(Prompts);
                } else if (Password != Password1) {
                    window.alert("Please enter the same password!");
                } else {
                    document.SignUp.submit();
                }
            }

        </script>
        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
        </script>
    </body> 
</html>

