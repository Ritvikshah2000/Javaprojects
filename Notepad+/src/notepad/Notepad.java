/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package notepad;

import java.awt.BorderLayout;
import java.util.*;
import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import static oracle.net.aso.C11.f;
import java.util.Date;
import javax.swing.*;
import java.awt.event.*;
import static java.awt.event.KeyEvent.VK_E;
import static java.awt.event.KeyEvent.VK_N;
import static java.awt.event.KeyEvent.VK_O;
import static java.awt.event.KeyEvent.VK_S;

public class Notepad extends JFrame implements ActionListener,KeyListener
{
    JMenuBar menubr;
    JMenu File,Edit, Help;
    JMenuItem New,Open,Exit,Save, Cut, Copy, Paste, SelectAll, Information;
    JTextArea type;
    String data;
    JLabel save;
    JButton yes;
    JButton no;
    boolean text = false;
    JPanel statusbar;
    JTextField tclock;
    JTextField time;
    JTextArea help;
    
    
    
    public Notepad()
            {
                super("Notepad+");
                
              
                menubr = new JMenuBar();
                setJMenuBar(menubr);
                
                File = new JMenu("File");
                menubr.add(File);
                
                Edit = new JMenu("Edit");
                menubr.add(Edit);
                
                Help = new JMenu("Help");
                menubr.add(Help);
                
                Cut = new JMenuItem("Cut");
                Cut.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
                
                Copy = new JMenuItem("Copy");
                Copy.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
                
                
                Paste = new JMenuItem("Paste");
                Paste.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
                
                SelectAll = new JMenuItem("SelectAll");
                SelectAll.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
                
                Cut.addActionListener(this);
                Copy.addActionListener(this);
                Paste.addActionListener(this);
                SelectAll.addActionListener(this);
                
                Edit.add(Cut);
                Edit.add(Copy);
                Edit.add(Paste);
                Edit.add(SelectAll);
                
                
                
                New = new JMenuItem("New");
                File.add(New);
                New.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
               
                
                Open = new JMenuItem("Open");
                File.add(Open);
                Open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
                
                Save = new JMenuItem("Save");
                File.add(Save);
                Save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
                
                Exit = new JMenuItem("Exit");
                File.add(Exit);
                Exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
                
                Information = new JMenuItem("Information");
                Help.add(Information);
                Information.addActionListener(this);
      
                type = new JTextArea();
                add(type);
                
                New.addActionListener(this);
                Open.addActionListener(this);
                Save.addActionListener(this);
                Exit.addActionListener(this);
                type.addKeyListener(this);
                Help.addActionListener(this);
                

                statusbar = new JPanel();
                statusbar.setLayout(new GridLayout());
                tclock = new JTextField();
                tclock.setEnabled(false);
                statusbar.add(tclock);
                add(statusbar, BorderLayout.SOUTH);
                
                startClock();
                
                tclock.setFont(new Font("Times New Roman",Font.BOLD,20));
                
                
                {
                    final SimpleDateFormat sdf = new SimpleDateFormat();
                    Runnable r = new Runnable()
                    {
                        Date d = new Date();
                        public void run()
                        {
                            while(true)
                            {
                                tclock.setText(sdf.format(d));
                                try
                                {
                                    Thread.sleep(1000);
                                }
                                catch(Exception e)
                                {
                                    
                                }
                                d.setTime(System.currentTimeMillis());
                                    
                            }
                        }
                };
                    Thread t = new Thread(r);
                    t.start();
                
                addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
		}}) ;  
            }
                
            }
    
    public static void main(String[] args) 
    {
        Notepad N=new Notepad();
        N.setBounds(0, 0, 500, 500);
        N.setVisible(true);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) 
    {
       if(e.getSource() == Cut)
           type.cut();
       
       if(e.getSource() == Paste)
           type.paste();
       
       if(e.getSource() == Copy)
           type.copy();
       
       if(e.getSource()== SelectAll)
           type.selectAll();
       
        if(e.getActionCommand() == "New")
        {
            if(text)
            {
                int i=JOptionPane.showConfirmDialog(this,"Do you want to save?");
      
                 if(i==0)
                {
                    try {
                        save();
                    } catch (IOException ex) {
                        Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                 if(i==1)
                {
                    type.setText(" ");
                }
            }
            else
            {
                type.setText(" ");
            }
        }
        if(e.getActionCommand() == "Exit")
        {
           System.exit(0);
           
        }
        if(e.getActionCommand() == "Open")
        {
            FileDialog f1 = new FileDialog(this,"Open Dialog",FileDialog.LOAD);
            f1.setVisible(true);
            File f2;
            f2 = new File(f1.getDirectory(),f1.getFile());
            try
            {
                BufferedReader reader = new BufferedReader(new FileReader(f2));
                String str;
                try 
                {
                    while((str = reader.readLine()) != null)
                    {
                        type.append(str);
                    }
                    reader.close();
                } 
                
                catch (IOException ex) {
                    Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            text=false; 
        }
        if(e.getActionCommand() == "Save")
        {
            if(text)
            {
                int i=JOptionPane.showConfirmDialog(this,"Do you want to save?");
      
                 if(i==0)
                {
                    try {
                        save();
                    } catch (IOException ex) {
                        Logger.getLogger(Notepad.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                 if(i==1)
                {
                    System.exit(0);
                }
            }
            else
            {
                type.setText(" ");
            }
        }
        if(e.getActionCommand() == "Information")
        {
            JFrame f = new JFrame();
            f.setVisible(true);
            f.setBounds(10,10,635,500);
            
            help = new JTextArea("When Notepad+ opens from Netbeans editor, you'll see this no-frills screen. Nothing"
                    + "\nmore is needed, since Notepad+ has a limited set of options. At the top of the window"
                    + "\nyou'll see menus for File, Edit and Help."
                    + "\n"
                    + "\nUsing the File menu in Notepad+ will give you the choices New, Open, Save and Exit. As"
                    + "\nyou can see many of these commands have keyboard shortcuts as well. You should"
                    + "\nalready be familiar with these commands, since they are the same un nearly"
                    + "\nevery + application."
                    + "\n"
                    + "\nYou do have some options you might not be familiar with when use use the Save"
                    + "\ncommand. You will have to specify the type of file you would like to save, you can use"
                    + "\nany of the available types of files on your device."
                    + "\n"
                    + "\nThe Edit menu offer quite a few choices, but again, everything on this menu should be"
                    + "\nfamiliar to anyone who's used the + applications. All the Edit choices have assocaited"
                    + "\nkeyboard shortcuts. Note that most of the shortcuts have a light blue font color."
                    + "\n"
                    + "\nThe first item on the Edit menu is the Cut command which will allow you to copy the"
                    + "\ndata and delete it at the same time, the data can later be pasted in any word"
                    + "\nprocessor. The second item on the Edit menu is the Copy command which will allow"
                    + "\nyou to simply copy the highlighted data and paste into any word processor."
                    + "\nThe third item on the Edit menu is the Paste command which will allow you to paste"
                    + "\nany copied data into the notepad+ editor."
                    + "\nThe fourth item on the Edit menu is the SelectAll command which will allow you"
                    + "\nto highlight all the data typed or pasted into the Notepad+ editor.");
            help.setFont(new Font("Courier New", Font.PLAIN,12));
            help.setDisabledTextColor(Color.DARK_GRAY);
            
            help.setBounds(50,10,635,500);
            help.setEnabled(false);
            f.add(help);
            
             f.addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent windowEvent)
                {
                    System.exit(0);
                    
                }
                
            });
            
        }
    }

public void keyTyped(KeyEvent e)
    {
       
        text=true;
    }

    public void keyPressed(KeyEvent e) 
    {
        
    }
    
    public void keyReleased(KeyEvent e)
    {
        
    }
    public void save() throws FileNotFoundException, IOException
    {
         FileDialog f=new FileDialog(this,"Save Dialog",FileDialog.SAVE);
         f.setVisible(true);
         File f1=new File(f.getDirectory(),f.getFile());
         FileOutputStream fou=new FileOutputStream(f1);
         String st=type.getText();
         byte[] b=st.getBytes();
         fou.write(b);
         fou.close();
         text=false;
    }

   
    public void startClock()
    {}

   
}


 

