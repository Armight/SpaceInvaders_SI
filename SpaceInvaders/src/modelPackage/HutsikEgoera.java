package modelPackage;

public class HutsikEgoera implements Egoera {
	
	public HutsikEgoera() {};
    @Override
    public void setEgoera(Gelaxka g) {
        g.setEgoera(this);
    }

    @Override
    public String getIzena() {
        return "Hutsik";
    }

	@Override
	public Egoera getEgoera() {
		
		return this;
	}
}
