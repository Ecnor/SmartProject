package main;

import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Classe d�crivant la trace de l'utilisateur
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class UserLetterTrace {
	/**
	 * Liste des points trac�s
	 */
	private ArrayList<Point> allPoints = new ArrayList<Point>();
	
	/**
	 * Liste des points d�riv�s
	 */
	private ArrayList<Point> derivedAllPoints = new ArrayList<Point>();
	
	/**
	 * Lettre a reconnaitre
	 */
	private Letter guessedLetter = null;
	
	/**
	 * Constructeur de la classe UserLetterTrace
	 * @param pts Points
	 */
	public UserLetterTrace(ArrayList<Point> pts) {
		this.allPoints = pts;
	}
	
	/**  TODO Mettre en privée une fois que ça fonctionne
	 * D�rive
	 */
	public void derivate() {
	int width=5;	
	
		for(int i=0;i<allPoints.size()-1;i++){
			derivedAllPoints.add(new Point(allPoints.get(i+1).getX()-allPoints.get(i).getX(),
					allPoints.get(i+1).getY()-allPoints.get(i).getY()));
		}
		System.out.println("Tableau  de point dérivé : \n"+derivedAllPoints.toString()+"\n");
	}
	 
	/**
	 * R�cup�re l'origine et la fin de la lettre
	 */
	private void guessOriginEnd() {
		// TODO: guessOriginEnd
		throw new NotImplementedException();
	}
	 
	/**
	 * R�cup�re les angles de la lettre
	 */
	private void guessAngles() {
		// TODO: guessAngles
		throw new NotImplementedException();
	}
	 
	/**
	 * guessLetter
	 */
	public void guessLetter() {
		// TODO: guessLetter
		throw new NotImplementedException();
	}

	/**
	 * Returns allPoints.
	 * @return allPoints 
	 */
	public ArrayList<Point> getAllPoints() {
		return this.allPoints;
	}

	/**
	 * Returns derivedAllPoints.
	 * @return derivedAllPoints 
	 */
	public ArrayList<Point> getDerivedAllPoints() {
		return this.derivedAllPoints;
	}

	/**
	 * Returns guessedLetter.
	 * @return guessedLetter 
	 */
	public Letter getGuessedLetter() {
		return this.guessedLetter;
	}
}