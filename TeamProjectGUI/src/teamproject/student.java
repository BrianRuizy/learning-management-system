/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

/**
 *
 * @author OscarDuarte
 */
public class student extends user{
    public String username;
    public int test1, test2, test3;
    public float gpa, gradeT;
    public char letter;
    
    public student()
    {
        super();
        this.test1 = 0;
        this.test2 = 0;
        this.test3 = 0;
        this.gpa = 0;
        this.username = "";
        this.letter = 'n';
    }
    public student(String f, String l, int passw,int t1, int t2, int t3)
    {
        super(f,l,passw);
        this.test1 = t1;
        this.test2 = t2;
        this.test3 = t3;
        this.username = l + f.charAt(0);
        //this.gpa = //gpa func
        this.gradeT = (t1+t2+t3)/3;
    }
    
    //public double gradePA()
    //{
        
        
    //}
    
    public String getUserName()
    {
        return username;
    }
    
    
    


}
