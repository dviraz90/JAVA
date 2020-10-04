import java.util.Scanner;

import interfaces.IPlay;

public class Player implements IPlay
{
	Deck randomCard = new Deck();
	
	private int card1 = randomCard.PullRandomCard(randomCard.cards);
	private int card2 = randomCard.PullRandomCard(randomCard.cards) ;
	private String type1 = randomCard.RandomType(randomCard.cardType);
	private String type2 = randomCard.RandomType(randomCard.cardType);
	
	public static int ace1 = 0;
	public static int ace2 = 0;
	public static int playerSum = 0;
	
	public int Hit()
	{
		int hitCard = randomCard.PullRandomCard(randomCard.cards);
		if(hitCard == 13) 
		    hitCard = GetAce(hitCard);
		return hitCard;
		}
	
	

	public void Stand() 
	{
		System.out.println("You Stand");
	}
	
	public int SumOfCards(int card1, int card2)
	{
		int sum = card1 + card2;
		return sum;
	}
	
	public String getType1(){
		return type1;
	}


	public String getType2() {
		return type2;
	}


	public int getCard2() {
			return card2;
	}


	public int getCard1() {
		return card1;
	}
	public int GetAce(int card)
	{
		if(card == 13) 
		{
			System.out.println("for A = 1 press 1, for A = 11 press 11");
			Scanner input = new Scanner(System.in);
			String choice = input.next(); 
			if(choice.equals("11"))
				card = 11;
			else card = 1;
			return card;
		}
		return 0;
	}
	
	public int Move() 
	{
		System.out.println("Hit or Stand? H/S");
		Scanner input = new Scanner(System.in);
		String choice = input.next();
		
		if(choice.equals("H"))
		{
			playerSum += Hit();
			return 1;
		}
		if(choice.equals("S"))
		{
			Stand();
			return -1;
		}
		return 0;
	}
	
	public String GetCards(int card1, String type1, int card2, String type2)
	{
		if(card1 == 13 && card2 == 13) 
		{
			System.out.println("You have:" + " " + "Ace" + " " +  type1 +" " + "and" + " " + "Ace" +" " + type2);
			ace1 = GetAce(card1);
			ace2 = GetAce(card2);
			return "You have:" + " " + ace1 + " " +  type1 +" " + "and" + " " + ace2 +" " + type2;
		}
		if(card1 == 13)
		{
			System.out.println("You have:" + " " + "Ace" + " " +  type1 +" " + "and" + " " + card2 +" " + type2);
			ace1 = GetAce(card1);
			return "You have:" + " " + ace1 + " " +  type1 +" " + "and" + " " + card2 +" " + type2;
		}
		if(card2 == 13)
		{
			System.out.println("You have:" + " " + card1 + " " +  type1 +" " + "and" + " " + "Ace" +" " + type2);
			ace2 = GetAce(card2);
			return "You have:" + " " + card1 + " " +  type1 +" " + "and" + " " + ace2 +" " + type2;
		}
		return "You have:" + " " + card1 + " " +  type1 +" " + "and" + " " + card2 +" " + type2;
	}
	
	
}



	