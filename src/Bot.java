import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

@SuppressWarnings("unused")
class Bot extends Player{
	    
	/**
	 * Creates a new bot
	 */
    public Bot() {
		super();
    }
    
    /**
     * Generates a random number, from within the bot's number of entries, to ask for a card
     */
    public String ask()
	{	
    	return hand[ (int) (numberOfEntries* Math.random())].getValues();
    	
		}
}