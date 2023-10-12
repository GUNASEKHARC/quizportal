<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" 
%>

<html><head>
<title>Take test index</title>
<style>
table, th, td {
  border: 1px solid;
}</style></head>
<body><br><br><br><br><br><br><br><br><br>
            <fieldset style="background-color: rgba(206,89,55,0.19);">
            <center>
            <h1>Take test index</h1></center>
<center>
 <form action="taketest.jsp" method="post"><br>
							<label for="cid">Enter Course ID:</label>
                            <input type="text" name="cid" required><br><br>
							<label for="hwq">How many questions going to attend ? (min:5)</label>
                            <input type="text" name="hwq" min="5" required><br><br>
							<input type="submit" value="taketest">						
</form>
<br><center><b><u><p>Click here to view Current Courses:</p><b><u>
							<form action="1view" method="post">
					<input type="submit" value="view courses"> </form></center></fieldset>
</body>
</html>