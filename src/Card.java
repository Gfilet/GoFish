public class Card
	{

	// Creates the suits and individual values
	public static int hearts = 14;
	public static int spades = 15;
	public static int diamonds = 16;
	public static int clubs = 17;
	public static int ace = 1;
	public static int jack = 11;
	public static int queen = 12;
	public static int king = 13;
	private String suits;
	private String values;
	private  String number;
	
	/**
	 * Constructor to initialize card values with their determined suit and value
	 * @param cardValue
	 * @param suit
	 */
	   public Card(int cardValue, int suit)
	   { 
		   if (suit >= 0 && suit <= 3) 
		   {
		      if (cardValue >= 1 && cardValue <= 13){
		    	switch (cardValue){
		    	case 1:
		    		values = "A";
		    		break;
		    	case 2:
		    		values = "2";
		    		break;
		    	case 3:
		    		values = "3";
		    		break;
		    	case 4:
		    		values = "4";
		    		break;
		    	case 5:
		    		values = "5";
		    		break;
		    	case 6:
		    		values = "6";
		    		break;
		    	case 7:
		    		values = "7";
		    		break;
		    	case 8:
		    		values = "8";
		    		break;
		    	case 9:
			    	values = "9";
			    	break;
			    case 10:
		    		values = "10";
		    		break;
		    	case 11:
		    		values = "J";
		    		break;
		    	case 12:
		    		values = "Q";
		    		break;
		    	case 13:
		    		values = "K";
		    		break;
		    	}
		      }    
		   	  if (suit == 0)
		   		  suits = "H";
		   	  else if (suit == 1)
		   		  suits = "S";
		   	  else if (suit == 2)
		   		  suits = "D";
		   	  else
		   		  suits = "C";
		   }
	   } // end constructor   
	   
	public String getValues() {
		return values;
	}
	
	public String getNumber(){
		return number;
    }

	public void setValues(String values) {
		this.values = values;
	}

	@Override
	public String toString() {
		return suits + values;
	}
}