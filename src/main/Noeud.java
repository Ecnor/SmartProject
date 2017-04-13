package main;

import java.util.ArrayList;

public class Noeud {
	
	private ArrayList<Arc> allArcs;
	
	private Angle noyal;
	
	public Noeud(Angle noyal){
		this.allArcs=new ArrayList<Arc>();
		this.noyal=noyal;
	}
	
	
	public void insert(Arc larc){
		//Avant d'insérer il faut check que l'arc n'est pas déjà présent.
		if(!allArcs.contains(larc))
		{
			System.out.println("Noeud : Insertion de " + larc.getCharc());
			allArcs.add(larc);
		}
		else
			System.out.println("Noeud.insert : Arc qu'il est déjà dedans");
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
	
}

