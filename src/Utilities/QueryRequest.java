/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilities;

import Classes.*;
import java.sql.*;
import javafx.util.*;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author maiken
 */
public class QueryRequest {
    public static String RegisterUser(UserRegistration ur)
    {
        String verify="";
//        try{
//            Connection con=ConnectionProvider.getCon();
//            System.out.println("Connected to Microsft SQL SERVER:Registering user..");
//          // PreparedStatement myStmt= con.prepareStatement("Select ")
//        }
//         catch(SQLException ex) 
//        {
//            System.out.println("Error: User registration..");
//            ex.printStackTrace();
//            return "error";
//        }
        return verify;
    }
    
    public static String VerifyLogin(Pair user)
    {
        String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Checking Login user..");
            
            PreparedStatement myStmt = con.prepareStatement("Select * from Users where username = ? and "
                    + "password = ?");
            myStmt.setString(1, user.getKey().toString());
            myStmt.setString(2, user.getValue().toString());
            ResultSet res = myStmt.executeQuery();
            if(res.getRow()!=1)
            {   
                String id= res.getString("ID");
                switch (id.charAt(0)) {
                    case '1':
                        verify="patient";
                        break;
                    case '2':
                        verify="doctor";
                        break;
                    case '3':
                        verify="nurse";
                        break;
                    case '4':
                        verify="admin";
                        break;
                    default:
                        break;
                }
                con.close();
            }
            else
            {
                verify="invalidlogin";
            }
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Login Verification");
            ex.printStackTrace();
            return "error";
        }
        return verify;
    }
    
    public static String AddPatient(Patient p)
    {
        String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Adding Patient..");
            
            PreparedStatement myStmt = con.prepareStatement("Insert into Patients Values(?,?,?,?,?)");
            myStmt.setString(1, p.getFirstName());
            myStmt.setString(2, p.getLastName());
            myStmt.setString(3, p.getDOB());
            myStmt.setString(4, p.getAddress());
            myStmt.setString(5, p.getPhoneNumber());
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Added Patient..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Adding Patient");
            ex.printStackTrace();
        }
        return verify;
    }
    
    public static String ModifyPatient(Patient p)
    {
        String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Modifying Patient..");
            
            PreparedStatement myStmt = con.prepareStatement("Update Patients Set firstname=?"
                    + "lastname=?, dob=?, addr=?,phonenumber=? where patientID=?");
            myStmt.setString(1, p.getFirstName());
            myStmt.setString(2, p.getLastName());
            myStmt.setString(3, p.getDOB());
            myStmt.setString(4, p.getAddress());
            myStmt.setString(5, p.getPhoneNumber());
            myStmt.setInt(6,p.getID());
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Modified Patient..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Modifying Patient");
            ex.printStackTrace();
        }
        return verify;
    }
    public static String AddEmployee(Employee e){
        String verify="";
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Adding Employee..");
            
            PreparedStatement myStmt = con.prepareStatement("Insert into ? Values(?,?,?,?,?,?)");

            if(e.getJobTitle().equals("doctor")){
                myStmt.setString(1, "Practitioners");
                myStmt.setString(7, e.getSpecialty());
            }
            
            else if(e.getJobTitle().equals("nurse")){
                myStmt.setString(1, "Nurses");
                myStmt.setString(7, null);
            }
            
            myStmt.setString(2, e.getFirstName());
            myStmt.setString(3, e.getLastName());
            myStmt.setString(4, e.getDOB());
            myStmt.setString(5, e.getAddress());
            myStmt.setString(6, e.getPhoneNumber());
            
            int count = myStmt.executeUpdate();
            if(count>0)
            {
                verify="success";
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Adding Employee");
            ex.printStackTrace();
        }
        return verify;
    }
    public static String ModifyEmployee(Employee e){
        String verify="";
        int count=0;
        try{
            Connection con=ConnectionProvider.getCon();
            System.out.println("Connected to Microsft SQL SERVER:Modifying Employee..");
             PreparedStatement myStmt;
            if(e.getJobTitle().toString().equals("doctor")){
                myStmt = con.prepareStatement("Update Practitioners Set firstname=?"
                    + "lastname=?, dob=?, addr=?,phonenumber=?, specialty =? "
                        + "where practitionerID=?");
                myStmt.setString(1, e.getFirstName());
                myStmt.setString(2, e.getLastName());
                myStmt.setString(3, e.getDOB());
                myStmt.setString(4, e.getAddress());
                myStmt.setString(5, e.getPhoneNumber());
                myStmt.setString(6, e.getSpecialty());
                myStmt.setInt(7,e.getID());
                count = myStmt.executeUpdate();
            }
            else if(e.getJobTitle().toString().equals("nurse")){
                 myStmt = con.prepareStatement("Update Nurses Set firstname=?"
                    + "lastname=?, dob=?, addr=?,phonenumber=? where nurseID=?");
                myStmt.setString(1, e.getFirstName());
                myStmt.setString(2, e.getLastName());
                myStmt.setString(3, e.getDOB());
                myStmt.setString(4, e.getAddress());
                myStmt.setString(5, e.getPhoneNumber());
                myStmt.setInt(6,e.getID());
                count = myStmt.executeUpdate();
            }
            
            if(count>0)
            {
                verify="success";
                System.out.println("Success:Modified Patient..");
                con.close();
            }
            else
                verify="fail";
            con.close();
        }
        catch(SQLException ex) 
        {
            System.out.println("Error: Modifying Patient");
            ex.printStackTrace();
        }
        return verify;
    }
}
