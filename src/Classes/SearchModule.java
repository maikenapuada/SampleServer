/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Classes;
import java.io.Serializable;
/**
 *
 * @author maiken
 */
public class SearchModule implements Serializable{
    private final String PrimaryFilter;
    public enum PersonFilter{
        All, Patient, Doctor, Nurse,Admin;
    }
    public enum SearchByFilter{
        
    }
    
    public SearchModule(PersonFilter pf){
        PrimaryFilter= pf.toString();
        if(PrimaryFilter =="Doctor")
        {
            
        }
    }
    
}
