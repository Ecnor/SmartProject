package main;

public class Arc {

	private Noeud pnoeud;//noeud pointé
	private LetterCount lecharc;
	private int count;
	private int currentcount;
	
	public Arc(Noeud pnoeud, LetterCount lecharc)
	{
		this.pnoeud=pnoeud;
		this.lecharc=lecharc;
		this.count=1;
	}
	
	public char getCharc(){
	return this.lecharc.getChar();
	}
	
	public boolean equals(Object jeanne)
	{
		return this.pnoeud.equals(((Arc)jeanne).pnoeud) && this.lecharc==((Arc)jeanne).lecharc;
	}
	
	public Noeud getNoeud(){
		return this.pnoeud;
	}
	
	public void scoreIncrement(double score)
	{
		//System.out.println("score increment : angle :"+pnoeud.getNoyal() +" count :"+count+", currentcount :"+currentcount+", score :"+score);
		if(currentcount>0)
		{
			currentcount--;
			lecharc.scoreIncrement(score);
		}
	}
	
	public void countIncrement(){
		count++;
	}
	
	public void init(){
		currentcount=count;
	}
	
	
}
