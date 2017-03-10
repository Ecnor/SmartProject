/*******************************************************************************
 * 2017, All rights reserved.
 *******************************************************************************/


import java.util.ArrayList;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of OENode.
 * 
 * @author alain
 */
public class OENode {
	/**
	 * Description of the property AllangleCountNode.
	 */
	private ArrayList<AngleCountNode> AllangleCountNode = new ArrayList<AngleCountNode>();
	
	/**
	 * Description of the property origin.
	 */
	private Point origin = null;
	
	/**
	 * Description of the property end.
	 */
	private Point end = null;
	
	// Start of user code (user defined attributes for OENode)

	// End of user code
	
	
	/**
	 * Description of the method insert.
	 * @param letter_to_insert 
	 */
	public void insert(Letter letter_to_insert) {
		// Start of user code for method insert
		// End of user code
	}
	 
	/**
	 * Description of the method guess.
	 * @param letter_to_insert 
	 */
	public void guess(Letter letter_to_insert) {
		// Start of user code for method guess
		// End of user code
	}
	 
	// Start of user code (user defined methods for OENode)

	// End of user code
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



}
