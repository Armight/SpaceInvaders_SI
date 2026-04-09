package modelPackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface Pixel {
	
	//*************************ETSAIAN ERABILITAKO METODOAK:**************************
	void sortu();
	
	int getX();
	
	int getXBerria();
	
	int getY();
	
	int getYBerria();
	
	int getId();

	void setPosizio(int pX, int pY);
	
	HashSet<String> setRandom(int r);
	
	void mugituRandom();
	
	boolean xLimiteakKonprobatu();
	
	boolean yLimiteakKonprobatu();
	
	boolean kolisioakKonprobatu(int pX, int pY);
	
	int bizitzaKendu();

	void mugituX(int i);
	 
	void mugituY(int i);
	
	void ezabatu();	
	
	//BAKARRIK TIRO-K ERABILI
	boolean etsaiKolisioak(Pixel pEtsai);
}

