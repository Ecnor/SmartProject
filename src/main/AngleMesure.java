package main;

public class AngleMesure {
	private int ampf;
	private int avpf;
	private int avg;
	private char composante;
	private boolean inverse;//si faux on est dans le sens de lecture à la française, gauche, droite, haut bas, si true c'est l'inverse
	
	private boolean droit;
	private int dtype;
	
	public AngleMesure(int ampf, int avpf, char composante, boolean inverse)
	{
		this.ampf=ampf;
		this.avpf=avpf;
		this.composante=composante;
		this.inverse=inverse;
	}
	
	public AngleMesure(int ampf, int avpf, int avg, char composante, boolean inverse)
	{
		this.ampf = ampf;
		this.avpf = avpf;
		this.avg = avg;
		this.composante = composante;
		this.inverse = inverse;
	}
	
	public AngleMesure(int dt, int avg)
	{
		this.avg = avg;
		this.droit = true;
		this.dtype = dt;
	}
	
	public int getAmpf(){
		return this.ampf;
	}
	
	public int getAvpf(){
		return this.avpf;
	}
	
	public int getAvg(){
		return this.avg;
	}
	
	public int getDtype(){
		return this.dtype;
	}
	
	public char getComposante(){
		return this.composante;
	}
	
	public boolean getInverse()
	{
		return this.inverse;
	}
	
	public boolean getDroit()
	{
		return this.droit;
	}
	
	public String toString()
	{
		return "Angle mesuree : Avg"+this.avg+" ampf : "+this.ampf+"avpf : "+this.avpf+"composante : "+this.composante+"inverse : "+this.inverse;
	}
}
