import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
@SuppressWarnings("unused")

public class Player 
{
	public final Card[] hand;
	public static final int DEFAULT_CAPACITY = 52;
	public int numberOfEntries;
	public int myScore = 0;
	private boolean remove;

	/** Creates an empty hand having a given initial capacity.
	    @param capacity  the integer capacity desired */
	public Player() 
	{
		hand = new Card[DEFAULT_CAPACITY];
		numberOfEntries = 0;
	}

	// Add method to add a card to the hand from the deck
	public boolean add(Card anEntry)
	{
		hand[numberOfEntries] = anEntry;
		numberOfEntries++;
		return true;
	}
	
	/**
	 * Removes first card within hand when called
	 * @param anEntry
	 * @return result
	 */
	private boolean remove(Card anEntry)
	{
			int index = getIndexOf(anEntry);
	      Card result = removeEntry(index);
			
			return anEntry.equals(result);
	}
	
	/**
	 * Checks an entry, removes it from hand if found
	 * @param givenIndex
	 * @return null if removed
	 */
	private Card removeEntry(int givenIndex)
	{
		Card result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = hand[givenIndex];               // entry to remove
         numberOfEntries--;
         hand[givenIndex] = hand[numberOfEntries]; // replace entry to remove with last entry
         hand[numberOfEntries] = null;            // remove reference to last entry
		} // end if
      
      return result;
	} // end removeEntry  

	// Checks to see if the hand is empty
	private boolean isEmpty() 
	{
		return numberOfEntries == 0;
	} // end isEmpty
	
	/**
	 * Looks through the hand to see if it has a certain index
	 * @param anEntry
	 * @return true if found, or false if not
	 */
	private int getIndexOf(Card anEntry) 
	{
		int where = -1;
		boolean found = false;
      
		for (int index = 0; !found && (index < numberOfEntries); index++) 
		{
			if (anEntry.equals(hand[index]))
			{
				found = true;
				where = index;
			} // end if
		} // end for
      
      // Assertion: If where > -1, anEntry is in the array bag, and it
      // equals bag[where]; otherwise, anEntry is not in the array
		return where;
	} // end getIndexOf
	
	/**
	 * Checks to see how many times an entry appears within the hand
	 * @param anEntry
	 * @return the amount of times a given card shows up
	 */
	public int getFrequencyOf(Card anEntry) 
	{
		int counter = 0;

		for (int index = 0; index < numberOfEntries; index++) 
		{
			if (anEntry.equals(hand[index]))
			{
				counter++;
			} // end if
		} // end for
		return counter;
	}
	
	/**
	 * Gets the players hand
	 * @return what's within the array
	 */
	public Card[] getHand()
	{
		return(hand);
	}
	
	/**
	 * Checks to see if anEntry is within the array
	 * @param anEntry
	 * @return true if within the hand, else false
	 */
	public boolean containsValue(String anEntry)
	{
		for(int i = 0; i < numberOfEntries;i++)
		{
			if(hand[i].getValues().equals(anEntry))
			{
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Checks to see if 2 of the same values are within the hand
	 * @param anEntry
	 * @return null if 2 of the same values are within the hand
	 */
	public Card removeByValue(String anEntry)
	{
		
		for(int i = 0; i < numberOfEntries;i++)
		{
			if(hand[i].getValues().equals(anEntry))
			{
				return removeEntry(i);
			}
		}
		return null;
	}
	
	/**
	 * Checks to see if a given entry is within the array
	 * @param anEntry
	 * @return the values within the hand
	 */
	   public boolean contains(Card anEntry) 
		{
			return getIndexOf(anEntry) > -1; // or >= 0
		} // end contains
	
	/** Retrieves all entries that are in this hand.
		 @return a newly allocated array of all the entries in this hand */
	public Card[] toArray()
	{
      // the cast is safe because the new array contains null entries
      Card[] result = (Card[])new Card[numberOfEntries]; // unchecked cast

		for (int index = 0; index < numberOfEntries; index++) 
		{
			result[index] = hand[index];
		} // end for
			
		return result;
	} // end toArray

	
	@Override
	public String toString() {
		return "hand [hand=" + Arrays.toString(hand) + ", numberOfEntries="
				+ numberOfEntries + "]";
	}

	/**
	 * Checks to see if there is a given pair based on the values within hand
	 */
	public void pair() 
	{	
			for(int b=0;b<(numberOfEntries - 1);b++)
			{
			
				for(int k=b+1; k<(numberOfEntries);k++)
				{
					if(hand[b].getValues().equals(hand[k].getValues()))
					{	
						
						removeEntry(k);
						removeEntry(b);
						b--;
							System.out.println("Found a pair!");
						myScore++;
						break;
					}
				}
				
			}
	}
	
	/**
	 * Asks opponent if they have a certain card
	 * @return given card, or Go Fish
	 */
	public String ask()
	{
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		Card[] copyOfBag = this.toArray();
		System.out.println("Player's Card " + Arrays.toString(copyOfBag));
		System.out.println("Ask apponent for [A,2,3,4,5,6,7,8,9,10,J,Q,K]: ");
		
		while(true)
		{
			String askCard = s.next();
			if(containsValue(askCard))
			{
				return askCard;
			}
			else
			{
				System.out.println("You don't have that card! ask again:");
			}
		}	
	}
	
	/**
	 * Gets score of the player
	 * @return player score
	 */
	public int getScore()
	{
		return myScore; //score should be an integer in the method pile
	}
}