package exam;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
/**
 *
 * @author rames
 */

public class GiveExam extends JFrame implements ActionListener{

    JLabel lblquestion,lblwelcome;
    JRadioButton btnopt[]=new JRadioButton[5];
    JButton btnSave,btnNext;
    String ans[]=new String[11];
    
    int count=0,current=-1;
    long StartTime, EndTime, seconds, minutes, flag=0;
    int a;
    String v;
    
    public GiveExam(){
        
        lblwelcome=new JLabel("Welcome to Java Test!");
        lblwelcome.setBounds(150,100,550,40);
        lblwelcome.setForeground(new Color(188, 143, 143));
	lblwelcome.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
	lblwelcome.setBackground(SystemColor.textInactiveText);
        add(lblwelcome);
        
        ButtonGroup bg=new ButtonGroup();
        for(int i=0;i<5;i++){
            btnopt[i]=new JRadioButton();
            add(btnopt[i]);
            bg.add(btnopt[i]);
        }
        if(current !=-1){
           btnopt[0].setBounds(200,200,150,30);
           btnopt[1].setBounds(200,230,150,30);
           btnopt[2].setBounds(200,260,150,30);
           btnopt[3].setBounds(200,290,150,30);
           
        }
        
        
        
        lblquestion =new JLabel();
        
        
        btnSave=new JButton("Result");
        btnSave.setForeground(new Color(0, 10, 10));
	btnSave.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
	//btnSave.setBackground(SystemColor.textInactiveText);
        btnNext=new JButton("Start");
        btnSave.setVisible(false);
        
        
        
        lblquestion.setBounds(200,170,150,30);
        
        
         
       
        btnSave.setBounds(300,350,100,30);
        btnSave.addActionListener(this);
        btnNext.setBounds(200,350,100,30);
        btnNext.addActionListener(this);
        
       add(lblquestion);
        add(btnNext);add(btnSave);
        
         
        setTitle("Java Exam!!");
        setLayout(null);
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
  
    void setnext() //function to set next question 
    {  
        btnopt[4].setSelected(true);
        int k=0; 
        try
        {
            for(int i=1; i<=10; i++){
                database db=new database();
            Statement stmt = db.con.createStatement();
            
            if(current==k)  
            {    
                String sql="select * from javaq order by RAND() Limit 4"; //selects all fields of table 'java_questions' 
                ResultSet rs = stmt.executeQuery(sql); //executing sql query 
                if(rs.next()){ //pointing to next row of result set 
                String s1 =rs.getString("Question"); //getting value stored in result set under field "Questions"
                String s2 =rs.getString("Option1"); //getting value stored in result set under field "Ans_one"
                String s3 =rs.getString("Option2"); //getting value stored in result set under field "Ans_two"
                String s4 =rs.getString("Option3"); //getting value stored in result set under field "Ans_three"
                String s5 =rs.getString("Option4"); //getting value stored in result set under field "Ans_four"
                lblquestion.setText("Q."+i+" "+s1); //setting question
                btnopt[0].setText(s2);btnopt[1].setText(s3);btnopt[2].setText(s4);btnopt[3].setText(s5);
                }//setting options
            } 
            k++;
            }
            lblquestion.setBounds(30,40,1200,30);  
            for(int i=0,j=0;i<=140;i+=40,j++)  
                btnopt[j].setBounds(50,80+i,500,30);  
        }   
        catch(Exception e)
        {
            System.out.println("setnext\n"+e);
        }
    }
        
    void check()  //function to check number of correct answers 
    {  
        try
        {
             database db=new database();
            Statement stmt = db.con.createStatement();
            String sq="select * from javaq";
            ResultSet rs2 = stmt.executeQuery(sq);
            for(int i=1;i<=10;i++)
            {  
                rs2.absolute(i);
                ans[i] =rs2.getString("CorrectAns");
                for(int j=0;j<4;j++){
                     if(btnopt[j].isSelected()) //if answer has been selected in radio button group
                    {
                       v =btnopt[j].getText();
                        String s1 = v;
                        if(s1.equals(ans[i])){ //checks if user's answer matches correct answer
                           count++;
                        }
                    }                
                }
            }
        }
        catch(Exception e)
        {
            System.out.println("check: CATCH: "+e);
        }
    }
  
    void showAnswerKey() //function to print answer key if requested for
    {
        try
        {
            database db=new database();
            Statement stmt = db.con.createStatement();
            String answerkey="";
            answerkey+="Answer Key:\nQ.No. Correct Answer\n";
            for(int i=1;i<=10;i++)
            {
                String sq="select CorrectAns from javaq where ID="+i+"";
                ResultSet rs2 = stmt.executeQuery(sq);
                rs2.next();
                String s2 =rs2.getString("CorrectAns"); //stores correct answer
                if(i<=9)
                 answerkey+="   "+(char)(i+48)+"  "+s2+"\n";
                else //0-9 is 48-57 in ascii 
                 answerkey+="  10"+" "+s2+"\n";
            }
            JOptionPane.showMessageDialog(this,answerkey); //prints answer key

            System.exit(0);
            db.con.close();
        }
        catch(Exception e)
        {
            System.out.println("showAnswerKey\n"+e);
        }
    }
    
    /*static void pickrandom()Function to display random question in the user panal
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mcqs_assignment", "root", "");
            Statement stmt = con.createStatement();
            int a[]=new int[11];
            int c=0;
            int p;
            for(int i=0;i<=10;i++)
                a[i]=0;
            while(c!=10)
            {
                p=1+(int)(Math.random()*10); //generating random integers in range [1,20]
                if(a[p]==0)
                {
                    a[p]=1; //marking the 10 randomly selected integers
                    c++; //counting number of random indexes marked
                }
            }
            c=0;
            for(int i=1;i<=10;i++)
            {
                if(a[i]==1) //checks if integer 'i' has been picked by code as a random integer 
                {
                    c++;
                    String sql="select * from java_questions where ID="+i+"";
                    ResultSet randomrs = stmt.executeQuery(sql);
                    randomrs.next();
                    randomrs.close();

                }
            }
            con.close();
        }
        catch(Exception e)
        {
            System.out.println("pickrandom\n"+e);
        }
    }*/
    
      @Override
    public void actionPerformed(ActionEvent e) {
      
       try
        {
             
            if(e.getSource().equals(btnNext) && current ==9 )
            {
                btnSave.setVisible(true);
                btnNext.setVisible(false);
                JOptionPane.showMessageDialog(this,"No more questions. Please see result.\n");
            }
            else if(e.getSource().equals(btnNext))  //if user clicks on start/next and there are more questions available to be displayed
            {  
                if(current == -1) //if user hasn't started test yet, i.e., she/he clicks on "start" button
                {
                    btnNext.setText("Next");
                    lblwelcome.setVisible(false);
                    StartTime = System.currentTimeMillis(); //stores time when user starts test
                    
                }
                else
                {
                    check();//adding user's response to the question
                }
                current++; //incrementing counter of questions countered  
                setnext();
            }  
            
            if(e.getSource().equals(btnSave))  //if user clicks on result button
            {  
                EndTime = System.currentTimeMillis(); //stores time when user ends test
                EndTime-=StartTime; //stores time taken by user to give test in milliseconds
                EndTime/=1000; //stores time taken by user to give test in seconds
                if(EndTime>=60) // if time can be expressed in minutes or hours
                {
                    seconds = EndTime%60; //calculating seconds
                    EndTime/=60; //calculating minutes
                    flag=1;
                    if(EndTime>=60) //if time can be expressed in hours
                    {
                        flag=2;
                        minutes=EndTime%60; //calculating minutes
                        EndTime/=60; //calculating hours
                    }
                }
                current++;
                check();
                   
                 //checks user's responses against correct responses stored in database                
                if(flag==0)
                 a = JOptionPane.showConfirmDialog(this,"Time taken: "+EndTime+" seconds\nYour Score: "+count+" / 10\nPercentage: "+(count*10)+" %\nDo you wish to see the answer key ?");  
                else if(flag==1)
                 a = JOptionPane.showConfirmDialog(this,"Time taken: "+EndTime+" minutes "+seconds+" seconds\nYour Score: "+count+" / 10\nPercentage: "+(count*10)+" %\nDo you wish to see the answer key ?");     
                else
                 a = JOptionPane.showConfirmDialog(this,"Time taken: "+EndTime+" hours "+minutes+" minutes "+seconds+" seconds\nYour Score: "+count+" / 10\nPercentage: "+(count*10)+" %\nDo you wish to see the answer key ?");     
                //displays total score and percentage
                if(a==JOptionPane.YES_OPTION) //checks if user wants to see answer key or not
                    showAnswerKey();
                else
                {
                    System.exit(0);  //closes interface and exits
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("actionPerformed"+ex);
        }  
    }
}