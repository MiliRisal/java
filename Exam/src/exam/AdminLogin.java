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
public class AdminLogin extends JFrame implements ActionListener{
    JLabel lblWelcome;
    
    JLabel lblUserName;
    JLabel lblPassword;
    
    JTextField txtName;
    JPasswordField txtPass;
    
    JButton btnlogin,btnback;
    
    public AdminLogin(){
        
        setTitle("Admin Login Form!!");
        setLayout(null);
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        
        lblWelcome= new JLabel("WELCOME TO ADMIN LOGIN!!!");
        lblWelcome.setForeground(new Color(188, 143, 143));
	lblWelcome.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
	lblWelcome.setBackground(SystemColor.textInactiveText);
        
        lblUserName= new JLabel("User Name :");
        lblPassword= new JLabel("Password :");
        
        txtName=new JTextField();
        txtPass=new JPasswordField();
        
        btnlogin= new JButton("Log-In");
        
        btnback=new JButton("Back");
        btnback.setBounds(0,0,70,30);
        btnback.addActionListener(this);
        add(btnback);
        
        lblWelcome.setBounds(100,20,400,30);
        
        lblUserName.setBounds(100,90,180,30);
        lblPassword.setBounds(100,140,180,30);
        
        txtName.setBounds(200,90,180,35);
        txtPass.setBounds(200,140,180,35);
        
        btnlogin.setBounds(190,270,120,35);
        btnlogin.addActionListener(this);
        
        
        add(lblWelcome);add(lblUserName);add(lblPassword);
        add(txtName);add(txtPass);add(btnlogin);
    }
    
    public static void main(String[] args) {
        new AdminLogin().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        String a="admin";
        String p= "admin";
        String x=txtName.getText();
        String y=txtPass.getText();
        
        try 
           {                                     
            if(ae.getSource().equals(btnlogin))
            {

                   if(a.equals(x)&&p.equals(y))
                   {
                       JOptionPane.showMessageDialog(null,"Login Successfull!");
                         new QuesForm();
                    dispose();
                   }
                   else if((txtName.getText().equals("") || txtPass.getText().equals("")))
                   {
                       JOptionPane.showMessageDialog(null,"Please enter username and password");

                   }
                    else
                    {
                        JOptionPane.showMessageDialog(null,"Only for admimistration!");
                    }
                } 
        
                if(ae.getSource().equals(btnback))
                {
                    new Main().setVisible(true);
                    dispose();
                }
        
           
        }
          
            catch(Exception e)
                    {
                        System.out.println(e);
                    } 
            
    }
    
}
