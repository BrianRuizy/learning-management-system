/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;
import java.util.Random;

/**
 *
 * @author Junior
 */
public class user {
    private String fName, lName;
    private final int id;
    private int password;
    
    public user()
    {
        this.password = 0;
        this.fName = "";
        this.lName = "";
        this.id = 0;
    }
    
    public user(String first, String last, int password)
    {
        Random rand = new Random();
        int random = rand.nextInt(8999)+1000;
        
        this.fName = first;
        this.lName = last;
        this.id = random;
        this.password = password;
    }
    
    public String getfName()
    {
        return fName;
    }
    
    public String getlName()
    {
        return lName;
    }
    
    
    public int getID()
    {
        return id;
    }
    

    public int getPassword()
    {
        return password;
    }
    

    public String getName()
    {
        return fName + " " + lName;
    }    
    
    public void setPassword(int pass)
    {
        this.password = pass;
    }
    
}
