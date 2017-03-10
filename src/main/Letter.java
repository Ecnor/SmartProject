/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/


import java.util.ArrayList;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Letter.
 * 
 * @author alain
 */
public class Letter {
	/**
	 * Description of the property character.
	 */
	private char character = 0;
	
	/**
	 * Description of the property origin.
	 */
	private Point origin = null;
	
	/**
	 * Description of the property end.
	 */
	private Point end = null;
	
	/**
	 * Description of the property allAngles.
	 */
	private ArrayList<Angle> allAngles = new ArrayList<Angle>();
	
	// Start of user code (user defined attributes for Letter)

	// End of user code
	
	
	// Start of user code (user defined methods for Letter)

	// End of user code
	/**
	 * Returns character.
	 * @return character 
	 */
	public char getCharacter() {
		return this.character;
	}
	
	/**
	 * Sets a value to attribute character. 
	 * @param newCharacter 
	 */
	public void setCharacter(char newCharacter) {
	    this.character = newCharacter;
	}

	/**
	 * Returns origin.
	 * @return origin 
	 */
	public Point getOrigin() {
		return this.origin;
	}
	
	/**
	 * Sets a value to attribute origin. 
	 * @param newOrigin 
	 */
	public void setOrigin(Point newOrigin) {
	    this.origin = newOrigin;
	}

	/**
	 * Returns end.
	 * @return end 
	 */
	public Point getEnd() {
		return this.end;
	}
	
	/**
	 * Sets a value to attribute end. 
	 * @param newEnd 
	 */
	public void setEnd(Point newEnd) {
	    this.end = newEnd;
	}

	/**
	 * Returns allAngles.
	 * @return allAngles 
	 */
	public ArrayList<Angle> getAllAngles() {
		return this.allAngles;
	}



}
