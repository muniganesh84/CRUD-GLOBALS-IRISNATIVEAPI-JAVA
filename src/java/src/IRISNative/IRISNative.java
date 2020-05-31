/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.intersystems.jdbc.IRIS;
import com.intersystems.jdbc.IRISConnection;
import com.intersystems.jdbc.IRISIterator;
import java.sql.DriverManager;
import java.util.Scanner;


/**
 *
 * @author muniganesh
 */
public class IRISNative {
    
    protected static int superserverPort = 51773;
    protected static String namespace = "USER";
    protected static String username = "_SYSTEM";
    protected static String password = "SYS";
    public static void main(String[] args) {
        // TODO code application logic here
         Displayoption();
         
    
    }
    public static void Displayoption()
    {
           try {
            // open connection to InterSystems IRIS instance using connection string
            Scanner reader = new Scanner(System.in);
            System.out.print("Select option \n");
            System.out.print("1.VIEW \n");
            System.out.print("2.CREATE \n");
            System.out.print("3.SEARCH \n");
            System.out.print("4.EXIT \n");
            Integer InpOption = reader.nextInt();
            
            switch (InpOption){
                case 1: System.out.print("Selected option "+InpOption+"\n");
                        GlobalView();
                        break;
                case 2: System.out.print("Selected option "+InpOption+"\n");
                        GlobalCreate();
                        break;
                case 3: System.out.print("Selected option "+InpOption+"\n");
                        GlobalSearch();
                        break;
                case 4: System.out.print("Selected option "+InpOption+"\n");
                        return;
                        
                default:System.out.print("Invalid Option "+InpOption+"\n");
                        break;
                        
            }
            return;

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static void GlobalCreate()
    {
        try{
            IRISConnection conn = (IRISConnection) DriverManager.getConnection("jdbc:IRIS://localhost:"+superserverPort+"/"+namespace,username,password);
            IRIS iris = IRIS.createIRIS(conn);
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter a Global Name: ");
            String InpGlobalName = reader.nextLine();
            System.out.println("Enter Subscript for global " + InpGlobalName);
            
        }
    catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
     public static void GlobalView(){
        try {    
            IRISConnection conn = (IRISConnection) DriverManager.getConnection("jdbc:IRIS://localhost:"+superserverPort+"/"+namespace,username,password);
            IRIS iris = IRIS.createIRIS(conn);
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter a Global Name: ");
            String InpGlobalName = reader.nextLine();
            System.out.println("You entered: " + InpGlobalName);
            if (InpGlobalName.isEmpty()==true) {
                System.out.println("EMPTY Value enetered \n ");
                Displayoption();
            }
            if (InpGlobalName.contains("^")==false){
                InpGlobalName="^"+InpGlobalName;
            }
                   
                
            IRISIterator subscriptIter = iris.getIRISIterator(InpGlobalName);
            //System.out.print(subscriptIter+"\n");
            
            
            if (subscriptIter.hasNext()==false){
                System.out.print("Global:"+InpGlobalName+" Does not exists \n");
                GlobalSearch();
            }
            int cnt=0;
            String DisplayStr="";
            if (subscriptIter.hasNext()==true){
                while (subscriptIter.hasNext()) {
                    String subscript = subscriptIter.next();
                    String Subvalue= String.valueOf(subscriptIter.getValue());
                    if (InpGlobalName.contains("(")==false) DisplayStr=InpGlobalName+"(\""+subscript+"\")="+Subvalue;
                    else if ((InpGlobalName.contains(")")==true)) {
                        if (isObjectInteger(subscript)==false) DisplayStr=InpGlobalName.replace(")", "") +","+subscript+")="+Subvalue;
                    }   else DisplayStr=InpGlobalName.replace(")", "") +","+subscript+"\")="+Subvalue;
                         
                  
                    System.out.println(DisplayStr);
                    
                }
            }
            System.out.println();
            // close connection and IRIS object
            iris.close();
            conn.close();
        }
        catch (Exception ex) {
                System.out.println(ex.getMessage());
              
        }
      Displayoption();  
    }
    public static void GlobalSearch(){
        try {    
            IRISConnection conn = (IRISConnection) DriverManager.getConnection("jdbc:IRIS://localhost:"+superserverPort+"/"+namespace,username,password);
            IRIS iris = IRIS.createIRIS(conn);
            Scanner reader = new Scanner(System.in);
            System.out.print("Enter a Global Name: ");
            String InpGlobalName = reader.nextLine();
            System.out.println("You entered: " + InpGlobalName);
            if (InpGlobalName.isEmpty()==true) {
                System.out.println("EMPTY Value enetered \n ");
                Displayoption();
            }   
            IRISIterator subscriptIter = iris.getIRISIterator(InpGlobalName);
            //System.out.print(subscriptIter+"\n");
            
            
            if (subscriptIter.hasNext()==false){
                System.out.print("Global:"+InpGlobalName+" Does not exists \n");
                GlobalSearch();
            }
            if (subscriptIter.hasNext()==true){
                System.out.print("Enter the value to find : ");
                String InpFind = reader.nextLine();
                System.out.println("Finding : " + InpFind + " in Global "+ InpGlobalName);
                while (subscriptIter.hasNext()) {
                    String subscript = subscriptIter.next();
                    String Subvalue= String.valueOf(subscriptIter.getValue());
                    if (Subvalue.contains(InpFind)==true) {
                        //subscriptIter.
                        System.out.println(InpGlobalName+","+subscript+"="+Subvalue);
                    }
                }
            }
            System.out.println();
            // close connection and IRIS object
            iris.close();
            conn.close();
        }
        catch (Exception ex) {
                System.out.println(ex.getMessage());
              
        }
      Displayoption();  
    }
 public static boolean isObjectInteger(Object o)
{
    return o instanceof Integer;
}

    
}
