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
            <div class = "flexHorizontal">

                <div>
                    <aside>
                        <div class = "flexVertical">
                           <div class = "links">Website Directories</div>
                            <a href = "${pageContext.request.contextPath}/index" class = "active-link">Login</a>
                            <a href = "${pageContext.request.contextPath}/SignUp">Sign Up</a>
                        </div>
                    </aside>
                </div>
                <div id = "space"> </div>
                <main> 
                    <p align ="center">Invalid URL</p>
                    
                    <div id = "date"> </div>

                </main>
            </div>
            <footer><small><em>
                        <br>Copyright © 2020 EzPassWebApplication</br>
                        <a href = "mailto:jchanunh@student.fdu.edu">jchanunh@student.fdu.edu</a>
                    </em></small></footer>
        </div>

        
        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
        </script>
    </body> 
</html>