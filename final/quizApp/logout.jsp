<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
</script>
<%
		session.invalidate();
		Cookie cookie = new Cookie("CHAR1","");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
		response.sendRedirect("index.jsp");
		%>