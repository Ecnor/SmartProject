package main;

import java.util.ArrayList;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class Graph {
	
	private ArrayList<Noeud> lesNoeuds;
	
	
	public Graph(){
		lesNoeuds=new ArrayList<Noeud>();
		lesNoeuds.add(new Noeud(null));
		
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.aigu,Angle.DIRECTIONS.haut)));
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.aigu,Angle.DIRECTIONS.bas)));
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.aigu,Angle.DIRECTIONS.gauche)));
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.aigu,Angle.DIRECTIONS.droite)));
		
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.arrondi,Angle.DIRECTIONS.haut)));
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.arrondi,Angle.DIRECTIONS.bas)));
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.arrondi,Angle.DIRECTIONS.gauche)));
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.arrondi,Angle.DIRECTIONS.droite)));
		
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.droit,Angle.DIRECTIONS.haut)));
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.droit,Angle.DIRECTIONS.bas)));
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.droit,Angle.DIRECTIONS.gauche)));
		lesNoeuds.add(new Noeud(new Angle(Angle.TYPES.droit,Angle.DIRECTIONS.droite)));
		
		
	}
	
	
	
	void insert(ArrayList<Angle> base, char lechar){
		System.out.println("Graph : Insertion de "+lechar);
		
		Noeud pointeur=lesNoeuds.get(0);
		for(int i=0;i<base.size();i++)
		{
		
		int indice=lesNoeuds.indexOf(new Noeud(base.get(i)));
		Noeud next=lesNoeuds.get(indice);
		
		pointeur.insert(new  Arc(next,lechar));
		pointeur=next;
		}
		
	}
}
;