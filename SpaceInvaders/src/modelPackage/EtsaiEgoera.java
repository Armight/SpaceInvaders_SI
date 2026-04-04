package modelPackage;

public class EtsaiEgoera implements Egoera {

	@Override
	public void setEgoera(Gelaxka pGelaxka) {
		pGelaxka.egoeraAldatu(new EtsaiEgoera());
	}
	
	@Override
	public String getEgoera() {
		return "Etsaia";
	}



}
