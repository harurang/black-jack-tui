/**
 class Card initializes instance variables rank and suit when the constructor is called by passing in parameters
 that represents the indices in RANKS[] and SUITS[], the value of rank may be obtained through method
 getRank(), the value of suit may be obtained through method getSuit() and an instance of Card can be printed because of
 the toString() method which concatenates the rank and suit instance variables
 **/
class Card
{
    /**
     @inv RANKS.length() = 12
     **/
    private final String[] RANKS = {"A","2","3","4","5","6","7","8","9","10","J", "Q", "K"};

    //@inv	SUITS.length() = 3
    private final String[] SUITS = {"Clubs", "Hearts", "Spades", "Diamonds"};

    private String rank;

    private String suit;

    /**
     @requires (2) parameters of type int
     @ensures instance variables are intialized by assigning an element of RANKS[] or SUITS[] to each
     **/
    public Card(int x, int y)
    {
        this.rank = RANKS[x];
        this.suit = SUITS[y];
    }

    /**
     @ensures length of RANKS[] is returned
     only for testing to ensure encapsulation is not broken
     **/
    public int getRanksLength()
    {
        return RANKS.length;
    }

    /**
     @ensures length of SUITS[] is returned
     only for testing to ensure encapsulation is not broken
     **/
    public int getSuitsLength()
    {
        return SUITS.length;
    }

    /**
     @requires instance variable rank declaration
     @ensures value of rank is returned
     **/
    public String getRank()
    {
        return this.rank;
    }

    /**
     @requires instance variable suit declaration
     @ensures value of suit is returned
     **/
    public String getSuit()
    {
        return this.suit;
    }

    /**
     @requires the intialization of rank and suit
     @ensures the return of rank and suit concatenated
     **/
    public String toString()
    {
        return rank + " of " + suit + "\n";
    }
}

