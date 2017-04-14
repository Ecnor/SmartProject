package main;

import java.util.ArrayList;

public class graphtest {

	public static void main(String[] args){
		//Création du graph
		
		Graph legraph=new Graph();
		//Création des lettres à insérer dans la base
		ArrayList<Angle> Ubase=new ArrayList<Angle>();
		Ubase.add(new Angle(Angle.TYPES.arrondi,Angle.DIRECTIONS.haut));
		
		ArrayList<Angle> Vbase=new ArrayList<Angle>();
		Vbase.add(new Angle(Angle.TYPES.aigu,Angle.DIRECTIONS.haut));
		
		ArrayList<Angle> Wbase=new ArrayList<Angle>();
		Wbase.add(new Angle(Angle.TYPES.arrondi,Angle.DIRECTIONS.haut));
		Wbase.add(new Angle(Angle.TYPES.aigu,Angle.DIRECTIONS.bas));
		Wbase.add(new Angle(Angle.TYPES.arrondi,Angle.DIRECTIONS.haut));
		
		
		//Insertion
		legraph.insert(Ubase,'U',1);
		legraph.insert(Ubase,'U',1);
		legraph.insert(Vbase, 'V',1);
		legraph.insert(Wbase, 'W',3);
		
		
		
		//Création d'inputs de test, simule des inputs d'utilisateurs possibles
		//On demande au capteur de filtrer le bruit.
		ArrayList<AngleMesure> U= new ArrayList<AngleMesure>();
		U.add(new AngleMesure(-10,10,'y',true));
		legraph.evaluate(U);
		
		//Legraph.evaluer(U)
		
		ArrayList<AngleMesure> V= new ArrayList<AngleMesure>();
		V.add(new AngleMesure(25,-25,'y',false));
		legraph.evaluate(V);
		
		ArrayList<AngleMesure> W= new ArrayList<AngleMesure>();
		W.add(new AngleMesure(10,-10,'y',false));
		W.add(new AngleMesure(-25,25,'y',false));
		W.add(new AngleMesure(10,-10,'y',false));
		legraph.evaluate(W);
	}
}