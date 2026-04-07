package modelPackage;

import java.util.Set;

public interface Pixel {
	
	//*************************METODO OROKORRAK:**************************
	void sortu();
	
	int getX();
	
	int getY();
		
	void setPosizio(int pX, int pY);
	
	void mugituX(int i);
	 
	void mugituY(int i);
	
	void ezabatu();
	
	boolean kolisioakKonprobatu(int pX, int pY);
	
	//*************************ETSAI METODOAK:**************************
	default void mugituRandom() {}
			
	default public boolean bizitzaKendu() {
		return false;
	}
	
	default boolean etsaiKolisioak(Set<String> etsaiPos, int pId) {return false;}
}

