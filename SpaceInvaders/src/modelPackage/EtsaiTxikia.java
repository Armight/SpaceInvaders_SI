package modelPackage;

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
    	
        this.ezabatuEtsai4Pixel();
        
        //Posizioa eguneratu
        setPosizio(getX()+i, getY());
        
        sortuEtsai4Pixel(getX(), getY());
    }
    
    @Override
    public void mugituY() {

       this.ezabatuEtsai4Pixel();

        //Posizioa eguneratu
        setPosizio(getX(), getY()+1);

        sortuEtsai4Pixel(getX(), getY());
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
    
  
    
    
}

