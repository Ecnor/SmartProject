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
	private float x = 0;
	
	/**
	 * Coordonn�e en y
	 */
	private float y = 0;	
	
	/**
	 * Contructeur de la classe Point
	 * @param cx Coordonn�e en x
	 * @param cy Coordonn�e en y
	 */
	public Point(float cx,float cy) {
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
	public float getX() {
		return this.x;
	}

	/**
	 * Returns y.
	 * @return y 
	 */
	public float getY() {
		return this.y;
	}
}