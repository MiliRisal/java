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

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
public class UserLogin extends JFrame implements ActionListener{
    JLabel lblWelcome;
    
    JLabel lblUserName;
    JLabel lblPassword;
    JLabel lblapplier;
    
    JTextField txtName;
    JPasswordField txtPass;
   
    
    JButton btnlogin;
    
    JLabel lblqn;
    JButton btnsignin,btnback;
    
    public UserLogin(){
        
        setTitle("User Login!!");
        setLayout(null);
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        lblWelcome= new JLabel("WELCOME TO USER LOGIN!!!");
        lblWelcome.setForeground(new Color(188, 143, 143));
	lblWelcome.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
	lblWelcome.setBackground(SystemColor.textInactiveText);
        
        lblUserName= new JLabel("User Name :");
        lblPassword= new JLabel("Password :");
        lblapplier= new JLabel("Applier :");
        
        txtName=new JTextField();
        txtPass=new JPasswordField();
        
        lblqn=new JLabel("Are you a new user?");
        btnlogin= new JButton("Log-In");
        btnsignin= new JButton("Sign-Up");
        
        lblWelcome.setBounds(100,20,400,30);
        
        lblUserName.setBounds(100,90,180,30);
        lblPassword.setBounds(100,140,180,30);
        
        
        txtName.setBounds(200,90,180,35);
        txtPass.setBounds(200,140,180,35);
        
        btnlogin.setBounds(100,270,120,35);
        btnlogin.addActionListener(this);
        
        btnback=new JButton("Back");
        btnback.setBounds(0,0,70,30);
        btnback.addActionListener(this);
        add(btnback);
        
        lblqn.setBounds(300,230,120,35);
        btnsignin.setBounds(300,270,120,35);
        btnsignin.addActionListener(this);
        
        add(lblWelcome);add(lblUserName);add(lblPassword);add(lblapplier);
        add(txtName);add(txtPass);add(btnlogin);add(btnsignin);add(lblqn);
    }
    
    public static void main(String[] args) {
        new AdminLogin().setVisible(true);
      
    } 

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       String str1 = txtName.getText();
       String str2 = txtPass.getText();
       
       
        try
        {
            if (ae.getSource().equals(btnlogin))
            {
                if((txtName.getText().equals("") || txtPass.getText().equals("")))
                {
                    JOptionPane.showMessageDialog(null, "Please enter username and password!");
                }
                 else
                {
                    database db=new database();
                    PreparedStatement pstmt = db.con.prepareStatement("SELECT * FROM `regform` WHERE `UserName`=? AND `Password`=? ");
                    pstmt.setString(1,str1);
                    pstmt.setString(2,str2);
                    ResultSet rs=pstmt.executeQuery();
                    if(rs.next()){
                        JOptionPane.showMessageDialog(null,"login successfull!!");
                        new ChooseSub(str1);
                    }
                    else{
                        JOptionPane.showMessageDialog(null,"login unsuccessfull!!");
                        txtName.setText("");
                        txtPass.setText("");
                    }
                    
                }
                
            }
            if(ae.getSource().equals(btnsignin)){
                new RegForm(str1);
            }
            
             if(ae.getSource().equals(btnback))
                {
                    new Main().setVisible(true);
                    dispose();
                }
             
        } 
        catch (Exception e)
        {
            
        }
        
    }
    
}    
