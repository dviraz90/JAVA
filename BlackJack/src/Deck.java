import java.util.Random;


public class Deck {

	public int cards[] = {2,3,4,5,6,7,8,9,10,10,10,10,13};
	public String cardType[] = {"heart", "diamond", "club", "spade"};
	
	public int PullRandomCard(int[] cards) {
		Random rand = new Random();
		int card = rand.nextInt(13);
		int randomCard =cards[card];
		return randomCard;
	}
	 public String RandomType(String[] cardType) {
		Random rand = new Random();
		int type = rand.nextInt(4);
		String randomType =cardType[type];
		return randomType;
	}
}
