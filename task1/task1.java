//Use Main.java as file name
import java.util.*;
import java.lang.*;
import java.time.LocalDateTime; // Import the LocalDateTime class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class
public class Main
{
    static String formattedDate1;
 public static void main (String[]args)
{

boolean keepGoing=true;
while(keepGoing)
{
    System.out.println ("Welcome to Quiz Portal\nPlease enter 1 for Admin, 2 for User & 3 for exit");
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
}
public static void Admin()
{ 
    boolean keepGoing=true;
    while(keepGoing)
    {
    System.out.println("Enter Number for making opertions to\n1.addcourse|2.update|3.delete|4.view|5.exit");
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
}
public static void addcourse()
{
    Addcourse1 ac1=new Addcourse1();
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    String formattedDate = myDateObj.format(myFormatObj);
    for(int i=0;i<2;i++)
    {
        String t="null";
        ac1.addcourse1[i][0]=null;
        Scanner in = new Scanner(System.in);
        System.out.println(i+". \nEnter Course name");
        ac1.addcourse1[i][0]=in.nextLine();
        System.out.println("Enter the ID");
        ac1.addcourse1[i][1]=in.nextLine();
        System.out.println("Enter Course Description");
        ac1.addcourse1[i][2]=in.nextLine();
        System.out.println("Enter the Type");
        ac1.addcourse1[i][3]=in.nextLine();
        System.out.println("Enter a  category \n 1.Upsc 2.group1 3.group2");
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
    ac1.addcourse1[i][4]=t;
    ac1.addcourse1[i][5]= formattedDate;
    }

    view();
}
public static void update()
{
    
    Addcourse1 ac1=new Addcourse1();
    LocalDateTime myDateObj = LocalDateTime.now();
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    formattedDate1 = myDateObj.format(myFormatObj);
    boolean keepGoing=true;
    Scanner ins = new Scanner(System.in);
    while(keepGoing)
    {
        int i;
    System.out.println("\nChoose any \n 1.Course name\n 2.ID\n 3.Course Description\n 4.Type\n 5.Category\n 6.To quit\n");
    int w= Integer.parseInt(ins.nextLine());
     switch(w)
     {    
        case 1:
            System.out.println("\nEnter which data in number you need to update ");
            i= Integer.parseInt(ins.nextLine());
            System.out.println("\nEnter the details to be changed:");
            ac1.addcourse1[i][0]=ins.nextLine();
                ac1.addcourse1[i][6]= formattedDate1;
            break;
        case 2:
            System.out.println("\nEnter which data in number you need to update ");
            i= Integer.parseInt(ins.nextLine());
            System.out.println("\nEnter the details to be changed:");
            ac1.addcourse1[i][1]=ins.nextLine();
                ac1.addcourse1[i][6]= formattedDate1;
            break;
        case 3:
            System.out.println("\nEnter which data in number you need to update ");
            i= Integer.parseInt(ins.nextLine());
            System.out.println("\nEnter the details to be changed:");
            ac1.addcourse1[i][2]=ins.nextLine();
                ac1.addcourse1[i][6]= formattedDate1;
            break;
        case 4:
            System.out.println("\nEnter which data in number you need to update ");
            i= Integer.parseInt(ins.nextLine());
            System.out.println("\nEnter the details to be changed:");
            ac1.addcourse1[i][3]=ins.nextLine();
                ac1.addcourse1[i][6]= formattedDate1;
            break;
        case 5:
            System.out.println("\nEnter which data in number you need to update ");
            i= Integer.parseInt(ins.nextLine());
            System.out.println("\nEnter the details to be changed:");
            ac1.addcourse1[i][4]=ins.nextLine();
                ac1.addcourse1[i][6]= formattedDate1;
            break;
        case 6:
            keepGoing=false;
            break;
    
     }
    
    }
     Admin();
}
public static void delete()
{Scanner in =new Scanner(System.in);
    Addcourse1 ac1=new Addcourse1();
    System.out.println("Enter number to delete");
    int i =in.nextInt();
    if(i==0||i==1)
    {
       ac1.addcourse1[i][0]=null;
       ac1.addcourse1[i][1]=null;
       ac1.addcourse1[i][2]=null;
       ac1.addcourse1[i][3]=null;
       ac1.addcourse1[i][4]=null;
       ac1.addcourse1[i][5]=null;
       ac1.addcourse1[i][6]=null;
    }
}
public static void view()
{LocalDateTime myDateObj = LocalDateTime.now();  
    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  
    Addcourse1 ac1=new Addcourse1();
 for(int i=0;i<2;i++)
    {
    System.out.println("\nCourseName="+ac1.addcourse1[i][0]+" ID:"+ac1.addcourse1[i][1]+" Course Description:"+
    ac1.addcourse1[i][2]+" Type:"+ac1.addcourse1[i][3]+" Category:"+ac1.addcourse1[i][4]+" Created Time:"+ac1.addcourse1[i][5]+" Modified Time:"+ ac1.addcourse1[i][6]);
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
 System.out.print("Enter Username:");
 a.addcourse[i][0]=s.nextLine();
 System.out.print("Enter Password:");
 a.addcourse[i][1]=s.nextLine();
 i++;
 a.z++;
 System.out.println("Registration completed\nPlease wait until login page displayed");
 Login();
}
public static void Login()
{
    String [][] t=new String[1][2];
    Scanner s=new Scanner(System.in);
    Addcourse a=new Addcourse();
    System.out.print(" Enter user name => ");
    t[0][0]=s.nextLine();
    System.out.print(" Enter password => ");
    t[0][1]=s.nextLine();
    for(int i=0;i<a.z;i++)
    {
        if(a.addcourse[i][0].matches(t[0][0]) && a.addcourse[i][1].matches(t[0][1]))
        {
            System.out.println(" User successfully logged-in.. ");
            Takequestions();
        }
        else
        {
            System.out.println(" In valid userName of password ");
        }
    
    }
}    
public static void Takequestions()
{
Scanner ins =new Scanner(System.in);
Addcourse1 ac1=new Addcourse1();
int i=0;
int c=0;
String k="Upsc";
String l="group1";
String m="group2";
    if(ac1.addcourse1[i][4]==k)
    {
        System.out.println("1) Consider the following statements with respect to Child adoption in India:"+
        "\nThe procedure for child adoption in India is governed by the Hindu Adoption and Maintenance Act, 1956 (HAMA) and the Juvenile Justice Act, 2015.\n"+
        "The power to issue orders regarding adoption of children in the country lies with the High courts.\n"
        +"Which of the above statement(s) is/are correct? a.  1 only b.  2 only c.  Both 1 and 2 d.  Neither 1 nor 2");
        char x= ins.nextLine().charAt(0);
         switch(x)
        {
            case 'a': 
                c=c+1;
                break;
            case 'b':
                break;
            case 'c':
                break;
            case 'd':
                break;
        }
        System.out.println("2) A committee was recently constituted under the Chairmanship of Suresh Prabhu.\n Which of the following is the objective of the committee?\na.  To draft national cooperative policy document\nb.  To strengthen the Capital Goods sector\nc.  To review the guidelines on television rating agencies\nd.  To facilitate digital payments through reforming the prevalent QR Code system in India");
        char y= ins.nextLine().charAt(0);
         switch(y)
        {
            case 'a': 
                c=c+1;
                break;
            case 'b':
                break;
            case 'c':
                break;
            case 'd':
                break;
        }
        System.out.println("3) Which of the following statements is/are correct with respect to E-cigarettes in India?\nE-cigarette is an electric device that produces an aerosol made by heating a liquid, usually containing nicotine.\nIn 2019, India banned the production, import, export, sale of all ENDS products.\nWhich of the above statement(s) is/are correct?\na.  1 only b.  2 only c.  Both 1 and 2 d.  Neither 1 nor 2");
         char z= ins.nextLine().charAt(0);
         switch(z)
        {
            case 'a': 
                break;
            case 'b':
                break;
            case 'c':
                c=c+1;
                break;
            case 'd':
                break;
        }
        System.out.println("4) Consider the following statements about Enhancing Climate Resilience of India’s Coastal Communities:\nIt is being implemented by the Union Ministry of Environment, Forest and Climate Change with support from United Nations Environment Programme.\nIt is a 6-year project from 2019-2024 that will enhance the climate resilience of the most vulnerable populations, particularly women, in the coastal areas of India.\nWhich of the above statement(s) is/are correct?\na.  1 only b.  2 only    c.  Both 1 and 2 d.  Neither 1 nor 2");
       char z1= ins.nextLine().charAt(0);
         switch(z1)
        {
            case 'a': 
                break;
            case 'b':
                break;
            case 'c':
                c=c+1;
                break;
            case 'd':
                break;
        }
        System.out.println("5) Consider the following statements about EU-India green hydrogen forum:It was jointly organized by the Ministry of Power with the NITI Aayog.\nIt provides a platform for the exchange of best practices, policy frameworks for renewable hydrogen.\nWhich of the above statement(s) is/are incorrect?\na.  1 only b.  2 only c.  Both 1 and 2 d.  Neither 1 nor 2");
        char z2= ins.nextLine().charAt(0);
         switch(z2)
        {
            case 'a': 
                break;
            case 'b':
                break;
            case 'c':
                c=c+1;
                break;
            case 'd':
                break;
        }
        System.out.println("Your Credit is:"+c*5);
    }
    else if(ac1.addcourse1[i][4]==l)
    {
       System.out.println("1) Consider the following statements with respect to Child adoption in India:"+
        "\nThe procedure for child adoption in India is governed by the Hindu Adoption and Maintenance Act, 1956 (HAMA) and the Juvenile Justice Act, 2015.\n"+
        "The power to issue orders regarding adoption of children in the country lies with the High courts.\n"
        +"Which of the above statement(s) is/are correct? a.  1 only b.  2 only c.  Both 1 and 2 d.  Neither 1 nor 2");
        char x= ins.nextLine().charAt(0);
         switch(x)
        {
            case 'a': 
                c=c+1;
                break;
            case 'b':
                break;
            case 'c':
                break;
            case 'd':
                break;
        }
        System.out.println("2) A committee was recently constituted under the Chairmanship of Suresh Prabhu.\n Which of the following is the objective of the committee?\na.  To draft national cooperative policy document\nb.  To strengthen the Capital Goods sector\nc.  To review the guidelines on television rating agencies\nd.  To facilitate digital payments through reforming the prevalent QR Code system in India");
        char y= ins.nextLine().charAt(0);
         switch(y)
        {
            case 'a': 
                c=c+1;
                break;
            case 'b':
                break;
            case 'c':
                break;
            case 'd':
                break;
        }
        System.out.println("3) Which of the following statements is/are correct with respect to E-cigarettes in India?\nE-cigarette is an electric device that produces an aerosol made by heating a liquid, usually containing nicotine.\nIn 2019, India banned the production, import, export, sale of all ENDS products.\nWhich of the above statement(s) is/are correct?\na.  1 only b.  2 only c.  Both 1 and 2 d.  Neither 1 nor 2");
         char z= ins.nextLine().charAt(0);
         switch(z)
        {
            case 'a': 
                break;
            case 'b':
                break;
            case 'c':
                c=c+1;
                break;
            case 'd':
                break;
        }
        System.out.println("4) Consider the following statements about Enhancing Climate Resilience of India’s Coastal Communities:\nIt is being implemented by the Union Ministry of Environment, Forest and Climate Change with support from United Nations Environment Programme.\nIt is a 6-year project from 2019-2024 that will enhance the climate resilience of the most vulnerable populations, particularly women, in the coastal areas of India.\nWhich of the above statement(s) is/are correct?\na.  1 only b.  2 only    c.  Both 1 and 2 d.  Neither 1 nor 2");
       char z1= ins.nextLine().charAt(0);
         switch(z1)
        {
            case 'a': 
                break;
            case 'b':
                break;
            case 'c':
                c=c+1;
                break;
            case 'd':
                break;
        }
        System.out.println("5) Consider the following statements about EU-India green hydrogen forum:It was jointly organized by the Ministry of Power with the NITI Aayog.\nIt provides a platform for the exchange of best practices, policy frameworks for renewable hydrogen.\nWhich of the above statement(s) is/are incorrect?\na.  1 only b.  2 only c.  Both 1 and 2 d.  Neither 1 nor 2");
        char z2= ins.nextLine().charAt(0);
         switch(z2)
        {
            case 'a': 
                break;
            case 'b':
                break;
            case 'c':
                c=c+1;
                break;
            case 'd':
                break;
        }
        System.out.println("Your Credit is:"+c*5);
        
        
    }
    else if(ac1.addcourse1[i][4]==m){
        System.out.println("1) Consider the following statements with respect to Child adoption in India:"+
        "\nThe procedure for child adoption in India is governed by the Hindu Adoption and Maintenance Act, 1956 (HAMA) and the Juvenile Justice Act, 2015.\n"+
        "The power to issue orders regarding adoption of children in the country lies with the High courts.\n"
        +"Which of the above statement(s) is/are correct? a.  1 only b.  2 only c.  Both 1 and 2 d.  Neither 1 nor 2");
        char x= ins.nextLine().charAt(0);
         switch(x)
        {
            case 'a': 
                c=c+1;
                break;
            case 'b':
                break;
            case 'c':
                break;
            case 'd':
                break;
        }
        System.out.println("2) A committee was recently constituted under the Chairmanship of Suresh Prabhu.\n Which of the following is the objective of the committee?\na.  To draft national cooperative policy document\nb.  To strengthen the Capital Goods sector\nc.  To review the guidelines on television rating agencies\nd.  To facilitate digital payments through reforming the prevalent QR Code system in India");
        char y= ins.nextLine().charAt(0);
         switch(y)
        {
            case 'a': 
                c=c+1;
                break;
            case 'b':
                break;
            case 'c':
                break;
            case 'd':
                break;
        }
        System.out.println("3) Which of the following statements is/are correct with respect to E-cigarettes in India?\nE-cigarette is an electric device that produces an aerosol made by heating a liquid, usually containing nicotine.\nIn 2019, India banned the production, import, export, sale of all ENDS products.\nWhich of the above statement(s) is/are correct?\na.  1 only b.  2 only c.  Both 1 and 2 d.  Neither 1 nor 2");
         char z= ins.nextLine().charAt(0);
         switch(z)
        {
            case 'a': 
                break;
            case 'b':
                break;
            case 'c':
                c=c+1;
                break;
            case 'd':
                break;
        }
        System.out.println("4) Consider the following statements about Enhancing Climate Resilience of India’s Coastal Communities:\nIt is being implemented by the Union Ministry of Environment, Forest and Climate Change with support from United Nations Environment Programme.\nIt is a 6-year project from 2019-2024 that will enhance the climate resilience of the most vulnerable populations, particularly women, in the coastal areas of India.\nWhich of the above statement(s) is/are correct?\na.  1 only b.  2 only    c.  Both 1 and 2 d.  Neither 1 nor 2");
       char z1= ins.nextLine().charAt(0);
         switch(z1)
        {
            case 'a': 
                break;
            case 'b':
                break;
            case 'c':
                c=c+1;
                break;
            case 'd':
                break;
        }
        System.out.println("5) Consider the following statements about EU-India green hydrogen forum:It was jointly organized by the Ministry of Power with the NITI Aayog.\nIt provides a platform for the exchange of best practices, policy frameworks for renewable hydrogen.\nWhich of the above statement(s) is/are incorrect?\na.  1 only b.  2 only c.  Both 1 and 2 d.  Neither 1 nor 2");
        char z2= ins.nextLine().charAt(0);
         switch(z2)
        {
            case 'a': 
                break;
            case 'b':
                break;
            case 'c':
                c=c+1;
                break;
            case 'd':
                break;
        }
        System.out.println("Your Correct :"+c*5);

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
    public static String[][] addcourse1=new String[2][7];
}
