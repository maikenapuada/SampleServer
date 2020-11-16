/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hmsserver;

import java.io.*;
import ocsf.server.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author maiken
 */
/**
 * This class overrides some of the methods in the abstract 
 * superclass in order to give more functionality to the server.
 *
 * @author Dr Timothy C. Lethbridge
 * @author Dr Robert Lagani&egrave;re
 * @author Fran&ccedil;ois B&eacute;langer
 * @author Paul Holden
 * @version July 2000
 */
public class EchoServer extends AbstractServer 
{
  //Class variables *************************************************
  
  /**
   * The default port to listen on.
   */
  final public static int DEFAULT_PORT = 5555;
  
  //Constructors ****************************************************
  
  /**
   * Constructs an instance of the echo server.
   *
   * @param port The port number to connect on.
   */
  public EchoServer(int port) 
  {
    super(port);
  }

  
  //Instance methods ************************************************
  
  /**
   * This method handles any messages received from the client.
   *
   * @param msg The message received from the client.
   * @param client The connection from which the message originated.
   */
  public void handleMessageFromClient
    (Object msg, ConnectionToClient client)
  {
    System.out.println("Message received: " + msg + " from " + client);
    this.sendToAllClients(msg);
  }
    
  /**
   * This method overrides the one in the superclass.  Called
   * when the server starts listening for connections.
   */
  protected void serverStarted()
  {
    System.out.println
      ("Server listening for connections on port " + getPort());
  }
  
  /**
   * This method overrides the one in the superclass.  Called
   * when the server stops listening for connections.
   */
  protected void serverStopped()
  {
    System.out.println
      ("Server has stopped listening for connections.");
  }
  
  //Class methods ***************************************************
  
  /**
   * This method is responsible for the creation of 
   * the server instance (there is no UI in this phase).
   *
   * @param args[0] The port number to listen on.  Defaults to 5555 
   *          if no argument is entered.
   */
  public static void main(String[] args) 
  {
    int port = 0; //Port to listen on

    try
    {
      port = Integer.parseInt(args[0]); //Get port from command line
    }
    catch(Throwable t)
    {
      port = DEFAULT_PORT; //Set port to 5555
    }
	
    String url = "jdbc:sqlserver://DESKTOP-OG5SA85;databaseName=HMSdatabase";
    String user= "hmsadmin";
    String password= "hmsadmin";
     try {
            Connection connection = DriverManager.getConnection(url,user,password);
            System.out.println("Connected to Microsft SQL SERVER");
            
            String sql= "Select * FROM Admins";
            
            Statement statement= connection.createStatement();
            
            ResultSet result = statement.executeQuery(sql);
            
            while(result.next()){
                int idnum = result.getInt("adminID");
                String fname =result.getString("firstname");
                String lname= result.getString("lastname");
                String dob= result.getString("dob");
                String addr= result.getString("addr");
                String phonenum= result.getString("phonenumber");
                
                System.out.printf("Admin ID: %d, Firstname: %s, LastName: %s, DOB: %s, Address: %s, Ph.Num: %s \n", idnum,
                        fname, lname, dob,addr,phonenum);
            }
            
            connection.close();
        } catch (SQLException ex) {
            System.out.println("There is an error");
            ex.printStackTrace();
        }
    
    EchoServer sv = new EchoServer(port);
    
    try 
    {
      sv.listen(); //Start listening for connections
    } 
    catch (Exception ex) 
    {
      System.out.println("ERROR - Could not listen for clients!");
    }
  }
}
//End of EchoServer class