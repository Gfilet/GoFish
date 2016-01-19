import java.util.Arrays;
import java.util.Random;
@SuppressWarnings("unused")

public class Deck 
{
	public final Card[] deck;
	public static final int DEFAULT_CAPACITY = 52;
	public int numberOfEntries;

	/** Creates an empty deck having a given initial capacity.
	    @param capacity  the integer capacity desired */
	public Deck() 
	{
		deck = new Card[DEFAULT_CAPACITY];
		numberOfEntries = 0;
		for (int suit = 0; suit <= 3; suit++)
		{
			for (int value = 1; value <= 13; value++)
			{
				deck[numberOfEntries] = new Card(value, suit);
				numberOfEntries++;
			}
		}	
	}

	/** Adds a new entry to the bag.
	    @param newEntry  the object to be added as a new entry
	    @return true if the addition is successful, or false if not */
	public boolean add(Card newEntry) 
	{
		boolean result = true;
		if (isFull())
		{
			result = false;
		}
		else
		{  
			deck[numberOfEntries] = newEntry;
			numberOfEntries++;
		} // end if
		return result;
	} // end add
	
	/**
	 * Removes an entry once a pair is found
	 * @return result
	 */
	public Card remove()
	{
		Card result = removeEntry(numberOfEntries - 1);
		
		return result;
	} // end remove
	
	/**
	 * Checks for a given entry within the Deck and removes it
	 * @param anEntry
	 * @return result
	 */
	public boolean remove(Card anEntry)
	{
			int index = getIndexOf(anEntry);
	      Card result = removeEntry(index);
			
			return anEntry.equals(result);
	}
	
	/**
	 * Checks for a given index within the Deck
	 * @param anEntry
	 * @return the index within the deck
	 */
	private int getIndexOf(Card anEntry) 
	{
		int where = -1;
		boolean found = false;
      
		for (int index = 0; !found && (index < numberOfEntries); index++) 
		{
			if (anEntry.equals(deck[index]))
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
	 * Checks the Deck for a given index
	 * @param givenIndex
	 * @return the position of card within the deck
	 */
	private Card removeEntry(int givenIndex)
	{
		Card result = null;
      
		if (!isEmpty() && (givenIndex >= 0))
		{
         result = deck[givenIndex];               // entry to remove
         numberOfEntries--;
         deck[givenIndex] = deck[numberOfEntries]; // replace entry to remove with last entry
         deck[numberOfEntries] = null;            // remove reference to last entry
		} // end if
      
      return result;
	} // end removeEntry  
	
	/** Sees whether this bag is full.
       @return true if this bag is full, or false if not */
	public boolean isFull() 
	{
		return numberOfEntries == deck.length;
	} // end isFull
	
	/**
	 * Method to check and see if your hand is empty
	 * @return true if it is, or false otherwise.
	 */
	public boolean isEmpty() 
	{
		return numberOfEntries == 0;
	} // end isEmpty
	
	/**
	 * Goes through the deck and shuffles the cards
	 * @param deck
	 */
	public void shuffle(int n) {
			int i, j, k;
			
			for (k = 0; k< n; k++)
			{
				i = (int) (DEFAULT_CAPACITY * Math.random());
				j = (int) (DEFAULT_CAPACITY * Math.random());
				Card temp = deck[i];
				deck[i] = deck[j];
				deck[j] = temp;
			}
		}
	
	/** Retrieves all entries that are in this bag.
		 @return a newly allocated array of all the entries in this bag */
	public Card[] toArray()
	{
      // the cast is safe because the new array contains null entries
      Card[] result = (Card[])new Object[numberOfEntries]; // unchecked cast

		for (int index = 0; index < numberOfEntries; index++) 
		{
			result[index] = deck[index];
		} // end for
			
		return result;
	} // end toArray


	@Override
	public String toString() {
		return "Deck [deck=" + Arrays.toString(deck) + ", numberOfEntries="
				+ numberOfEntries + "]";
	}
}