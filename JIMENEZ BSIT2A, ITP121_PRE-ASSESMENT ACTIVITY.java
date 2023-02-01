//KENT JOSEPH JIMENEZ BSIT-2A
import java.util.*;

import org.omg.CORBA.ARG_OUT;
class Peripheral{
    
    private int pcode;
    private String pname;
    private String pperipheral,employee;

    Peripheral(int pcode, String pname, String pperipheral,String employee){
        this.pcode = pcode;
        this.pname = pname;
        this.pperipheral = pperipheral;
        this.employee=employee;


    }
    public int getPcode(){
        return pcode;
    }
    public String getPname(){
        return pname;
    }
    /**
     * @return
     */
    public String getPperipheral(){
        return pperipheral;

    }
    public String Employee(){
        return employee;
    }
    
    public String toString(){
       return "Bar Code : "+"\t"+pcode+"\t"+"Device Name"+"\t"+pname+"\t"+"Peripheral Type  :"+"\t"+pperipheral+"\t"+"Employee"+"\t"+employee;


    }
    public String Report(){
        return "Peripheral Type :"+pperipheral+"\n"+"Device Name : "+pname+"\n"+"BarCode :"+pcode+"\n"+"Employee : "+employee;

    }

}
class MainClass{
    /**
     * @param args
     * @param peripheral TODO
     * @param peripheral2 TODO
     */
    public static void main(String[] args) {
        System.out.println(); 
        System.out.println("-----WELCOME TO THE DOrSU INVENTORY SYSTEM-----"); 
        System.out.println();  
        boolean found; 
         
            List<Peripheral> c = new ArrayList<Peripheral>();
            try (Scanner s = new Scanner(System.in)) {
                Scanner s1 = new Scanner(System.in);
                int ch=6;
                do{
                    System.out.println("1.CREATE TO ADD NEW");
                    System.out.println("2.VIEW RECORD");
                    System.out.println("3.EDIT");
                    System.out.println("4.DELETE");
                    System.out.println("5.UPDATE");
                    System.out.println("6.EXIT");
                    System.out.print("PLEASE ENTER YOUR CHOICE: ");
                    ch = s.nextInt();

                    switch(ch){
                        //CASE 1
                        case 1:
                            System.out.print("Enter the Peripheral Code : ");
                            int pcode = s.nextInt();
                            s.nextLine();
                            System.out.print("Enter the PC Name : ");
                            String pname = s1.nextLine();
                            System.out.print("Enter the Peripheral and it's Type\n example: Mouse-Input : ");
                            String pperipheral = s.nextLine();
                            System.out.print("Enter the Employee's Name : ");
                            String employee=s.nextLine();

                            c.add(new Peripheral(pcode,pname,pperipheral,employee));
                        break;
                        //CASE 2
                        case 2:

                           System.out.println("--------------------------------------------------------------------------------------");
                           System.out.println("RECORDS");
                           Iterator<Peripheral> i = c.iterator();
                           while(i.hasNext()){
                               Peripheral p = i.next();
                               System.out.println(p);
                               

                           }
                           System.out.println("--------------------------------------------------------------------------------------");
                        break;
                        //CASE 3
                        case 3:
                        
                          found =false;


                          System.out.println("Please Enter the Existing Pcode To Update the Record: ");
                          pcode=s.nextInt();
                        System.out.println("-----------------------------------------------------------------------------------------");
                          ListIterator<Peripheral> ii=c.listIterator();
                          
                          while(ii.hasNext()){
                            Peripheral p = ii.next();

                            if(p.getPcode() == pcode){
                                System.out.print("Enter New Pcode : ");
                                 pcode = s.nextInt();
                                s.nextLine();
                                System.out.print("Enter New PC Name : ");
                                 pname = s1.nextLine();
                                System.out.print("Enter New Peripheral : ");
                                 pperipheral = s.nextLine();
                                System.out.print("Enter New Employee Name : ");
                                 employee=s.nextLine();


                                 ii.set(new Peripheral(pcode, pname, pperipheral, employee));
                                found = true;

                            }

                          }
                          if(!found){
                            System.out.println("Inaccurate Pcode, Please Try Again.");
                          }
                          System.out.println("--------------------------------------------------------------------------------------");
     
                        break; 
                        //CASE 4
                        case 4:
                           found = false; 
                           System.out.println("Enter the Pcode to Delete: ");
                            pcode = s.nextInt();
                           System.out.println("--------------------------------------------------------------------------------------");
                           i = c.iterator();
                           while(i.hasNext()){
                               Peripheral p = i.next();
                               if(p.getPcode() == pcode)  {
                                  i.remove();
                                  found = true; 
                               

                                } 
                            }
                            
                            if(!found){
                                System.out.println("Record is Not Found.");
                            
                            }else{
                                System.out.println("You Have Deleted the Record.");
                            }
                           System.out.println("--------------------------------------------------------------------------------------");
                        break;
                       //CASE 5
                        case 5:
                        System.out.println("--------------------------------------------------------------------------------------");
                        Iterator<Peripheral> i1 = c.iterator();
                        while(i1.hasNext()){
                            Peripheral p = i1.next();
                            System.out.println(p.Report());

                        }
                        System.out.println("--------------------------------------------------------------------------------------");
                        break;

                        case 6:
                        System.out.println("YOU HAVE EXITED THE INVENTORY, THANK YOU FOR USING KA-TATA!");
                        break;

                    }
                }while(ch!=6);
            }
        }
    }

    






