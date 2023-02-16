package carrentalsystem;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import javax.swing.JOptionPane;

public class VIP extends Car{
    
    private Driver d ; 

public VIP(String plateNo, double pricePerDay, String model, String color , Driver d ) {
super(plateNo, pricePerDay, model, color);
this.d = d; 
}

public String printBill(int days) 
{
double total = ( super.pricePerDay + 100 )* days ; 

String str = "VIP Car Bill : \n " +  super.toString() + "\n"; 
str = str + " Driver : " + d.toString() + "\n" ; 
str = str + " Total price : " + total + "\n" ; 

String fileName = getCustomer().getName()+ "_" + getCustomer().getId() + ".txt" ; 
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

    public Driver getDriver() {
        return d;
    }




}
