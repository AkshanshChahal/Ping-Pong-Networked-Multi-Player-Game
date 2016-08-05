/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author amareshiitd
 */
public class gamepage extends JPanel{
    
    private Game game;
    private FormPanel panel;            // These are all the initial parameters given by the user
    public int gametypex;
	public String difficulty0x;
	public String difficulty1x;
	public String whattodox = "";
	public String ipx = "";
	public String npx = "";
    
    public gamepage( int gametype, String difficulty0, String difficulty1, String whattodo, String ip, String np,String numofball){
    	
    	
        panel = new FormPanel();
        game = new Game(gametype, difficulty0,difficulty1, whattodo, ip, np,numofball);
        setLayout(new BorderLayout());
        add(game,BorderLayout.CENTER);      // Our Game screen
        add(panel, BorderLayout.EAST);      // Game info panel
    }


    public void startS()
    {
    	game.startS();
    }

    public void gameupdate(){               // is called every 20ms
        game.update();
        panel.formUpdate(game.lives);
    }
}
