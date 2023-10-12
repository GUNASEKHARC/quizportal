<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" 
%>

<html><head>
<title>Take questions index</title></head>
<body><br><br><br><br><br><br><br><br><br>
            <fieldset style="background-color: rgba(206,89,55,0.19);">
                <center><h1>Take questions index</h1></center>
		<center>
 <form action="takequestions.jsp" method="post"><br>
 <label for="cate">Enter the category to be changed :</label>
<select name="cate" id="cate">
<%try{
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
		%>
</select> <br><br>
							<label for="hq">How many questions going to add ?</label>
                            <input type="text" name="hq" required><br><br>
							<input type="submit" value="takequestions">
							<input type ="button" value="add new category" onclick="window.location='addcategory.jsp'">
</form></center></fieldset>
</body>
</html>