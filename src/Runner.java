
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class Runner {

	static ArrayList<PlayerPanel> panels = new ArrayList<PlayerPanel>();
	static ArrayList<JFrame> frames = new ArrayList<JFrame>();
	static ArrayList<PlayerPanel> winPanels;
	static int playerNum = 1;
	static void buildPlayer(){
		JFrame frame = new JFrame("Player " + (playerNum+1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.setMinimumSize(new Dimension(200,100));
		//frame.setLocation(Math.abs(playerNum*400-150),0);
		
		PlayerPanel pp = new PlayerPanel((playerNum+1));
		JPanel gamePanel = new JPanel();
		gamePanel.setBackground(Color.WHITE);
		gamePanel.add(pp);
		
		
		 
	
		frame.getContentPane().add(gamePanel);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
		panels.add(pp);
		frames.add(frame);
		playerNum++;
	}
	
	static void deletePerson(){
		int playnum = frames.size()-1;
		frames.get(playnum).dispose();
		frames.remove(playnum);
		playerNum--;
		
	}
	/*static void buildScoreBoard(){
		JFrame frame = new JFrame("SCOREBOARD");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.setMinimumSize(new Dimension(350,600));
		//ScoreBoardPanel scp = new ScoreBoardPanel();
		//frame.getContentPane().add(scp);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}*/
	static void checkWinner(){
		winPanels = new ArrayList<PlayerPanel>();
		winPanels.add(panels.get(0));
		PlayerPanel check;
		for(PlayerPanel pp:panels){
			check = winPanels.get(0);
			if(pp.getScore()>check.getScore()){
				winPanels.clear();
				winPanels.add(pp);
			}
			else if(pp.getScore()==check.getScore()){
				winPanels.add(pp);
			}
			
		}
		System.out.println("ITS NOT WOKRING");
		for(PlayerPanel pp:panels){
			pp.setBackground(Color.RED);
			pp.diceHandPanel.setBackground(Color.RED);
		}
		for(PlayerPanel ppa:winPanels){
			ppa.setBackground(Color.BLUE);
			ppa.diceHandPanel.setBackground(Color.BLUE);
		}
	}
	
	static Boolean outofSF = false;
	public static void main(String[] args) {
		
			int NumOfPlayers =4;
			
			
			for(int i=0;i<NumOfPlayers;i++){
				buildPlayer();
				
			}

			
			//buildScoreBoard();
			
			Scanner reader = new Scanner(System.in);
			Boolean gameLoop = true;
			System.out.println("Welcome to the Dice Game CONSOLE\n");
			System.out.println("Commands:\n/rollAll------Roll All Dice\n/Exit---------Exit all Games\n/RollAllAlot--Roll the Dice ALOT");
			
			JFrame frame = new JFrame("CONSOLE");
			//frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setBackground(Color.WHITE);
			frame.setMinimumSize(new Dimension(200,100));
			
			ComandConsole consolePanel = new ComandConsole();
			
			frame.setLocationRelativeTo(null);
			frame.getContentPane().add(consolePanel);
			frame.pack();
			frame.setVisible(true);
			
			while(gameLoop){
				System.out.println("\nPlease Enter a Command!");
				String input = reader.nextLine();
				switch(input){
				case "/rollAllAlot":
					Boolean runningTONS = true;
					while(runningTONS){
					consolePanel.rollAll();}
					break;
				case "/rollAll":
					for(PlayerPanel p:panels){
						p.buttonAction();
					}
				//case "/Restart":
					
					
				case "/Exit":
					for(JFrame f:frames){
						f.dispatchEvent(new WindowEvent(f, WindowEvent.WINDOW_CLOSING));
					}
					break;
				default:
					System.out.println("Please Enter a Different, Valid, Command");
					break;
				}
			}
		}
		
		
		/*
		//creates one die and rolls it
		Die die1 = new Die();
		System.out.println(die1.rollDie());
		*/
		
		
		
		
		/*Scanner reader = new Scanner(System.in);
		//Choose how many players
		System.out.println("Welcome to the Dice Poker Game!\nHow many Players shall play?");
		int input = reader.nextInt();
		System.out.println("How Many Rounds?");
		int input2 = reader.nextInt();

		
		//Print out said rounds
		for(int j = 0;j<input2;j++){
			DiceHand player = new DiceHand();
			System.out.println("Round " + (j+1) + ":");
			for(int i = 0;i<input;i++){
				player.rollDiceHand();
				System.out.println("Player " + (i + 1) + " Hand: \n\t" + player.getDiceHand());
				player.evalDiceHand();
				player.organizeDiceHand();
				System.out.println(player.getCounts());
				System.out.println("\nHand Type: " + player.determineDiceHand() + "\n");
				player.clearCounts();
			}
		}*/
		/*rolls a dice hand
		DiceHand hand = new DiceHand();
		hand.rollDiceHand();
		System.out.println("Original Hand: " + hand.getDiceHand());
		System.out.println();
		hand.organizeDiceHand();
		System.out.println("Organzied Hand: " + hand.getCounts());
		System.out.println("\nHand Type: " + hand.determineDiceHand());
		*/

	}


