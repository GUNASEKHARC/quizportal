<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" 
%>

<html>
<head>
    <title>Update Course Page</title>
<style>
table, th, td {
  border: 1px solid;
}
</style></head>
<body>
     <br><br><br><br><br><br><br><br><br>
            <fieldset style="background-color: rgba(206,89,55,0.19);">
                <center>
                    <h1>Update Course</h1>
                    <form action="update" method="post">
                           <label for="upid">Enter which, ID you need to update:</label>
                            <input type="text" name="upid"required><br><br>
							<label for="Category">Choose Course:</label>
							<select id="demo" name="Category" onclick="myFunction()">
									  <option value="COURSENAME">Name </option>
									  <option value="ID">ID</option>
									  <option value="DESCRIPTION">Description</option>
									  <option value="TYPE">Type</option>
									  <option value="cat">Category</option>
							</select><br>
							<p id="demo1"></p>
                            <input type="submit" value="Submit">
                        </form>
 </center>
<script>
function myFunction() {
  let temp =document.getElementById("demo").value;
if(temp=="cat"){
  document.getElementById("demo1").innerHTML ="Choose category to be changed/others :<select name=\"categor\" id= \"categor\">"
<%
        try
        {
			String cate[]= new String [1000];
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
			if(conn == null){
                 response.sendRedirect("error.jsp");
            }
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_type='BASE TABLE' AND table_schema='public' and table_name NOT IN ('admin','users')");
			int d=0;
            while (rs.next())
            {
			conn = DriverManager.getConnection(url);
			if(conn == null){
                response.sendRedirect("error.jsp");
            }
            stmt = conn.createStatement();
			cate[d]= rs.getString("TABLE_NAME");%>
			+"<option value=\"<%=cate[d]%>\"><%=cate[d]%></option>"
			<%d++;
			}
}
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
		%> 
		+"<option value=\"others\" onclick=\"fun()\">others</option>"+"</select>"+"<p id=\"demoq\"></p>";	
}
else
{
 document.getElementById("demo1").innerHTML ="Enter the details to be changed:<input type=\"text\" name=\"qw\" >";
}
}
function fun() {
 let temp =document.getElementById("categor").value;
if(temp=="others")
 { document.getElementById("demoq").innerHTML ="<label for=\"ncategory\">Enter new category:</label><input type=\"text\" name=\"ncategory\"required><br><br>";
}
else 
{
	document.getElementById("demoq").innerHTML="";
}
}
</script> </center></fieldset>
<br><center><b><u><p>Click here to view Current Courses:</p><b><u>
					<form action="1view" method="post">
					<input type="submit" value="view courses"> </form></center></body><br>         
</body>
</html>