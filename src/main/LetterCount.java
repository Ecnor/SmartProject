package main;

import java.util.ArrayList;

public class LetterCount {
	private static ArrayList<LetterCount> lesLC=new ArrayList<LetterCount>();
	private int indice;
	
	private char lechar;
	private int totalangle;
	
	
	
	public int getIndice()
	{
		return this.indice;
	}
	
	public static LetterCount getLC(int indice)
	{
		return lesLC.get(indice);
	}
	
	public static int getLesLCSize()
	{
		return lesLC.size();
	}
	
	public static ArrayList<LetterCount> getlesLC()
	{
		return lesLC;
	}
	
	
	public char getChar(){
		return this.lechar;
	}
	

	
	public LetterCount(char lechar,int totalangle){
		this.lechar=lechar;
		this.totalangle=totalangle;
		this.indice=lesLC.size();
		lesLC.add(this);
	}
	

	
	public int getTotalAngle()
	{
		return this.totalangle;
	}
	

}
