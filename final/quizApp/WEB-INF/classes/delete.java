import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import com.qpp.dcon;
@WebServlet("/delete")
public class delete extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
	{
		PrintWriter out = res.getWriter();
		try
            { 
			String aid = req.getParameter("did");
            Statement stmt = null;
			Connection conn = dcon.gcon();
			if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN;");
			String cidt = null;
			int allow = 0;
            while(rs.next())
            {
				cidt = rs.getString("ID");
				if(cidt.equalsIgnoreCase(aid)){
					allow++;
				}
			}
			if(allow!=0)
			{
				String sql = "DELETE FROM ADMIN WHERE ID = ?;";
				PreparedStatement pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,aid);
				pstmt.executeUpdate();
				conn.close();	
            }
			else{
			res.sendRedirect("error.jsp");    
			}
			 res.sendRedirect("adminindex.jsp");
			 }
			catch(Exception e) 
                {
                    System.out.println(e.getMessage());
                }
    }
}