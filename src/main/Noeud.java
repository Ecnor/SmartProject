package main;

import java.util.ArrayList;

public class Noeud {
	
	private ArrayList<Arc> allArcs;
	
	private Angle noyal;
	
	public Noeud(Angle noyal){
		this.allArcs=new ArrayList<Arc>();
		this.noyal=noyal;
	}
	
	
	public void insert(Noeud noeud, LetterCount letter){
		//Avant d'insérer il faut check que l'arc n'est pas déjà présent.
		Arc larc=new Arc(noeud,letter);
		if(!allArcs.contains(larc))
		{
			System.out.println("Noeud : Insertion de " + larc.getCharc());
			allArcs.add(larc);
		}
		else
		{
			allArcs.get(allArcs.indexOf(larc)).countIncrement();
			System.out.println("Noeud.insert : Arc qu'il est déjà dedans");
		}
	}
	
	public boolean equals(Object noeud)
	{
		boolean ret;
		if(((Noeud)noeud).noyal==null)
			return false;
		ret=this.noyal.equals(((Noeud )noeud).noyal);
		///System.out.println("cocu" + ret);
		return ret;
	}
	
	public Angle getNoyal(){
		return this.noyal;
	}
	
	//C'est ptét sale mais...
	public ArrayList<Arc> getAllArcs(){
		return this.allArcs;
	}
	

	
}

