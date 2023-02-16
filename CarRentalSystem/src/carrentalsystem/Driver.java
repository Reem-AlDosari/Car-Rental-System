package carrentalsystem;

import java.io.Serializable;

public class Driver implements Serializable{
private int id ; 
private String name ; 

    public Driver(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return  "id=" + id + ", name=" + name ;
    }


}
