<html>
<head>
    <title>Registration Page</title>
</head>
<body>
     <br><br><br><br><br><br><br><br><br>
            <fieldset style="background-color: rgba(206,89,55,0.19);">
                <center>
                    <h1>Welcome to Quiz portal</h1>
                    <h1>Registration form</h1>
                    <form action="register" method="post">
                            <input type="text" name="username"  placeholder="Username" required><br><br>
                            <input type="password" name="password" placeholder="Password" required><br><br>
                            <input type="text" name="fullname" placeholder="Fullname"required><br><br>
                            <input type="text" name="mobilenumber" placeholder="Mobilenumber"required><br><br>
                            <input type="text" name="city" placeholder="City"required><br><br>
                            <input type="submit" value="Submit">
							<input type="button" value="Go back" onclick="history.back()">
                        </form>
                </center>
</body>
</html>