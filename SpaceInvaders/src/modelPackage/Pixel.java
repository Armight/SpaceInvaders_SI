package modelPackage;

public interface Pixel {
	
	//*************************ETSAIAN ERABILITAKO METODOAK:**************************
	void sortu();
	
	int getX();
		
	int getY();
	
	int getXBerria();
	
	int getYBerria();
	
	int getId();
	
	void setRandom(int r);
	
	boolean mugitu();
	
	boolean xLimiteakKonprobatu(int i);
	
	boolean yLimiteakKonprobatu(int i);
	
	boolean kolisioakKonprobatu(Pixel p);
	
	boolean etsaiEtsaiKonprobatu(Pixel pEtsai);
	
	boolean etsaiKolisioak(Pixel pEtsai);
	
	int bizitzaKendu();

	boolean mugituX(int i);
	 
	boolean mugituY(int i);
	
	void ezabatu();	
	
	boolean kolisioak(Pixel p);
	
	void shoot();
	
	public void aldatuTiroa();
	
}

