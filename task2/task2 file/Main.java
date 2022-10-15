import java.util.*;
import java.lang.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException; 
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
        Addcourse1 ac1=new Addcourse1();
		String addCourse[] = new String[10];
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("Enter how many course are you going to add?");
        Scanner ins = new Scanner(System.in);
        ac1.N= ins.nextInt();
        try
        { 
            File file = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\course.txt");
            FileWriter file1 = new FileWriter(file,true);
            BufferedWriter output1 = new BufferedWriter(file1);
            for(int i=0;i<ac1.N;i++)
            {
                Scanner in = new Scanner(System.in); 
                String t=null;
                System.out.print("Enter Course name:");
                addCourse[0]=in.nextLine();
                System.out.print("Enter the ID:");
                addCourse[1]=in.nextLine();
                System.out.print("Enter Course Description:");
                addCourse[2]=in.nextLine();
                System.out.print("Enter the Type:");
                addCourse[3]=in.nextLine();
                System.out.println("Enter a category : 1.Upsc 2.group1 3.group2");
                int t1 =in.nextInt();
                switch(t1)
                {
                    case 1:
                        t="Upsc";
                        break;
                    case 2:
                        t="group1";
                        break;
                    case 3:
                        t="group2";
                        break;
                }
                addCourse[4]=t;
                addCourse[5]= formattedDate;
                addCourse[6]=formattedDate;
				String line;
				line = addCourse[0]+"//"+addCourse[1]+"//"+addCourse[2]+"//"+addCourse[3]+"//"+addCourse[4]+"//"+addCourse[5]+"//"+addCourse[6];
				output1.write(line);
				output1.newLine();
            }
            output1.close();
	        file1.close();
        }
        catch(Exception e) 
        {
        System.out.println(e.getMessage());
        }
    }
    public static void update()
    { 
        Addcourse1 ac1=new Addcourse1();
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        formattedDate1 = myDateObj.format(myFormatObj);
        Scanner ins = new Scanner(System.in);
		String upCourse[] = new String[7];
	try
        {     
            File file = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\course.txt");
            FileReader filer = new FileReader(file);
            BufferedReader outputr = new BufferedReader(filer);
	        File filet1 = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\t.txt");
            FileWriter file3 = new FileWriter(filet1);
            BufferedWriter output3 = new BufferedWriter(file3);
            System.out.println("\nEnter which ID you need to update:");
            String a= ins.nextLine();
            System.out.println("\nChoose any \n 1.Course name\n 2.ID\n 3.Course Description\n 4.Type\n 5.Category\n");
            int w= ins.nextInt();
			String line1;
			String chLine[] = new String[8];
            while((line1 = outputr.readLine()) != null)
            {
				chLine=line1.split("//");
				if(!a.equals(chLine[1])){
					String join = chLine[0]+"//"+chLine[1]+"//"+chLine[2]+"//"+chLine[3]+"//"+chLine[4]+"//"+chLine[5]+"//"+chLine[6];
					output3.write(join);
					output3.newLine();
				}
           else if(a.equals(chLine[1]))
             {  
		        String joinup;
                Scanner ins1 = new Scanner(System.in);
            	if(w==1)
            	{
                    System.out.println("\nEnter the details to be changed:");
                    chLine[0]=ins1.nextLine();
                    chLine[6]= formattedDate1;
					joinup = chLine[0]+"//"+chLine[1]+"//"+chLine[2]+"//"+chLine[3]+"//"+chLine[4]+"//"+chLine[5]+"//"+chLine[6];
					output3.write(joinup);
					output3.newLine();
            	}
            	else if(w==2)
            	{
                    System.out.println("\nEnter the details to be changed:");
                    chLine[1]=ins1.nextLine();
                    chLine[6]= formattedDate1; 
					joinup = chLine[0]+"//"+chLine[1]+"//"+chLine[2]+"//"+chLine[3]+"//"+chLine[4]+"//"+chLine[5]+"//"+chLine[6];
					output3.write(joinup);	
					output3.newLine();					
                }
            	else if(w==3)
            	{
                    System.out.println("\nEnter the details to be changed:");
                    chLine[2]=ins1.nextLine();
                    chLine[6]= formattedDate1;  
					joinup = chLine[0]+"//"+chLine[1]+"//"+chLine[2]+"//"+chLine[3]+"//"+chLine[4]+"//"+chLine[5]+"//"+chLine[6];
					output3.write(joinup);		
					output3.newLine();				
                }
            	else if(w==4)
            	{
                    System.out.println("\nEnter the details to be changed:");
                    chLine[3]=ins1.nextLine();
            	    chLine[6]= formattedDate1;    
					joinup = chLine[0]+"//"+chLine[1]+"//"+chLine[2]+"//"+chLine[3]+"//"+chLine[4]+"//"+chLine[5]+"//"+chLine[6];
					output3.write(joinup);	
					output3.newLine();					
            	}
                else if(w==5)
            	{
            	    System.out.println("Enter the category to be changed : 1.Upsc 2.group1 3.group2");
                    int t1 =ins.nextInt();
            	    String t=null;
                    switch(t1)
                    {
                        case 1:
                            t="Upsc";
                            break;
                        case 2:
                            t="group1";
                            break;
                        case 3:
                            t="group2";
                            break;
                    }
                    chLine[4]=t;
            	    chLine[6]= formattedDate1;   
					joinup = chLine[0]+"//"+chLine[1]+"//"+chLine[2]+"//"+chLine[3]+"//"+chLine[4]+"//"+chLine[5]+"//"+chLine[6];
					//System.out.println(joinup);
					output3.write(joinup);	
output3.newLine();					
                    //break;
                }
                }
        }
            
			outputr.close();   
			filer.close();
			output3.close();
            file3.close();
            file.delete();
            filet1.renameTo(file);
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
    }
    public static void delete()
    {
        Scanner in =new Scanner(System.in);
        String[][] str12=new String[10][7];
        Addcourse1 ac1=new Addcourse1();
        System.out.println("\nEnter which ID you need to delete");
        String a= in.nextLine();
		try
            { 
            	    File file = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\course.txt");
                    File filet = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\temp.txt");
                    FileReader file1 = new FileReader(file);
                    FileWriter file2 = new FileWriter(filet);
                    BufferedReader output1 = new BufferedReader(file1);
                    BufferedWriter output2 = new BufferedWriter(file2);
					
			String line1;
			String chLine[] = new String[8];
            while((line1 = output1.readLine()) != null)
            {
				chLine=line1.split("//");
				//System.out.println(chLine[0]);
				if(!a.equals(chLine[1])){
					String join = chLine[0]+"//"+chLine[1]+"//"+chLine[2]+"//"+chLine[3]+"//"+chLine[4]+"//"+chLine[5]+"//"+chLine[6];
					output2.write(join);
					output2.newLine();
				}
			}
                	output1.close();
                   	output2.close();
                	file1.close();
                	file2.close();
                    	file.delete();
                    	filet.renameTo(file);
            }
                catch(Exception e) 
                {
                    System.out.println(e.getMessage());
                }
    }
	
    public static void view()
    {   
        LocalDateTime myDateObj = LocalDateTime.now();  
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy_HH:mm:ss");  

        try
        {
            File file = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\course.txt");
            FileReader file1 = new FileReader(file);
            BufferedReader output1 = new BufferedReader(file1);
            String st;
			String viewCourse[] = new String[8];
            System.out.println("Coursename  |  ID  |  Decription  |  Type  |  Category  |  C_time  |  M_time \n");
            while ((st = output1.readLine()) != null)
            {
                viewCourse = st.split("//");
				System.out.println(viewCourse[0]+" | "+viewCourse[1]+" | "+viewCourse[2]+" | "+viewCourse[3]+" | "+viewCourse[4]+" | "+viewCourse[5]+" | "+viewCourse[6]);
            }
            output1.close();
        	file1.close();
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
        int i=0;
        Scanner s=new Scanner(System.in);
        Addcourse a=new Addcourse();
        try 
        {
            File file = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\reg.txt");
            FileWriter file1 = new FileWriter(file,true);
            BufferedWriter output = new BufferedWriter(file1);
            File file4 = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\Userdetails.txt");
            FileWriter file5 = new FileWriter(file4,true);
            BufferedWriter output1 = new BufferedWriter(file5);
            System.out.print("Enter Username:");
            a.addcourse[i][0]=s.nextLine();
            System.out.print("Enter Password:");
            a.addcourse[i][1]=s.nextLine();
            System.out.print("Enter Full name:");
            a.addcourse[i][2]=s.nextLine()+" ";
            System.out.print("Enter Mobile number:");
            a.addcourse[i][3]=s.nextLine()+" ";
            System.out.print("Enter City:");
            a.addcourse[i][4]=s.nextLine()+" ";
            output.write(a.addcourse[i][0]);
            output.newLine();
            output.write(a.addcourse[i][1]);
            output.newLine();
            output.close();
            output1.newLine();
            output1.write(a.addcourse[i][2]);
            output1.write(a.addcourse[i][3]);
            output1.write(a.addcourse[i][4]);
            output1.close();
            file1.close();
            file5.close();
            i++;
            a.z++;
            System.out.println("Registration completed\nPlease wait until login page displayed");
            Login();
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
            String sep;
            String line;
            File file = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\reg.txt");
            FileReader file1 = new FileReader(file);
            BufferedReader output = new BufferedReader(file1);
            String [][] t=new String[1][2];
            Scanner s=new Scanner(System.in);
            Addcourse a=new Addcourse();
            System.out.print(" Enter user name => ");
            t[0][0]=s.nextLine();
            System.out.print(" Enter password  => ");
            t[0][1]=s.nextLine();
            while((line=output.readLine())!=null)
            {
                sep=output.readLine();
                if(((line).equals(t[0][0]))&&((sep).equals(t[0][1])))
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
            output.close();  
            file1.close();  
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
        Addcourse1 ac1=new Addcourse1();
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
            File fil = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\upscq.txt");
            FileWriter fil1 = new FileWriter(fil,true);
            BufferedWriter outpu1 = new BufferedWriter(fil1);
            File fila = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\upsca.txt");
            FileWriter fila1 = new FileWriter(fila,true);
            BufferedWriter outputa = new BufferedWriter(fila1);
            System.out.println("Enter how many question you are going to be added ?");
            Scanner ins =new Scanner(System.in);
            int tq=ins.nextInt();
            int b=1;
            for(int a=0;a<tq;a++)
            {
                System.out.println((b)+"Enter the question with option");
                Scanner inns =new Scanner(System.in);
                String question=inns.nextLine();
                System.out.println((b)+"Enter the answer in option");
                String answers=inns.nextLine();
                outpu1.write("\n"+question);
                outputa.write("\n"+answers);
                b++;
            }
			System.out.println("your credit is "+tq*5);
            outpu1.close();
            fil1.close();
            outputa.close();
            fila1.close();
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
            File filg = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\group1q.txt");
            FileWriter filg1 = new FileWriter(filg,true);
            BufferedWriter outpu2 = new BufferedWriter(filg1);
            File filga = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\group1a.txt");
            FileWriter filga1 = new FileWriter(filga,true);
            BufferedWriter outputga = new BufferedWriter(filga1);
            System.out.println("Enter how many question you are going to be added ?");
            Scanner ins =new Scanner(System.in);
            int tq=ins.nextInt();
            int b=1;
            for(int a=0;a<tq;a++)
            {
                System.out.println((b)+"Enter the question with option");
                Scanner inns =new Scanner(System.in);
                String question=inns.nextLine();
                System.out.println((b)+"Enter the answer in option");
                String answers=inns.nextLine();
                outpu2.write("\n"+question);
                outputga.write("\n"+answers);
                b++;
            }
			System.out.println("your credit is "+tq*5);
            outpu2.close();
            filg1.close();
            outputga.close();
            filga1.close();
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
            File filg1 = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\group2q.txt");
            FileWriter filg2 = new FileWriter(filg1,true);
            BufferedWriter outpu3 = new BufferedWriter(filg2);
            File filga1 = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\group2a.txt");
            FileWriter filga2 = new FileWriter(filga1,true);
            BufferedWriter outputga2 = new BufferedWriter(filga2);
            System.out.println("Enter how many question you are going to be added ?");
            Scanner ins =new Scanner(System.in);
            int tq=ins.nextInt();
            int b=1;
            for(int a=0;a<tq;a++)
            {
                System.out.println((b)+"Enter the question with option");
                Scanner inns =new Scanner(System.in);
                String question=inns.nextLine();
                System.out.println((b)+"Enter the answer in option");
                String answers=inns.nextLine();
                outpu3.write("\n"+question);
                outputga2.write("\n"+answers);
                b++;
            }
		System.out.println("your credit is "+tq*5);
            outpu3.close();
            filg2.close();
            outputga2.close();
            filga2.close();
            }
            catch (Exception e) 
            {
                System.out.println(e.getMessage());
            }
        }
    public static void Taketest()
    {
        view();
        Addcourse1 ac1=new Addcourse1();
		try{	File file = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\course.txt");
            FileReader filer = new FileReader(file);
                   BufferedReader outputr = new BufferedReader(filer);
					String line1;
					 String z="";
        Scanner ins =new Scanner(System.in);
        System.out.println("Enter Course Id:" );
        String a1 = ins.nextLine();
					String chLine[] = new String[8];
					while((line1 = outputr.readLine()) != null)
					{
						chLine=line1.split("//");
						//System.out.println(chLine[0]);
						if(a1.equals(chLine[1])){
							//String join = chLine[0]+"//"+chLine[1]+"//"+chLine[2]+"//"+chLine[3]+"//"+chLine[4]+"//"+chLine[5]+"//"+chLine[6];
							z=chLine[4];
						}
					}
        int c=0;
        String k="Upsc";
        String l="group1";
        String m="group2";
        int credit1=0;
        if(z.equals(k))
        {
            try
            {   
                File fil = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\upscq.txt");
                FileReader fil1 = new FileReader(fil);
                BufferedReader outpu1 = new BufferedReader(fil1);
                File fila = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\upsca.txt");
                FileReader fila1 = new FileReader(fila);
                BufferedReader outputa = new BufferedReader(fila1);
                File filetemp = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\tempa.txt");
                FileWriter filetempa = new FileWriter(filetemp);
                BufferedWriter outtemp = new BufferedWriter(filetempa);
		FileReader filetempa1 = new FileReader(filetemp);
                BufferedReader outtemp1 = new BufferedReader(filetempa1);
                String st;
                String ans;
                String tans;
                int p=0;
		int q=0;
                String ch[]=new String[90];
                String ch1[]=new String[90];
                Scanner inst =new Scanner(System.in);
                System.out.println("How many questions going to attend ? (min:5)");
                int qs=inst.nextInt();
                int d=0;
                while ((st = outpu1.readLine()) != null)
                {   
                    if (qs==d)
                    {
                        break;
                    }
                    System.out.println(st);
                    d++;
                }
		        outpu1.close();
                fil1.close();
    	        System.out.println("Enter the answers");
                for(int w=0;w<d;w++)
                {
                    outtemp.write(ins.nextLine().charAt(0));
            	    outtemp.write("\n");
                }
				outtemp.close();
                filetempa.close();	
                while((ans = outputa.readLine()) != null)
                {
                    ch[p]=ans;
                    p=p+1;
                }
				outputa.close();
                fila1.close();
                while((tans = outtemp1.readLine()) != null)
                {
                    ch1[q]=tans;
                    q=q+1;
                }
				outtemp1.close();                
				filetempa1.close();
                for(int g=0;g<d;g++)
                {
                    if(ch[g].equals(ch1[g]))
                    {
                        credit1=credit1+1; 
                    }
                }
                System.out.println("Your Credit is:"+credit1);
            }   
            catch(Exception e) 
            {
                System.out.println(e.getMessage());
            }   
        }
       else if((z).equals(l))
        {
            try
            {   
                File filz = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\group1q.txt");
                FileReader fil1z = new FileReader(filz);
                BufferedReader outpu1z = new BufferedReader(fil1z);
                File filaz = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\group1a.txt");
                FileReader fila1z = new FileReader(filaz);
                BufferedReader outputaz = new BufferedReader(fila1z);
                File filetempz = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\tempa.txt");
                FileWriter filetempaz = new FileWriter(filetempz);
                BufferedWriter outtempz = new BufferedWriter(filetempaz);
				FileReader filetempa1z= new FileReader(filetempz);
                BufferedReader outtemp1z = new BufferedReader(filetempa1z);
                String st;
                String ans;
                String tans;
                int p=0;
				int q=0;
                String ch[]=new String[90];
                String ch1[]=new String[90];
                Scanner inst =new Scanner(System.in);
                System.out.println("How many questions going to attend ? (min:5)");
                int qs=inst.nextInt();
                int d=0;
                while ((st = outpu1z.readLine()) != null)
                {   
                    if (qs==d)
                    {
                        break;
                    }
                    System.out.println(st);
                    d++;
                }
				outpu1z.close();
                fil1z.close();
    	        System.out.println("Enter the answers");
                for(int w=0;w<d;w++)
                {
                    outtempz.write(ins.nextLine().charAt(0));
            	    outtempz.write("\n");
                }
				outtempz.close();
                filetempaz.close();	
                while((ans = outputaz.readLine()) != null)
                {
                    ch[p]=ans;
                    p=p+1;
                }
				outputaz.close();
                fila1z.close();
                while((tans = outtemp1z.readLine()) != null)
                {
                    ch1[q]=tans;
                    q=q+1;
                }
				outtemp1z.close();                
				filetempa1z.close();
                for(int g=0;g<d;g++)
                {
                    if(ch[g].equals(ch1[g]))
                    {
                        credit1=credit1+1; 
                    }
                }
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
                File fily = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\group2q.txt");
                FileReader fil1y = new FileReader(fily);
                BufferedReader outpu1y = new BufferedReader(fil1y);
                File filay = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\group2a.txt");
                FileReader fila1y = new FileReader(filay);
                BufferedReader outputay = new BufferedReader(fila1y);
                File filetempy = new File("C:\\Users\\guna-pt6152\\Desktop\\task\\tempa.txt");
                FileWriter filetempay = new FileWriter(filetempy);
                BufferedWriter outtempy = new BufferedWriter(filetempay);
				FileReader filetempa1y = new FileReader(filetempy);
                BufferedReader outtemp1y = new BufferedReader(filetempa1y);
                String st;
                String ans;
                String tans;
                int p=0;
				int q=0;
                String ch[]=new String[90];
                String ch1[]=new String[90];
                Scanner inst =new Scanner(System.in);
                System.out.println("How many questions going to attend ? (min:5)");
                int qs=inst.nextInt();
                int d=0;
                while ((st = outpu1y.readLine()) != null)
                {   
                    if (qs==d)
                    {
                        break;
                    }
                    System.out.println(st);
                    d++;
                }
				outpu1y.close();
                fil1y.close();
    	        System.out.println("Enter the answers");
                for(int w=0;w<d;w++)
                {
                    outtempy.write(ins.nextLine().charAt(0));
            	    outtempy.write("\n");
                }
				outtempy.close();
                filetempay.close();	
                while((ans = outputay.readLine()) != null)
                {
                    ch[p]=ans;
                    p=p+1;
                }
				outputay.close();
                fila1y.close();
                while((tans = outtemp1y.readLine()) != null)
                {
                    ch1[q]=tans;
                    q=q+1;
                }
				outtemp1y.close();                
				filetempa1y.close();
                for(int g=0;g<d;g++)
                {
                    if(ch[g].equals(ch1[g]))
                    {
                        credit1=credit1+1; 
                    }
                }
                System.out.println("Your Credit is:"+credit1);
            }   
            catch(Exception e) 
            {
                System.out.println(e.getMessage());
            }   
        }
	outputr.close();   
			filer.close();
}
catch(Exception e) 
            {
                System.out.println(e.getMessage());
            }  
	}			
}
class Addcourse
{
    public static String[][] addcourse=new String[5][5];
    public static int z=0;
}
class Addcourse1
{
    LocalDateTime myDateObj = LocalDateTime.now();  
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    public String formattedDate = myDateObj.format(myFormatObj); 
    public String formattedDate1 = myDateObj.format(myFormatObj);
    public static String[][] addcourse1=new String[10][10];
    public static int d;
    public static int N;
}