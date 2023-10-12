<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" 
%>

<%int i=1;%>

<html>
<head>
    <title>Take test</title>
	
</head>
<body>
 <br><br><br><br><br><br><br><br><br>
            <fieldset style="background-color: rgba(206,89,55,0.19);">
                <center>
                    <h1>Take test</h1>
					<h2>Answer the following questions:</h1>
</center>
<form action="taketest" method="post">
<%

		try{
String a1 = request.getParameter("cid");
String qs1 =request.getParameter("hwq");
int qs =Integer.parseInt(qs1);
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
			if(conn == null){
                response.sendRedirect("error.jsp");
            }
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN;");
			int d=0;
			String cidt = null,aq=null,z=null;
            while(rs.next())
            {
				cidt = rs.getString("ID");
				aq=rs.getString("CATEGORY");
				if(cidt.equalsIgnoreCase(a1)){
					z=aq;
				}
			}
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM "+z+";");
                while (rs1.next())
                {   
				if (qs==d)
                    {
						break;
                    }
				String question= rs1.getString("QUESTIONS");
				String v= rs1.getString("A");
				String b= rs1.getString("B");
				String n= rs1.getString("C");
				String m1= rs1.getString("D");
                out.println("Question"+(d+1)+":"+question);%><br><%
				out.println("(a)"+v);%><br><%
				out.println("(b)"+b);%><br><%
				out.println("(c)"+n);%><br><%
				out.println("(d)"+m1);%><br><%
                   %>
 <br>
<input type="text" name="choice<%=i%>"  placeholder="Enter a/b/c/d" required><br>
<%i=i+1;%>
<% 
                    d++;
				}    
%> 
<input type="hidden" name="c" value=<%=i%> />                     
<br><input type="submit" value="Submit">
                        </form>
                </center>
</body>
</html><%
			 
request.getSession().setAttribute("data1",a1);
request.getSession().setAttribute("data2",qs);
conn.close();
stmt.close();
}
catch(Exception e) 
            {
               out.println(e.getMessage());
            }  
%>