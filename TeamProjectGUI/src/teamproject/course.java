/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package teamproject;

/**
 *
 * @author Junior
 */
public class course {
    
    private int test1, test2, test3, credit, cNumber;
    private double total;
    private String name;
    private char letterGrade;
    
    public course()
    {
        this.test1 = 0;
        this.test2 = 0;
        this.test3 = 0;
        this.credit = 0;
        this.total = 0;
        this.name = "-";
        this.letterGrade = '-';
        this.cNumber = 0;
    }
    
    public course(String name, int cNumber, int t1, int t2, int t3, int credit)
    {
        this.name = name;
        this.test1 = t1;
        this.test2 = t2;
        this.test3 = t3;
        this.credit = credit;
        this.cNumber = cNumber;
        this.total = total();
        this.letterGrade = letterG();
    }
    
    
    public double total()
    {
        return (test1 + test2 + test3)/3;
    }
    
    public char letterG()
    {
        if(total != 0)
        {
        if(total > 89 && total <= 100)
        {
            return'A';
        }
        
        else if(total > 79 && total < 90)
        {
            return 'B';
        }
        else if(total > 69 && total < 80)
        {
            return 'C';
        }
        else if(total > 59 && total < 70)
        {
            return 'D';
        }
        else
            return 'F';
        }
        else
        {
            return '-';
        }
    }
    
    public double getTotal()
    {
        return total;
    }
    
    public int getCredit()
    {
        
        if(total > 89 && total <= 100)
        {
            return 4;
        }
        
        else if(total > 79 && total < 90)
        {
            return 3;
        }
        else if(total > 69 && total < 80)
        {
            return 2;
        }
        else if(total > 59 && total < 70)
        {
            return 1;
        }
        else
            return 0;
     
    }
    
    public int getClassNumber()
    {
        return cNumber;
    }
    
    public String getClassName()
    {
        return name;
    }
    
}
