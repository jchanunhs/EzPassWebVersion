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

                    <h1 align ="center">Ez Tags</h1>
                    <table>
                        <tr><th>Your Ez Tags</th></tr>
                                <%for (int i = 0; i < ez_list.size(); i++) {
                                %>
                        <tr><td><%=ez_list.get(i)%></td></tr>
                        <%}%>
                    </table>
                    <div align="center">    
                        <a href='${pageContext.request.contextPath}/AddTag'>Add EzTags</a>
                        <a href='${pageContext.request.contextPath}/RemoveTag'>Remove EzTags</a>
                    </div>

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
