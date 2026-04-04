package modelPackage;

public class JokalariEgoera implements Egoera{

	@Override
	public void setEgoera(int pX, int pY) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(pX, pY).egoeraAldatu(new JokalariEgoera());
	}
	
	@Override
	public String getEgoera() {
		return "Jokalari";
	}
}
