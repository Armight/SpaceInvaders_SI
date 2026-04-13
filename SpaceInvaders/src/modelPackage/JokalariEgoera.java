package modelPackage;

public class JokalariEgoera implements Egoera{
	private String izena;
	
	public JokalariEgoera() {
		this.izena="Jokalari";
	}
	@Override
    public String getIzena() {
        return this.izena;
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
