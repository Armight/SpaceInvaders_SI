package modelPackage;
//proba push
public class EtsaiTxikia extends Etsai {
    private static int pixelKop = 4;//etsai txikia 4 pixeleko etsaia da
    
    //eraikitzailea ondo ipini
    public EtsaiTxikia(int pX, int pY) {
        super(pX, pY, true, pixelKop,1);//etsai txikiaren bizitza=1
        
    }
    
    //Itsasontzian joan beharko zen && polimorfismoa egin???
    
    
    
    
    @Override
    public void mugituX(int i) {
    	
    	EspazioModel espazio = EspazioModel.getGelaxkaMatrizea();
    	
    	//Limite horizontalak zehaztu
    	int zabalera = espazio.getZabalera();
		if (i == 1 && getX() + 1 >= zabalera - 1) return;
		if (i == -1 && getX() - 1 <= 0) return;    	
    	
        this.ezabatuEtsai();
        
        //Posizioa eguneratu
        setPosizio(getX()+i, getY());
        
        sortuEtsai(getX(), getY());
    }
    
    
    @Override
    public void mugituY() {

       this.ezabatuEtsaia();

        //Posizioa eguneratu
        setPosizio(getX(), getY()+1);


        sortuEtsai(getX(), getY());
    }   
    
    @Override
    public boolean kolisioakKonprobatu(int pX, int pY) {
    	//EtsaiTxikiak okupatzen dituen pixel guztiak deklaratu
    	int [][] pixelPos = {{0,0}, {-1,0}, {+1,0}, {0,+1}};
    	boolean baiDa = false;
    	//Pixel horren eta Tiroaren posizioa berdina den ala ez konprobatu
    	for (int i = 0; i < pixelPos.length; i++) {
        	int x = getX() + pixelPos[i][0];
        	int y = getY() + pixelPos[i][1];
        		
        	if (x==pX && y==pY) {
        		baiDa = true;
        	}
 	}
    	return baiDa;
}
    public void sortuEtsai(int pX, int pY) {
    	EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
    	
    	espazioa.getGelaxka(pX, pY).setEgoera("Etsai"); //erdiko pixela
		espazioa.getGelaxka(pX-1, pY).setEgoera("Etsai");//ezkerreko pixela
		espazioa.getGelaxka(pX+1, pY).setEgoera("Etsai");//eskumako pixela
		espazioa.getGelaxka(pX, pY+1).setEgoera("Etsai");//beheko pixela
    }
    public void ezabatuEtsaia() {
        EspazioModel espazio = EspazioModel.getGelaxkaMatrizea();

		espazio.getGelaxka(getX(), getY()).setEgoera("Hutsik");
        espazio.getGelaxka(getX()-1, getY()).setEgoera("Hutsik");
        espazio.getGelaxka(getX()+1, getY()).setEgoera("Hutsik");
        espazio.getGelaxka(getX(), getY()+1).setEgoera("Hutsik");
}
  
    
    
}

