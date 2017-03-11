package main;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;


public class PadDraw extends JComponent {
	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;
	
	Image image;
	Graphics2D graphics2D;
	int currentX, currentY, oldX, oldY;
	
	private ArrayList<Point> allPoints = new ArrayList<Point>();

	//Now for the constructors
	public PadDraw(){
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				oldX = e.getX();
				oldY = e.getY();
			}
		});
		//if the mouse is pressed it sets the oldX & oldY
		//coordinates as the mouses x & y coordinates
		addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				currentX = e.getX();
				currentY = e.getY();
				
				allPoints.add(new Point(currentX, currentY));
				
				if(graphics2D != null)
					graphics2D.drawLine(oldX, oldY, currentX, currentY);
				
				repaint();
				oldX = currentX;
				oldY = currentY;
			}

		});
		//while the mouse is dragged it sets currentX & currentY as the mouses x and y
		//then it draws a line at the coordinates
		//it repaints it and sets oldX and oldY as currentX and currentY
		
		addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				System.out.println(allPoints.toString());
				System.out.println(allPoints.size());
				
				UserLetterTrace ult = new UserLetterTrace(allPoints);
				//ult.guessLetter();
				
				MainWindowApplication.addLetterOutput('A');
				
				clear();
			}
		});
	}

	public void paintComponent(Graphics g){
		if(image == null){
			image = createImage(getSize().width, getSize().height);
			graphics2D = (Graphics2D)image.getGraphics();
			graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			clear();
		}
		
		g.drawImage(image, 0, 0, null);
	}
	//this is the painting bit
	//if it has nothing on it then
	//it creates an image the size of the window
	//sets the value of Graphics as the image
	//sets the rendering
	//runs the clear() method
	//then it draws the image


	public void clear(){
		graphics2D.setPaint(Color.white);
		graphics2D.fillRect(0, 0, getSize().width, getSize().height);
		graphics2D.setPaint(Color.black);
		repaint();
		
		allPoints.clear();
	}
	//this is the clear
	//it sets the colors as white
	//then it fills the window with white
	//thin it sets the color back to black
}
