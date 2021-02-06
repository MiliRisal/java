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

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Main extends JFrame implements ActionListener{
    /**
     * @param args the command line arguments.
     */
     
    JLabel Welcome, lblimg;
    JLabel choose;
    JButton btnAdmin;
    JButton btnExaminee;
    public Main(){
        setTitle("Examination Application!!");
        setLayout(null);
        setSize(600,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("images/bag.jpg");
        lblimg = new JLabel(icon);
 
        Welcome=new JLabel("WELCOME TO EXAM APPLICATION !!!");
        Welcome.setForeground(new Color(188, 143, 143));
	Welcome.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
	Welcome.setBackground(SystemColor.textInactiveText);
				
        choose=new JLabel("Are you ADMIN or EXAMINEE ???");
        choose.setForeground(new Color(100, 10, 10));
	choose.setFont(new Font("Arial", Font.PLAIN, 18));
	choose.setBackground(SystemColor.textInactiveText);
        
        btnAdmin=new JButton("ADMIN");
        btnAdmin.setForeground(new Color(0, 10, 10));
	btnAdmin.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
	btnAdmin.setBackground(SystemColor.textInactiveText);
        
        btnExaminee=new JButton("EXAMINEE");
        btnExaminee.setForeground(new Color(0, 10, 10));
	btnExaminee.setFont(new Font("Comic Sans MS", Font.ITALIC, 18));
	btnExaminee.setBackground(SystemColor.textInactiveText);
        
        Welcome.setBounds(100,40,450,30);
        choose.setBounds(140,150,300,30);
        btnAdmin.setBounds(110,200,150,60);
        btnAdmin.addActionListener(this);
        btnExaminee.setBounds(290,200,150,60);
        btnExaminee.addActionListener(this);
        lblimg.setBounds(0, 0, 1000, 400);
        
        add(Welcome);add(choose);add(btnAdmin);add(btnExaminee);add(lblimg);
    }
    
    public static void main(String[] args) {
        // TODO code application logic here
        new Main().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        try{
                if (ae.getSource().equals(btnAdmin))
                {
                    new AdminLogin();
                    dispose();
                }
                 if (ae.getSource().equals(btnExaminee))
                {
                    new UserLogin();
                    dispose();
                }
            }
        catch(Exception e)
           {
               System.out.println(e);
           }
    }
}
