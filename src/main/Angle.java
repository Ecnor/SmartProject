package main;

/**
 * Chaque instance de la classe Angle modélise un Angle d'une lettre.  
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class Angle {
	/**
	 * Valeurs acceptées du champs type. 
	 *     -sec : changement brutal de dérivée 
	 *     -arrondi : changement de dérivée gentil.
	 */
	public static enum TYPES{aigu,arrondi};
	
	
	/**
	 * Type peut valoir "arrondi"/"sec"
	 */
	private TYPES type;

	/**
	 * Direction de la tête de l'angle prise par la bissectrice. 
	Comprise entre 0 et 359. 0 La tête est en haut, 90 à droite, 180 en bas 270 à gauche.
	 */
	private int direction = 0;

	/**
	 * à priori sert à rien      TODO sens 
	 
	private int way = 0;
	*/

	
	/**
	 * Returns type.
	 * @return type 
	 */
	public TYPES getType() {
		return this.type;
	}


	/**
	 * Returns direction.
	 * @return direction Direction de la tête de l'angle prise par la bissectrice. 
	 Comprise entre 0 et 359. 0 La tête est en haut, 90 à droite, 180 en bas 270 à gauche.
	 */
	public int getDirection() {
		return this.direction;
	}

}
