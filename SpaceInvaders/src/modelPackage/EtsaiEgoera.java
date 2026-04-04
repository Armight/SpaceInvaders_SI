package modelPackage;

public class EtsaiEgoera implements Egoera {

	@Override
	public void setEgoera(int pX, int pY) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(pX, pY).egoeraAldatu(new EtsaiEgoera());
	}
	
	@Override
	public String getEgoera() {
		return "Etsaia";
	}



}
