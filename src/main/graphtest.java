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
		legraph.insert(Ubase,'U');
		legraph.insert(Vbase, 'V');
		legraph.insert(Wbase, 'W');
		
		
		
		//Création d'inputs de test, simule des inputs d'utilisateurs possibles
		//On demande au capteur de filtrer le bruit.
		ArrayList<AngleMesure> U= new ArrayList<AngleMesure>();
		U.add(new AngleMesure(20,-20));
		
		//Legraph.evaluer(U)
		
		ArrayList<AngleMesure> V= new ArrayList<AngleMesure>();
		V.add(new AngleMesure(70,-70));
		
		ArrayList<AngleMesure> W= new ArrayList<AngleMesure>();
		W.add(new AngleMesure(20,-20));
		W.add(new AngleMesure(-70,70));
		W.add(new AngleMesure(20,-20));
	}
}