package main;

public class Arc {

	private Noeud pnoeud;//noeud pointé
	private char lecharc;
	
	public Arc(Noeud pnoeud, char lecharc)
	{
		this.pnoeud=pnoeud;
		this.lecharc=lecharc;
	}
	
	public char getCharc(){
		return this.lecharc;
	}
	
	public boolean equals(Object jeanne)
	{
		return this.pnoeud.equals(((Arc)jeanne).pnoeud) && this.lecharc==((Arc)jeanne).lecharc;
	}
}
