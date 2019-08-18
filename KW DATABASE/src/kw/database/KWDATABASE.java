
package kw.database;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import static java.lang.reflect.Array.set;
import javax.swing.UIManager;

public class KWDATABASE extends JFrame implements ActionListener,Keylistener
{
    JMenuBar menubr;
    JMenu File,Edit, Help;
    JMenuItem New,Open,Exit,Save, Cut, Copy, Paste, SelectAll, Information;
    JPanel statusbar;
    JTextField tclock;
    JTextField time;
    JTextArea help;
    
    public KWDATABASE()
    {
        super("Kaluworks Database");
        
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
                
                New.addActionListener(this);
                Open.addActionListener(this);
                Save.addActionListener(this);
                Exit.addActionListener(this);
                Help.addActionListener(this);
                

                statusbar = new JPanel();
                statusbar.setLayout(new GridLayout());
                tclock = new JTextField();
                tclock.setEnabled(false);
                statusbar.add(tclock);
                add(statusbar, BorderLayout.SOUTH);
                
             startClock();
                
                tclock.setFont(new Font("Times New Roman",Font.BOLD,30));
                
                
                
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
        try 
        {
            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
        }   
        catch (Exception e) 
        {
            
        }
        
        KWDATABASE KW =new KWDATABASE();
        KW.setBounds(0,0,1366,768);
        KW.setVisible(true); 
        KW.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        KW.setUndecorated(true);
        KW.setVisible(true); 
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   public void startClock()
    {}
    
}
