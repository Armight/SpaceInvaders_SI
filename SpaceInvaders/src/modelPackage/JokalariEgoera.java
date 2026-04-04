package modelPackage;

public class JokalariEgoera implements Egoera{

	
	
	@Override
	public String getEgoera() {
		return "Jokalari";
	}

	@Override
	public void setEgoera(Gelaxka pGelaxka) {
		pGelaxka.egoeraAldatu(new JokalariEgoera());
		
	}
}
