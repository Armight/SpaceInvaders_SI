package modelPackage;

public class HutsikEgoera implements Egoera {
	
    @Override
    public String getIzena() {
        return "Hutsik";
    }

	@Override
	public Egoera getEgoera() {
		
		return this;
	}
}
