package main;

import java.util.ArrayList;

/**
 * Classe enregistre le dessin de l'utilisateur dans l'attribut allPoints.
 * En extrait les caractéristiques d'une lettre et les range dans une lettre fictive guessedLetter qui sert à interoger la base. 
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class UserLetterTrace {
	/**
	 * Liste des points trac�s
	 */
	private ArrayList<Point> allPoints = new ArrayList<Point>();
	
	/**
	 * Liste des points d�riv�s
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
	 * Taille de la fen�tre de d�rivation
	 */
	//public static final int DERIVATE_WIDTH = 5;
	public static final int DERIVATE_WIDTH = 10;
	
	/**
	 * Seuil de d�tection de plateau
	 */
	//public static final int ANGLE_THRESHOLD = 50;
	public static final int ANGLE_THRESHOLD = 10;
	
	/**
	 * Seuil de d�tection d'un nouvel angle
	 */
	public static final int ANGLE_GAP = 3;
	
	
	/**
	 * Lors de la détection d'angles, après détection de l'annulation d'une composante, taille
	 * de la fenêtre de détection de changement de signe de l'autre composante
	 */
	//public static final int SIGN_DETECTION_WIDTH = 30;
	public static final int SIGN_DETECTION_WIDTH = 50;
	
	public static final int ANGLE_TYPE_THRESHOLD = 30;
	
	public static final int ANGLE_DETECTION_THRESHOLD = 10;
	
	/**
	 * Derive
	 */
	private void derivate() {
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
			
			derivedAllPoints.add(new Point((aheadX - behindX) / DERIVATE_WIDTH, (aheadY - behindY) / DERIVATE_WIDTH));
		}
		
		System.out.println("Tableau  de point dérivé : \n");
		
		for(int i=0;i<derivedAllPoints.size();i++)
		{
			System.out.print(""+derivedAllPoints.get(i)+"i : "+i+" ;");
			if(i != 0 && i%5 == 0)
				System.out.println();
		}
	}
	 
	/**
	 * R�cup�re les angles de la lettre
	 * 
	 * ça serait bien de commenter le fonctionnement de ce bouzin, la reprise est compliquée...
	 */
	private void guessAngles() {
		ArrayList<Integer> indexListX = new ArrayList<Integer>(); //liste des indices du tableau dérivée où les x s'annulent
		ArrayList<Integer> indexListY = new ArrayList<Integer>(); //idem avec les y
		
		for(int i = 0; i < derivedAllPoints.size(); i++) {
			if(derivedAllPoints.get(i).getX() < ANGLE_THRESHOLD && derivedAllPoints.get(i).getX() > -ANGLE_THRESHOLD)
				indexListX.add(i);
			if(derivedAllPoints.get(i).getY() < ANGLE_THRESHOLD && derivedAllPoints.get(i).getY() > -ANGLE_THRESHOLD) 
				indexListY.add(i);		
		}
		
		System.out.println("Annulations de la dérivée en X :" + indexListX.toString());
		System.out.println("Annulations de la dérivée en Y :" + indexListY.toString());
		
		parseIndexList(indexListX,'x');
		parseIndexList(indexListY,'y');	
	}
	
	private void parseIndexList(ArrayList<Integer> indexList,char composante) {
		if(!indexList.isEmpty())
		{	
			int min = indexList.get(0);
			int max;
			
			for(int j = 0; j < indexList.size() - 1; j++) {
				if((indexList.get(j + 1) - indexList.get(j)) > ANGLE_GAP) { //Nouvel angle, ici construire angle
					max = indexList.get(j);				
					System.out.println("avg min max 1: " + ((max + min) / 2));
					System.out.println("Changement de signe ? -"+sign_detection((max + min) / 2,composante));
					min = indexList.get(j + 1);			
				}
			}
			
			max = indexList.get(indexList.size() - 1);
			
			if(min != 0) {
				System.out.println("avg min max 2: " + ((max + min) / 2));
				System.out.println("Changement de signe ? -"+sign_detection((max + min) / 2,composante));					
			}
			else {			
				System.out.println("avg min max 3: " + (max / 2));
				System.out.println("Changement de signe ? -"+sign_detection((max) / 2,composante));
			}
		}
		else
			System.out.println("bah ya pas d'angles");
	}
	
	private boolean sign_detection(int avg,char composante) {
		if(avg == 0) 
			return false;
		
		int aval=0, amont=0;
		int local_width=Math.min(Math.min(avg, SIGN_DETECTION_WIDTH),(derivedAllPoints.size() - 1)-avg);
		
		for(int i=avg-local_width;i<avg;i++)
		{
			if(composante=='y')
				amont+=derivedAllPoints.get(i).getY();
			else
				amont+=derivedAllPoints.get(i).getX();
		}
		
		for(int i=avg;i<avg+local_width;i++)
		{
			if(composante=='y')
				aval+=derivedAllPoints.get(i).getY();
			else
				aval+=derivedAllPoints.get(i).getX();
		}
		
		aval /= local_width;
		amont /= local_width;
		
		System.out.println("sign_detection "+composante+" : amont : "+ amont + "aval :"+ aval);
		
		if(amont * aval < 0) {
			Angle a = null;
			int sum = Math.abs(amont) + Math.abs(aval);
			if(sum < ANGLE_TYPE_THRESHOLD) {
				if(sum > ANGLE_DETECTION_THRESHOLD) {
					a = new Angle(Angle.TYPES.arrondi);
				}
			}
			else {
				a = new Angle(Angle.TYPES.aigu);
			}
			
			if(a != null)
				guessedLetter.addAngle(a);
			
			return true;
		}
		
		return false;
	}
	 
	/**
	 * guessLetter
	 */
	public void guessLetter() {	
		derivate();
		
		Point origin = allPoints.get(0);
		Point end = allPoints.get(allPoints.size() - 1);
		
		ArrayList<Angle> angles = new ArrayList<Angle>();
		
		guessedLetter = new Letter(' ', origin, end, angles);
		
		guessAngles();
		
		System.out.println("LOL " + guessedLetter.getAllAngles());
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