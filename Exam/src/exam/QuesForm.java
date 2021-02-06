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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
public class QuesForm extends JFrame implements ActionListener{
    
    JLabel lblchoose;
    JComboBox cmbsubject;
     
    JLabel lblWelcome;
    
    JTextField question;
    JTextField ans1;
    JTextField ans2;
    JTextField ans3;
    JTextField ans4;
    JTextField CorrrectAns;
    
    
    JLabel lbladdqn;
    JLabel lblopt1;
    JLabel lblopt2;
    JLabel lblopt3;
    JLabel lblopt4;
    JLabel lblans;
    
    
    
    JButton btnSave;
        
        
    public QuesForm(){
        lblchoose= new JLabel("Choose the subject :");
        cmbsubject=new JComboBox();
        
        cmbsubject.addItem("Java");
        cmbsubject.addItem("Ethics");
        cmbsubject.addItem("Web");
        lblWelcome=new JLabel("Welcome to Question Frame!");
        
        question= new JTextField();
        ans1= new JTextField();
        ans2= new JTextField();
        ans3= new JTextField();
        ans4= new JTextField();
        CorrrectAns= new JTextField();
        
        lbladdqn=new JLabel("Add Your Questions here:");
        lblopt1=new JLabel("Option 1:");
        lblopt2=new JLabel("Option 2:");
        lblopt3=new JLabel("Option 3:");
        lblopt4=new JLabel("Option 4:");
        lblans=new JLabel("Correct Answer:"); 
        
        btnSave=new JButton("Save ");
        
        lblchoose.setBounds(10,55,150,30);
        cmbsubject.setBounds(140,55,100,30);
        cmbsubject.addActionListener(this);
        lblWelcome.setBounds(150,30,180,30);
        
        question.setBounds(200,100,300,30);
        ans1.setBounds(200,150,180,30);
        ans2.setBounds(200,200,180,30);
        ans3.setBounds(200,250,180,30);
        ans4.setBounds(200,300,180,30);
        CorrrectAns.setBounds(200,350,180,30);
        
        lbladdqn.setBounds(50,100,180,30);
        lblopt1.setBounds(140,150,180,30);
        lblopt2.setBounds(140,200,180,30);
        lblopt3.setBounds(140,250,180,30);
        lblopt4.setBounds(140,300,180,30);
        lblans.setBounds(100,350,180,30);
        
        btnSave.setBounds(200,400,100,30);
        btnSave.addActionListener(this);
        
        add(lblWelcome);
        add(question);add(ans1);add(ans2);add(ans3);add(ans4);add(CorrrectAns);
        add(lbladdqn);add(lblopt1);add(lblopt2);add(lblopt3);add(lblopt4);add(lblans);
        add(btnSave);
        add(lblchoose);add(cmbsubject);
       
        
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Question Form");
        setLayout(null);
        setSize(600,600);
        setVisible(true);
         
    }
    public static void main(String[] args) {
        new QuesForm().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        try {
        
        if(ae.getSource().equals(btnSave))
        {       
            if(cmbsubject.getSelectedItem()=="Java")
            {
               if((question.getText().equals("") || ans1.getText().equals("") || ans2.getText().equals("") || ans3.getText().equals("") || ans4.getText().equals("") || CorrrectAns.getText().equals("")))
               {
                    JOptionPane.showMessageDialog(null, "Unable to Save");
               }
                else{
                    database db=new database();
                    int values=db.addqn(question.getText(),ans1.getText(),ans2.getText(),ans3.getText(),ans4.getText(),CorrrectAns.getText());
                    if(values>0)
                    {
                        JOptionPane.showMessageDialog(null,"Sucessfully Added!!");

                    }
                }
                
            }
        }
            
            
        if(ae.getSource().equals(btnSave))
        {       
            if(cmbsubject.getSelectedItem()=="Ethics")
            {
               if((question.getText().equals("") || ans1.getText().equals("") || ans2.getText().equals("") || ans3.getText().equals("") || ans4.getText().equals("") || CorrrectAns.getText().equals("")))
               {
                    JOptionPane.showMessageDialog(null, "Unable to Save");
               }
                else{
                    database db=new database();
                    int values=db.addqnEthics(question.getText(),ans1.getText(),ans2.getText(),ans3.getText(),ans4.getText(),CorrrectAns.getText());
                    if(values>0)
                    {
                        JOptionPane.showMessageDialog(null,"Sucessfully Added!!");

                    }
                }
                
            }
        }
           
         
        if(ae.getSource().equals(btnSave))
        {       
            if(cmbsubject.getSelectedItem()=="Web")
            {
               if((question.getText().equals("") || ans1.getText().equals("") || ans2.getText().equals("") || ans3.getText().equals("") || ans4.getText().equals("") || CorrrectAns.getText().equals("")))
               {
                    JOptionPane.showMessageDialog(null, "Unable to Save");
               }
                else{
                    database db=new database();
                    int values=db.addqnWeb(question.getText(),ans1.getText(),ans2.getText(),ans3.getText(),ans4.getText(),CorrrectAns.getText());
                    if(values>0)
                    {
                        JOptionPane.showMessageDialog(null,"Sucessfully Added!!");

                    }
                }
                
            }
        }
            
            
            
            question.setText("");
            ans1.setText("");
            ans2.setText("");
            ans3.setText("");
            ans4.setText("");
            CorrrectAns.setText("");
            
       }
       
         catch(Exception e)
                    {
                        System.out.println(e);
                    }
        
            
            
    }
    
}
