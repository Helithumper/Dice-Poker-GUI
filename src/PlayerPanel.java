
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerPanel extends JPanel {
	
	

	//Fields
	JPanel diceHandPanel;
	ImageIcon d1 = new ImageIcon("d1.gif");
	ImageIcon d2 =new ImageIcon("d2.gif");
	ImageIcon d3 =new ImageIcon("d3.gif");
	ImageIcon d4 =new ImageIcon("d4.gif");
	ImageIcon d5 =new ImageIcon("d5.gif");
	ImageIcon d6 =new ImageIcon("d6.gif");
	//ImageIcon background = new ImageIcon("background.jpg");
	JLabel s1 = new JLabel(d1);
	JLabel s2 = new JLabel(d1);
	JLabel s3 = new JLabel(d1);
	JLabel s4 = new JLabel(d1);
	JLabel s5 = new JLabel(d1);
	private int playerNumber;
	
	JLabel playerName,results = new JLabel(" ");
	JButton rollButton;
	DiceHand hand; 
	
	//Constructor
	public PlayerPanel(int pn){
		hand = new DiceHand();
		playerNumber = pn;

		
		setBorderLayout();
		//setSize(600,449);	
		setBackground(Color.LIGHT_GRAY);
	}
	
	public PlayerPanel(){}
	
	public int getScore(){
		return hand.getScore();
	}

	public void buttonAction(){
		hand.clearCounts();
		hand.rollDiceHand();
		
		int spotsDone = 0;
		for(int f:hand.diceHand){
			switch(spotsDone){
			case 0:
				switch(f){
				case 1:
					s1.setIcon(d1);
					break;
				case 2:
					s1.setIcon(d2);
					break;
					
				case 3:
					s1.setIcon(d3);
					break;
				case 4:
					s1.setIcon(d4);
					break;
				case 5:
					s1.setIcon(d5);
					break;
				case 6:
					s1.setIcon(d6);
					break;
				}spotsDone++;
				break;
			case 1:
				switch(f){
				case 1:
					s2.setIcon(d1);
					break;
				case 2:
					s2.setIcon(d2);
					break;
				case 3:
					s2.setIcon(d3);
					break;
				case 4:
					s2.setIcon(d4);
					break;
				case 5:
					s2.setIcon(d5);
					break;
				case 6:
					s2.setIcon(d6);
					break;
				}spotsDone++;
				break;
			case 2:
				switch(f){
				case 1:
					s3.setIcon(d1);
					break;
				case 2:
					s3.setIcon(d2);
					break;
				case 3:
					s3.setIcon(d3);
					break;
				case 4:
					s3.setIcon(d4);
					break;
				case 5:
					s3.setIcon(d5);
					break;
				case 6:
					s3.setIcon(d6);
					break;
				}spotsDone++;
				break;
			case 3:
				switch(f){
				case 1:
					s4.setIcon(d1);
					break;
				case 2:
					s4.setIcon(d2);
					break;
				case 3:
					s4.setIcon(d3);
					break;
				case 4:
					s4.setIcon(d4);
					break;
				case 5:
					s4.setIcon(d5);
					break;
				case 6:
					s4.setIcon(d6);
					break;
				}
				spotsDone++;
				break;
			case 4:
				switch(f){
				case 1:
					s5.setIcon(d1);
					break;
				case 2:
					s5.setIcon(d2);
					break;
				case 3:
					s5.setIcon(d3);
					break;
				case 4:
					s5.setIcon(d4);
					break;
				case 5:
					s5.setIcon(d5);
					break;
				case 6:
					s5.setIcon(d6);
					break;
				}
			spotsDone++;
			break;
		}
			
		}
		hand.evalDiceHand();
		hand.organizeDiceHand();
		System.out.println("RUN");
		results.setText(hand.determineDiceHand());
	}
	public void setBorderLayout(){
		//JPanel bigPanel = new JPanel();
		setLayout(new BorderLayout());
		
		//Dice Hand Panel
		diceHandPanel = new JPanel();
		diceHandPanel.add(s1);
		diceHandPanel.add(s2);
		diceHandPanel.add(s3);
		diceHandPanel.add(s4);
		diceHandPanel.add(s5);
		
		
		add(diceHandPanel,BorderLayout.CENTER);
		
		//Button Panel
		
		JPanel buttonPanel = new JPanel();
		rollButton = new JButton("Roll Dice");
		rollButton.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buttonAction();
			}
		});
		
		buttonPanel.setLayout(new BorderLayout());
		buttonPanel.add(rollButton,BorderLayout.NORTH);
		
		
		add(buttonPanel,BorderLayout.SOUTH);
		
		//PlayerName Panel
		JPanel namePanel = new JPanel();
		
		playerName = new JLabel("<html><font color = 'blue'>Player </font><font color = 'red'>" + playerNumber +"</font></html>");
		playerName.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		namePanel.add(playerName);
		add(namePanel,BorderLayout.NORTH);
		
		//Results Panel
		JPanel resultsPanel = new JPanel();
		resultsPanel.add(results,BorderLayout.SOUTH);
		buttonPanel.add(resultsPanel);
		
		
	}
	
}
