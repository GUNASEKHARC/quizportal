<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@page import="java.sql.*,java.io.*,java.io.*, javax.servlet.*, javax.servlet.http.*, javax.servlet.annotation.WebServlet ,
 io.jsonwebtoken.*, com.auth0.jwt.JWT, com.auth0.jwt.JWTVerifier,com.auth0.jwt.*, com.auth0.jwt.algorithms.Algorithm, 
 com.auth0.jwt.exceptions.JWTVerificationException, com.auth0.jwt.interfaces.*,
 java.util.*, javax.crypto.spec.SecretKeySpec, io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator,
 javax.xml.bind.DatatypeConverter, io.jsonwebtoken.Jws.*, com.auth0.jwt.interfaces.DecodedJWT" %>
 <%!
 
    public Cookie getCookie(HttpServletRequest request, String name) {
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals(name)) {
                    return cookie;
                }
            }
        }
        return null;
    }
%>
<% 
Cookie cookies = getCookie(request, "CHAR1");
String token= (String) cookies.getValue();
String username ="";
	if (cookies != null) 
	{
	String secret = "3aCNhf3ZUZ";	
	Algorithm algorithm = Algorithm.HMAC256(secret);
	String[] chunks = token.split("\\.");
	SignatureAlgorithm sa = SignatureAlgorithm.forName("HS256");
	SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HS256");
	String tokenWithoutSignature = chunks[0] + "." + chunks[1];
	String signature = chunks[2];
	DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(sa, secretKeySpec);
		if (validator.isValid(tokenWithoutSignature, signature)) 
		{JWTVerifier verifier = JWT.require(algorithm).withIssuer("guna").build();
		DecodedJWT jwt = verifier.verify(token);
		username = jwt.getClaim("username").asString();
		}
	}
%>
<html>
<head>
<title>User Dashboard</title>
<style>
.block {
  border: none;
  background-color: #04AA6D;
  color: white;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  text-align: center;
}
</style>
</head>
<body><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<fieldset style="background-color: rgba(206,89,55,0.19);"><br><br>
<center>
<h1>Hello <%= username%> </h1><h1>Welcome to Dashboard!</h1><br><br>			
		<input type="button" class="block" value="Takequesions" onclick="window.location='takequestionsindex.jsp'">
		<input type="button" class="block" value="Taketest" onclick="window.location='taketestindex.jsp'"><br><br>
		<input type="button" class="block" value="LOGOUT" onclick="window.location='/quizApp/logout.jsp'"><br><br><br><br></fieldset>
</center>
</body>
</html>