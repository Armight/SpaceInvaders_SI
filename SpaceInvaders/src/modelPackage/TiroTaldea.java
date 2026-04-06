package modelPackage;

import java.util.ArrayList;
import java.util.List;

public class TiroTaldea implements TiroElementua{
	private List<TiroElementua> tiroKol = new ArrayList<TiroElementua>();
	
	public void mugituY() {
		for (TiroElementua tiro : tiroKol) {
			tiro.mugituY();
		}
		
	}
	
	public void addTiro(TiroElementua pTiro) {
		tiroKol.add(pTiro);
	}
}
