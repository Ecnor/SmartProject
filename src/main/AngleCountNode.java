package main;

import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Noeud du compteur d'angle.
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class AngleCountNode {
	/**
	 * Liste des lettres avec le même nombre d'angles
	 */
	private ArrayList<Letter> letters = new ArrayList<Letter>();

	/**
	 * Nombre d'angles
	 */
	private int angleCount = 0;
	
	/**
	 * Contructeur de la classe AngleCountNode
	 * @param ac Nombre d'angles
	 */
	public AngleCountNode(int ac) {
		this.angleCount = ac;
	}

	/**
	 * Insère une lettre
	 * @param letter_to_insert Lettre à insèrer
	 */
	public void insert(Letter letter_to_insert) {
		// TODO: insert
		throw new NotImplementedException();
	}

	/**
	 * Description of the method guess.
	 * @param letter_to_guess 
	 */
	public Letter guess(Letter letter_to_guess) {
		// TODO: guess
		throw new NotImplementedException();
	}
	
	/**
	 * Returns letters.
	 * @return letters 
	 */
	public ArrayList<Letter> getLetters() {
		return this.letters;
	}

	/**
	 * Returns angleCount.
	 * @return angleCount 
	 */
	public int getAngleCount() {
		return this.angleCount;
	}
}
