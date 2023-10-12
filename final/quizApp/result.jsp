<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<html>
<head>
<title>result Page</title>
</head>
<body>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<fieldset style="background-color: rgba(206,89,55,0.19);"><br><br>
<center><h1>Result</h1>
<%try{
		int cre=(int)request.getSession().getAttribute("cred");
		out.println("Your credit is "+cre);
}catch(Exception e) 
            {response.sendRedirect("login.jsp");
            }%>					  
<br><br>
 <input type="button" value="Logout" onclick="window.location='/quizApp/logout.jsp'">	
							<br><br></fieldset></center>
</body></html>