package modelPackage;

import java.util.ArrayList;
import java.util.List;

public class TiroTaldea implements TiroElementua{
	private List<TiroElementua> tiroKol = new ArrayList<TiroElementua>();
	
	public void mugituY(int i) {
		for (TiroElementua tiro : tiroKol) {
			tiro.mugituY(0);
		}
		
	}
	
	public void addTiro(TiroElementua pTiro) {
		tiroKol.add(pTiro);
	}
}
