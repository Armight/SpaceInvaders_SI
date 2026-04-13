package modelPackage;

public class JokalariEgoera implements Egoera{
	private String izena;
	private String kolorea;
	
	public JokalariEgoera(String pKolorea) {
		this.izena="Jokalari";
		this.kolorea=pKolorea;
	}
	@Override
    public String getIzena() {
        return this.izena +"_"+ kolorea;
    }
	
	@Override
    public void setEgoera(Gelaxka g) {
        g.setEgoera(this);
    }

    

	@Override
	public Egoera getEgoera() {
		
		return this;
	}
}
