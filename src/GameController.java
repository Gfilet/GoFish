import java.util.Arrays;
import java.util.Scanner;

import javax.swing.JOptionPane;
@SuppressWarnings("unused")

public class GameController
{
	private Player Human = new Player();
	private Deck Deck = new Deck();
	private boolean playing;
	private static Frame frame;
	
	public static void main(String []args)
	{
		frame = new Frame();
		frame.startGame();
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		Deck a1 = new Deck();
		
		Player player1 = new Player();
		Player player2 = new Bot();
		a1.shuffle(7*52);
		
		// Creates both players and gives them both 7 cards
		for(int i = 0; i < 7; i++)
		{
			player1.add(a1.remove());
			player2.add(a1.remove());
		}
		System.out.println("Player 1:");
		player1.pair();
		System.out.println("Player 2:");
		player2.pair();
		System.out.println();
		int turn = 0;
		
		boolean playing = true;
		// Gets the score for both players and prints their values
		while((player1.numberOfEntries > 0) && (player2.numberOfEntries > 0)){
			
			System.out.println("player1 Score: " + player1.getScore());
			System.out.println("player2 Score: " + player2.getScore());
			System.out.println();
			
			// Checks whose turn it is
			Player player, opponent;
			if(turn % 2 == 0)
			{
				
				System.out.println("Player1 turn!!");
				player = player1;
				opponent = player2;
			}
			else
			{
				System.out.println("Player2 turn!!");
				player = player2;
				opponent = player1;
			}

			/**
			 * Asks player which card they want to check for
			 * returns a pair or GoFish if opponent doesn't have card
			 * Changes turn if opponent doesn't have card
			 */
			String askedCard = player.ask();
			if(opponent.containsValue(askedCard))
			{
				player.add(opponent.removeByValue(askedCard));
			}
			else
			{
				System.out.println("GoFish!!!");
				player.add(a1.remove());
				turn++;
			}
			
			player.pair();
			
		}
		
		// Checks score to see who the winner is
		if(player1.getScore() > player2.getScore())
			{
			System.out.println();
			System.out.println();
			System.out.println("You win! Your score: " +player1.getScore() + "." + " Player 2 Score: " + player2.getScore() + ".");
			}
		
		else if(player1.getScore() < player2.getScore())
			System.out.println("You lose! Your score: " +player1.getScore() + "." + " Player 2 Score: " + player2.getScore() + ".");
		else if(player1.getScore() == player2.getScore())
			System.out.println("You tied! Your score and Player 2 score: " + player1.getScore());
	    }
}