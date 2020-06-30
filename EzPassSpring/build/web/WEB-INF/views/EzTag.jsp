<%@page import="java.util.ArrayList"%>
<%@page import="model.EzTag"%>
<%EzTag ez = new EzTag((String) session.getAttribute("CID"));
    ArrayList<String> ez_list = ez.getTags();%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <title>Ez Pass Web Application</title>
        <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/styles/content.css">
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/resources/images/favicon.ico">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Jason Chan">
        <meta name="description" content="Web implementation of the EzPassApplication">
        <link href="${pageContext.request.contextPath}/resources/jquery-ui-1.12.1/jquery-ui.min.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath}/resources/jquery-ui-1.12.1/external/jquery/jquery.js"></script>
        <script src="${pageContext.request.contextPath}/resources/jquery-ui-1.12.1/jquery-ui.min.js"></script>
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

                <aside class = "navbar">
                    <div class = "navtitle">Website Directories</div>
                    <a href='${pageContext.request.contextPath}/Main'>Profile</a>
                    <a href='${pageContext.request.contextPath}/Vehicle'>Vehicle</a>
                    <a href='${pageContext.request.contextPath}/EzTag'id = "active-link">EzTags</a>
                    <a href='${pageContext.request.contextPath}/PayTolls'>Pay Tolls</a>
                    <a href='${pageContext.request.contextPath}/Transactions'>Transactions</a>
                </aside>               

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
                                        <%for (int i = 0; i < ez_list.size(); i++) {
                                        %>
                                <tr><td><%=ez_list.get(i)%></td></tr>
                                <%}%>
                            </table>
                        </div>

                        <div id = "tab-2">
                            <form name="AddTag" action="${pageContext.request.contextPath}/AddTagControl" method="post">
                                <label for="CustomerID">Customer ID:</label>
                                <input type="text" name="CustomerID" value="<%=session.getAttribute("CID")%>"readonly><br>
                                <label for="TagCode">Tag Code:</label>
                                <input type="text" name="TagCode"><br>
                                <label for="TagType">Tag Type:</label>
                                <input type="text" name="TagType"><br>
                                <input type="button" value="Add Tag" onClick="checkAddTagInputs()">
                                <input type="reset" value="Reset">

                            </form>
                        </div>

                        <div id = "tab-3">
                            <form name="RemoveTag" action="${pageContext.request.contextPath}/RemoveTagControl" method="post">
                                <label for="CustomerID">Customer ID:</label>
                                <input type="text" name="CustomerID" value="<%=(String) session.getAttribute("CID")%>"readonly><br>
                                <label for="TagCode">Tag Code:</label>
                                <input type="text" name="TagCode"><br>

                                <input type="button" value="Remove Tag" onClick="checkRemoveTagInputs()">
                                <input type="reset" value="Reset">

                            </form>
                        </div>

                    </div>

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
            function checkAddTagInputs()
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
            function checkRemoveTagInputs()
            {
                var Prompts = "";
                TagCode = document.RemoveTag.TagCode.value;
                if (TagCode == "") {
                    window.alert("Please enter tag code you wish to remove!");
                } else {
                    document.RemoveTag.submit();
                }
            }
        </script>     
    </body> 
</html>
