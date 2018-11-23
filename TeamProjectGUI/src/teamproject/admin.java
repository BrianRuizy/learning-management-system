package teamproject;

import java.util.ArrayList;

/**
 *
 * @author OscarDuarte
 */
public class admin extends user{
    
    public String uName = "admin";
    ArrayList<student> students = new ArrayList<>();
    
    
 
    public admin(String f, String l, int pass)
    {
        super(f,l,pass);
    }
    
    //copy constructor
   public admin(admin ad)
    {
        super(ad.getfName(), ad.getlName(), ad.getPassword());
        this.students = ad.students;
        this.uName = ad.uName;
    }
    public void createStudent(student stu)
    {
        students.add(stu);
        
    }
    public void createTeacher()
    {
    }
    
    public void createCourse()
    {
    }
}
