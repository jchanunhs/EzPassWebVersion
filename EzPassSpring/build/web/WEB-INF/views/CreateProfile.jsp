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
                </nav>
                <main> 
                    <h1 align ="center">Customer Profile</h1>
                    <form name="CreateProfile" action="${pageContext.request.contextPath}/CreateProfileControl" method="post">
                        <label for="Name">Customer Name:</label>
                        <input type="text" name="Name" value="<%=(String) session.getAttribute("Name")%>"readonly><br>
                        <label for="Street">Street:</label>
                        <input type="text" name="Street"><br>
                        <label for="City">City:</label>
                        <input type="text" name="City"><br>
                        <label for="State">State:</label>
                        <input type="text" name="State"><br>                                  
                        <label for="Zip">Zip:</label>
                        <input type="text" name="Zip"><br>
                        <label for="Phone">Phone:</label>
                        <input type="text" name="Phone"><br>
                        <label for="Email">Email:</label>
                        <input type="text" name="Email"><br> 
                        <input type="button" value="Create Profile" onClick="checkInputs()">
                        <input type="reset" value="Reset">
                    </form>                              
                    <div id = "date"> </div>
                </main>
            </div>
            <footer><small><em>
                        Copyright © 2020 EzPassWebApplication<br>
                        <a href = "mailto:jchanunh@student.fdu.edu">jchanunh@student.fdu.edu</a>
                    </em></small></footer>
        </div>
        <script>
            function checkInputs()
            {
                Name = document.CreateProfile.Name.value;
                Street = document.CreateProfile.Street.value;
                City = document.CreateProfile.City.value;
                State = document.CreateProfile.State.value;
                Zip = document.CreateProfile.Zip.value;
                Phone = document.CreateProfile.Phone.value;
                Email = document.CreateProfile.Email.value;
                if (Name == "" || Street == "" || City == "" || State == "" || Zip == "" || Phone == "" || Email == "") {
                    window.alert("One or more fields are empty! Please fill out all information!");
                } else {
                    document.CreateProfile.submit();
                }
            }

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

