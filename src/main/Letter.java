package main;

import java.util.ArrayList;

/**
 * Classe décrivant une lettre.
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class Letter {
	/**
	 * Lettre
	 */
	private char character;
	
	/**
	 * Origine de la lettre
	 */
	private Point origin = null;
	
	/**
	 * Fin de la lettre
	 */
	private Point end = null;
	
	/**
	 * Angles de la lettre
	 */
	private ArrayList<Angle> allAngles = new ArrayList<Angle>();
	
	/**
	 * Constructeur de la classe Lettre
	 * @param c Caractère
	 * @param o Origine
	 * @param e Fin
	 * @param a Angles
	 */
	public Letter(char c, Point o, Point e, ArrayList<Angle> a) {
		this.character = c;
		this.origin = o;
		this.end = e;		
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
	 * Returns origin.
	 * @return origin 
	 */
	public Point getOrigin() {
		return this.origin;
	}

	/**
	 * Returns end.
	 * @return end 
	 */
	public Point getEnd() {
		return this.end;
	}

	/**
	 * Returns allAngles.
	 * @return allAngles 
	 */
	public ArrayList<Angle> getAllAngles() {
		return this.allAngles;
	}
}