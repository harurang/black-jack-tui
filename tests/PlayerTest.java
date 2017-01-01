import junit.framework.TestCase;
import org.junit.Before;

class PlayerTest extends TestCase {
    //src.tests fixtures
    private Card hand[];
    private Player dealer;
    private Player aggressivePlayer;
    private Player timidPlayer;

    private DeckOfCards deck;

    //instantiate text fixtures before each src.tests
    @Before
    public void setUp()
    {
        this.hand = new Card[5];
        this.deck = new DeckOfCards();
        this.dealer = new Player();
        this.aggressivePlayer = new Player(2);
        this.timidPlayer = new Player(1);
    }


    //@Test class Player, hand[] array length
    public void testHandLength()
    {
        assertEquals(aggressivePlayer.getHandLength(),5);
        assertEquals(timidPlayer.getHandLength(),5);
        assertEquals(dealer.getHandLength(),5);
    }

    //@Test class Player, hand[] array for null values
    public void testHandValues()
    {
        assertEquals(aggressivePlayer.getCard(0), null);
        assertEquals(timidPlayer.getCard(0), null);
        assertEquals(dealer.getCard(0), null);
    }


    //@Test class Player, giveCard() method
    public void testGiveCard()
    {
        //retreive a Card object from deck[]
        Card x = deck.draw();

        //add a Card object to each player's hand[] at index 0
        aggressivePlayer.giveCard(x);
        timidPlayer.giveCard(x);
        dealer.giveCard(x);

        //ensure no hand[0] is null
        assertFalse(aggressivePlayer.getCard(0).equals("null"));
        assertFalse(timidPlayer.getCard(0).equals("null"));
        assertFalse(dealer.getCard(0).equals("null"));
    }


    //@Test class Player, totalPoints() method after Cards have been dealt
    public void testTotalPointsAfter()
    {
        //retrive a Card object from deck[]
        Card card = deck.draw();

        //add a Card object to each player's hand[]
        aggressivePlayer.giveCard(card);
        timidPlayer.giveCard(card);
        dealer.giveCard(card);

        //the first card dealt is an Ace when the
        //deck is not shuffled, all points will equal 11
        assertEquals(aggressivePlayer.totalPoints(), 11);
        assertEquals(timidPlayer.totalPoints(), 11);
        assertEquals(dealer.totalPoints(), 11);
    }

    //@Test class Player, totalPoints() method before Cards have been dealt
    public void testTotalPointsBefore()
    {
        assertEquals(aggressivePlayer.totalPoints(), 0);
        assertEquals(timidPlayer.totalPoints(), 0);
        assertEquals(dealer.totalPoints(), 0);
    }


    //@Test class Player, takeTurn() method
    public void testTakeTurn()
    {
        //retrieve a Card object from deck[]
        Card card = deck.draw();

        //add a Card to each player's hand[]
        aggressivePlayer.giveCard(card);
        timidPlayer.giveCard(card);
        dealer.giveCard(card);

        //all players will have a return value of 1 because
        //one Card will not meet the takeTurn requirements to hit
        assertEquals(aggressivePlayer.takeTurn(), 1);
        assertEquals(timidPlayer.takeTurn(), 1);
        assertEquals(dealer.takeTurn(), 1);
    }
}