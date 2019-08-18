
package planets;

import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Planets extends JFrame implements ActionListener, KeyListener 
{
    JLabel Mercury;
    JLabel Venus;
    JLabel Earth;
    JLabel Mars;
    JLabel Jupiter;
    JLabel Saturn;
    JLabel Uranus;
    JLabel Neptune;
    
    JTextArea mercury1;
    JTextArea venus1;
    JTextArea earth1;
    JTextArea mars1;
    JTextArea jupiter1;
    JTextArea saturn1;
    JTextArea uranus1;
    JTextArea neptune1;
    
    JButton mer;
    JButton ven;
    JButton ear;
    JButton mar;
    JButton jup;
    JButton sat;
    JButton ura;
    JButton nep;
    
    Icon mercu;
    Icon venu;
    Icon eart;
    Icon marse;
    Icon jupi;
    Icon satu;
    Icon uran;
    Icon nept;
    
    Planets() 
    {
        super("Planets+");
        
        Mercury = new JLabel("Mercury");
        Mercury.setBounds(60,40,100,100);
        mercury1.setBounds(160,80,150,25);
        mercury1.setVisible(false);
        add(Mercury);
        add(mercury1);
        mercu = new ImageIcon("C:\\Users\\ritvik100\\Documents\\NetBeansProjects\\Planets+\\mercury.jpg");
        mer = new JButton("Mercury", mercu);
        add(mer);
        
        
        Venus = new JLabel("Venus");
        Venus.setBounds(410,40,100,100);
        venus1 = new JTextArea();
        venus1.setBounds(160,80,150,25);
        venus1.setVisible(false);
        add(Venus);
        add(venus1);
        
        Earth = new JLabel("Earth");
        Earth.setBounds(760,40,100,100);
        earth1 = new JTextArea();
        earth1.setBounds(160,80,150,25);
        earth1.setVisible(false);
        add(Earth);
        add(earth1);
        
        Mars = new JLabel("Mars");
        Mars.setBounds(1110,40,100,100);
        mars1 = new JTextArea();
        mars1.setBounds(160,80,150,25);
        mars1.setVisible(false);
        add(Mars);
        add(mars1);
        
        Jupiter = new JLabel("Jupiter");
        Jupiter.setBounds(60,340,100,100);
        jupiter1 = new JTextArea();
        jupiter1.setBounds(160,80,150,25);
        jupiter1.setVisible(false);
        add(Jupiter);
        add(jupiter1);
        
        Saturn = new JLabel("Saturn");
        Saturn.setBounds(410,340,100,100);
        saturn1 = new JTextArea();
        saturn1.setBounds(160,80,150,25);
        saturn1.setVisible(false);
        add(Saturn);
        add(saturn1);
        
        Uranus = new JLabel("Uranus");
        Uranus.setBounds(760,340,100,100);
        uranus1 = new JTextArea();
        uranus1.setBounds(160,80,150,25);
        uranus1.setVisible(false);
        add(Uranus);
        add(uranus1);
        
        Neptune = new JLabel("Neptune");
        Neptune.setBounds(1110,340,100,100);
        neptune1 = new JTextArea();
        neptune1.setBounds(160,80,150,25);
        neptune1.setVisible(false);
        add(Neptune);
        add(neptune1);
        
        addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
		}}) ;  
    }

    public static void main(String[] args) 
    {
        Planets P=new Planets();
        P.setBounds(0,0,1366,768);
        P.setVisible(true); 
        P.setExtendedState(JFrame.MAXIMIZED_BOTH); 
        P.setUndecorated(true);
        P.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
