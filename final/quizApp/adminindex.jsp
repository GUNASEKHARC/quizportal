<html>
<head>
<title>Admin Page</title>
<style>
.block {
  border: none;
  background-color: #04AA6D;
  color: white;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  text-align: center;
}</style></head>
<body><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<fieldset style="background-color: rgba(206,89,55,0.19);"><br><br><center>
                    <h1>Welcome to Admin dashboard</h1><br><br>	
    <input type="button" class="block" value="Addcourse" onclick="window.location='addcourse.jsp'">
    <input type="button" class="block" value="Update" onclick="window.location='update.jsp'">
	<input type="button" class="block" value="Delete" onclick="window.location='delete.jsp'"><br><br>
	<form action="1view" method="post">
	<input type="submit" class="block" value="view">
	</form><br>
	<input type="button" class="block" value="LOGOUT" onclick="window.location='/quizApp/logout.jsp'">		
							<br><br>
							</fieldset>        
               </center>
</body>
</html