/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

import java.util.ArrayList;
import java.text.DecimalFormat;

/**
 *
 * @author OscarDuarte
 */
public class student extends user{
    
    public String username;
    public double gpa;
    public ArrayList<course> courses = new ArrayList<>();
 
    //contrusctor
    public student()
    {
        super();
        this.gpa = 0;
        this.username = "";
    }
    public student(String f, String l, int passw, ArrayList<course> coursesT)
    {
        super(f,l,passw);
        this.username = l + f.charAt(0);
        this.courses = coursesT;
        this.gpa = gradePointAvg();
    }
    
    public double gradePointAvg()
    {
        double totalCredit = 0;
        double count = 0;
        for (course course : courses) {
            if(course.getTotal() != 0){
            count += 1;
            totalCredit += course.getCredit();
            }   
        }
        return totalCredit / count;
    }
    
    public double count()
    {
        double count = 0;
        for (course course : courses) {
            if(course.getTotal() != 0){
            count += 1;
            }   
        }
        return count;
    }
    
    public String getUserName()
    {
        return username;
    }
 
    
    
    


}
