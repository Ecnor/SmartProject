package main;

/**
 * Chaque instance de la classe Angle mod�lise un Angle d'une lettre.  
 * 
 * @author Alain KABBOUH, Emine BERNARDONE
 */
public class Angle {
	public static final double SUMAX = 55;
	
	/**
	 * Valeurs accept�es du champs type. 
	 *     -sec : changement brutal de d�riv�e
	 *     -arrondi : changement de d�riv�e gentil.
	 */
	public static enum TYPES{aigu,arrondi,droit};
	
	
	/**
	 * Type peut valoir "arrondi"/"sec"
	 */
	private TYPES type;

	/**
	 * Pour un V c'est haut, pour un A c'est bas. Pour un Z c'est d'abord gauche puis droite.
	 */
	public static enum DIRECTIONS{haut,bas,droite,gauche};
	
	/**
	 * blabla
	 */
	private DIRECTIONS direction;
	
	/**
	 * Constructeur de la classe Angle
	 * @param t type de l'angle
	 */
	public Angle(TYPES t) {
		this.type = t;
	}
	
	/**
	 * Constructeur 2 de la classe Angle
	 * @param t type de l'angle,
	 * @param d direction de l'angle
	 */
	public Angle(TYPES t,DIRECTIONS d) {
		this.type = t;
		this.direction =d;
	}
	
	/**
	 * Returns type.
	 * @return type 
	 */
	public TYPES getType() {
		return this.type;
	}

	/**
	 * Returns direction.
	 * @return direction Direction de la t�te de l'angle prise par la bissectrice. 
	 Comprise entre 0 et 359. 0 La tête est en haut, 90 �droite, 180 en bas 270 � gauche.
	 */
	public DIRECTIONS getDirection() {
		return this.direction;
	}

	public boolean equals(Object angle)
	{
		boolean ret=(this.direction==((Angle)angle).direction) && (this.type==((Angle)angle).type);
		//System.out.println("coucou" + ret);
		return ret;
	}
	
	
	
	public double evalueAngle(AngleMesure alpha)
	{
		double score = 0;
		//Check direction si pas bonnne, on met 0
		
		DIRECTIONS local_inverse=this.direction;
		if(alpha.getInverse())
		{
			switch (this.direction){
			case haut : local_inverse = DIRECTIONS.bas ; break;
			case bas : local_inverse = DIRECTIONS.haut ; break;
			case gauche : local_inverse = DIRECTIONS.droite ; break;
			case droite : local_inverse = DIRECTIONS.gauche ; break;
			
			}
		}
		if(local_inverse==DIRECTIONS.bas)
		{
			if(!(alpha.getComposante() == 'y' && (alpha.getAmpf() < 0 && alpha.getAvpf() > 0))) {
				return score;
			}
		} 
		else if(local_inverse==DIRECTIONS.haut)
		{
			if(!(alpha.getComposante() == 'y' && (alpha.getAmpf() > 0 && alpha.getAvpf() < 0))) {
				return score;
			}
		} 
		else if(local_inverse==DIRECTIONS.droite)
		{
			if(!(alpha.getComposante() == 'x' && (alpha.getAmpf() < 0 && alpha.getAvpf() > 0))) {
				return score;
			}
		} 
		else if(local_inverse==DIRECTIONS.gauche)
		{
			if(!(alpha.getComposante() == 'x' && (alpha.getAmpf() > 0 && alpha.getAvpf() < 0))) {
				return score;
			}
		} 
		

		
		double sum = (double) (Math.abs(alpha.getAmpf()) + Math.abs(alpha.getAvpf()));
		if(this.type==TYPES.aigu)
		{
			score=sum/SUMAX;
		}
		else if(this.type==TYPES.arrondi)
		{
			score=(SUMAX-sum)/SUMAX;
		}
		else if(this.type==TYPES.droit)
		{
			if(alpha.getDroit())
				score=1;
						
		}
		score*=100;
		return score;
	}
	
	public String toString() {
		return type.toString();
	}
}