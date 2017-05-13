package main;

import java.util.ArrayList;

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
	
	
	
	void insert(ArrayList<Angle> base, char lechar, int totalangle){
		////System.out.println("Graph : Insertion de "+lechar);
		ArrayList<LetterCount> lesLettres=LetterCount.getlesLC();
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
		////System.out.println("Evaluation de : " + trace);	
		
		ArrayList<Integer> passagesParArcs=new ArrayList<Integer>();
		ArrayList<Double> score=new ArrayList<Double>();
		for(int i=0;i<Arc.getArcsSize();i++)
		{
			passagesParArcs.add(Arc.getArc(i).getCount());
		}
		
		ArrayList<Double>scoreDSC=new ArrayList<Double>();
		for(int i = 0 ;i < LetterCount.getLesLCSize() ; i++)
			scoreDSC.add(0.0);
		score=evaluateR(trace,lesNoeuds.get(0),0,passagesParArcs,scoreDSC);
		
		ArrayList<SmartScore> alss = new ArrayList<SmartScore>();		
		for(int i = 0; i < LetterCount.getLesLCSize(); i++) {
			SmartScore ss = new SmartScore(LetterCount.getLC(i).getChar(), score.get(i) / Math.max(LetterCount.getLC(i).getTotalAngle(), trace.size()));
			////System.out.println("SMART SCORE : "+i+"  "+score.get(i));
			alss.add(ss);
		}
		
		return alss;
	}
	
	
	private ArrayList<Double> evaluateR(ArrayList<AngleMesure> trace, Noeud np, int tracep,
			ArrayList<Integer> passageParArcs,ArrayList<Double> scoreDSC)
	{
		ArrayList<Double> lesScores=new ArrayList<Double>(scoreDSC);
	
		if(tracep!=trace.size())
		{			
			AngleMesure trangle= trace.get(tracep);//Angle mesuré à comparer avec les noyeaux des noeuds des différents arcs qui sortent de np
			Arc localArc;
			Noeud narc;
		
			//Parcours du graphe
			for(int i = 0; i < np.getAllArcs().size();i++)
			{		
				localArc=np.getAllArcs().get(i);
				ArrayList<Integer>localPPA=new ArrayList<Integer>(passageParArcs);
				narc=localArc.getNoeud();
				ArrayList<Double>localSC=new ArrayList<Double>();
				
				for(int j = 0; j < scoreDSC.size() ; j++)
				{
					localSC.add(new Double(scoreDSC.get(j).doubleValue()));
				}
					
				if(localPPA.get(localArc.getIndice())>0)
				{
					double score=narc.getNoyal().evalueAngle(trangle);
					
					/*if(localArc.getCharc() == 'B' || localArc.getCharc() == 'V')
					{//le print conditionnel, la révolution du débugage.
					//System.out.println("PARCOURS"+tracep+": Angle :"+narc.getNoyal() + " De la Lettre : " + localArc.getCharc());
					//System.out.println("Ampf :"+trace.get(tracep).getAmpf()+" Avpf : "+trace.get(tracep).getAvpf());
					//System.out.println("Score increment : "+score);
					}*/
					localSC.set(localArc.getLC().getIndice(),localSC.get(localArc.getLC().getIndice())+score);
					localPPA.set(localArc.getIndice(), localPPA.get(localArc.getIndice())-1);
				}
				
				ArrayList<Double> localSM=evaluateR(trace,narc,tracep+1,localPPA,localSC);
				for(int j = 0; j < localSM.size();j++)
				{
					if(localSM.get(j)>lesScores.get(j))
						lesScores.set(j, localSM.get(j));
				}
			}
		}
		return lesScores;
	}	
}