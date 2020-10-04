package interfaces;

public interface IPlay {

	String GetCards(int card1, String type1, int card2, String type2);
	
	int SumOfCards(int card1, int card2);
	
	int Hit();
	
	void Stand(); 
}
