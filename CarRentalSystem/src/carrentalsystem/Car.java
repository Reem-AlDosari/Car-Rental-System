package carrentalsystem;

import java.io.Serializable;

public abstract class Car implements Payabel , Serializable{

protected String plateNo ; 
protected  double pricePerDay ; 
protected String model; 
protected String color ; 
protected boolean available ;  

protected Customer  cr ; 

    public Car(String plateNo, double pricePerDay, String model, String color) {
        this.plateNo = plateNo;
        this.pricePerDay = pricePerDay;
        this.model = model;
        this.color = color;
        this.available = true; 
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public double getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(double pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Customer getCustomer() {
        return cr;
    }

    public void setCustomer(Customer cr) {
        this.cr = cr;
    }

    public String toString() {
        String str =  "plateNo=" + plateNo + ", pricePerDay=" + pricePerDay + ", model=" + model + 
                "\n color=" + color + ", available=" + available + "\n" ; 
        
        if( cr != null )
             str = str +  " Customer : " + cr.toString() + "\n";
        
        return str ; 
    }

    

    
}
