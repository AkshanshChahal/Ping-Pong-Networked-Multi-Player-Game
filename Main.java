


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Main extends JFrame implements ActionListener {

	private Timer timer;
	
	private gamepage gamepage;             // contains Game and FormPanel
	private MainFrame mainframe;           // Single or MultiPlayer
	private CardLayout cards;
	
    public int gametypex;                   // Single or MultiPlayer
    public String difficulty0x;             // Easy, Medium, Hard for Single player
    public String difficulty1x;             // Easy, Medium, Hard for Host
    public String whattodox = "";           // Host or Connect
    public String ipx = "";                 // IP address
    public String npx = "";                 // #Players
    public String numofball;                // #balls
	 
	
	
	public Main() {
		
    	setTitle("Pong");
        setResizable(false);
        setVisible(true);
            
            
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        mainframe = new MainFrame();
            
            
        cards = new CardLayout();
        setSize(900,650);
        setLayout(cards);
        timer = new Timer(20, this);
    	
            
        add(mainframe, "mainframe");	        



        // Listener for the button start Game. This will create the object of the class gamepage and sends the parameters to it.
        mainframe.setListener(new MainFrameListener(){      
        public void startgame(){
        	
        	gametypex = mainframe.gametype;
        	difficulty0x = mainframe.difficulty0;
        	difficulty1x = mainframe.difficulty1;
        	whattodox = mainframe.whattodo;
        	ipx = mainframe.ip;
        	npx = mainframe.np;
            numofball = mainframe.numofplayer;
        	gamepage = new gamepage(gametypex, difficulty0x,difficulty1x, whattodox, ipx, npx,numofball );
        	
        	add(gamepage, "gamepage");
       
        	cards.show(Main.this.getContentPane(), "gamepage");
        	gamepage.startS();
        	
                
            timer.start();
                
            }
        });
            
    }
        

    public static void main(String[] args) {
    new Main();
    }
    
    public void actionPerformed(ActionEvent e) {            // This is called in every 20ms
	   gamepage.gameupdate();
	}
		
}

   

    
	
	
	
	
	


	
