package modelPackage;

public class TiroEgoera implements Egoera{

	@Override
	public void setEgoera(int pX, int pY) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(pX, pY).egoeraAldatu(new TiroEgoera());
	}
	
	@Override
	public String getEgoera() {
		return "Tiro";
		
	}

}
