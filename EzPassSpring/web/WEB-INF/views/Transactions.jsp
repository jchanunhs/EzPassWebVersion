<%@page import="java.util.ArrayList"%>
<%
    ArrayList<String> TID_list = (ArrayList<String>) request.getAttribute("TID");
    ArrayList<String> TC_list = (ArrayList<String>) request.getAttribute("TC");
    ArrayList<String> TD_list = (ArrayList<String>) request.getAttribute("TD");
    ArrayList<String> TT_list = (ArrayList<String>) request.getAttribute("TT");
    ArrayList<String> TP_list = (ArrayList<String>) request.getAttribute("TP");
    ArrayList<String> TLN_list = (ArrayList<String>) request.getAttribute("TLN");
    ArrayList<String> TA_list = (ArrayList<String>) request.getAttribute("TA");
%>
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
                    <a href='${pageContext.request.contextPath}/Profile'>Profile</a>
                    <a href='${pageContext.request.contextPath}/Vehicle'>Vehicle</a>
                    <a href='${pageContext.request.contextPath}/EzTag'>EzTags</a>
                    <a href='${pageContext.request.contextPath}/PayTolls'>Pay Tolls</a>
                    <a href='${pageContext.request.contextPath}/Transactions'id = "active-link">Transactions</a>
                </nav>
                <main> 
                    <h1 align ="center">Transactions</h1>
                    <form name="Transaction" action="${pageContext.request.contextPath}/ViewTransactionDates" method="post">
                        <label for="CustomerID">Customer ID:</label>
                        <input type="text" name="CustomerID" value="<%=(String) session.getAttribute("CID")%>"readonly><br>
                        <label for="before">Date from:</label>
                        <input type="text" name="before"><br>
                        <label for="after">Date to:</label>
                        <input type="text" name="after"><br>
                        <input type="submit" value="View Transaction">
                        <input type="reset" value="Reset">
                    </form>
                    <table>
                        <tr>
                            <th>Transaction ID</th>
                            <th>Tag Code</th>
                            <th>Transaction Date</th>
                            <th>Transaction Time</th>
                            <th>Toll Plaza</th>
                            <th>Toll Lane Number</th>
                            <th>Toll Amount</th>
                        </tr>
                        <%
                            for (int i = 0; i < TID_list.size(); i++) {
                        %>
                        <tr>
                            <td><%=TID_list.get(i)%></td>
                            <td><%=TC_list.get(i)%></td>
                            <td><%=TD_list.get(i)%></td>
                            <td><%=TT_list.get(i)%></td>
                            <td><%=TP_list.get(i)%></td>
                            <td><%=TLN_list.get(i)%></td>
                            <td><%=TA_list.get(i)%></td>
                        </tr>
                        <%}%>
                    </table>
                    <div id = "date"> </div>
                </main>
            </div>
            <footer><small><em>
                        Copyright © 2020 EzPassWebApplication<br>
                        <a href = "mailto:jchanunh@student.fdu.edu">jchanunh@student.fdu.edu</a>
                    </em></small></footer>
        </div>
        <script language="JavaScript">
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


