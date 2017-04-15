package main;

import java.util.ArrayList;

/**
 * Classe d�crivant une lettre.
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class Letter {
	/**
	 * Lettre
	 */
	private char character;
	
	/**
	 * Angles de la lettre
	 */
	private ArrayList<Angle> allAngles = new ArrayList<Angle>();
	
	/**
	 * Constructeur de la classe Lettre
	 * @param c Caract�re
	 * @param a Angles
	 */
	public Letter(char c, ArrayList<Angle> a) {
		this.character = c;	
		this.allAngles = a;
	}
	
	/**
	 * Returns character.
	 * @return character 
	 */
	public char getCharacter() {
		return this.character;
	}

	/**
	 * Returns allAngles.
	 * @return allAngles 
	 */
	public ArrayList<Angle> getAllAngles() {
		return this.allAngles;
	}
	
	/**
	 * Add an angle
	 * @param a angle
	 */
	public void addAngle(Angle a) {
		this.allAngles.add(a);
	}
}