/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package signup;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.*;

public class Signup extends Frame implements ActionListener
{
   Label l;
   Label l1;
   Label l2;
   Label l3;
   Label l4;
   Label l5;
   Label l6;
   Label l7;
   Label l8;
   Label fname;
   Label lname;
   Label emal;
   Label phone;
   Label statee;
   Label country;
   Label password;
   Button b;
   Button b1;
   Button back;
   TextField t;
   TextField t2;
   TextField t3;
   TextField t4;
   TextField t5;
   TextField t6;
   TextField t7;
   TextField t8;
   String fnm,lnm,email,phoneno,state,coun,pass,rpass;
   Signup()
   {
        super("Sign up Form");
       setLayout(null);
           
            l8 = new Label("Registration Form");
            l8.setBounds(165,25,110,50);
            l8.setForeground(Color.blue);
            l8.setFont(new Font("Serif", Font.BOLD, 20));
       
            l = new Label("First Name : ");
            l.setBounds(60,40,100,100);
            t = new TextField();
            t.setBounds(160,80,150,25);
         
            l1 = new Label("Last Name : ");
            l1.setBounds(60,100,100,100);
            t2 = new TextField();
            t2.setBounds(160,140,150,25);
            
            l2 = new Label("Password : ");
            l2.setBounds(60,160,100,100);
            t3 = new TextField();
            t3.setBounds(160,200,150,25);
            t3.setEchoChar('*');
            
            l3 = new Label("Re Password : ");
            l3.setBounds(60,220,100,100);
            t4 = new TextField();
            t4.setBounds(160,259,150,25);
            t4.setEchoChar('*');
            
            l4 = new Label("Phone Number : ");
            l4.setBounds(60,280,100,100);
            t5 = new TextField();
            t5.setBounds(160,319,150,25);
            
            l5 = new Label("E- mail : ");
            l5.setBounds(60,340,100,100);
            t6 = new TextField();
            t6.setBounds(160,377,150,25);
            
            l6 = new Label("State : ");
            l6.setBounds(60,400,100,100);
            t7 = new TextField();
            t7.setBounds(160,435,150,25);
            
            l7 = new Label("Country : ");
            l7.setBounds(60,460,100,100);
            t8 = new TextField();
            t8.setBounds(160,497,150,25);
            
            b = new Button("Sign up");
            b.setBounds(120,575,100,50);
            b.setFont(new Font("Serif", Font.BOLD, 20));
            
            b1 = new Button("Cancel");
            b1.setBounds(250,575,100,50);
            b1.setFont(new Font("Serif", Font.BOLD, 20));
            
            add(l8);
            add(l);
            add(t);
            add(l1);
            add(t2);
            add(l2);
            add(t3);
            add(l3);
            add(t4);
            add(l4);
            add(t5);
            add(l5);
            add(t6);
            add(l6);
            add(t7);
            add(l7);
            add(t8);
            add(b);
            add(b1);
            
             b.addActionListener(this);
             b1.addActionListener(this);

            addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent windowEvent)
                {
                    System.exit(0);
                }
            });
         }
   
 
    public static void main(String[] args) 
    {
        Signup s1 = new Signup();
        s1.setVisible(true);
        s1.setBounds(10,10,430,700);
    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getActionCommand()=="Sign up")
       {
           fnm=t.getText();
           lnm=t2.getText();
           pass=t3.getText();
           phoneno=t5.getText();
           email=t6.getText();
           state=t7.getText();
           coun=t8.getText();
           rpass=t4.getText();
           
        setVisible(false);
        Frame fsignup =new Frame("Check Details");
        fsignup.setVisible(true);
        fsignup.setBounds(10,10,430,400);
        
        fsignup.setLayout(null);
        
        fname = new Label("First Name is: "+fnm);
        fname.setBounds(50,50,500,50);
        fname.setFont(new Font("Calibri", Font.BOLD, 20));
        fsignup.add(fname);
        
        lname = new Label("Last Name is: "+lnm);
        lname.setBounds(50,100,500,50);
        lname.setFont(new Font("Calibri", Font.BOLD, 20));
        fsignup.add(lname);
        
        password = new Label("Password is: "+pass);
        password.setBounds(50,150,500,50);
        password.setFont(new Font("Calibri", Font.BOLD, 20));
        fsignup.add(password);
        
        phone = new Label("Phoneno. is: "+phoneno);
        phone.setBounds(50,200,500,50);
        phone.setFont(new Font("Calibri", Font.BOLD, 20));
        fsignup.add(phone);
        
        emal = new Label("E-mail id is: "+email);
        emal.setBounds(50,250,500,50);
        emal.setFont(new Font("Calibri", Font.BOLD, 20));
        fsignup.add(emal);
        
        statee = new Label("State is: "+state);
        statee.setBounds(50,300,500,50);
        statee.setFont(new Font("Calibri", Font.BOLD, 20));
        fsignup.add(statee);
        
        country = new Label("Country is: "+coun);
        country.setBounds(50,350,500,50);
        country.setFont(new Font("Calibri", Font.BOLD, 20));
        fsignup.add(country);
        
        int x=0;
           
            if (pass.equals(rpass))
           {

                try
                {
                    Class.forName("oracle.jdbc.driver.OracleDriver");
                    Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "ritu2000");
                    PreparedStatement ps = con.prepareStatement("insert into signlog values(?,?,?,?,?,?,?)");

                    ps.setString(1, fnm);
                    ps.setString(2, lnm);
                    ps.setString(3, email);
                    ps.setString(4, pass);
                    ps.setString(5, coun);
                    ps.setString(6, state);
                    ps.setString(7, phoneno);
                    
                    ResultSet rs = ps.executeQuery();

                    JOptionPane.showMessageDialog(this, "Data Saved Successfully");
                }
          catch (Exception ex)
                {

                    System.out.println(ex);

                }
                 fsignup.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent windowEvent)
                {
                    System.exit(0);
                }
            });
           
           
       }
       else
       {
            JOptionPane.showMessageDialog(this, "Password Does Not Match");
       }
    }
       else
       {
           System.exit(0);
       }
        
    }
}
    

