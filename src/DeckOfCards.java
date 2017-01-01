import java.util.Random;

/**
 class DeckOfCards instantiates a deck array with a Card object in each element when the constructor is called,
 receives the next card in deck[] through method draw(), shuffles the deck[] through method shuffle() and prints
 each Card in deck[] with method getDeck()
 **/
class DeckOfCards
{
    private final Card[] deck;

    /**
     @inv draw() = nextCard++
     **/
    private int nextCard = 0;

    /**
     @ensures deck instantiation and that each element in deck[] is assigned a Card
     **/
    public DeckOfCards()
    {
        deck = new Card[52];

        //declare a counter for deck[k]
        int k = 0;

        //while less than array RANKS[] and SUITS[] provided in class Card
        for(int i = 0; i < 13; i++)
            for(int j = 0; j<4; j++)
            {
                //assign each element in deck[] a Card object
                //this is possible because deck is of type Card
                deck[k] = new Card(i,j);
                k++;
            }
    }

    /**
     @ensures length of deck[] is returned
     only for testing to ensure encapsulation is not broken
     **/
    public int getLength()
    {
        return deck.length;
    }

    /**
     @ensures individual Card is returned from deck[]
     only for testing
     **/
    public Card getCard(int x)
    {
        Card y = deck[x];
        return y;
    }

    /**
     @ensures nextCard is incremented and the next Card object is returned
     **/
    public Card draw()
    {
        Card card = deck[nextCard];
        //having a counter prevents the same card from being dealt twice
        this.nextCard++;

        return card;
    }

    /**
     @ensures each element in deck[] is assigned to a new index
     **/
    public void shuffle()
    {
        Random randomNum = new Random();

        //assign each Card in deck[] a new index
        for(int i = 0; i < deck.length; i++)
        {
            //assign a random number to num
            int num = randomNum.nextInt(deck.length);

            //assign temp a value from deck[]
            Card temp = deck[i];

            //assign an index from deck[] a random value from deck[]
            deck[i] = deck[num];

            //assign random deck[] index to original deck[i] value
            deck[num] = temp;
        }
    }

    /**
     @requires toString for Card class
     @ensures each element in deck[] is printed
     **/
    public void getDeck()
    {
        //print each Card in deck[]
        for(int i = 0; i < deck.length; i++)
            System.out.print(deck[i]);
    }
}