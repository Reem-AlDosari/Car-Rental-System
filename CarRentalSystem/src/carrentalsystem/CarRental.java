package carrentalsystem;

import java.io.*;
import javax.swing.JOptionPane;

public class CarRental {

Car carlist[]; 
private int numOfCars ; 

public CarRental(int size)
{
carlist = new Car[size] ; 
numOfCars = 0 ; 
loadFromFile();
}

public void addCar( Car c )
{
if( numOfCars >= carlist.length )
{
JOptionPane.showMessageDialog(null ,"list of car is full, can't add more cars");
return;
}
// sarch about id first
for( int i =0 ; i < numOfCars ; i++ )
if( carlist[i].getPlateNo().equals(c.getPlateNo()))
{
JOptionPane.showMessageDialog(null ,"sorry we cant add this car , this plate number is allready exist");
return ; 
}

carlist[numOfCars++] = c ; 
String type = c.getClass().getSimpleName() ;
JOptionPane.showMessageDialog(null ,"add new " + type + " car to system successfully");

}
public void saveToFile()
{
try{
File out = new File("cars.dat");
FileOutputStream fos = new FileOutputStream (out);
ObjectOutputStream oos = new ObjectOutputStream (fos);

for( int i = 0 ;i < this.numOfCars ; i++ )
oos.writeObject(carlist[i]);

oos.close();

JOptionPane.showMessageDialog(null , "Tank you for use CAR RENTAL SYSTEM , All changes is saved. ");  

}
catch(IOException ex  ) 
{
JOptionPane.showMessageDialog(null , "Error in saving file ");  

}

}

////////////////////////////////////
public void loadFromFile()
{
ObjectInputStream file = null;
try{
File f = new File("cars.dat") ; 
FileInputStream fi = new FileInputStream(f);
file= new ObjectInputStream( fi);

while( true )
{
Car c = (Car) file.readObject() ; 
//addCar( c ) ; 
if( numOfCars >= carlist.length )
    break; 
carlist[numOfCars++] = c ; 
}

}
catch(EOFException ex )
{

}
catch(ClassNotFoundException ex )
{
JOptionPane.showMessageDialog(null , "Error while reading car from file ");  

}
catch(IOException ex  )
{
JOptionPane.showMessageDialog(null , "Error file in carRental");  
}

try{  if( file!= null ) file.close(); } 
catch(IOException e ){ } 
}// end load 
//////////////////////////////////////////////////////////
public void rentCar( String plateNo , Customer c ,int numOfDay)  
{
Car  car = this.getCar(plateNo) ; 

if( car == null)
{
JOptionPane.showMessageDialog(null , "this plateNo is not found");  
return;   
}

if( car.isAvailable() == true ){
car.setCustomer(c);
car.setAvailable(false);


JOptionPane.showMessageDialog(null , "Rent a car done successfully"); 
String str = car.printBill(numOfDay) ; 
JOptionPane.showMessageDialog(null , str ); 

return ; }
else
{
JOptionPane.showMessageDialog(null , "this car is not available");  
return ; 
}

}

////////////////////////////////////////
public void returnCar(String plateNo)
{
Car  car = this.getCar(plateNo) ; 

if( car == null)
{
JOptionPane.showMessageDialog(null , "this plateNo is not found");  
return;   
}

if( car.isAvailable() == false ){
car.setCustomer(null);
car.setAvailable(true);
JOptionPane.showMessageDialog(null , "return car done successfully");  
return ; }
else
{
JOptionPane.showMessageDialog(null , "this car is already available");  
return ; 
}

}
//////////////////////////////////////
public VIP[] searchAvailableVIP()
{
VIP[] arr = new VIP[numOfCars] ; 
int j = 0 ; 
for( int i = 0 ;i < numOfCars ; i++)
if( carlist[i] instanceof VIP && carlist[i].isAvailable() == true )
arr[j++] = (VIP) carlist[i] ; 

if( j == 0 )
return null; 

return arr; 

}

public  Economy[] searchAvailableEconomy()
{
Economy[] arr = new Economy[numOfCars] ; 
int j = 0 ; 
for( int i = 0 ;i < numOfCars ; i++)
if( carlist[i] instanceof Economy && carlist[i].isAvailable() == true )
arr[j++] = (Economy) carlist[i] ; 

if( j == 0 )
return null; 

return arr; 
}


public Car getCar(String PN)
{
for( int i = 0 ; i < numOfCars ; i++)
if( carlist[i].getPlateNo().equals(PN)  )
return carlist[i] ; 

return null; 
}


}





