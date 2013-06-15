package net.mindsoup.pathfindercharactersheet.pf.util;

public class Dice {
	int numSides;
	int numDice;
	
	public Dice(int argNumSides, int argNumDice) {
		numSides = argNumSides;
		numDice = argNumDice;
	}
	
	public String toString() {
		return Integer.toString(numDice) + "d" + Integer.toString(numSides);
	}
	
	public int getMax() {
		return numSides * numDice;
	}
}
