package modelPackage;

public class FinalBossEgoera implements Egoera{
	private String izena;
	
	public FinalBossEgoera() {
		this.izena = "FinalBoss";
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
