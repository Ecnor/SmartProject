package main;

public class AngleMesure {
	private int ampf;
	private int avpf;
	private char composante;
	
	public AngleMesure(int ampf, int avpf, char composante)
	{
		this.ampf=ampf;
		this.avpf=avpf;
		this.composante=composante;
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
	
	

}
