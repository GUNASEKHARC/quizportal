import java.util.Scanner;
import java.lang.*;
import java.util.Date;
import java.text.DateFormat;
import java.util.Calendar;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet; 
import java.sql.PreparedStatement;
public class Main
{
    static String formattedDate1;
    public static void main (String[]args)
    {
        boolean keepGoing=true;
        while(keepGoing)
        {
            try 
            {
                System.out.println ("Welcome to Question bank Portal\nPlease enter 1 for Admin, 2 for User & 3 for exit");
                Scanner in = new Scanner(System.in);
                int ch1 = in.nextInt();
                switch(ch1)
                {
                    case 1: 
                        Admin();
                        break;
                    case 2: 
                        User();
                        break;
                    case 3:
                        keepGoing=false;
                        break;	
                }
            }
            catch (Exception e) 
            {
                System.out.println("OOPS ! PLEASE ENTER NUMBER ONLY");
            }
        }
    }
    public static void Admin()
    { 
        boolean keepGoing=true;
        do
        {
            try 
            {
            System.out.println("\nEnter Number for making opertions to\n1.addcourse|2.update|3.delete|4.view|5.exit");
            Scanner in = new Scanner(System.in);
            int ach = in.nextInt();
            switch(ach)
            {
                case 1: 
                    addcourse();
                    break;
                case 2: 
                    update();
                    break;
                case 3: 
                    delete();
                    break;
                case 4: 
                    view();
                    break;
                case 5:
                    keepGoing=false;
                    break;
            }
        }
        catch (Exception e) 
        {
            System.out.println("OOPS ! PLEASE ENTER NUMBER ONLY");
        }
        }while(keepGoing);
    }
    public static void addcourse()
    {
		String cname,cid,desc,type,cat=null;
        Date date=Calendar.getInstance().getTime();
		//Dateformat dateFormat=new SimpleDateFormat("yyyy-mm-dd");
        Scanner ins = new Scanner(System.in);
        try
        {
		System.out.println("Enter how many course are you going to add?");
		int N= ins.nextInt();
          for(int i=0;i<N;i++)
           {		Class.forName("org.postgresql.Driver");
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
            if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN;");
                Scanner in = new Scanner(System.in); 
                String t=null;
                System.out.print("Enter Course name:");
                cname=in.nextLine();
                System.out.print("Enter the ID:");
                cid=in.nextLine();
                System.out.print("Enter Course Description:");
                desc=in.nextLine();
                System.out.print("Enter the Type:");
                type=in.nextLine();
                System.out.println("Enter a category : 1.Upsc 2.group1 3.group2");
                int t1 =in.nextInt();
                switch(t1)
                {
                    case 1:
                        cat="Upsc";
                        break;
                    case 2:
                        cat="group1";
                        break;
                    case 3:
                        cat="group2";
                        break;
                }
				String ctime=Calendar.getInstance().getTime().toString();
				String mtime=Calendar.getInstance().getTime().toString();
			String sql = "INSERT INTO ADMIN (COURSENAME,ID,DESCRIPTION,TYPE,CATEGORY,CTIME,MTIME) VALUES (?,?,?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,cname);
			pstmt.setString(2,cid);
			pstmt.setString(3,desc);
			pstmt.setString(4,type);
			pstmt.setString(5,cat);
			pstmt.setString(6,ctime);
			pstmt.setString(7,mtime);
			pstmt.executeUpdate();
			conn.close();
		}
		}
        catch(Exception e) 
        {
        System.out.println(e.getMessage());
        }
    }
    public static void update()
    { 
		Date date=Calendar.getInstance().getTime();
        Scanner ins = new Scanner(System.in);
	try
        {     String cname,cid,desc,type,cat=null,ctime;
            System.out.println("\nEnter which, ID you need to update:");
            String aid= ins.nextLine();
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
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
		{	System.out.println("\nChoose any \n 1.Course name\n 2.ID\n 3.Course Description\n 4.Type\n 5.Category\n");
            int w= ins.nextInt();
                Scanner ins1 = new Scanner(System.in);
            	if(w==1)
            	{
                    System.out.println("\nEnter the details to be changed:");
                    cname=ins1.nextLine();
                    String mtime=Calendar.getInstance().getTime().toString();

					String sql = "UPDATE ADMIN SET COURSENAME = ?,MTIME = ? WHERE ID = ?;";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,cname);
					pstmt.setString(2,mtime);
					pstmt.setString(3,aid);
					pstmt.executeUpdate();
					conn.close();
				}
            	else if(w==2)
            	{
                    System.out.println("\nEnter the details to be changed:");
                    cid=ins1.nextLine();
                    String mtime=Calendar.getInstance().getTime().toString();
					String sql = "UPDATE ADMIN SET ID = ?,MTIME = ? WHERE ID = ?;";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,cid);
					pstmt.setString(2,mtime);
					pstmt.setString(3,aid);
					pstmt.executeUpdate();
					conn.close();
				}
            	else if(w==3)
            	{
                    System.out.println("\nEnter the details to be changed:");
                    desc=ins1.nextLine();
                    String mtime=Calendar.getInstance().getTime().toString();	
					String sql = "UPDATE ADMIN SET DESCRIPTION = ?,MTIME = ? WHERE ID = ?;";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,desc);
					pstmt.setString(2,mtime);
					pstmt.setString(3,aid);
					pstmt.executeUpdate();
					conn.close();
                }
            	else if(w==4)
            	{
                    System.out.println("\nEnter the details to be changed:");
                    type=ins1.nextLine();
            	    String mtime=Calendar.getInstance().getTime().toString();   
					String sql = "UPDATE ADMIN SET TYPE = ?,MTIME = ? WHERE ID = ?;";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,type);
					pstmt.setString(2,mtime);
					pstmt.setString(3,aid);
					pstmt.executeUpdate();
					conn.close();					
            	}
                else if(w==5)
            	{
            	    System.out.println("Enter the category to be changed : 1.Upsc 2.group1 3.group2");
                    int t1 =ins.nextInt();
            	    String t=null;
                    switch(t1)
                    {
                        case 1:
                            cat="Upsc";
                            break;
                        case 2:
                            cat="group1";
                            break;
                        case 3:
                            cat="group2";
                            break;
                    }
            	    String mtime=Calendar.getInstance().getTime().toString();
					String sql = "UPDATE ADMIN SET CATEGORY = ?,MTIME = ? WHERE ID = ?;";
					PreparedStatement pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,cat);
					pstmt.setString(2,mtime);
					pstmt.setString(3,aid);
					pstmt.executeUpdate();
					conn.close();	
                }
				else if(allowq==0)
				{System.out.println("Something Went Wrong!!");}
        }
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
    }
    public static void delete()
    {
        Scanner in =new Scanner(System.in);
		try
            { System.out.println("\nEnter which ID you need to delete");
			String aid= in.nextLine();
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
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
				System.out.println("\t OOPS ! INVALID COURSE ID");
                
			}
			}catch(Exception e) 
                {
                    System.out.println(e.getMessage());
                }
    }
	
    public static void view()
    {   String cname,cid,desc,type,cat,ctime,mtime;
        try
        {Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
			if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM ADMIN;");
			System.out.println("Coursename  |  ID  |  Decription  |  Type  |  Category  |  C_time  |  M_time \n");
            while (rs.next())
            {
			conn = DriverManager.getConnection(url);
            
			if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
            stmt = conn.createStatement();
				cname= rs.getString("COURSENAME");
				cid= rs.getString("ID");
				desc= rs.getString("DESCRIPTION");
				type= rs.getString("TYPE");
				cat= rs.getString("CATEGORY");
				ctime= rs.getString("CTIME");
				mtime= rs.getString("MTIME");
				System.out.println(cname+" | "+cid+" | "+desc+" | "+type+" | "+cat+" | "+ctime+" | "+mtime);
				stmt.close();
				conn.close();
			}
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void User()
    {
        System.out.println("\nEnter Number for making opertions to\n1.Registration|2.login");
        Scanner in = new Scanner(System.in);
        int uch = in.nextInt();
        switch(uch)
        {
            case 1: 
                Registration();
                break;
            case 2: 
                Login();
                break;
        }
    }
    public static void Registration()
    {
        int count=0;
		String usernames,pass,fname,mno,city;
        Scanner s=new Scanner(System.in);
        try 
        {
			System.out.print("Enter Username:");
            usernames =s.nextLine();
			Class.forName("org.postgresql.Driver");
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
			if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
            stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");
			while(rs.next()){
                String username = rs.getString("username");
                if(username.equals(usernames)){
                    count++;
				}
			 }
			 rs.close();
			 stmt.close();
			 if(count ==0)
			 {	 
            System.out.print("Enter Password:");
            pass=s.nextLine();
            System.out.print("Enter Full name:");
            fname=s.nextLine();
            System.out.print("Enter Mobile number:");
            mno=s.nextLine();
            System.out.print("Enter City:");
            city=s.nextLine();
			String sql = "INSERT INTO USERS (USERNAME,PASSWORD,FULLNAME,MOBILENO,CITY) VALUES (?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,usernames);
            pstmt.setString(2,pass);
			pstmt.setString(3,fname);
			pstmt.setString(4,mno);
			pstmt.setString(5,city);
            pstmt.executeUpdate();
            conn.close();
			System.out.println("Registration completed\nPlease wait until login page displayed");		
		    Login();
			 }
			  else {
                System.out.println("\t OOPS ! USERNAME ALREADY TAKEN OR SOMETHING WENT WRONG. TRY AGAIN.");
            }
            stmt.close();
            conn.close();
	   }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    public static void Login()
    {   
        int flag=1;
        try
        {
            String tuser,tpass;
            Scanner s=new Scanner(System.in);
            System.out.print(" Enter user name => ");
            tuser=s.nextLine();
            System.out.print(" Enter password  => ");
			tpass=s.nextLine();
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
            
			if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
			stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM USERS;");
            
			while(rs.next())
			{
                String username = rs.getString("username");
				String password = rs.getString("password");
                if(((username).equals(tuser))&&((password).equals(tpass)))
                {
                    System.out.println(" User successfully logged-in.. ");
                    System.out.println("Enter 1.Take_questions 2.Take_test");
                    Scanner as=new Scanner(System.in);
                	int q= as.nextInt();
                    switch(q)
                	{
                		case 1:
                			Takequestions();
                			break;
                		 case 2:
                			Taketest();
                			break;
                	}
                flag=0;
                }
            }
			rs.close();
            stmt.close();
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
        if(flag!=0)
        {
            System.out.println("Login Unsuccessful");
        } 
    }
    public static void Takequestions()
    {
        Scanner ins =new Scanner(System.in);
        System.out.println("Enter the category 1.Upsc 2.group1 3.group2 to add questions with options");
        int t1 =ins.nextInt();
	    String t="null";
        switch(t1)
            {
                case 1:
                    t="Upsc";
        	    	upscq();
                    break;
                case 2:
                    t="group1";
        		    group1q();
                    break;
                case 3:
                    t="group2";
        		    group2q();
                    break;
            }
    }
    public static void upscq()
    {
        try
        {
            Scanner ins =new Scanner(System.in);
			System.out.println("Enter how many question you are going to be added ?");
			int tq=ins.nextInt();
            for(int a=0;a<tq;a++)
            {
				Class.forName("org.postgresql.Driver");
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
            if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM UPSC;");
				Scanner inns =new Scanner(System.in);
				System.out.println("Enter the question:");
                String question=inns.nextLine();
				System.out.println("Enter option a");
                String v=inns.nextLine();
				System.out.println("Enter option b");
                String b=inns.nextLine();
				System.out.println("Enter option c");
                String n=inns.nextLine();
				System.out.println("Enter option d");
                String m=inns.nextLine();
                System.out.println("Enter the answer in option");
                String answers=inns.nextLine();
            String sql = "INSERT INTO UPSC (QUESTIONS,A,B,C,D,ANS) VALUES (?,?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,question);
			pstmt.setString(2,v);
			pstmt.setString(3,b);
			pstmt.setString(4,n);
			pstmt.setString(5,m);
			pstmt.setString(6,answers);
			pstmt.executeUpdate();
			conn.close();
			}
			System.out.println("your credit is "+tq*5);
        }
        catch (Exception e) 
        {
            System.out.println(e.getMessage());
        }
    }
    public static void group1q()
    {
        try
        {
            System.out.println("Enter how many question you are going to be added ?");
            Scanner ins =new Scanner(System.in);
            int tq=ins.nextInt();
            for(int a=0;a<tq;a++)
            {Class.forName("org.postgresql.Driver");
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
            if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
                stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM GROUP1;");
				Scanner inns =new Scanner(System.in);
				System.out.println("Enter the question:");
                String question=inns.nextLine();
				System.out.println("Enter option a");
                String v=inns.nextLine();
				System.out.println("Enter option b");
                String b=inns.nextLine();
				System.out.println("Enter option c");
                String n=inns.nextLine();
				System.out.println("Enter option d");
                String m=inns.nextLine();
                System.out.println("Enter the answer in option");
                String answers=inns.nextLine();
            String sql = "INSERT INTO GROUP1 (QUESTIONS,A,B,C,D,ANS) VALUES (?,?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,question);
			pstmt.setString(2,v);
			pstmt.setString(3,b);
			pstmt.setString(4,n);
			pstmt.setString(5,m);
			pstmt.setString(6,answers);
			pstmt.executeUpdate();
			conn.close();
            }
			System.out.println("your credit is "+tq*5);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    public static void group2q()
    {
        try
        {
            System.out.println("Enter how many question you are going to be added ?");
            Scanner ins =new Scanner(System.in);
            int tq=ins.nextInt();
            for(int a=0;a<tq;a++)
            {
				Class.forName("org.postgresql.Driver");
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
            if(conn == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
                stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM GROUP2;");
				Scanner inns =new Scanner(System.in);
				System.out.println("Enter the question:");
                String question=inns.nextLine();
				System.out.println("Enter option a");
                String v=inns.nextLine();
				System.out.println("Enter option b");
                String b=inns.nextLine();
				System.out.println("Enter option c");
                String n=inns.nextLine();
				System.out.println("Enter option d");
                String m=inns.nextLine();
                System.out.println("Enter the answer in option");
                String answers=inns.nextLine();
            String sql = "INSERT INTO GROUP2 (QUESTIONS,A,B,C,D,ANS) VALUES (?,?,?,?,?,?);";
            PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,question);
			pstmt.setString(2,v);
			pstmt.setString(3,b);
			pstmt.setString(4,n);
			pstmt.setString(5,m);
			pstmt.setString(6,answers);
			pstmt.executeUpdate();
			conn.close();
            }
		System.out.println("your credit is "+tq*5);
            }
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        }
    public static void Taketest()
    {
        view();
		try{
			Scanner ins =new Scanner(System.in);
			System.out.println("Enter Course Id:" );
			String a1 = ins.nextLine();
			Connection conn = null;
            Statement stmt = null;
			String url = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn = DriverManager.getConnection(url);
            
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
        int c=0;
        String k="Upsc",l="group1",m="group2";
        int credit1=0;
        if(z.equals(k))
        {
            try
            {   
			Connection conn1 = null;
            Statement stmt1 = null;
			String url1 = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn1 = DriverManager.getConnection(url1);
            
			if(conn1 == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
            stmt1 = conn1.createStatement();
			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM UPSC;");
            Scanner inst =new Scanner(System.in);
                System.out.println("How many questions going to attend ? (min:5)");
                int qs=inst.nextInt();
                int d=0;
				String ch[]=new String[90];
				String ch1[]=new String[90];
				System.out.println("Answer the questions in a/b/c/d");
                while (rs1.next())
                {   
				if (qs==d)
                    {
						break;
                    }
				String question= rs1.getString("QUESTIONS");
				String v= rs1.getString("A");
				String b= rs1.getString("B");
				String n= rs1.getString("C");
				String m1= rs1.getString("D");
				System.out.println("Question"+(d+1)+":"+question+"(a)"+v+"(b)"+b+"(c)"+n+"(d)"+m1);
				     ch[d]=ins.nextLine(); 
                    ch1[d]=rs1.getString("ANS");
                    d++;
				}    
			for(int i=0;i<d;i++){
				if(ch[i].equals(ch1[i])){
					credit1=credit1+1;
				}
			}
			conn.close();
                System.out.println("Your Credit is:"+credit1);  
            }catch(Exception e) 
            {
                System.out.println(e.getMessage());
            }   
        }
   else if((z).equals(l))
        {
            try
            {   
			Connection conn1 = null;
            Statement stmt1 = null;
			String url1 = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn1 = DriverManager.getConnection(url1);
            
			if(conn1 == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
            stmt1 = conn1.createStatement();
			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM GROUP1;");
            Scanner inst =new Scanner(System.in);
                System.out.println("How many questions going to attend ? (min:5)");
                int qs=inst.nextInt();
                int d=0;
				String ch[]=new String[90];
				String ch1[]=new String[90];
				System.out.println("Answer the questions in a/b/c/d");
                while (rs1.next())
                {   
				if (qs==d)
                    {
						break;
                    }
				String question= rs1.getString("QUESTIONS");
				String v= rs1.getString("A");
				String b= rs1.getString("B");
				String n= rs1.getString("C");
				String m1= rs1.getString("D");
				System.out.println("Question"+(d+1)+":"+question+"(a)"+v+"(b)"+b+"(c)"+n+"(d)"+m1);
				     ch[d]=ins.nextLine(); 
                    ch1[d]=rs1.getString("ANS");
                    d++;
				}    

			for(int i=0;i<d;i++){
				if(ch[i].equals(ch1[i])){
					credit1=credit1+1;
				}
			}
			conn.close();
                System.out.println("Your Credit is:"+credit1);  
            }
            catch(Exception e) 
            {
                System.out.println(e.getMessage());
            }   
        }
    else if((z).equals(m))
        {
            try
            {   
			Connection conn1 = null;
            Statement stmt1 = null;
			String url1 = "jdbc:postgresql://localhost/quizportal?user=postgres&password=admin";
			conn1 = DriverManager.getConnection(url1);
            
			if(conn1 == null){
                System.out.println("\t OOPS ! COULDN'T CONNECT TO THE DATABASE");
            }
            stmt1 = conn1.createStatement();
			ResultSet rs1 = stmt1.executeQuery("SELECT * FROM GROUP2;");
            Scanner inst =new Scanner(System.in);
                System.out.println("How many questions going to attend ? (min:5)");
                int qs=inst.nextInt();
                int d=0;
				String ch[]=new String[90];
				String ch1[]=new String[90];
				System.out.println("Answer the questions in a/b/c/d");
                while (rs1.next())
                {   
				if (qs==d)
                    {
						break;
                    }
				String question= rs1.getString("QUESTIONS");
				String v= rs1.getString("A");
				String b= rs1.getString("B");
				String n= rs1.getString("C");
				String m1= rs1.getString("D");
				System.out.println("Question"+(d+1)+":"+question+"(a)"+v+"(b)"+b+"(c)"+n+"(d)"+m1);
				    ch[d]=ins.nextLine(); 
                    ch1[d]=rs1.getString("ANS");
                    d++;
				}    
			for(int i=0;i<d;i++){
				if(ch[i].equals(ch1[i])){
					credit1=credit1+1;
				}
			}
			conn.close();
                System.out.println("Your Credit is:"+credit1);  
            }   
            catch(Exception e) 
            {
                System.out.println(e.getMessage());
            }   
        }
}
catch(Exception e) 
            {
                System.out.println(e.getMessage());
            }  
	}			
}