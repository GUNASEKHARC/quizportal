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
@WebServlet("/takequestions")
public class takequestions extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
    {
	String t11=(String)req.getSession().getAttribute("cate");
	int tq=(int)req.getSession().getAttribute("hq");
	int c=Integer.parseInt(req.getParameter("c"));
			String question[]=new String[100];
			String v[]=new String[100];
			String b[]=new String[100];
			String n[]=new String[100];
			String m[]=new String[100];
			String answers[]=new String[100];
		for(int i=0;i<c;i++){
			question[i]=req.getParameter("ques"+(i+1));
			v[i]=req.getParameter("opta"+(i+1));
			b[i]=req.getParameter("optb"+(i+1));
			n[i]=req.getParameter("optc"+(i+1));
			m[i]=req.getParameter("optd"+(i+1));
			answers[i]=req.getParameter("optas"+(i+1));
		}
        try
        {
			Connection conn = dcon.gcon();
            Statement stmt = null;
            if(conn == null){
                res.sendRedirect("error.jsp");
            }
			stmt = conn.createStatement();
			int d=0;
            while (d<tq)
                {   
				if (tq==d)
                    {
						break;
                    }
			String sql = "SELECT * FROM "+t11+";";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsm = rs.getMetaData();
            int rep = rsm.getColumnCount();
            String col = null;
            String pc = null;
            for (int i=1;i<= rep;i++){
                if(i==1){
                    col =rsm.getColumnName(i);
                    pc = "?";
                } else {
                    col=(col+","+rsm.getColumnName(i));
                    pc=(pc+","+"?");
                }
            }
			String sql1 = "INSERT INTO "+t11+" ("+col+") VALUES ("+pc+");";
            PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setString(1,question[d]);
			pstmt1.setString(2,v[d]);
			pstmt1.setString(3,b[d]);
			pstmt1.setString(4,n[d]);
			pstmt1.setString(5,m[d]);
			pstmt1.setString(6,answers[d]);
			pstmt1.executeUpdate();
			d++;
			}
						conn.close();       
	int credit1=tq*5;
	req.getSession().setAttribute("cred",credit1);
	res.sendRedirect("result.jsp");
	}
	catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        }
	}