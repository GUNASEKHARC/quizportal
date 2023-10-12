import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;
import java.sql.*;
import java.lang.*;
import java.util.Date;
import java.util.Calendar;
import java.text.DateFormat;
import com.qpp.dcon;
@WebServlet("/update")
public class update extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
    {
		try
        {   String cname,cid,desc,type,ctime;
            String aid= req.getParameter("upid");	
            Statement stmt = null;
			Connection conn = dcon.gcon();
			if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN;");
			int allowq = 0;
			String cidt = null;
	       while(rs.next()){	
			cidt = rs.getString("ID");
				if(cidt.equalsIgnoreCase(aid)){
					aid = cidt;
					allowq++;
				}
		   }
		if(allowq!=0)
		{
			String w = req.getParameter("Category");
            String mtime=Calendar.getInstance().getTime().toString();
            	if((w.equals("COURSENAME"))||(w.equals("ID"))||(w.equals("DESCRIPTION"))||(w.equals("TYPE")))
            	{
                    cname=req.getParameter("qw");
					String sql = "UPDATE ADMIN SET "+w+" = ?,MTIME = ? WHERE ID = ?;";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,cname);
					pstmt.setString(2,mtime);
					pstmt.setString(3,aid);
					pstmt.executeUpdate();
				}
                else if(w.equals("cat"))
            	{
                   String cate = req.getParameter("categor");
				   if(cate.equals("others"))
				   {String ncat=req.getParameter("ncategory");	
					String sql1 ="CREATE TABLE public."+ncat+"(questions text,a text,b text,c text,d text,ans text,PRIMARY KEY (questions));";
					PreparedStatement pstmt1 = conn.prepareStatement(sql1);
					pstmt1.executeUpdate();
					ctime=Calendar.getInstance().getTime().toString();
					String sql = "UPDATE ADMIN SET CATEGORY = ?,CTIME=?,MTIME = ? WHERE ID = ?;";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,ncat);
					pstmt.setString(2,ctime);
					pstmt.setString(3,mtime);
					pstmt.setString(4,aid);
					pstmt.executeUpdate();
				   }
            	   else{ 
					String sql = "UPDATE ADMIN SET CATEGORY = ?,MTIME = ? WHERE ID = ?;";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,cate);
					pstmt.setString(2,mtime);
					pstmt.setString(3,aid);
					pstmt.executeUpdate();
				   }
					}
		res.sendRedirect("adminindex.jsp");
					conn.close();
					}
					}
catch(Exception e) 
            {
               System.out.println(e.getMessage());
            }  
	}
}