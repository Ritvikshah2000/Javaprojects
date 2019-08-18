
package tictactoe;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
public class TicTacToe extends JFrame implements ItemListener, ActionListener
{
    int i,j,ii,jj,x,y,yesnull;   
int a[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},  
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},  
        {10,7,8,9,11} };  
int a1[][]={{10,1,2,3,11},{10,1,4,7,11},{10,1,5,9,11},{10,2,5,8,11},  
                {10,3,5,7,11},{10,3,6,9,11},{10,4,5,6,11},{10,7,8,9,11} };  
                  
boolean state,type,set;  
  
Icon ic1,ic2,icon,ic11,ic22;  
Checkbox c1,c2;  
JLabel l1,l2;  
JButton b[]=new JButton[9];  
JButton reset;  
  
public void showButton()
{  
    x=10; y=10;j=0;  
    for(i=0;i<=8;i++,x+=100,j++)
    {  
        b[i]=new JButton();  
        if(j==3)  
        {j=0; y+=100; x=10;}  
        b[i].setBounds(x,y,100,100);  
        add(b[i]);  
        b[i].addActionListener(this);  
    }  
  
    reset=new JButton("Reset");  
    reset.setBounds(100,350,100,50);  
    add(reset);  
    reset.addActionListener(this);  
}  
   
public  void check(int num1)
{  
    for(ii=0;ii<=7;ii++)
    {  
        for(jj=1;jj<=3;jj++)
        {  
            if(a[ii][jj]==num1){ a[ii][4]=11;  }  
  
        }  
  
    } 
}    
    
  
public void complogic(int num)
{    
    for(i=0;i<=7;i++)
    {  
        for(j=1;j<=3;j++)
        {  
            if(a[i][j]==num){  a[i][0]=11; a[i][4]=10;    }
        }  
    }  
    
   for(i=0;i<=7;i++)
   {               
        set=true;               
        if(a[i][4]==10)
        {                  
            int count=0;  
            for(j=1;j<=3;j++)
            {            
                if(b[(a[i][j]-1)].getIcon()!=null)
                {   
                    count++;  
                }                          
            else{ yesnull=a[i][j]; }  
        }                                 
        if(count==2)
        {                       
            b[yesnull-1].setIcon(ic2);   
            this.check(yesnull); set=false;break;  
        }                                    
        }                                      
      else  
      if(a[i][0]==10)
      {  
            for(j=1;j<=3;j++)
            {        
                if(b[(a[i][j]-1)].getIcon()==null)
                {   
                    b[(a[i][j]-1)].setIcon(ic2);  
                    this.check(a[i][j]);  
                    set=false;  
                    break;  
                 }                           
            }                              
            if(set==false)  
            break;                                                         
      }  
  
    if(set==false)  
         break;      
 }  
  
  
} 
    
  
TicTacToe(){  
super("TicTacToe+");  
  
CheckboxGroup cbg=new CheckboxGroup();  
c1=new Checkbox("vs Computer",cbg,false);  
c2=new Checkbox("vs Friend",cbg,false);  
c1.setBounds(120,80,100,40);  
c2.setBounds(120,150,100,40);  
add(c1); add(c2);  
c1.addItemListener(this);  
c2.addItemListener(this);  
  
  
state=true;type=true;set=true;  
ic1=new ImageIcon("C:\\Users\\ritvik100\\Desktop\\game-piece-ex.jpg");  
ic2=new ImageIcon("C:\\Users\\ritvik100\\Desktop\\game-piece-oh.jpg");  
ic11=new ImageIcon("C:\\Users\\ritvik100\\Desktop\\game-piece-ex.jpg");  
ic22=new ImageIcon("C:\\Users\\ritvik100\\Desktop\\game-piece-oh.jpg");

  
setLayout(null);  
setSize(330,450);  
setVisible(true);  
setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  
}  
  
  
public void itemStateChanged(ItemEvent e)
{  
     if(c1.getState())  
     {   
        type=false;  
     }  
  
    else if(c2.getState())  
    { 
        type=true;  
    }  
    remove(c1);remove(c2);  
    repaint(0,0,330,450);  
    showButton(); 
}  
  
  
public void actionPerformed(ActionEvent e)
{    
    if(type==true) 
    {  
        if(e.getSource()==reset)
        {  
            for(i=0;i<=8;i++)
            {  
                b[i].setIcon(null);  
            }    
        }  
        else
        {   
            for(i=0;i<=8;i++)
            {  
                if(e.getSource()==b[i])
                {  
                    if(b[i].getIcon()==null)
                    {  
                        if(state==true)
                        { 
                            icon=ic2;           
                            state=false;
                        } 
                        else
                        { 
                            icon=ic1; state=true; 
                        }  
                        b[i].setIcon(icon);  
                    }     
                }   
            }  
        }  
}  
else if(type==false)
{                            
    if(e.getSource()==reset)
    {  
        for(i=0;i<=8;i++)
        {  
            b[i].setIcon(null);  
        }   
        for(i=0;i<=7;i++)  
        for(j=0;j<=4;j++)  
        a[i][j]=a1[i][j];   
    }  
    else
    {    
        for(i=0;i<=8;i++)
        {  
            if(e.getSource()==b[i])
            {  
                if(b[i].getIcon()==null)
                {   
                    b[i].setIcon(ic1);    
                    if(b[4].getIcon()==null)
                    {  
                        b[4].setIcon(ic2);  
                        this.check(5);  
                    }
                    else
                    {  
                        this.complogic(i);  
                    }  
                }  
            }  
        }  
    }   
}  
for(i=0;i<=7;i++)
{     
    Icon icon1=b[(a[i][1]-1)].getIcon();  
    Icon icon2=b[(a[i][2]-1)].getIcon();  
    Icon icon3=b[(a[i][3]-1)].getIcon();  
    if((icon1==icon2)&&(icon2==icon3)&&(icon1!=null))
    {  
        if(icon1==ic1)
        {   
            b[(a[i][1]-1)].setIcon(ic11);  
            b[(a[i][2]-1)].setIcon(ic11);   
            b[(a[i][3]-1)].setIcon(ic11);  
            JOptionPane.showMessageDialog(TicTacToe.this,"You Won!"
            + "\nClick Reset to play another game.");     
            break;  
        }  
             else if(icon1==ic2)
             {   
                b[(a[i][1]-1)].setIcon(ic22);  
                b[(a[i][2]-1)].setIcon(ic22);  
                b[(a[i][3]-1)].setIcon(ic22);   
                JOptionPane.showMessageDialog(TicTacToe.this,"The Computer Won!"
                       + "\nClick Reset to play another game.");  
                break;             
               }  
         }  
    }    
  
  
}  
  
  
public static void main(String []args)
{  
    new TicTacToe(); 
}
}


