/**
 class Player determines Player strategy based on constructor, collects total points for hand[] with method totalPoints(),
 adds cards to hand[] with giveCard() method, determines hit or stand with method takeTurn() and
 prints hand with method getHand()
 **/
class Player
{
    private Card[]hand;

    //@inv dynamic type must be of type Strategy
    private Strategy myStrategy;

    /**
     @requires a parameter of type int
     @ensures myStrategy and hand[] is instantiated
     **/
    public Player(int decision)
    {
        if(decision == 1)
            myStrategy = new TimidStrategy();
        else
            myStrategy = new AggressiveStrategy();

        hand = new Card[5];
    }


    //@ensures myStrategy and hand[] are instantiated
    public Player()	//overloaded constructor
    {
        myStrategy = new DealerStrategy();

        hand = new Card[5];
    }

    /**
     @ensures individual Card is returned from hand[]
     only for testing
     **/
    public Card getCard(int x)
    {
        Card y = hand[x];
        return y;
    }

    /**
     @ensures length of hand[] is returned
     only for testing to ensure encapsulation is not broken
     **/
    public int getHandLength()
    {
        return hand.length;
    }

    /**
     @ensures each Card in hand[] is assigned a numerical value and returns the sum
     **/
    public int totalPoints()
    {
        //retains value of hand[]
        int total =0;

        //temporarily holds the rank of each Card in hand[]
        String rank;

        //for each element in hand[], assign an int value and add to total
        for(int i = 0;i < hand.length; i++)
        {
            //if elment is null
            if(hand[i] == null)
                //skip
                break;
                //if element is not null
            else
            {
                //rank is assigned the rank of specified index
                rank = hand[i].getRank();

                //if rank is K, Q or J
                if((rank == "K") || (rank == "Q") || (rank == "J"))
                {
                    //add 10
                    total += 10;
                }
                //if rank is a number between 2 and ten
                else if((rank == "10") || (rank == "9") || (rank == "8") || (rank == "7") || (rank == "6") || (rank == "5") || (rank == "4") || (rank == "3") || (rank =="2"))
                {
                    //convert the String value of rank into an int value and assign that number to value
                    int value = Integer.parseInt(rank);
                    //add number to total
                    total += value;
                }
                //add the value of Ace last to determine whether value should represent an 11 or a 1
                else if(rank == "A")
                {
                    //if total is less than 11, add 11
                    if(total <= 11)
                        total += 11;
                    else
                        //if total is less than 11 add 1
                        total += 1;
                }
                else
                    total += 0;
            }
        }

        return total;
    }

    /**
     @requires Card object is passed in as a parameter
     @ensures Card is assigned to the first null index in hand[]
     **/
    public void giveCard(Card card)
    {
        //assign Card to the first null index
        for(int i = 0; i <hand.length; i++)
            //if element is null
            if(hand[i] == null)
            {
                //assign parameter to null index
                hand[i] = card;
                //end loop once Card object is assigned
                break;
            }
    }

    /**
     @ensures return value of 1 or 0 based on dynamic type of myStrategy
     **/
    public int takeTurn()
    {
        int total = totalPoints();
        return myStrategy.hitOrStand(total);
    }

    /**
     @requires toString() method for class Card
     @ensures elements in hand[] that do not contain null values are printed
     **/
    public void getHand()
    {
        //if index is not null, print element in hand[]
        for(int i=0; i<hand.length;i++)
            if(!(hand[i]==null))
                System.out.print(hand[i]);
    }
}