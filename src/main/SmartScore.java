package main;

public class SmartScore {
	private char letter;
	private double score;
	
	public SmartScore(char l, double s) {
		letter = l;
		score = s;
	}
	
	public char getLetter() {
		return this.letter;
	}
	
	public double getScore() {
		return this.score;
	}
	
	public String toString() {
		return letter + ": " + score;
	}
}
