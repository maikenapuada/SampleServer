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
public class UserModule {
    private String command;     //either log in or register
    private String username;
    private String password;
    private int ID;
    
    public UserModule(String username, String Password, int ID)
    {
        this.username= username;
        this.password=Password;
        this.ID= ID;
    }
    
    public UserModule(String username, String Password)
    {
        this.username= username;
        this.password=Password;
    }
    
    public void setUsername(String username){
        this.username=username;
    }
    
    public void setPassword(String password)
    {
        this.password=password;
    }
    public void setCommand(String command)
    {
        this.command=command;
    }
    
    
    
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public int getID(){
        return ID;
    }
    public String getCommand(){
        return command;
    }
}
