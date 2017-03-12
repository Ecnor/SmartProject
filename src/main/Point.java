package main;

/**
 * Classe d�crivant un point 2D
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class Point {
	
	static int printCount=0;
	/**
	 * Coordonn�e en x
	 */
	private int x = 0;
	
	/**
	 * Coordonn�e en y
	 */
	private int y = 0;	
	
	/**
	 * Contructeur de la classe Point
	 * @param cx Coordonn�e en x
	 * @param cy Coordonn�e en y
	 */
	public Point(int cx, int cy) {
		this.x = cx;
		this.y = cy;
	}
	
	public String toString() {
		String retourne="(x: " + this.x + " ; y: " + this.y + ")";
		if(printCount==10){
			retourne+="\n";
			printCount=0;
		}
		printCount++;
		return retourne;
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