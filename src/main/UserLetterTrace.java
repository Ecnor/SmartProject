package main;

import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * Classe dï¿½crivant la trace de l'utilisateur
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class UserLetterTrace {
	/**
	 * Liste des points tracï¿½s
	 */
	private ArrayList<Point> allPoints = new ArrayList<Point>();
	
	/**
	 * Liste des points dï¿½rivï¿½s
	 */
	private ArrayList<Point> derivedAllPoints = new ArrayList<Point>();
	
	/**
	 * Lettre a reconnaitre
	 */
	private Letter guessedLetter = null;
	
	/**
	 * Constructeur de la classe UserLetterTrace
	 * @param pts Points
	 */
	public UserLetterTrace(ArrayList<Point> pts) {
		this.allPoints = pts;
	}
	
	/**
	 * Taille de la fenêtre de dérivation
	 */
	public static final int DERIVATE_WIDTH = 5;
	
	/**
	 * Seuil de détection de plateau
	 */
	public static final int ANGLE_THRESHOLD = 5;
	
	/**
	 * Seuil de détection d'un nouvel angle
	 */
	public static final int ANGLE_GAP = 3;
	
	/**  TODO Mettre en privÃ©e une fois que Ã§a fonctionne, perfectionnable mais permet dÃ©jÃ  de voir la suite
	 * Dï¿½rive
	 */
	public void derivate() 
	{
		int aheadX, aheadY;
		int behindX, behindY;
		
			for(int i = DERIVATE_WIDTH; i < allPoints.size() - DERIVATE_WIDTH; i++)
			{
				aheadX = 0; aheadY = 0; behindX = 0; behindY = 0;
				for(int j = 1; j <= DERIVATE_WIDTH; j++)
				{				
					aheadX += allPoints.get(i + j).getX();
					aheadY += allPoints.get(i + j).getY();
					behindX += allPoints.get(i - j).getX();
					behindY += allPoints.get(i - j).getY();			
				}
				derivedAllPoints.add(new Point(aheadX - behindX, aheadY - behindY));
			}
			System.out.println("Tableau  de point dÃ©rivÃ© : \n" + derivedAllPoints.toString() + "\n");
	}
	 
	/**
	 * Rï¿½cupï¿½re les angles de la lettre
	 */
	public void guessAngles() {
		ArrayList<Integer> indexList = new ArrayList<Integer>();
		for(int i = 0; i < derivedAllPoints.size(); i++) {
			if((derivedAllPoints.get(i).getX() < ANGLE_THRESHOLD && derivedAllPoints.get(i).getX() > -ANGLE_THRESHOLD) 
					|| (derivedAllPoints.get(i).getY() < ANGLE_THRESHOLD && derivedAllPoints.get(i).getY() > -ANGLE_THRESHOLD)) {
				indexList.add(i);
			}
		}
		
		System.out.println(indexList.toString());
		
		int min = indexList.get(0);
		int max;
		for(int j = 0; j < indexList.size() - 1; j++) {
			if((indexList.get(j + 1) - indexList.get(j)) > ANGLE_GAP) {
				max = indexList.get(j);				
				System.out.println("min max: " + ((max + min) / 2) + "\n");
				min = indexList.get(j + 1);
			}
		}
		
		max = indexList.get(indexList.size() - 1);
		
		if(min != 0) {
			System.out.println("min max: " + ((max + min) / 2) + "\n");
		}
		else {			
			System.out.println("min max: " + (max / 2) + "\n");
		}
	}
	 
	/**
	 * guessLetter
	 */
	public void guessLetter() {
		// TODO: guessLetter
		throw new NotImplementedException();
	}

	/**
	 * Returns allPoints.
	 * @return allPoints 
	 */
	public ArrayList<Point> getAllPoints() {
		return this.allPoints;
	}

	/**
	 * Returns derivedAllPoints.
	 * @return derivedAllPoints 
	 */
	public ArrayList<Point> getDerivedAllPoints() {
		return this.derivedAllPoints;
	}

	/**
	 * Returns guessedLetter.
	 * @return guessedLetter 
	 */
	public Letter getGuessedLetter() {
		return this.guessedLetter;
	}
}