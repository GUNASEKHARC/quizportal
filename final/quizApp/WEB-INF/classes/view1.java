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
@WebServlet("/1view")
public class view1 extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
    {PrintWriter out = res.getWriter();
	try
        {String cname,cid,desc,type,cat,ctime,mtime;
		out.println("<html><head><title>View course Page</title><style>table, th, td {border: 1px solid;}</style></head><body>");
 out.println("<br><br><br><br><br><br><br><br><br><fieldset style=\"background-color: rgba(206,89,55,0.19);\"><center><h1>View Course</h1></center>");
            Statement stmt = null;
			Connection conn = dcon.gcon();
			if(conn == null){
                 res.sendRedirect("error.jsp");
            }
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN;");
			ResultSetMetaData rsm = rs.getMetaData();
			 int colcnt = rsm.getColumnCount();
			 String col=null;
			 out.println("<center><table><tr>");
			 for (int i=1;i<=colcnt;i++)
			 {col=rsm.getColumnName(i);
				out.println("<th>"+col+"</th>");
				}
			out.println("</tr><br>");
            while (rs.next())
            {
			if(conn == null){
                res.sendRedirect("error.jsp");
            }
            stmt = conn.createStatement();
				cname= rs.getString("COURSENAME");
				cid= rs.getString("ID");
				desc= rs.getString("DESCRIPTION");
				type= rs.getString("TYPE");
				cat= rs.getString("CATEGORY");
				ctime= rs.getString("CTIME");
				mtime= rs.getString("MTIME");
			out.println("<tr><td>"+cname+"</td><td>"+cid+"</td><td>"+desc+"</td><td>"+type+"</td><td>"+cat+"</td><td>"+ctime+"</td><td>"+mtime+"</td></tr>");
			}
        		stmt.close();
				conn.close();}
        catch(Exception e)
        {
            out.println(e.getMessage());
        }
		out.println("</table><br><br> <input type=\"button\" value=\"okay\" onclick=\"window.location=history.back()\"></center></body></html> ");
	}
}