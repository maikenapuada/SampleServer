/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

/**
 *
 * @author maiken
 */
import java.util.Date;
import javafx.beans.property.SimpleStringProperty;

public class Employee {
    
    private int ID;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private Date dob;
    private final SimpleStringProperty address;
    private final SimpleStringProperty phoneNumber;
    private final SimpleStringProperty jobtitle;
    private final SimpleStringProperty specialty;
    
    
    public Employee(int ID, String firstName, String lastName , Date dob, String address, String phoneNumber, String jobtitle, String specialty){
        
        this.ID = ID;
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.dob = dob;
        this.address = new SimpleStringProperty(address);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.jobtitle = new SimpleStringProperty(jobtitle);
        this.specialty = new SimpleStringProperty(specialty);
    }
    
    public Employee(String firstName, String lastName , Date dob, String address, String phoneNumber, String jobtitle, String specialty){
        
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);
        this.dob = dob;
        this.address = new SimpleStringProperty(address);
        this.phoneNumber = new SimpleStringProperty(phoneNumber);
        this.jobtitle = new SimpleStringProperty(jobtitle);
        this.specialty = new SimpleStringProperty(specialty);
    }
    
    
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
    public void setLastName(String department){
        this.lastName.set(department);
    }
    public void setDOB(Date dob){
        this.dob = dob;
    }
    public void setAddress(String address){
        this.address.set(address);   
    }
     public void setPhoneNumber(String phoneNumber){
        this.phoneNumber.set(phoneNumber);   
    }
    public void setJobTitle(String title){
        this.jobtitle.set(title);   
    }
    public void setSpecialty(String specialty){
        this.specialty.set(specialty);   
    }
    
    
    public int getID(){
        return ID;
    }
    public String getFirstName(){
        return firstName.get();
    }
    public String getLastName(){
        return lastName.get();
    }
    public String getAddress(){
        return address.get();
    }
    public String getDOB(){
        return dob.toString();
    }
    public String getPhoneNumber(){
        return phoneNumber.get();
    } 
    public String getJobTitle(){
        return jobtitle.get();
    }
    public String getSpecialty(){
        return specialty.get();
    }
    
}

