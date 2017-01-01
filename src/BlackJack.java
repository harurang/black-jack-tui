/**
Description: Black Jack Game
Completed: 01/27/2015
**/

import java.util.Scanner;

/**
class BlackJack continues to display instructions with method instructions(),deal with method deal(),hit or 
stand with method play() and display game results with method determineWinner()
while user chooses not to exit
**/
public class BlackJack
{
	private static Scanner input = new Scanner(System.in);

	/**
	@inv deck.length = 52
	**/
	private DeckOfCards deck;
	
	private Player player1;
	
	private Player dealer;

	/**
	@ensures the instantiation of the instance variables and determines termination or continuation of game 
	**/
	public static void main(String[]args)
	{
		//will retain the return value of instructions()
		int choice = 0;
		//retains return value of strategyChoice()
		int decision;

		//continue playing Black Jack while user chooses not to exit
		do
		{	
			System.out.printf("\n\n\tWelcome to Black Jack!\n");

			decision = strategyChoice();

			DeckOfCards deck = new DeckOfCards();

			Player player1 = new Player(decision);

			Player dealer = new Player();

			//shuffle deck
			deck.shuffle();

			//give each player two cards
			deal(player1, deck);
			deal(dealer, deck);

			//have each player hit x numbers of times according to their strategy
			play(player1, deck);
			play(dealer, deck);

			//collect the total value of each hand[]
			int playerTotal = player1.totalPoints();
			int dealerTotal = dealer.totalPoints();
			
			//based on total determine winner
			String status = determineWinner(playerTotal, dealerTotal);

			
			//display the hand[] and total of hand[] of each player
			System.out.print("\nPlayer hand:\n");
			player1.getHand();
			System.out.printf("\nPlayer total:%d\n", playerTotal);
			System.out.print("\nDealer hand:\n");
			dealer.getHand();
			System.out.printf("\nDealer total:%d\n", dealerTotal);

			//display game status
			System.out.print(status);

			//ask user if they would like to play again
			choice = instructions();

		}while(choice != 2); 

		System.out.print("\nThank you for playing!\n");

	}

	//@ensures the return value of a 1 or 0 which represents game continuation or termination
	public static int instructions()
	{
		int choice = 1;
		//continue to prompt the user for a 1 or 0 while response is invalid
		do
		{
			System.out.print("\n1 - Play\n2 - Exit\n\n");
			choice = input.nextInt();
		}while((choice != 1)&&(choice != 2));

		return choice;
	}

	//@ensures the return value of 1 or 2 which represents stategy choice for Player
	public static int strategyChoice()
	{
		int choice = 0;

		//prompt the user for a 1 or 2 while response is not valid
		do
		{
			System.out.print("\n\nPlease select a strategy for your player:\n");
			System.out.printf("1- Timid\n2- Aggressive\n\n");
			choice = input.nextInt();
		}while((choice != 1) && (choice != 2)); 

		return choice;
	}

	/**
	@requires a Player and DeckOfCards object as parameters
	@ensures Player object has two Card's added to hand[]
	**/
	public static void deal(Player player, DeckOfCards deck)
	{
		//assign return value of draw() to x
		Card x = deck.draw();
		//pass in Card object as an argument to giveCard() in order to add Card to hand[]
		player.giveCard(x); 
		Card y = deck.draw();
		player.giveCard(y);
	}

	/**
	@requires Player and DeckOfCards object as parameters
	@ensures to add Card to hand[] based on strategy
	**/
	public static void play(Player player, DeckOfCards deck)
	{
		//assign choice return value of takeTurn()
		int choice = player.takeTurn();
	
		//if and while the choice is 1
		while(choice == 1)
		{
			//assign a Card from deck to j
			Card j = deck.draw();
			//add Card to hand[]
			player.giveCard(j);
			//determine if player needs to hit again based on strategy
			choice = player.takeTurn();
		}
	}

	/**
	@requires total value of hand[] for each player as parameters
	@ensures the outcome of the game is returned as a String
	**/
	public static String determineWinner(int playerTotal, int dealerTotal)
	{
		//instantiate variables that represent (3) types of possible statuses to return
		String playerStatus = "";
		String dealerStatus = "";
		String combinedStatus = "";

		//if playerTotal is greater then 21, playerStatus = bust
		if(playerTotal > 21)
			playerStatus = "\nPlayer one bust.\n";
		//if dealerTotal is greater than 21, dealerStatus = bust
		if(dealerTotal > 21)
			dealerStatus = "\nDealer bust.\n";
		//if playerTotal is less than 21 and greater than dealerTotal 
		else if((playerTotal <=21)&&(playerTotal > dealerTotal))
			//assign player status
			playerStatus = "\nPlayer one won.\n";
		//if dealerTotal is less than 21 and greater than playerTotal
		else if((dealerTotal <=21)&&(dealerTotal > playerTotal))
			//assign dealer status
			dealerStatus = "\nDealer won.\n";
		//if dealerTotal and playerTotal equate
		else if(dealerTotal == playerTotal)
			//assign combinedStatus
			combinedStatus = "\nPlayers tied.\n";

		//return concatenation of (3) possible statuses
		//this way if player and dealers busts, both can be returned
		return playerStatus + dealerStatus + combinedStatus;
	}
}



