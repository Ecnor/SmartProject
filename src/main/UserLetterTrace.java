package main;

import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Classe décrivant la trace de l'utilisateur
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class UserLetterTrace {
	/**
	 * Liste des points tracés
	 */
	private ArrayList<Point> allPoints = new ArrayList<Point>();
	
	/**
	 * Liste des points dérivés
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
	
	/**
	 * Dérive
	 */
	private void derivate() {
		// TODO: derivate
		throw new NotImplementedException();
	}
	 
	/**
	 * Récupère l'origine et la fin de la lettre
	 */
	private void guessOriginEnd() {
		// TODO: guessOriginEnd
		throw new NotImplementedException();
	}
	 
	/**
	 * Récupère les angles de la lettre
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