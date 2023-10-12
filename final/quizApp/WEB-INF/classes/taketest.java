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
@WebServlet("/taketest")
public class taketest extends HttpServlet {
	public void doPost(HttpServletRequest req , HttpServletResponse res) throws IOException
    {
	String a1=(String)req.getSession().getAttribute("data1");
	int c=Integer.parseInt(req.getParameter("c"));
	int qs=(int)req.getSession().getAttribute("data2");
				String ch[]=new String[90];
		for(int i=0;i<c;i++){
			ch[i]=req.getParameter("choice"+(i+1));
		}
		try{
			Connection conn = dcon.gcon();
            Statement stmt = null;
			if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN;");
			String cidt = null,aq=null,z=null;
            while(rs.next())
            {
				cidt = rs.getString("ID");
				aq=rs.getString("CATEGORY");
				if(cidt.equalsIgnoreCase(a1)){
					z=aq;
				}
			}
        int g=0,credit1=0,d=0;
			ResultSet rs1 = stmt.executeQuery("SELECT * FROM "+z+";");
				String ch1;
                while (rs1.next())
                {   
				if (qs==d)
                    {
						break;
                    }
                    ch1=rs1.getString("ANS");
				if(ch1.equals(ch[g])){
					credit1=credit1+1;
					}
                    g++;
					d++;
				}      
 req.getSession().setAttribute("cred",credit1);
 res.sendRedirect("result.jsp");
 conn.close();

		}catch(Exception e) 
            {
                System.out.println(e.getMessage());
            }  
	}	
}