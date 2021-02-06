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
public class RegForm extends JFrame implements ActionListener{
     JLabel lblWelcome;
    
    JLabel lblFname;
    JLabel lblLname;
    JLabel lblUserName;
    JLabel lblPassword;
    JLabel lblConPw;
    JLabel lblDob;
    JLabel lblAddress,lblname;
    
    JTextField txtFname;
    JTextField txtLname;
    JTextField txtUserName;
    JPasswordField txtPass;
    JPasswordField txtConPw;
    JTextField txtDob;
    JTextField txtAddress;
    
    JButton btnLogin;
    JButton btnRegister;
    
        public RegForm(String a){
        setTitle("Registration Form!!");
        setLayout(null);
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        
        lblWelcome= new JLabel("WELCOME TO THE REGISTRATION FORM!!!");
    
        lblFname= new JLabel("First Name :");
        lblLname= new JLabel("Last Name :");
        lblUserName= new JLabel("User Name :");
        lblPassword= new JLabel("Password :");
        lblConPw= new JLabel("Confirm Password :");
        lblDob= new JLabel("Date Of Birth :");
        lblAddress=new JLabel("Address");
        
        
    
        txtFname=new JTextField();
        txtLname=new JTextField();
        txtUserName=new JTextField();
        txtPass=new JPasswordField();
        txtConPw=new JPasswordField();
        txtDob=new JTextField();
        txtAddress=new JTextField();
        
        btnLogin=new JButton("Login");
        btnRegister=new JButton("Register");
        
        lblname =new JLabel(a);
        
        lblname.setBounds(0,20,300,30);
        add(lblname);
        
        lblWelcome.setBounds(150,20,300,30);
        
        lblFname.setBounds(100,90,180,30);
        lblLname.setBounds(100,140,180,30);
        lblUserName.setBounds(100,190,180,30);
        lblPassword.setBounds(100,240,180,30);
        lblConPw.setBounds(100,290,180,30);
        lblDob.setBounds(100,340,180,30);
        lblAddress.setBounds(100,390,180,30);
        
        txtFname.setBounds(220,90,180,35);
        txtLname.setBounds(220,140,180,35);
        txtUserName.setBounds(220,190,180,35);
        txtPass.setBounds(220,240,180,35);
        txtConPw.setBounds(220,290,180,35);
        txtDob.setBounds(220,340,180,35);
        txtAddress.setBounds(220,390,180,35);
        
        btnLogin.setBounds(100,450,100,35);
        btnRegister.setBounds(250,450,100,35);
        
        add(lblWelcome);add(lblFname);add(lblLname);add(lblUserName);add(lblPassword);add(lblConPw);add(lblDob);add(lblAddress);
        add(txtFname);add(txtLname);add(txtUserName);add(txtPass);add(txtConPw);add(txtDob);add(txtDob);add(txtAddress);
        add(btnLogin);add(btnRegister);
        
        btnLogin.addActionListener(this);
        btnRegister.addActionListener(this);
        
        }
        public static void main(String[] args) {
        
             new Main().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
      
        if(ae.getSource().equals(btnRegister))
        {       
            if((txtFname.getText().equals("") || txtLname.getText().equals("") || txtUserName.getText().equals("") || txtPass.getText().equals("") || txtConPw.getText().equals("") || txtDob.getText().equals("") || txtAddress.getText().equals("")))
            {
                 JOptionPane.showMessageDialog(null, "Unable to Register!");
            }
            else{
                 database db=new database();
                 int values=db.register(txtFname.getText(),txtLname.getText(),txtUserName.getText(),txtPass.getText(),txtConPw.getText(),txtDob.getText(),txtAddress.getText());
                 if(values>0)
                 {
                     JOptionPane.showMessageDialog(null,"Sucessfully Added!!");

                 }
             }
               
        }
        
        if(ae.getSource().equals(btnLogin)){
            new UserLogin();
        }
       
    
       
    }
        
}
