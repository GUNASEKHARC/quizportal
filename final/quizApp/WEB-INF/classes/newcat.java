import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import com.qpp.dcon;
@WebServlet("/newcat")
public class newcat extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
	{ try{
            Statement stmt = null;
			Connection conn = dcon.gcon();
          if(conn == null)
		  {
             res.sendRedirect("error.jsp");
          }
			stmt = conn.createStatement();
			String ncat = req.getParameter("category");
            String sql ="CREATE TABLE public."+ncat+"(questions text,a text,b text,c text,d text,ans text,PRIMARY KEY (questions));";
            PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			stmt.close();
			conn.close();
			res.sendRedirect("takequestionsindex.jsp");
			}
catch(Exception e){
			System.out.println(e.getMessage());
	    }		
	}
}
