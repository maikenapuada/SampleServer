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
public class PatientModule implements Serializable{
    private Patient patient; 
    private String command;
    
    public PatientModule(String c, Patient p)
    {
        patient=p;
        command= c;
    }
    
    public Patient getPatient(){
        return patient;
    }
    public String getcommand(){
        return command;
    }
}
