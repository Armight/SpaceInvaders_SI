package modelPackage;

public class PowerUpEgoera implements Egoera{
	private String izena;
	
	public PowerUpEgoera() {
		this.izena = "PowerUp";
	}
	
	@Override
    public String getIzena() {
        return this.izena;
    }

	@Override
	public Egoera getEgoera() {
		
		return this;
	}

}
