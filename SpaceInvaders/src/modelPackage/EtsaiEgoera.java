package modelPackage;

public class EtsaiEgoera implements Egoera {
	private String izena;
	
	public EtsaiEgoera() {
		this.izena="Etsaia";
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
