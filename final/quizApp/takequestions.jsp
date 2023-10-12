<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import = "java.sql.*" 
%>
<%int i=1;%>
<html>
<head>
    <title>Take questions</title>
</head>
<body><br><br><br><br><br><br><br><br><br>
            <fieldset style="background-color: rgba(206,89,55,0.19);">
                <center><h1>Take questions</h1>
					<h2>Enter the question,options and answer option</h1>
					<form action="takequestions" method="post">
<%
try{
String t1 = request.getParameter("cate");
String tq1 = request.getParameter("hq");
int tq =Integer.parseInt(tq1);
int d=0;
			while (d<tq)
			{if (tq==d)
             {break;
             }%><br>
	<% out.println((d+1)+")"); %>
  <input type="text" name="ques<%=i%>"placeholder="Enter question:" required><br>
  <input type="text" name="opta<%=i%>" placeholder="Enter option a:" required><br>
  <input type="text" name="optb<%=i%>" placeholder="Enter option b:" required><br>
  <input type="text" name="optc<%=i%>" placeholder="Enter option c:" required><br>
  <input type="text" name="optd<%=i%>" placeholder="Enter option d:" required><br>
  <input type="text" name="optas<%=i%>" placeholder="Enter answer option a/b/c/d:" required>
<%i=i+1;%>
<% d++;
}
%>
<input type="hidden" name="c" value=<%=i%> /> 
<br><input type="submit" value="Submit">
                        </form>
						</center>
						</fieldset>
					</body>
						<%
request.getSession().setAttribute("cate",t1);
request.getSession().setAttribute("hq",tq);
}
catch(Exception e) 
            {
               out.println(e.getMessage());
            }  
%></html>
