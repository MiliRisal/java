/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exam;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Mili Risal
 */
public class ChooseSub extends JFrame implements ActionListener{
    JLabel lbluser;
    
    JLabel lblchoose;
    JLabel lbltoken;
    JTextArea txttoken;
    JComboBox cmbsubject;
    JLabel lblentertkn;
    JTextField txtentertkn;
    
    JButton btnStart;
    
    public ChooseSub(String a){
        lbluser=new JLabel("welcome "+a);
        lbluser.setForeground(new Color(188, 143, 143));
	lbluser.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
	lbluser.setBackground(SystemColor.textInactiveText);
        
        lbltoken=new JLabel("Your login token is :");
        
        txttoken=new JTextArea(a+123);
        
        lblchoose= new JLabel("Please choose the subject :");
        lblentertkn= new JLabel("Please enter your token here:");
        txtentertkn=new JTextField();
        cmbsubject=new JComboBox();
        
        cmbsubject.addItem("Java");
        cmbsubject.addItem("Ethics");
        cmbsubject.addItem("Web");
        
        btnStart=new JButton("Start Test");
        
        lbluser.setBounds(200,20,150,30);
        lbltoken.setBounds(150,100,200,30);
        txttoken.setBounds(300,100,100,20);
        
        lblchoose.setBounds(80,150,250,45);
        
        lblentertkn.setBounds(80,230,250,45);
        txtentertkn.setBounds(300,230,150,45);
        
        cmbsubject.setBounds(300,150,150,45);
        
        btnStart.setBounds(200,350,150,70);
        btnStart.addActionListener(this);
        
        add(lbltoken);
        add(txttoken);
        add(lblentertkn);
        add(txtentertkn);
        add(lbluser);
        add(lblchoose);add(cmbsubject);
        add(btnStart);
      
        setTitle("Registration Form!!");
        setLayout(null);
        setSize(600,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }
    

    @Override
    public void actionPerformed(ActionEvent ae) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(ae.getSource().equals(btnStart)){    
            if(cmbsubject.getSelectedItem()=="Java"){
                    if(txttoken.getText().equals(txtentertkn.getText())){
                        new GiveExam();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "please enter correct tokenId!");
                    }
                }
            }
        
        if(ae.getSource().equals(btnStart)){    
            if(cmbsubject.getSelectedItem()=="Ethics"){
                if(txttoken.getText().equals(txtentertkn.getText())){
                        new GiveExamEthics();
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "please enter correct tokenId!");
                    }
                }
            }
          
       
          
          if(ae.getSource().equals(btnStart)){    
             if(cmbsubject.getSelectedItem()=="Web"){
                if(txttoken.getText().equals(txtentertkn.getText())){
                            new GiveExamWeb();
                        }
                    else{
                        JOptionPane.showMessageDialog(null, "please enter correct tokenId!");
                    }
                }
            }
          
          
            
    
    }
}
