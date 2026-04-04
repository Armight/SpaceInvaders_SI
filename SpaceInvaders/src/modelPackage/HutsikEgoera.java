package modelPackage;

public class HutsikEgoera implements Egoera {

	@Override
	public void setEgoera(int pX, int pY) {
		EspazioModel espazioa = EspazioModel.getGelaxkaMatrizea();
		espazioa.getGelaxka(pX, pY).egoeraAldatu(new HutsikEgoera());
	}
	
	@Override
	public String getEgoera() {
		return "Hutsik";
	}




}
