package main;

import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Arbre de lettres
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class LetterTree {
	/**
	 * Noeuds origine/fin
	 */
	private ArrayList<OENode> allOENodes = new ArrayList<OENode>();
	
	/**
	 * Fichier description lettres
	 */
	private String file_letters_description_path;
	
	/**
	 * Constructeur de la classe LetterTree
	 * @param f Chemin du fichier de description des lettres
	 */
	public LetterTree(String f) {
		this.file_letters_description_path = f;
	}
	
	/**
	 * Insert
	 * @param letter_to_insert 
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
	 * Description of the method loadFile.
	 * @param file_to_load 
	 */
	public void loadFile() {
		// TODO: loadFile
		throw new NotImplementedException();
	}
}
