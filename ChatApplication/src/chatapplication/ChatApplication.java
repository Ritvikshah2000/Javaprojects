
package chatapplication;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.TextField;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;

public class ChatApplication extends JFrame implements ActionListener, KeyListener
{
    JMenuBar menubr;
    JMenu File,Edit, Help;
    JMenuItem New,Open,Exit,Save, Cut, Copy, Paste, SelectAll, Information;
    JPanel statusbar;
    JTextField tclock;
    JTextField time;
    JTextArea help;
    
    JLabel HostAddress;
    JLabel HostPort;
    JLabel Username;
    JLabel Password;
    JLabel Message;
    JLabel useless;
    
    JButton Connect;
    JButton Login;
    JButton Signup;
    JButton Send;
    JButton Anonymous;
    
    JTextField hostaddress;
    JTextField hostport;
    JTextField username;
    JTextField password;
    JTextField message;
    
    JTextArea main; 
    
    final static String newline = "\n";
      
            
    
    public ChatApplication() throws IOException
    {
       super("Chat Application");
        
                main = new JTextArea();
                main.setBounds(120,200,750,200);
                add(main);
               
       
                HostAddress = new JLabel("Host Address : ");
                HostAddress.setBounds(60,40,100,100);
                add(HostAddress);  
                
                hostaddress = new JTextField("localhost");
                hostaddress.setBounds(160,78,150,25);
                add(hostaddress);
                
                HostPort = new JLabel("Host Port : ");
                HostPort.setBounds(400,40,100,100);
                add(HostPort);
                
                hostport = new JTextField("2222");
                hostport.setBounds(490,78,150,25);
                add(hostport);
                
                Username = new JLabel("User Name : ");
                Username.setBounds(60,100,100,100);
                add(Username);
                
                username = new JTextField();
                username.setBounds(160,140,150,25);
                add(username);
                
                Password = new JLabel("Password : ");
                Password.setBounds(400,100,100,100);
                add(Password);
                
                
                
                password = new JTextField();
                password.setBounds(490,140,150,25);
                add(password);
                
                Connect = new JButton("Connect");
                Connect.setBounds(900, 60, 300, 50);
                add(Connect);
                Connect.addActionListener(this);
                
                Login = new JButton("Login");
                Login.setBounds(900, 150, 150,50);
                add(Login);
                Login.addActionListener(this);
                
                Signup = new JButton("Signup");
                Signup.setBounds(1050,150,150,50);
                add(Signup);
                Signup.addActionListener(this);
                
                Message = new JLabel("Message : ");
                Message.setBounds(60,450,100,100);
                add(Message);
                
                message = new JTextField();
                message.setBounds(120,474,750,50);
                add(message);  
                
                Send = new JButton("Send");
                Send.setBounds(900,474,150,50);
                add(Send);
                Send.addActionListener(this);
             
                useless = new JLabel("");
                add(useless);
       
       
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
    public static void main(String[] args) throws IOException 
    {
        try 
        {
            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
        }   
        catch (Exception e) 
        {
            
        }
        
        ChatApplication CA =new ChatApplication();
        CA.setBounds(0,0,1366,768);
        CA.setVisible(true); 
        CA.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        CA.setVisible(true); 
        
    }
  

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getActionCommand()== "Login")
        {
            Login l = new Login();
            l.show();
            l.setBounds(1,1,470,450);
        }
        
        if(e.getActionCommand()=="Signup")
        {
            Signup s = new Signup();
            s.show();
            s.setBounds(10,10,430,700);
        }
        if(e.getActionCommand() == "Send")
        {
            String fm  = username.getText();

            String main_message = message.getText();
            main.append(fm + " : "+ main_message+newline);
            message.setText("");
            JRootPane rootPane = SwingUtilities.getRootPane(Send);
            rootPane.setDefaultButton(Send);
        }
        if(e.getActionCommand() == "Connect")
        {
            String ffm = username.getText();
            main.append(ffm + " : "+ "Has Connected"+newline);
            String str = main.getText();
            if(str.equals ("END") || str.equals("end"))
            {
                main.append(ffm + "Has requested to quit"+newline);
                main.append(ffm + " : " + "Has Disconnected"+newline);
            }
        }
           
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
    public void startClock()
    {}
    }


   