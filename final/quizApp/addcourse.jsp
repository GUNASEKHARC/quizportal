<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" 
%>

<html>
<head>
    <title>Add Course Page</title>
</head>
<body>
        <center> <br><br><br><br><br><br><br><br><br>
            <fieldset style="background-color: rgba(206,89,55,0.19);">
                <center>
                    <h1>Addcourse</h1>
                    <form action="addcourse" method="post">
							<label for="Coursename">Enter Course name:</label>
                            <input type="text" name="Coursename"required><br><br>
							<label for="Id">Enter Course ID:</label>
                            <input type="text" name="Id" required><br><br>
							<label for="Desc">Enter Course Description:</label>
                            <input type="text" name="Desc"required><br><br>
							<label for="Type">Enter Course Type:</label>
							<input type="text" name="Type"required><br><br>
							<label for="cate">Choose Course Category / others :</label>
<select name="Category" onchange="fun()" id= "Category">
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
			 <option value="<%=cate[d]%>"><%=cate[d]%></option>
			<%d++;
			}
        stmt.close();
				conn.close();}
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
		%> <option value="others" >others</option> 
							</select>
							<p id="demo1"></p>
                           <br> <input type="submit" value="Submit">

                        </form>
                </center>
				<script>
function fun() {
 let temp =document.getElementById("Category").value;
if(temp=="others")
 { document.getElementById("demo1").innerHTML ="<label for=\"ncategory\">Enter new category:</label><input type=\"text\" name=\"ncategory\"required><br><br>";
}else 
{
	document.getElementById("demo1").innerHTML="";
}
}
</script>      
</body>
</html>