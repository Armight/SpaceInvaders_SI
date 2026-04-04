package modelPackage;

public class TiroEgoera implements Egoera{

	
	
	@Override
	public String getEgoera() {
		return "Tiro";
		
	}

	@Override
	public void setEgoera(Gelaxka pGelaxka) {
		pGelaxka.egoeraAldatu(new TiroEgoera());		
	}

}
