
import java.util.Arrays;

public class DiceHand extends Die {

	//fields
	protected int[] diceHand = new int[5];
	private int[] counts = new int[7];
	private String handType;
	private int ones;
	private int twos;
	private int pair;
	private int threes;
	private int threeofkind;
	private int fours;
	private int fives;
	private int sixes;
	private int tripletCount;
	private int fiveCount;
	private int quadCount;
	private int pairCount;
	private int oneCount;
	private int score;
	
	
	//constructors
	public DiceHand() {
		rollDiceHand();
	}
	
	//methods
	
	//rolls the dice 5 times to create a hand
	public void rollDiceHand() {
		for(int x = 0; x < diceHand.length; x++) {
			/*
			int roll = super.rollDie();
			diceHand[x] = roll;
			*/
			super.rollDie();
			diceHand[x] = super.getFaceValue();
		}
	}
	
	//uses an array counts to organize the number values of each dice
	public void organizeDiceHand() {
		for(int i = 0; i < diceHand.length; i++) {
			counts[diceHand[i]]++;
		}
	}
	
	public int getScore(){return score;}
	
	//prints out the diceHand array
	public String getDiceHand() {
		String str = "";
		for(int x = 0; x < diceHand.length; x++) {
			str += diceHand[x] + "\t";
		}
		return str;
	}
	
	//prints out the counts array
	public String getCounts() {
		String str = "";
		for(int x = 1; x < counts.length; x++) {
			str += counts[x] + "\t";
		}
		return str;
	}
	
	//evaluates the the diceHand array
	public String evalDiceHand() {

		for(int v : diceHand) {
			if(v == 1) { ones++; }
			else if (v == 2) { twos++; }
			else if (v == 3) { threes++; }
			else if (v == 4) { fours++; }
			else if (v == 5) { fives++; }
			else if (v == 6) { sixes++; }
		}
		return "Ones: " + ones + 
				"\nTwos: " + twos + 
				"\nThrees: " + threes + 
				"\nFours: " + fours + 
				"\nFives: " + fives + 
				"\nSixes: " + sixes;
	}
	
	public void clearCounts(){
		ones =0;
		twos =0;
		threes=0;
		fours=0;
		fives=0;
		sixes=0;
		oneCount =0;
		tripletCount=0;
		fiveCount=0;
		quadCount=0;
		pairCount=0;
		oneCount=0;
		threeofkind=0;
		Arrays.fill(counts, 0);
		score=0;
	}
	
	//determines the value of the hand
	public String determineDiceHand() {
		//use a loop to walk through the counts array
		for(int i = 1; i <= 6; i++) {
			
			//look for how many i have of something
			//add it to a variable that represents a possible hand you get in poker
			if(counts[i] == 5) { fiveCount++; }
			else if (counts[i] == 4) { quadCount++; }
			else if (counts[i] == 3) { tripletCount++; }
			else if (counts[i] == 2) { pairCount++; }
			else if (counts[i] == 1) { oneCount++;}
			
		}
		//a set of conditionals to tell us what what have
		//return what our hand is
		if(fiveCount == 1){ handType = "Five of a Kind";score=5;}
		else if (quadCount == 1){handType = "Four of a Kind";score=4;}
		else if (tripletCount == 1){
			if(pairCount == 1){
				handType = "Full House";score=6;
			}
			else{handType = "Three of a Kind";score=3;}
		}
		else if (pairCount == 2){handType = "2 Pairs";}
		else if (pairCount == 1){handType = "1 Pair";}
		
		else{handType = "No Special Pairs";score=0;}
		
		//Return handType
		return handType;
	}
}
