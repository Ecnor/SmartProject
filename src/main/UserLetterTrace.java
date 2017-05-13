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
	 * Liste des angles mesurés
	 */
	private ArrayList<AngleMesure> mesuredAngles = new ArrayList<AngleMesure>();
	
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
	public static final int DERIVATE_WIDTH = 2;
	
	/**
	 * Seuil de d�tection de plateau
	 */
	public static final int ANGLE_THRESHOLD = 10;
	
	/**
	 * Seuil de d�tection d'un nouvel angle
	 */
	public static final int ANGLE_GAP = 3;
	
	/**
	 * Seuil de détection d'angle droit
	 */
	public static final int RIGHT_ANGLE_DETECTION_THRESHOLD = 120;
	
	
	/**
	 * Lors de la détection d'angles, après détection de l'annulation d'une composante, taille
	 * de la fenêtre de détection de changement de signe de l'autre composante
	 */
	public static final int SIGN_DETECTION_WIDTH = 10;
	
	public static final int ANGLE_DETECTION_WIDTH = 2;
	
	public static final int ANGLE_TYPE_THRESHOLD = 40;
	
	public static final int ANGLE_DETECTION_THRESHOLD = 5;
	
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
		
		//System.out.println("Tableau  de point dérivé : \n");
		
		for(int i=0;i<derivedAllPoints.size();i++)
		{
			//System.out.print(""+derivedAllPoints.get(i)+"i : "+ i +" ;");
			//if(i != 0 && i%5 == 0)
				//System.out.println();
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
		
		//System.out.println("Annulations de la dérivée en X :" + indexListX.toString());
		//System.out.println("Annulations de la dérivée en Y :" + indexListY.toString());
		
		parseIndexList(indexListX,'x');
		parseIndexList(indexListY,'y');	
	}
	
	private void parseIndexList(ArrayList<Integer> indexList,char composante) {
		if(!indexList.isEmpty())
		{	
			int min = indexList.get(0);
			int max, minComposante;
			
			for(int j = 0; j < indexList.size() - 1; j++) {
				if((indexList.get(j + 1) - indexList.get(j)) > ANGLE_GAP) { //Nouvel angle, ici construire angle
					max = indexList.get(j);	
					
					minComposante = getMinComposante(min, max, composante);		
					sign_detection(minComposante,composante, min, max);
					
					min = indexList.get(j + 1);			
				}
			}
			
			max = indexList.get(indexList.size() - 1);
			
			if(min != 0) {
				minComposante = getMinComposante(min, max, composante);	
				sign_detection(minComposante,composante, min, max);			
			}
			else {		
				minComposante = getMinComposante(min, max, composante);
				sign_detection(minComposante,composante, min, max);
			}
		}
		//else
			//System.out.println("bah ya pas d'angles");
	}
	
	private int getMinComposante(int min, int max, char composante) {
		int minComposante = min;
		
		if(composante == 'x') {
			for(int i = min + 1; i <= max; i++) {
				if(Math.abs(derivedAllPoints.get(minComposante).getX()) > Math.abs(derivedAllPoints.get(i).getX())) {
					minComposante = i;
				}
			}
		}
		else {
			for(int i = min + 1; i <= max; i++) {
				if(Math.abs(derivedAllPoints.get(minComposante).getY()) > Math.abs(derivedAllPoints.get(i).getY())) {
					minComposante = i;
				}
			}
		}
		
		return minComposante;
	}
	
	private void sign_detection(int avg, char composante, int min, int max) {	
		int amont = 0, aval = 0;
		int ampfX = 0, avpfX = 0, ampfY = 0, avpfY = 0; // amont et aval n°2 #petite fenetre
		
		if(avg == 0)
			avg++;
		
		if(avg == derivedAllPoints.size() - 1)
			avg--;
		
		
		int local_width = Math.min(Math.min(avg, SIGN_DETECTION_WIDTH), (derivedAllPoints.size() - 1) - avg);
		int little_width = Math.min(Math.min(avg, ANGLE_DETECTION_WIDTH), (derivedAllPoints.size() - 1) - avg);
		
		boolean barredroite = false;
		for(int i = avg - local_width; i < avg; i++)
		{
			if(composante == 'y') {				
				amont += derivedAllPoints.get(i).getY();		
			}
			else {				
				amont += derivedAllPoints.get(i).getX();	
			}
			
			if(i >= avg - little_width) {
				ampfX += derivedAllPoints.get(i).getX();
				ampfY += derivedAllPoints.get(i).getY();
				////System.out.println("ampf+=" + derivedAllPoints.get(i).getY());
			}
		}
		
		for(int i = avg + 1; i <= avg + local_width; i++)
		{
			if(composante=='y') {				
				aval+=derivedAllPoints.get(i).getY();
			}
			else {			
				aval+=derivedAllPoints.get(i).getX();
			}
			
			if(i <= avg + little_width) {
				avpfX += derivedAllPoints.get(i).getX();
				avpfY += derivedAllPoints.get(i).getY();
				////System.out.println("avpf+=" + derivedAllPoints.get(i).getY());
			}
		}
		
		amont /= local_width;
		aval /= local_width;
		
		ampfX /= little_width;
		avpfX /= little_width;
		ampfY /= little_width;
		avpfY /= little_width;
					
		
		////System.out.println("sign_detection " + composante + " : ampf : " + ampf + " avpf :" + avpf);
		if(amont * aval < 0) {
			if(composante == 'x') {
				int sum = Math.abs(ampfX) + Math.abs(avpfX);
			
				if(sum > ANGLE_DETECTION_THRESHOLD) {
					boolean inv = ampfY < 0;			
					AngleMesure a = new AngleMesure(ampfX, avpfX, avg, composante, inv);
					mesuredAngles.add(a);
				}
				else {
					barredroite = true;
				}
			}
			else {
				int sum = Math.abs(ampfY) + Math.abs(avpfY);
				
				if(sum > ANGLE_DETECTION_THRESHOLD) {
					boolean inv = ampfX < 0;			
					AngleMesure a = new AngleMesure(ampfY, avpfY, avg, composante, inv);
					mesuredAngles.add(a);
				}
			}
		}
		else {
			barredroite = true;
		}
			
		if(barredroite) {
			ampfX = 0;
			ampfY = 0;
			avpfX = 0;
			avpfY = 0;
			
		
			
			if(composante == 'x') {
				if(min > 5 && min < derivedAllPoints.size() - 5) {
					//System.out.println("MIN");
					for(int i = min - 5; i < min; i++)
					{						
						ampfX += derivedAllPoints.get(i).getX();
						ampfY += derivedAllPoints.get(i).getY();
					}
					
					for(int i = min + 1; i <= min + 5; i++)
					{						
						avpfY += derivedAllPoints.get(i).getY();							
					}
					
					
					
					ampfY /= 5;
					
					//System.out.println("ampfX = " + ampfX);
					//System.out.println("ampfY = " + ampfY);
					
					//System.out.println("avpfY = " + avpfY);
					
					if(ampfY < 15) {
						if(ampfX > RIGHT_ANGLE_DETECTION_THRESHOLD) {
							AngleMesure a;
							
							// coin haut droit ou bas droit
							if(avpfY > 0)
								a = new AngleMesure(2, min);
							else
								a = new AngleMesure(3, min);
							
							mesuredAngles.add(a);
						}
					
						else if(ampfX < -RIGHT_ANGLE_DETECTION_THRESHOLD) {
							AngleMesure a;
							
							//Coin haut gauche ou bas gauche
							if(avpfY > 0)
								a = new AngleMesure(1, min);
							else
								a = new AngleMesure(4, min);
							
							mesuredAngles.add(a);
						}
						else {
							//System.out.println("truc chelou min");
						}
					}
				}
				
				if(max > 5 && max < derivedAllPoints.size() - 5) {
					//System.out.println("MAX");
					
					for(int i = max + 1; i <= max + 5; i++)
					{						
						avpfX += derivedAllPoints.get(i).getX();
						avpfY += derivedAllPoints.get(i).getY();							
					}
					
					for(int i = max - 5; i < max; i++)
					{						
						ampfY += derivedAllPoints.get(i).getY();
					}
					
					avpfY /= 5;
					
					//System.out.println("avpfX = " + avpfX);
					//System.out.println("avpfY = " + avpfY);
					
					//System.out.println("ampfY = " + ampfY);
					
					if(avpfY < 15) {
						if(avpfX > RIGHT_ANGLE_DETECTION_THRESHOLD) {
							AngleMesure a;
							
							//Coin haut gauche ou coin bas gauche
							if(ampfY > 0)
								a = new AngleMesure(4, max);
							else
								a = new AngleMesure(1, max);
							
							mesuredAngles.add(a);
						}
						else if(avpfX < -RIGHT_ANGLE_DETECTION_THRESHOLD) {
							AngleMesure a;
							
							if(ampfY > 0)
								a = new AngleMesure(3, max);
							else
								a = new AngleMesure(2, max);
							
							mesuredAngles.add(a);
						}
						else {
							//System.out.println("truc chelou max");
						}
					}
				}
			}
		}
	}
	 
	/**
	 * guessLetter
	 */
	public ArrayList<AngleMesure> guessLetter() {	
		derivate();	
		guessAngles();
		sortMesuredAngles();	
		
		return mesuredAngles;
	}
	
	private void sortMesuredAngles() {
		AngleMesure tmp;
		int min = 0;
		
		for(int n = 0; n < mesuredAngles.size(); n++) {
			min = n;
			
			for(int i = n; i < mesuredAngles.size(); i++) {
				if(mesuredAngles.get(i).getAvg() < mesuredAngles.get(min).getAvg()) {
					min = i; 
				}
			}
			
			tmp = mesuredAngles.get(min);
			mesuredAngles.set(min, mesuredAngles.get(n));
			mesuredAngles.set(n, tmp);
		}
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
}