import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.lang.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;
import com.qpp.dcon;
@WebServlet("/addcourse")
public class addcourse extends HttpServlet {
    public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
    {
        PrintWriter out = res.getWriter();
        try{
            String cname = req.getParameter("Coursename");
            String cid = req.getParameter("Id");
            String desc = req.getParameter("Desc");
            String type = req.getParameter("Type");
			String ncat = req.getParameter("Category");
			if(ncat.equals("others"))
			{ncat = req.getParameter("ncategory");
				try{
            Statement stmt = null;	
			Connection conn = dcon.gcon();
          if(conn == null)
		  {
             res.sendRedirect("error.jsp");
          }
			stmt = conn.createStatement();
            String sql ="CREATE TABLE public."+ncat+"(questions text,a text,b text,c text,d text,ans text,PRIMARY KEY (questions));";
            PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.executeUpdate();
			stmt.close();
			conn.close();
			}
catch(Exception e){
			System.out.println(e.getMessage());
	    }		
			}
            String ctime=Calendar.getInstance().getTime().toString();
            String mtime=Calendar.getInstance().getTime().toString();
            Statement stmt = null;
			Connection conn = dcon.gcon();
            if(conn == null){
                res.sendRedirect("error.jsp");
            }
            stmt = conn.createStatement();
			String sql = "SELECT * FROM ADMIN;";
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
            String sql1 = "INSERT INTO ADMIN ("+col+") VALUES ("+pc+");";
            pstmt = conn.prepareStatement(sql1);
            pstmt.setString(1,cname);
            pstmt.setString(2,cid);
            pstmt.setString(3,desc);
            pstmt.setString(4,type);
            pstmt.setString(5,ncat);
            pstmt.setString(6,ctime);
            pstmt.setString(7,mtime);
            pstmt.executeUpdate();
            res.sendRedirect("adminindex.jsp");
            rs.close();
            stmt.close();
            conn.close();
        } catch(Exception e){
            out.println(e.getMessage());
        }
    }
}