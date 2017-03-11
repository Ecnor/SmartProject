package main;
	
import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Noeud orignie/fin
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class OENode {
	/**
	 * Noeuds AngleCountNode
	 */
	private ArrayList<AngleCountNode> AllangleCountNode = new ArrayList<AngleCountNode>();
	
	/**
	 * Origine lettre
	 */
	private Point origin = null;
	
	/**
	 * Fin lettre
	 */
	private Point end = null;
	
	/**
	 * Constructeur de la classe OENode
	 * @param o Origine
	 * @param e Fin
	 */
	public OENode(Point o, Point e) {
		this.origin = o;
		this.end = e;
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
	 * Guess
	 * @param letter_to_insert 
	 */
	public void guess(Letter letter_to_insert) {
		// TODO: guess
		throw new NotImplementedException();
	}
	 
	/**
	 * Returns AllangleCountNode.
	 * @return AllangleCountNode 
	 */
	public ArrayList<AngleCountNode> getAllangleCountNode() {
		return this.AllangleCountNode;
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
}