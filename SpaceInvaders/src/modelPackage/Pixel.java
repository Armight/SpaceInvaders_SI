package modelPackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public interface Pixel {
	
	//*************************ETSAIAN ERABILITAKO METODOAK:**************************
	void sortu();
	
	int getX();
		
	int getY();
	
	int getId();

	//void setPosizio(int pX, int pY);
	
	HashSet<String> setRandom(int r);
	
	void mugituRandom();
	
	//i jokalariaren posizio berriak kalkulatzeko erabili
	boolean xLimiteakKonprobatu(int i);
	
	boolean yLimiteakKonprobatu(int i);
	
	boolean kolisioakKonprobatu(int pX, int pY);
	
	int bizitzaKendu();

	void mugituX(int i);
	 
	void mugituY(int i);
	
	void ezabatu();	
	
	//BAKARRIK TIRO-K INPLEMENTATU
	boolean etsaiKolisioak(Pixel pEtsai);
	
	//BAKARRIK JOKALARIAK INPLEMENTATU
	void shoot();
	
}

