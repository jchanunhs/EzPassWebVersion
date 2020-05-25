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
                            <a href='${pageContext.request.contextPath}/Vehicle'>Vehicle</a>
                            <a href='${pageContext.request.contextPath}/EzTag'class = "active-link">EzTags</a>
                            <a href='${pageContext.request.contextPath}/PayTolls'>Pay Tolls</a>
                            <a href='${pageContext.request.contextPath}/Transactions'>Transactions</a>
                        </div>
                    </aside>
                </div>

                <div id = "space"> </div>

                <main> 
                    <h1 align ="center">Add Tag</h1>

                    <form name="AddTag" action="${pageContext.request.contextPath}/AddTagControl" method="post">
                        <label for="CustomerID">Customer ID:</label>
                        <input type="text" name="CustomerID" value="<%=(String) session.getAttribute("CID")%>"readonly><br>
                        <label for="TagCode">Tag Code:</label>
                        <input type="text" name="TagCode"><br>
                        <label for="TagType">Tag Type:</label>
                        <input type="text" name="TagType"><br>


                        <input type="button" value="Add Tag" onClick="checkInputs()">
                        <input type="reset" value="Reset">

                    </form>
                    <% if (request.getAttribute("message") != null) {%>
                    <div id="message"><%=request.getAttribute("message")%></div>    
                    <%}%>
                    <div id = "date"> </div>

                </main>

            </div>

            <footer><small><em>
                        <br>Copyright © 2020 EzPassWebApplication</br>
                        <a href = "mailto:jchanunh@student.fdu.edu">jchanunh@student.fdu.edu</a>
                    </em></small></footer>

        </div>
        <script language="JavaScript">

            function checkInputs()
            {
                var Prompts = "";
                TagCode = document.AddTag.TagCode.value;
                TagType = document.AddTag.TagType.value;
                if (TagCode == "" || TagType == "") {
                    window.alert("One or more fields are empty! Please fill out all information!");
                } else {
                    document.AddTag.submit();
                }
            }

        </script>

        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
        </script>
    </body> 
</html>



