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
public class PatientModule {
    private Patient patient; 
    private String command;
    
    public PatientModule(Pair p)
    {
        patient=(Patient) p.getValue();
        command= (String)p.getKey();
    }
    
    public Patient getPatient(){
        return patient;
    }
    public String getcommand(){
        return command;
    }
}
