import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
///
import java.io.*;
import io.jsonwebtoken.*;
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
///
public class nologuserfilter implements Filter
{
	public void init(FilterConfig filterConfig)throws ServletException {}
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		Cookie[] cookies = request.getCookies();
		String username1="";
		String token="";
		if(cookies != null){
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("CHAR1")) {
					token= (String) cookie.getValue();
					String secret = "3aCNhf3ZUZ";	
					Algorithm algorithm = Algorithm.HMAC256(secret);
					String[] chunks = token.split("\\.");
					SignatureAlgorithm sa = SignatureAlgorithm.forName("HS256");
					SecretKeySpec secretKeySpec = new SecretKeySpec(secret.getBytes(), "HS256");
					String tokenWithoutSignature = chunks[0] + "." + chunks[1];
					String signature = chunks[2];
					DefaultJwtSignatureValidator validator = new DefaultJwtSignatureValidator(sa, secretKeySpec);
					if (validator.isValid(tokenWithoutSignature, signature)) {
						JWTVerifier verifier = JWT.require(algorithm).withIssuer("guna").build();
						DecodedJWT jwt = verifier.verify(token);
						String role = jwt.getClaim("userrole").asString();
						if(role.equals("admin"))
						{
							response.sendRedirect("adminindex.jsp");
						}
						else
						{
							response.sendRedirect("userindex.jsp");
						}
					}
					else{
						chain.doFilter(req, res);
					}
				}
				else{
					chain.doFilter(req, res);
				}
			}
		}
		else{
			chain.doFilter(req, res);
		}
	}
	public void destroy() {}
}