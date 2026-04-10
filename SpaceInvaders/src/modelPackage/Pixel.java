package modelPackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface Pixel {
	
	//*************************ETSAIAN ERABILITAKO METODOAK:**************************
	void sortu();
	
	int getX();
		
	int getY();
	
	int getXBerria();
	
	int getYBerria();
	
	int getId();

	//void setPosizio(int pX, int pY);
	
	void setRandom(int r);
	
	boolean mugituRandom();
	
	//int i jokalariaren posizio berriak kalkulatzeko erabili
	boolean xLimiteakKonprobatu(int i);
	
	boolean yLimiteakKonprobatu(int i);
	
	boolean kolisioakKonprobatu(Pixel p);
	
	boolean etsaiEtsaiKonprobatu(Pixel pEtsai);
	
	boolean etsaiKolisioak(Pixel pEtsai);
	
	int bizitzaKendu();

	boolean mugituX(int i);
	 
	boolean mugituY(int i);
	
	void ezabatu();	
	
	//BAKARRIK TIRO ETA JOKALARIAK INPLEMENTATU
	boolean kolisioak(Pixel p);
	
	//BAKARRIK JOKALARIAK INPLEMENTATU
	void shoot();
	
}

