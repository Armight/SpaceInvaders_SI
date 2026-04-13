package modelPackage;

public class TiroEgoera implements Egoera{
	private String izena;
	
	public TiroEgoera() {
		this.izena="Tiro";
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
