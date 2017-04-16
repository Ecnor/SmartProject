package main;

import java.util.ArrayList;

public class Arc {

	private static ArrayList<Arc> lesArcs=new ArrayList<Arc>();
	private int indice;
	private Noeud pnoeud;//noeud pointé
	private LetterCount lecharc;
	private int count;
	
	public Arc(Noeud pnoeud, LetterCount lecharc)
	{
		this.pnoeud=pnoeud;
		this.lecharc=lecharc;
		this.count=1;
		this.indice=lesArcs.size();
		lesArcs.add(this);
	}
	
	public int getIndice()
	{
		return this.indice;
	}
	
	public int getCount()
	{
		return this.count;
	}
	
	public static Arc getArc(int indice)
	{
		return lesArcs.get(indice);
	}
	
	public static int getArcsSize()
	{
		return lesArcs.size();
	}
	
	public char getCharc(){
	return this.lecharc.getChar();
	}
	
	public LetterCount getLC()
	{
		return this.lecharc;
	}
	
	public boolean equals(Object jeanne)
	{
		return this.pnoeud.equals(((Arc)jeanne).pnoeud) && this.lecharc==((Arc)jeanne).lecharc;
	}
	
	public Noeud getNoeud(){
		return this.pnoeud;
	}
	

	public void countIncrement(){
		count++;
	}
		
	
}
