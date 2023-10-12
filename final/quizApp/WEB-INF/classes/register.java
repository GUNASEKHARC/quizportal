import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import com.qpp.dcon;
@WebServlet("/register")
public class register extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
	{
		int count = 0;
		PrintWriter out = res.getWriter();
		try{
			String msg = null;
			String usernames = req.getParameter("username");
			String pass = req.getParameter("password");
			String fname = req.getParameter("fullname");
			String mno = req.getParameter("mobilenumber");
			String city = req.getParameter("city");
			int pass1=pass.hashCode();
            Statement stmt = null;
			Connection conn = dcon.gcon();
          if(conn == null){
             res.sendRedirect("error.jsp");
          }
			stmt = conn.createStatement();
            ResultSet rs1 = stmt.executeQuery("SELECT * FROM USERS;");
            while(rs1.next()){
                  String username = rs1.getString("username");
                if(username.equals(usernames)){
                    count++;
                }
            }
            rs1.close();
            stmt.close();
			if(count == 0)
			{
	        String sql = "SELECT * FROM USERS;";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
            int rep = rsm.getColumnCount();
            String col = null;
            String pc = null;
			String col1[]=new String[100];
            for (int i=1;i<= rep;i++){
                if(i==1){
                    col =rsm.getColumnName(i);
					col1[i] =rsm.getColumnName(i);
                    pc = "?";
                } else {
                    col=(col+","+rsm.getColumnName(i));
                    pc=(pc+","+"?");
                }
            }
            String sql1 = "INSERT INTO USERS ("+col+") VALUES ("+pc+");";
            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1,usernames);
			pstmt.setInt(2,pass1);
			pstmt.setString(3,fname);
			pstmt.setString(4,mno);
			pstmt.setString(5,city);
			pstmt.executeUpdate();
            pstmt.close();
					res.sendRedirect("login.jsp");
			} 
			else {
				res.sendRedirect("error.jsp");
			}
			stmt.close();
			conn.close();
		} catch(Exception e){
			out.println(e.getMessage());
	    }
	}
}