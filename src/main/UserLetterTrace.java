package main;

import java.util.ArrayList;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
	public static final int DERIVATE_WIDTH = 5;
	
	/**
	 * Seuil de d�tection de plateau
	 */
	public static final int ANGLE_THRESHOLD = 50;
	
	/**
	 * Seuil de d�tection d'un nouvel angle
	 */
	public static final int ANGLE_GAP = 3;
	
	/**  TODO Mettre en privée une fois que ça fonctionne, perfectionnable mais permet déjà de voir la suite
	 * D�rive
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
			System.out.println("Tableau  de point dérivé : \n");
			for(int i=0;i<derivedAllPoints.size();i++)
			{
				System.out.print(""+derivedAllPoints.get(i)+"i : "+i+" ;");
				if(i!=0&&i%5==0)
					System.out.println();
			}
	}
	 
	/**
	 * R�cup�re les angles de la lettre
	 * 
	 * ça serait bien de commenter le fonctionnement de ce bouzin, la reprise est compliquée...
	 */
	public void guessAngles() {
		ArrayList<Integer> indexListX = new ArrayList<Integer>();//liste des indices du tableau dérivée où les x s'annulent
		ArrayList<Integer> indexListY = new ArrayList<Integer>();//idem avec les y
		for(int i = 0; i < derivedAllPoints.size(); i++) {
			if(derivedAllPoints.get(i).getX() < ANGLE_THRESHOLD && derivedAllPoints.get(i).getX() > -ANGLE_THRESHOLD)
				indexListX.add(i);
			if(derivedAllPoints.get(i).getY() < ANGLE_THRESHOLD && derivedAllPoints.get(i).getY() > -ANGLE_THRESHOLD) 
				indexListY.add(i);
			
		}
		
		System.out.println("Annulations de la dérivée en X :"+indexListX.toString());
		System.out.println("Annulations de la dérivée en Y :"+indexListY.toString());
		
		parseIndexList(indexListX,'x');
		parseIndexList(indexListY,'y');
		
				
		
	}
	
	private void parseIndexList(ArrayList<Integer> indexList,char composante)
	{
		if(!indexList.isEmpty())
		{	
			int min = indexList.get(0);
			int max;
			boolean sign_changed=false;
			for(int j = 0; j < indexList.size() - 1; j++) {
				//Ici detection chgt signe de l'autre composante.
				if(composante=='x')
				{
					if(derivedAllPoints.get(indexList.get(j)).getY() * derivedAllPoints.get(indexList.get(j+1)).getY()<0)
					{
						sign_changed=true;
						System.out.println("Detection V1 : Y sign changed!min :"+min+" j :"+j);
					}
				}
				else
				{
					if(derivedAllPoints.get(indexList.get(j)).getX() * derivedAllPoints.get(indexList.get(j+1)).getX()<0)
					{
						sign_changed=true;
						System.out.println("Detection V1 : X sign changed!min :"+min+" j :"+j);
					}
				}
				if((indexList.get(j + 1) - indexList.get(j)) > ANGLE_GAP) {//Nouvel angle, ici construire angle
					max = indexList.get(j);				
					System.out.println("moyenne min max: " + ((max + min) / 2) + "\n");
					min = indexList.get(j + 1);
					
					
					
					//Autre possibilité de detection de signe
					if(composante=='x')
					{
						if(derivedAllPoints.get(min).getY() * derivedAllPoints.get(max).getY()<0)
						{
							sign_changed=true;
							System.out.println("Detection V2 : Y sign changed!min :"+min+" j :"+j);
						}
					}
					else
					{
						if(derivedAllPoints.get(min).getX() * derivedAllPoints.get(max).getX()<0)
						{
							sign_changed=true;
							System.out.println("Detection V2 : X sign changed!min :"+min+" j :"+j);
						}
					}
					
					
					
					
					sign_changed=false;
				}
			}
			
			max = indexList.get(indexList.size() - 1);
			
			if(min != 0) {
				System.out.println("min : " +min+" max : " + max + "min max2 " + ((max + min) / 2) + "\n");
				//Autre possibilité de detection de signe
				if(composante=='x')
				{
					if(derivedAllPoints.get(min).getY() * derivedAllPoints.get(max).getY()<0)
					{
						sign_changed=true;
						System.out.println("Detection V2 : Y sign changed!min :"+min+" j :"+((max + min) / 2));
					}
				}
				else
				{
					if(derivedAllPoints.get(min).getX() * derivedAllPoints.get(max).getX()<0)
					{
						sign_changed=true;
						System.out.println("Detection V2 : X sign changed!min :"+min+" j :"+((max + min) / 2));
					}
				}
				
				
				
			}
			else {			
				System.out.println("min max 2: " + (max / 2) + "\n");
				//Autre possibilité de detection de signe
				if(composante=='x')
				{
					if(derivedAllPoints.get(min).getY() * derivedAllPoints.get(max).getY()<0)
					{
						sign_changed=true;
						System.out.println("Detection V2 : Y sign changed!min :"+min+" j :"+(max / 2));
					}
				}
				else
				{
					if(derivedAllPoints.get(min).getX() * derivedAllPoints.get(max).getX()<0)
					{
						sign_changed=true;
						System.out.println("Detection V2 : X sign changed!min :"+min+" j :"+(max / 2));
					}
				}
			}
		}
		else
			System.out.println("bah ya pas d'angles");
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