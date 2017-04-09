package main;

/**
 * Chaque instance de la classe Angle mod�lise un Angle d'une lettre.  
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class Angle {
	/**
	 * Valeurs accept�es du champs type. 
	 *     -sec : changement brutal de d�riv�e
	 *     -arrondi : changement de d�riv�e gentil.
	 */
	public static enum TYPES{aigu,arrondi};
	
	
	/**
	 * Type peut valoir "arrondi"/"sec"
	 */
	private TYPES type;

	/**
	 * Direction de la t�te de l'angle prise par la bissectrice. 
	Comprise entre 0 et 359. 0 La t�te est en haut, 90 �droite, 180 en bas 270�� gauche.
	 */
	private int direction = 0;
	
	/**
	 * Constructeur de la classe Angle
	 * @param t type de l'angle
	 * @param d direction de l'angle
	 */
	public Angle(TYPES t) {
		this.type = t;
	}
	
	/**
	 * Returns type.
	 * @return type 
	 */
	public TYPES getType() {
		return this.type;
	}

	/**
	 * Returns direction.
	 * @return direction Direction de la t�te de l'angle prise par la bissectrice. 
	 Comprise entre 0 et 359. 0 La tête est en haut, 90 �droite, 180 en bas 270 � gauche.
	 */
	public int getDirection() {
		return this.direction;
	}
	
	public String toString() {
		return type.toString();
	}
}