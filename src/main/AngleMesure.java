package main;

public class AngleMesure {
	private int ampf;
	private int avpf;
	private char composante;
	private boolean inverse;//si faux on est dans le sens de lecture à la française, gauche, droite, haut bas, si true c'est l'inverse
	private boolean droit;
	
	public AngleMesure(int ampf, int avpf, char composante, boolean inverse)
	{
		this.ampf=ampf;
		this.avpf=avpf;
		this.composante=composante;
		this.inverse=inverse;
	}
	
	public int getAmpf(){
		return this.ampf;
	}
	
	public int getAvpf(){
		return this.avpf;
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
	

}
