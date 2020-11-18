/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;

import javafx.util.*;
/**
 *
 * @author maiken
 */
public class EmployeeModule {
    private Employee employee; 
    private String command;
    
    public EmployeeModule(Pair p)
    {
        employee=(Employee) p.getValue();
        command= (String)p.getKey();
    }
    
    public Employee getEmployee(){
        return employee;
    }
    public String getcommand(){
        return command;
    }
}