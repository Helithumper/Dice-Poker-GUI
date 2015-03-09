

public class Die {
	
	//fields
	private int faceValue;
	
	//constructor
	public Die() {}
	
	//getters and setters
	public int getFaceValue() { return faceValue; }
	public void setFaceValue(int fv) { faceValue = fv; }
	
	//rolls the dice
	public int rollDie() { 
		faceValue = (int)(Math.random() * 6) + 1;
		return faceValue;
	}
	
	//toString()
	public String toString() { return "Die Value: " + faceValue; } 
}
