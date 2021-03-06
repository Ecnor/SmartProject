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

	/**
	 * Seuil de d�tection de plateau
	 */
	public static final int POINT_SPACING = 10;
	
	Image image;
	Graphics2D graphics2D;
	int lol = 0;
	double currentX, currentY, lastInsertX, lastInsertY; 
	int oldX, oldY;
	
	private ArrayList<Point> allPoints = new ArrayList<Point>();

	//Now for the constructors
	public PadDraw(){
		setDoubleBuffered(false);
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent e){
				oldX = e.getX();
				oldY = e.getY();
				
				lastInsertX = e.getX();
				lastInsertY = e.getY();
				lol=0;
			}
		});
		//if the mouse is pressed it sets the oldX & oldY
		//coordinates as the mouses x & y coordinates
		addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) {
				currentX = e.getX();
				currentY = e.getY();
				
				double tmp = ((currentX - lastInsertX) * (currentX - lastInsertX)) + ((currentY - lastInsertY) * (currentY - lastInsertY));
				double distance = Math.sqrt(tmp);
				
				
				if(distance > POINT_SPACING) {				
					allPoints.add(new Point((int)currentX, (int)currentY));
					lastInsertX = currentX;
					lastInsertY = currentY;
					
					if(graphics2D != null)
						//graphics2D.drawLine(oldX, oldY, (int)currentX, (int)currentY);
						graphics2D.drawLine((int)currentX,(int)currentY,(int)currentX,(int)currentY);
					repaint();
				}
				else {
					lol++;
				}
							
				/*
				if(graphics2D != null)
					//graphics2D.drawLine(oldX, oldY, (int)currentX, (int)currentY);
					graphics2D.drawLine((int)currentX,(int)currentY,(int)currentX,(int)currentY);
				repaint();
				*/
				
				oldX = (int)currentX;
				oldY = (int)currentY;
			}
		});
		//while the mouse is dragged it sets currentX & currentY as the mouses x and y
		//then it draws a line at the coordinates
		//it repaints it and sets oldX and oldY as currentX and currentY
		
		addMouseListener(new MouseAdapter(){
			public void mouseReleased(MouseEvent e){
				System.out.println("Tableau de points : \n"+allPoints.toString()+"\n");
				System.out.println(allPoints.size());
				System.out.println("Points ignorés : "+lol);
				
				UserLetterTrace ult = new UserLetterTrace(allPoints);
				ult.guessLetter();
				
				MainWindowApplication.addLetterOutput('A');
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
