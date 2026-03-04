package modelPackage;

import viewPackage.Observer;

public interface Observable {
	void addObserver(Observer observer);
	void removeObserver(Observer observer);
}
