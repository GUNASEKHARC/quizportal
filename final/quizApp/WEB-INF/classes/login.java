import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import io.jsonwebtoken.*;
import com.qpp.dcon;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.*;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.*;
import java.util.*;
import javax.crypto.spec.SecretKeySpec;
import io.jsonwebtoken.impl.crypto.DefaultJwtSignatureValidator;
import javax.xml.bind.DatatypeConverter;
import io.jsonwebtoken.Jws.*;
import com.auth0.jwt.interfaces.DecodedJWT;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.BufferedReader;
import java.io.BufferedWriter;

@WebServlet("/log")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		try{File file = new File("C:\\Program Files\\Apache Software Foundation\\Tomcat 9.0\\webapps\\manuals.pem");
            FileReader filer = new FileReader(file);
            BufferedReader outputr = new BufferedReader(filer);
			String line1 ;
			 while((line1 = outputr.readLine()) != null)
            {
			}
               filer.close();
              outputr.close();  
			req.getRequestDispatcher("login.jsp").include(req,res);
			String usernames = req.getParameter("username");
			String pass = req.getParameter("password");
			String password0=String.valueOf(pass.hashCode());
			if (usernames.equals("admin") && pass.equals("admin")) 
			{	
				String secret = line1;
				Algorithm algorithm = Algorithm.HMAC256(secret);
				String token = JWT.create().withIssuer("guna").withClaim("username", "admin").withClaim("userrole", "admin").sign(algorithm);
								Cookie c1 = new Cookie("CHAR1",String.valueOf(token));
				res.addCookie(c1);
				c1.setMaxAge(60*60);
				res.sendRedirect("adminindex.jsp");
				}
			Statement stmt = dcon.gcon().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS WHERE USERNAME= '"+usernames+"' AND PASSWORD= '"+password0+"' ;");
            if(rs.next())
			{	
				String dbusername= rs.getString("username");
				String secret = "3aCNhf3ZUZ";
				Algorithm algorithm = Algorithm.HMAC256(secret);
				String token = JWT.create().withIssuer("guna").withClaim("username",dbusername).withClaim("userrole", "user").sign(algorithm);
				Cookie c1 = new Cookie("CHAR1",String.valueOf(token));
				res.addCookie(c1);
				c1.setMaxAge(60*60);
				res.sendRedirect("userindex.jsp");
				rs.close();
				stmt.close();
				}		
			else
			{
				out.println("Sorry invalid username or password!");
			}
			rs.close();
			stmt.close();}
catch(Exception e){
			out.println(e.getMessage());
	    }		
	}
	protected void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException
	{
		doGet(req, res);
	}
}				/*String[] chunks = token.split("\\.");
				Base64.Decoder decoder = Base64.getUrlDecoder();
				String header = new String(decoder.decode(chunks[0]));
				String payload = new String(decoder.decode(chunks[1]));
				SignatureAlgorithm sa = SignatureAlgorithm.forName("HS256");
				SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HS256");
				String tokenWithoutSignature = chunks[0] + "." + chunks[1];
				String signature = chunks[2];
				DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(sa, secretKeySpec);
				if (validator.isValid(tokenWithoutSignature, signature)) 
				{
					JWTVerifier verifier = JWT.require(algorithm).withIssuer("guna").build();
					DecodedJWT jwt = verifier.verify(token);
					String username = jwt.getClaim("username").asString();
					String userrole = jwt.getClaim("userrole").asString();
				}*/