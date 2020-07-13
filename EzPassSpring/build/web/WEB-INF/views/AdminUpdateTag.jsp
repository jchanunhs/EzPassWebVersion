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
                    <a href = "${pageContext.request.contextPath}/Admin/UpdateCustomerProfile">Update Profile</a>
                    <a href = "${pageContext.request.contextPath}/Admin/UpdateCustomerEzTag" id = "active-link">Update Tag</a>
                    <a href = "${pageContext.request.contextPath}/Admin/DeleteAccount">Delete account</a>
                    <a href = "${pageContext.request.contextPath}/Admin/Finish">Finish Updates</a>
                    <a href = "${pageContext.request.contextPath}/Logout">Logout</a>    
                </nav>               
                <main> 
                    <h1 align ="center">Update Customer Ez Tags</h1>
                    <form name="UpdateTag" action="${pageContext.request.contextPath}/UpdateEzTagControl" method="post">
                        <label for="CustomerID">Customer ID:</label>
                        <input type="text" name="CustomerID" value="<%=session.getAttribute("AdminCIDInput")%>"readonly><br>
                        <label for="OldTagCode">Old Tag Code:</label>
                        <input type="text" name="OldTagCode"><br>
                        <label for="NewTagCode">New Tag Code:</label>
                        <input type="text" name="NewTagCode"><br>
                        <label for="NewTagType">New Tag Type:</label>
                        <input type="text" name="NewTagType"><br>
                        <input type="button" value="Update EzTag" onClick="checkInputs()">
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
        <script>
            var d = new Date();
            document.getElementById("date").innerHTML = d;
            function checkInputs()
            {
                OldTagCode = document.UpdateTag.OldTagCode.value;
                NewTagCode = document.UpdateTag.NewTagCode.value;
                NewTagType = document.UpdateTag.NewTagType.value;
                if (OldTagCode != "" && NewTagCode != "") { //update tag code
                    document.UpdateTag.submit();
                } else if (OldTagCode != "" && NewTagType != "") { //update tag type
                    document.UpdateTag.submit();
                } else if (OldTagCode != "" && NewTagCode != "" && NewTagType != "") { //update tagcode and tagtype
                    document.UpdateTag.submit();
                } else {
                    window.alert("Old tag code must be filled in. Then customer chooses to change tag code or tag type");
                }

            }
        </script>     
    </body> 
</html>
