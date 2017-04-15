package main;

import java.util.ArrayList;


public class Graph {
	
	private ArrayList<Noeud> lesNoeuds;
	private ArrayList<LetterCount> lesLettres;
	
	public Graph(){
		lesNoeuds=new ArrayList<Noeud>();
		lesLettres=new ArrayList<LetterCount>();
		
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
	
	
	
	void insert(ArrayList<Angle> base, char lechar, int totalangle){
		System.out.println("Graph : Insertion de "+lechar);
		boolean is_already_inserted=false;
		for(int i = 0; i < lesLettres.size();i++)
		{
			if(lesLettres.get(i).getChar()==lechar)
				is_already_inserted=true;
		}
		if(!is_already_inserted)
		{
			Noeud pointeur=lesNoeuds.get(0);
			LetterCount lettercount=new LetterCount(lechar,totalangle);
			lesLettres.add(lettercount);
			
			for(int i=0;i<base.size();i++)
			{
			
				int indice=lesNoeuds.indexOf(new Noeud(base.get(i)));
				Noeud next=lesNoeuds.get(indice);
			
				pointeur.insert(next,lettercount);
				pointeur=next;
				
			}
		}
		
	}
	
	public ArrayList<SmartScore> evaluate(ArrayList<AngleMesure> trace)
	{
		System.out.println("Evaluation :");
		//inits
		for(int i = 0; i < lesLettres.size();i++)
		{
			lesLettres.get(i).init();
		}
		for(int i =0;i<lesNoeuds.size();i++)
		{
			lesNoeuds.get(i).init();
		}
		evaluateR(trace,lesNoeuds.get(0),0);
		
		ArrayList<SmartScore> alss = new ArrayList<SmartScore>();		
		for(int i = 0; i < lesLettres.size(); i++) {
			SmartScore ss = new SmartScore(lesLettres.get(i).getChar(), lesLettres.get(i).getScore() / Math.max(lesLettres.get(i).getTotalAngle(), trace.size()));
			alss.add(ss);
		}
		
		return alss;
	}
	
	//Optimisable...
	private void evaluateR(ArrayList<AngleMesure> trace, Noeud np, int tracep){
		if(tracep!=trace.size())
		{
			System.out.println(""+np.getNoyal());
			AngleMesure trangle= trace.get(tracep);//Angle mesuré à comparer avec les noyeaux des noeuds des différents arcs qui sortent de np
			Arc localArc;
			Noeud narc;
			for(int i = 0; i < np.getAllArcs().size();i++)
			{
				localArc=np.getAllArcs().get(i);
				narc=localArc.getNoeud();
				
				double score=narc.getNoyal().evalueAngle(trangle);
				//System.out.println("Score increment : "+score);
				localArc.scoreIncrement(score);
				evaluateR(trace,narc,tracep+1);
			}	
		}
	}
}