package modelPackage;

public class HutsikEgoera implements Egoera {
	
	@Override
	public String getEgoera() {
		return "Hutsik";
	}

	@Override
	public void setEgoera(Gelaxka pGelaxka) {
		pGelaxka.egoeraAldatu(new HutsikEgoera());		
	}




}
