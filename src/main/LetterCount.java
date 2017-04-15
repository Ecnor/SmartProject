package main;

public class LetterCount {
	private char lechar;
	private double score;
	private int totalangle;
	
	public char getChar(){
		return this.lechar;
	}
	
	public void scoreIncrement(double score)
	{
		this.score+=score;
	}
	
	public LetterCount(char lechar,int totalangle){
		this.lechar=lechar;
		this.totalangle=totalangle;
	}
	
	public void init()
	{
		this.score=0;
	}
	
	public double getScore()
	{
		return this.score;
	}
	
	public int getTotalAngle()
	{
		return this.totalangle;
	}
	
	public String toString(){
		return "("+lechar+","+score/totalangle+")";
	}

}
