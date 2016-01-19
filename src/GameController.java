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
		player1.pair();
		player2.pair();
		int turn = 0;
		
		boolean playing = true;
		// Gets the score for both players and prints their values
		while((player1.numberOfEntries > 0) && (player2.numberOfEntries > 0)){
			 
			frame.updatePScore(player1.getScore());
			frame.updateBScore(player2.getScore());
			System.out.println("player1 Score: " + player1.getScore());
			System.out.println("player2 Score: " + player2.getScore());
			System.out.println();
			
			// Checks whose turn it is
			Player player, opponent;
			if(turn % 2 == 0)
			{
				frame.notifyBoard("Player1 turn!!");
				System.out.println("Player1 turn!!");
				player = player1;
				opponent = player2;
			}
			else
			{
				frame.notifyBoard("Player2 turn!!");
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
				frame.notifyBoard("GoFish!!!");
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
			frame.notifyBoard("You win! Your score: " +player1.getScore() + "." + " Player 2 Score: " + player2.getScore() + ".");
			}
		 
		else if(player1.getScore() < player2.getScore())
			frame.notifyBoard("You lose! Your score: " +player1.getScore() + "." + " Player 2 Score: " + player2.getScore() + ".");
		else if(player1.getScore() == player2.getScore())
			frame.notifyBoard("You tied! Your score and Player 2 score: " + player1.getScore());
	    }
	public static void notifyUI(String string) {
		frame.notifyBoard(string);
	}
	public static String request() {
		return frame.checkFish();
	}
	public static void clear() {
		frame.clear();		
	}
}