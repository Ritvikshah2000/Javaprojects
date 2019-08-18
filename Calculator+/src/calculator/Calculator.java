/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;
import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener,KeyListener
{
    int c,n;
    Button b;
    Button b1;
    Button b2;
    Button b3;
    Button b4;
    Button b5;
    Button b6;
    Button b7;
    Button b8;
    Button b9;
    Button b10;
    Button b11;
    Button b12;
    Button b13;
    Button b14;
    Button b15;
    Button b16;
    Button b17;
    TextField t;
    String s1;
    String s2;
    String s3;
    String s4;
    String s5;
    
    Calculator()
    {
        super("Calculator +");
        
         setLayout(null);
         
         t = new TextField();
         t.setBounds(50,40,293,100);
         
         b = new Button("1");
         b.setBounds(50,200,40,40);
         b.addActionListener(this);
         b.addKeyListener(this);
         b.setFont(new Font("Serif", Font.BOLD, 20));
         
         b1 = new Button("2");
         b1.setBounds(50,250,40,40);
         b1.addActionListener(this);
         b1.addKeyListener(this);
         b1.setFont(new Font("Serif", Font.BOLD, 20));
         
         b2 = new Button("3");
         b2.setBounds(50,300,40,40);
         b2.addActionListener(this);
         b2.addKeyListener(this);
         b2.setFont(new Font("Serif", Font.BOLD, 20));
         
         b3 = new Button("4");
         b3.setBounds(100,200,40,40);
         b3.addActionListener(this);
         b3.addKeyListener(this);
         b3.setFont(new Font("Serif", Font.BOLD, 20));
         
         b4 = new Button("5");
         b4.setBounds(100,250,40,40);
         b4.addActionListener(this);
         b4.addKeyListener(this);
         b4.setFont(new Font("Serif", Font.BOLD, 20));
         
         b5 = new Button("6");
         b5.setBounds(100,300,40,40);
         b5.addActionListener(this);
         b5.addKeyListener(this);
         b5.setFont(new Font("Serif", Font.BOLD, 20));
         
         b6 = new Button("7");
         b6.setBounds(150,200,40,40);
         b6.addActionListener(this);
         b6.addKeyListener(this);
         b6.setFont(new Font("Serif", Font.BOLD, 20));
         
         b7 = new Button("8");
         b7.setBounds(150,250,40,40);
         b7.addActionListener(this);
         b7.addKeyListener(this);
         b7.setFont(new Font("Serif", Font.BOLD, 20));
         
         b8 = new Button("9");
         b8.setBounds(150,300,40,40);
         b8.addActionListener(this);
         b8.addKeyListener(this);
         b8.setFont(new Font("Serif", Font.BOLD, 20));
         
         b9 = new Button(".");
         b9.setBounds(150,350,40,40);
         b9.addActionListener(this);
         b9.addKeyListener(this);
         b9.setFont(new Font("Serif", Font.BOLD, 20));
         
         b10 = new Button("0");
         b10.setBounds(50,350,89,40);
         b10.addActionListener(this);
         b10.addKeyListener(this);
         b10.setFont(new Font("Serif", Font.BOLD, 20));
         
         b11 = new Button("*");
         b11.setBounds(250,250,40,40);
         b11.addActionListener(this);
         b11.setFont(new Font("Serif", Font.BOLD, 25));
         b11.setForeground(Color.blue);
         
         b12 = new Button("+");
         b12.setBounds(250,300,40,40);
         b12.addActionListener(this);
         b12.setFont(new Font("Serif", Font.BOLD, 25));
         b12.setForeground(Color.blue);
         
         b13 = new Button("-");
         b13.setBounds(250,350,40,40);
         b13.addActionListener(this);
         b13.setFont(new Font("Serif", Font.BOLD, 25));
         b13.setForeground(Color.blue);
         
         b14 = new Button("/");
         b14.setBounds(250,200,40,40);
         b14.addActionListener(this);
         b14.setFont(new Font("Serif", Font.BOLD, 25));
         b14.setForeground(Color.blue);
         
         b15 = new Button("%");
         b15.setBounds(300,200,40,40);
         b15.addActionListener(this);
         b15.setFont(new Font("Serif", Font.BOLD, 25));
         b15.setForeground(Color.blue);
        
         b16 = new Button("=");
         b16.setBounds(300,300,40,89);
         b16.addActionListener(this);
         b16.setFont(new Font("Serif", Font.BOLD, 30));
         b16.setForeground(Color.red);
         
         b17 = new Button("C");
         b17.setBounds(300,250,40,40);
         b17.addActionListener(this);
         b17.setFont(new Font("Serif", Font.BOLD, 30));
         b17.setForeground(Color.yellow);
         
        
        add(t);
        add(b);
        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(b10);
        add(b11);
        add(b12);
        add(b13);
        add(b14);
        add(b15);
        add(b16);
        add(b17);
        
         addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent windowEvent)
                {
                    System.exit(0);
                }
            });
    }
        
    @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == b)
            {
                s3 = t.getText();
                s4 = "1";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b1)
            {
                s3 = t.getText();
                s4 = "2";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b2)
            {
                s3 = t.getText();
                s4 = "3";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b3)
            {
                s3 = t.getText();
                s4 = "4";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b4)
            {
                s3 = t.getText();
                s4 = "5";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b5)
            {
                s3 = t.getText();
                s4 = "6";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b6)
            {
                s3 = t.getText();
                s4 = "7";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b7)
            {
                s3 = t.getText();
                s4 = "8";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b8)
            {
                s3 = t.getText();
                s4 = "9";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b10)
            {
                s3 = t.getText();
                s4 = "0";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            if(e.getSource() == b9)
            {
                s3 = t.getText();
                s4 = ".";
                s5 = s3+ s4;
                t.setText(s5);
            }
            
            
            
            if(e.getSource() == b11)
            {
                s1 = t.getText();
                t.setText("");
                c=1;
            }
            
            if(e.getSource() == b12)
            {
                s1 = t.getText();
                t.setText("");
                c=2;
            }
            
            if(e.getSource() == b13)
            {
                s1 = t.getText();
                t.setText("");
                c=3;
            }
            
            if(e.getSource() == b13)
            {
                s1 = t.getText();
                t.setText("");
                c=3;
            }
            
            if(e.getSource() == b14)
            {
                s1 = t.getText();
                t.setText("");
                c=4;
            }
            
            if(e.getSource() == b15)
            {
                s1 = t.getText();
                t.setText("");
                c=5;
            }
            
            if(e.getSource() == b16)
            {
               s2 = t.getText();
               
               if(c==1)
               {
                   n = Integer.parseInt(s1)+Integer.parseInt(s2);
                   t.setText(String.valueOf(n));
               }
               
               else
                   if(c==2)
               {
                   n = Integer.parseInt(s1)+Integer.parseInt(s2);
                   t.setText(String.valueOf(n));
               }
               
               else
                   if(c==3)
               {
                   n = Integer.parseInt(s1)+Integer.parseInt(s2);
                   t.setText(String.valueOf(n));
               }
               
                else
                   if(c==4)
               {
                   try
                   {
                       int p = Integer.parseInt(s2);
                       
                       if(p!=0)
                       {
                           n = Integer.parseInt(s1)/Integer.parseInt(s2);
                           t.setText(String.valueOf(n));
                       }
                       
                       else
                       {
                           t.setText("Infinite");
                       }
                   }
                   
                   catch(Exception i)
                   {
                       
                   }
               }
               
                else
                   if(c==5)
               {
                   n = Integer.parseInt(s1)+Integer.parseInt(s2);
                   t.setText(String.valueOf(n));
               }
               
                else
                   if(c==6)
               {
                   n = Integer.parseInt(s1)+Integer.parseInt(s2);
                   t.setText(String.valueOf(n));
               }
            }
            
            if(e.getSource() == b17)
            {
                t.setText("");
            }
            
           
            
        }
         public static void main(String[] args) 
    {
        Calculator c1 = new Calculator();
        c1.setVisible(true);
        c1.setBounds(1,2,400,400);

    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
        
    


    

   
    

