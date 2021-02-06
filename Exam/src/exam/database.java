/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

/**
 *
 * @author Mili Risal
 */
import java.sql.*;
import javax.swing.JOptionPane;
public class database {
    
    public Connection con;
    PreparedStatement pstmt=null;
    ResultSet rs=null;
    public database()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/exam","root","");
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
    
    public int register(String Fname,String Lname,String UserName,String Password,String ConPw,String Dob,String Address)
    {
         int values=0;
        try {
            pstmt=con.prepareStatement("INSERT INTO `regform`(`Fname`, `Lname`, `UserName`, `Password`, `ConPw`, `Dob`, `Address`) VALUES (?,?,?,?,?,?,?)");
            pstmt.setString(1,Fname);
            pstmt.setString(2,Lname);
            pstmt.setString(3,UserName);
            pstmt.setString(4,Password);
            pstmt.setString(5,ConPw);
            pstmt.setString(6,Dob);
            pstmt.setString(7,Address);
            
            values=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return values;
    }
        
     public int addqn(String Question,String Option1,String Option2,String Option3,String Option4, String CorrectAns)
    {
         int values=0;
        try {
            pstmt=con.prepareStatement("INSERT INTO `javaq`(`Question`, `Option1`, `Option2`, `Option3`, `Option4`, `CorrectAns`) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1,Question);
            pstmt.setString(2,Option1);
            pstmt.setString(3,Option2);
            pstmt.setString(4,Option3);
            pstmt.setString(5,Option4);
            pstmt.setString(6,CorrectAns);
            
            values=pstmt.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
       return values;
    }
    
    public int addqnEthics(String Question,String Option1,String Option2,String Option3,String Option4, String CorrectAns)
    {
         int values=0;
        try {
            pstmt=con.prepareStatement("INSERT INTO `ethicsq`(`Question`, `Option1`, `Option2`, `Option3`, `Option4`, `CorrectAns`) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1,Question);
            pstmt.setString(2,Option1);
            pstmt.setString(3,Option2);
            pstmt.setString(4,Option3);
            pstmt.setString(5,Option4);
            pstmt.setString(6,CorrectAns);
            
            values=pstmt.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
       return values;
    }
    
    
    public int addqnWeb(String Question,String Option1,String Option2,String Option3,String Option4, String CorrectAns)
    {
         int values=0;
        try {
            pstmt=con.prepareStatement("INSERT INTO `webq`(`Question`, `Option1`, `Option2`, `Option3`, `Option4`, `CorrectAns`) VALUES (?,?,?,?,?,?)");
            pstmt.setString(1,Question);
            pstmt.setString(2,Option1);
            pstmt.setString(3,Option2);
            pstmt.setString(4,Option3);
            pstmt.setString(5,Option4);
             pstmt.setString(6,CorrectAns);
            
            values=pstmt.executeUpdate();
            
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
       return values;
    }
         
          
          
       /*public void regcheck(String UserName,String Password)
    {   
        
         int value=0;
        try {
            pstmt=con.prepareStatement("SELECT * FROM `regform` WHERE `UserName`=? AND `Password`=? ");
            
            pstmt.setString(1,UserName);
            pstmt.setString(2,Password);
            
            
            rs=pstmt.executeQuery();
            
            rs.next();
            
            JOptionPane.showMessageDialog(null,"Welcome "+ UserName);//Add a form to show student examination task
            value=pstmt.executeUpdate();
           
            
           
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
            
    }
    
    //public int save(String UserName,String Password,String Applier)
    public int save(String UserName,String Password)
    {
        int result=0;
        try {
            //pstmt=conn.prepareStatement("INSERT INTO `studentform`(`UserName`, `Password`, `Applier`) VALUES (?,?)");
            pstmt=con.prepareStatement("INSERT INTO `loginform`(`UserName`, `Password`) VALUES (?,?)");
            pstmt.setString(1,UserName);
            pstmt.setString(2,Password);
            
            //String value=applier.getSelectedItem().toString();
            //pstmt.setString(3,value);
            
            result=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return result;
        
    }
    
    public int update(String UserName,String Password,String Applier)
    {
        int result=0;
        try {
            pstmt=con.prepareStatement("update student set Password=?, Applier=? where UserName=?");
           pstmt.setString(1,UserName);
            pstmt.setString(2,Password);
            pstmt.setString(3,Applier);
            result=pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
           
            return result;
        
    }
    
    */   
    
    /*public ResultSet extract()
    {
        try {
            pstmt=con.prepareStatement("SELECT * FROM `javaq` ");
            rs=pstmt.executeQuery();
             
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        return rs;
    }*/
}

