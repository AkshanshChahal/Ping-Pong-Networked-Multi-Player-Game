


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;


public class MainFrame extends JPanel
{
    // These are the different Buttons, RadioBoxes, JLabels etc to get the input from the user.
    private JButton start;
    private JButton jb1;
    private JButton jb2;
    private ButtonGroup Type;
    private JRadioButton jb3;
    private JRadioButton jb4;
    private JRadioButton jb5;
    private JTextField jarea;
    private JTextField numbpl;
    private JRadioButton jb8;
    private JRadioButton jb9;
    private JRadioButton jb10;
    private JRadioButton nb1;
    private JRadioButton nb2;
    private JRadioButton nb3;
    private JButton jb6;
    private JButton jb7;
    private JLabel l1;
    private JLabel l2;
    private JLabel l3;
    private JLabel l4;
    private JLabel l5;
    private ButtonGroup b1;
    private ButtonGroup b2;
    private ButtonGroup b3;
    public int gametype;
    public String difficulty0;
    public String difficulty1;
    public String numofplayer;
    public String whattodo = "";
    public String ip = "";
    public String np = "";
    private MainFrameListener listener;


    public MainFrame(){
     
        start = new JButton("start game");
        jb1 = new JButton("Single player");
        jb2 = new JButton("Multi player");
        l1 = new JLabel("select:");
        l2 = new JLabel("Difficulty:");
        l3 = new JLabel("Choose");
        l4 = new JLabel("Difficulty");
        l5 = new JLabel("ball:");
        jarea = new JTextField(15);
        numbpl = new JTextField(1);
        b1 = new ButtonGroup();
        b2 = new ButtonGroup();
        b3 = new ButtonGroup();
        
        
        setLayout(new GridBagLayout());
        setFocusable(true);
        GridBagConstraints gc = new GridBagConstraints();       
        gc.gridx=0;
        gc.gridy=0;
        gc.weightx=1;
        gc.weighty=0.05;
        gc.fill= GridBagConstraints.NONE;
        add(l1,gc);
        
        
        gc.gridx=1;                 // Putting the objects in the different rows and collums
        gc.gridy=0;
        
        add(jb1,gc);
        
        gc.gridx=2;
        gc.gridy=0;
        add(jb2,gc);
        
        jb3 = new JRadioButton("Easy");
        jb4 = new JRadioButton("Medium");
        jb5 = new JRadioButton("Hard");
        jb8 = new JRadioButton("Easy");
        jb9 = new JRadioButton("Medium");
        jb10 = new JRadioButton("Hard");
        nb1 = new JRadioButton("1");
        nb2 = new JRadioButton("2");
        nb3 = new JRadioButton("3");
        
        b1.add(jb3);
        b1.add(jb4);
        b1.add(jb5);
        b3.add(nb1);
        b3.add(nb2);
        b3.add(nb3);
        b2.add(jb8);
        b2.add(jb9);
        b2.add(jb10);
        gc.gridx=0;
        gc.gridy=1;
        add(l2,gc);
        
        gc.gridx=1;
        gc.gridy=1;
        add(jb3,gc);
        
        gc.gridx=0;
        gc.gridy=4;
        add(l5,gc);
        
        gc.gridx=1;
        gc.gridy=4;
        add(nb1,gc);
        
        gc.gridx=2;
        gc.gridy=4;
        add(nb2,gc);
        
        gc.gridx=3;
        gc.gridy=4;
        add(nb3,gc);
        
        gc.gridx=1;
        gc.gridy=4;
        add(jarea,gc);
        
        gc.gridx=2;
        gc.gridy=5;
        add(numbpl,gc);
        
        gc.gridx=2;
        gc.gridy=1;
        add(jb4,gc);
        
        gc.gridx=3;
        gc.gridy=1;
        add(jb5,gc);
        
        gc.gridx=0;
        gc.gridy=3;
        add(l4,gc);
        
        gc.gridx=1;
        gc.gridy=3;
        add(jb8,gc);
        
        gc.gridx=2;
        gc.gridy=3;
        add(jb9,gc);
        
        gc.gridx=3;
        gc.gridy=3;
        add(jb10,gc);
        
        jb6 = new JButton("Connect");
        jb7 = new JButton("Host");
        gc.gridx=0;
        gc.gridy=2;
        add(l3,gc);
        
        gc.gridx=1;
        gc.gridy=2;
        add(jb6,gc);
        
        gc.gridx=2;
        gc.gridy=2;
        add(jb7,gc);
        
        gc.gridx=1;
        gc.gridy=5;
        add(start,gc);
        jb3.setSelected(true);
        jb8.setSelected(true);
        nb1.setSelected(true);
        jb3.setActionCommand("easy");
        jb4.setActionCommand("medium");
        jb5.setActionCommand("hard");
        jb8.setActionCommand("easy");
        jb9.setActionCommand("medium");
        jb10.setActionCommand("hard");
        nb1.setActionCommand("1");
        nb2.setActionCommand("2");
        nb3.setActionCommand("3");
        start.setVisible(false);
        jb3.setVisible(false);
        jb4.setVisible(false);
        jb5.setVisible(false);
        jb6.setVisible(false);
        jb7.setVisible(false);
        l2.setVisible(false);
        l3.setVisible(false);
        l4.setVisible(false);
        l5.setVisible(false);
        jb8.setVisible(false);
        jb9.setVisible(false);
        jb10.setVisible(false);
        nb1.setVisible(false);
        nb2.setVisible(false);
        nb3.setVisible(false);
        jarea.setVisible(false);
        numbpl.setVisible(false);

        
        jb1.addActionListener(new ActionListener(){

            public void actionPerformed(ActionEvent e) {
                jb3.setVisible(true);
                jb4.setVisible(true);
                jb5.setVisible(true);
                nb1.setVisible(true);
                nb2.setVisible(true);
                nb3.setVisible(true);
                l2.setVisible(true);
                l5.setVisible(true);
                jb6.setVisible(false);
                jb7.setVisible(false);
                jb8.setVisible(false);
                jb9.setVisible(false);
                jb10.setVisible(false);
                jarea.setVisible(false);
                numbpl.setVisible(false);
                start.setVisible(true);
                l3.setVisible(false);
                l4.setVisible(false);
                gametype = 0;
            }
    
        });

        
        start.addActionListener(new ActionListener(){               // Listener for the startGame
            public void actionPerformed(ActionEvent e) {

                difficulty0 = b1.getSelection().getActionCommand();
                difficulty1 = b2.getSelection().getActionCommand();
                numofplayer = b3.getSelection().getActionCommand();
                ip = jarea.getText();
                np = numbpl.getText();
          
                fireStartGame();
            }
        });
        
        jb2.addActionListener(new ActionListener(){             // Listener for the Single Player or MultiPlayer

            public void actionPerformed(ActionEvent e) {
                
                jb6.setVisible(true);
                jb7.setVisible(true);
                l3.setVisible(true);
                jb3.setVisible(false);
                jb4.setVisible(false);
                jb5.setVisible(false);
                nb1.setVisible(false);
                nb2.setVisible(false);
                nb3.setVisible(false);
                l5.setVisible(false);
                jb8.setVisible(false);
                jb9.setVisible(false);
                jb10.setVisible(false);
                l2.setVisible(false);
                start.setVisible(true);
                gametype = 1;
            }
            
            
        });
        
        jb6.addActionListener(new ActionListener(){		// Listener for the "connect" option button

            public void actionPerformed(ActionEvent e) {
                jb8.setVisible(false);
                jb9.setVisible(false);
                jb10.setVisible(false);
                l4.setVisible(false);
                jarea.setVisible(true);
                numbpl.setVisible(false);
                jb6.setVisible(false);
                jb7.setVisible(false);
                l3.setVisible(false);
                whattodo = "connect";
            }
            
            
        });
        
        jb7.addActionListener(new ActionListener(){  // Listener for the "connect" option button

            public void actionPerformed(ActionEvent e) {
                
                jb8.setVisible(true);
                jb9.setVisible(true);
                jb10.setVisible(true);
                l4.setVisible(true);
                jarea.setVisible(false);
                numbpl.setVisible(true);
                jb6.setVisible(false);
                jb7.setVisible(false);
                l3.setVisible(false);
                whattodo = "host";
                nb1.setVisible(true);
                nb2.setVisible(true);
                nb3.setVisible(true);
                l5.setVisible(true);
            }
            
            
        });
        
        
    }
    
    public void setListener(MainFrameListener listener)   
    {
        this.listener= listener;
    }
    
    public void fireStartGame(){
        if(listener != null)
        {
            listener.startgame();
        }
    }
}

