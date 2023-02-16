package carrentalsystem;

import java.io.*;
import javax.swing.JOptionPane;

public class Economy extends Car{

public Economy(String plateNo, double pricePerDay, String model, String color) {
super(plateNo, pricePerDay, model, color);
}

public String printBill(int days) 
{
double total = pricePerDay * days ; 
if( days > 7 )
total = total - ( total * 20 / 100 )  ; 

String str = "Economy Car Bill : \n " +  super.toString() + "\n"; 
str = str + " Total price : " + total + "\n" ; 

String fileName = getCustomer().getName()+ "_" +getCustomer().getId() + ".txt" ; 
try
{
// open txt file to save Bill 
File outFile = new File(fileName) ; 
FileOutputStream sf = new FileOutputStream(outFile) ; 
PrintWriter pf = new PrintWriter(sf) ; 

pf.println( str );
pf.close();

}
catch(IOException ex )
{
JOptionPane.showMessageDialog(null ,"Error in Economy file");
}


return str ; 


}


}
