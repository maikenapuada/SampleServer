/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javafx.util.*;
import java.io.Serializable;
/**
 *
 * @author maiken
 */
public class EmployeeModule implements Serializable{
    private Employee employee; 
    private String command;
    
    public EmployeeModule(String c, Employee e)
    {
        employee=e;
        command= c;
    }
    
    public Employee getEmployee(){
        return employee;
    }
    public String getcommand(){
        return command;
    }
}