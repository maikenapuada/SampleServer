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
public class UserRegistration {
    private String username;
    private String password;
    private int ID;
    
    public UserRegistration(String username, String Password, int ID)
    {
        this.username= username;
        this.password=password;
        this.ID= ID;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public void setPassword(String password)
    {
        this.password=password;
    }
    
    
    public String getUsername(){
        return username;
    }
}
