
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class FormPanel extends JPanel {
	
	
	public JLabel[] players = new JLabel[4];
	public JLabel[] lives = new JLabel[4];
	public JTextField[] livesx = new JTextField[4];
	
	
	
	public FormPanel(){
		
		Dimension dim = getPreferredSize();
		dim.width = 250;
		setPreferredSize(dim);
		
		for(int i=0;i<4;i++)
		{
			players[i] = new JLabel("Player " + (i+1) + " : ");
			lives[i] = new JLabel("3 Lives");
		}
		
		
		players[0].setForeground(Color.BLUE);								// Setting Font and Size of the text
		players[0].setFont (players[0].getFont().deriveFont(20.0f));

		players[2].setForeground(Color.PINK);
		players[2].setFont (players[1].getFont().deriveFont(20.0f));
		
		players[1].setForeground(Color.ORANGE);
		players[1].setFont (players[2].getFont().deriveFont(20.0f));
		
		players[3].setForeground(Color.GREEN);
		players[3].setFont (players[3].getFont().deriveFont(20.0f));
		
		
		
		
		
		
		Border innerborder = BorderFactory.createTitledBorder("Players");			// Bordering of the Info Panel
		Border outerborder = BorderFactory.createEmptyBorder(5,5,5,5);
		setBorder(BorderFactory.createCompoundBorder(outerborder, innerborder)) ;
		
		
		setLayout(new GridBagLayout());
		
		GridBagConstraints gc = new GridBagConstraints();

		// Adding the JLabels and JTextFields onto the GridLayout
		
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 1;
		gc.fill = GridBagConstraints.NONE;
		
		gc.anchor = GridBagConstraints.LINE_END;
		add(players[0], gc);
		
		gc.gridx = 1;
		gc.gridy = 0;
		gc.anchor = GridBagConstraints.LINE_START;
		add(lives[0], gc);
		
		gc.gridx = 0;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_END;
		add(players[1], gc);
		
		gc.gridx = 1;
		gc.gridy = 1;
		gc.anchor = GridBagConstraints.LINE_START;
		add(lives[1], gc);
		
		gc.gridx = 0;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_END;
		add(players[2], gc);
		
		gc.gridx = 1;
		gc.gridy = 2;
		gc.anchor = GridBagConstraints.LINE_START;
		add(lives[2], gc);
		
		gc.gridx = 0;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_END;
		add(players[3], gc);
		
		gc.gridx = 1;
		gc.gridy = 3;
		gc.anchor = GridBagConstraints.LINE_START;
		add(lives[3], gc);

	}
	
	
	public void formUpdate(int[] A){				// Updating the lives of the players
		
		for(int i=0;i<4;i++){
			if(A[i]==0){
				lives[i].setText("DEAD");
			}
			else{
				lives[i].setText(Integer.toString(A[i]));
			}
			
		}
		
		
	}
	

}
