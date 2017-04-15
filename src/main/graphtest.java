package main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class graphtest {

	public static void main(String[] args){
		//Création du graph	
		Graph legraph = parser();			
		
		//Création d'inputs de test, simule des inputs d'utilisateurs possibles
		//On demande au capteur de filtrer le bruit.
		ArrayList<AngleMesure> U= new ArrayList<AngleMesure>();
		U.add(new AngleMesure(-10,10,'y',true));
		System.out.println(legraph.evaluate(U));
		
		ArrayList<AngleMesure> V= new ArrayList<AngleMesure>();
		V.add(new AngleMesure(25,-25,'y',false));
		System.out.println(legraph.evaluate(V));
		
		ArrayList<AngleMesure> W= new ArrayList<AngleMesure>();
		W.add(new AngleMesure(10,-10,'y',false));
		W.add(new AngleMesure(-25,25,'y',false));
		W.add(new AngleMesure(10,-10,'y',false));
		System.out.println(legraph.evaluate(W));
	}
	
	public static Graph parser() {
		Graph g = new Graph();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/main/config.sp"));
		
		    String line = br.readLine();

		    while (line != null) {	        	        
		        String[] parts = line.split(",");
		        
		        char lechar = parts[0].charAt(0);
		        ArrayList<Angle> angles = new ArrayList<Angle>();
		        
		        for(int i = 1; i < parts.length; i+=2) {	        	
		        	angles.add(new Angle(Angle.TYPES.valueOf(parts[i]), Angle.DIRECTIONS.valueOf(parts[i + 1])));
		        }
		        
		        g.insert(angles, lechar, angles.size());
		        
		        line = br.readLine();
		    }	    
		    
		    br.close();
		} 
		catch(Exception e) {
			System.out.println(e.toString());
		} 
		
		return g;
	}
}