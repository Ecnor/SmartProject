package main;

/**
 * Classe décrivant un point 2D
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class Point {
	/**
	 * Coordonnée en x
	 */
	private int x = 0;
	
	/**
	 * Coordonnée en y
	 */
	private int y = 0;	
	
	/**
	 * Contructeur de la classe Point
	 * @param cx Coordonnée en x
	 * @param cy Coordonnée en y
	 */
	public Point(int cx, int cy) {
		this.x = cx;
		this.y = cy;
	}
	
	public String toString() {
		return "(x: " + this.x + " ; y: " + this.y + ")\n";
	}
	
	/**
	 * Returns x.
	 * @return x 
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Returns y.
	 * @return y 
	 */
	public int getY() {
		return this.y;
	}
}