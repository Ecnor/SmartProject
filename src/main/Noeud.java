package main;

import java.util.ArrayList;

public class Noeud {
	
	private ArrayList<Arc> allArcs;
	
	Angle noyal;
	
	public Noeud(Angle noyal){
		this.noyal=noyal;
	}
	
	
	public void insert(Arc larc){
		System.out.println("Noeud : Insertion de " + larc.getCharc());
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
	
}

