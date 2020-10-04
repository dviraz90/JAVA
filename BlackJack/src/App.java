
public class App {

	
	public static void main(String[] args) {
	
		Player play= new Player();
		Dealer deal = new Dealer();
		
		//CARDS
		int playerCard1 = play.getCard1();
		int playerCard2 = play.getCard2();
		int dealerCard1 = deal.getCard1();
		int dealerCard2 = deal.getCard2();
		
		//prints dealer and player cards
		System.out.println(deal.GetCards(dealerCard1, deal.getType1(), dealerCard2, deal.getType2()));
		System.out.println(play.GetCards(playerCard1, play.getType1(), playerCard2, play.getType2()));
		
		if(playerCard1 == 13)  playerCard1 = Player.ace1;
		if(playerCard2 == 13)  playerCard2 = Player.ace2;
		
		if(dealerCard1 == 13)  dealerCard1 = Dealer.ace1;
		if(dealerCard2 == 13)  dealerCard2 = Dealer.ace2;
		
		// dealer and player sum
		Player.playerSum = play.SumOfCards(playerCard1, playerCard2);
		Dealer.dealerSum = deal.SumOfCards(dealerCard1, dealerCard2);
		
		//game moves
		Dealer.standDealer = false;
		while(true)
		{
			int checkWin = 3;
			boolean press = true;
			System.out.println("Your sum is:" + Player.playerSum);
			System.out.println("Dealers sum is:" + Dealer.dealerSum);
			System.out.println("\n");
			
			//player move
			while(press) 
			{
				//System.out.println("Hit or Stand? H/S");
				int playRes = play.Move();
				//Hit
				if(playRes > 0) 
				{
					System.out.println("your sum is:" + " " + Player.playerSum);
					checkWin = CheckWin(Player.playerSum);
					press = false;
					break;
				}
				//Stand
				if(playRes < 0) 	
				{
					System.out.println("your sum is:" + " " + Player.playerSum);
					checkWin = CheckWin(Player.playerSum);
					press = false;
					break;
				}
				//Nothing
				continue;	
			}

			//DROW
			if(checkWin == 1) 
			{
				if(Dealer.standDealer) 
				{
					if(Dealer.dealerSum > Player.playerSum) checkWin = 0;
					if(Dealer.dealerSum == Player.playerSum) 
					{
						System.out.println("it's a drow!");
						return;
					}
				    if(Dealer.dealerSum < Player.playerSum) checkWin = -1;
				}
				System.out.println("you still in the game!\n");
			}
			// LOST	
			if(checkWin == 0) {
					System.out.println("game over -- you lost!");
					return;
				}
			//WIN
			if(checkWin == -1) {
					System.out.println("game over -- you won!");
					return;
				}
			
			// Dealers move
			System.out.println("Dealers move...");
			int dealersRes = deal.Move();
			int res = 99;
			if(dealersRes != 0) 
			{
				System.out.println("Dealer hits" +" " + Dealer.dealersHit + " " + "dealers sum is:" + " " + Dealer.dealerSum);
				res = CheckWin(Dealer.dealerSum);
				if(res == 0) 
				{
					System.out.println("game over -- you won!");
					return;
				}
				if(res == -1) 
				{
					System.out.println("game over -- you lost!");
					return;
				}
			}
			else 
			{
				System.out.println(" dealers sum is:" + " " + Dealer.dealerSum);
				Dealer.standDealer = true;
			}
		
				
		}
	}
	public static int CheckWin(int sum) 
	{
		if(sum > 21) return 0;
		if(sum < 21) return 1;
		return -1;
	
    }
}
