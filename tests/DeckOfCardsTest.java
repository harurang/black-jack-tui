import junit.framework.TestCase;
import org.junit.Before;

public class DeckOfCardsTest extends TestCase {
    //src.tests fixtures
    private DeckOfCards deck;

    //instantiation of src.tests fixture
    //setUp will be executed prior to every src.tests
    @Before
    public void setUp()
    {
        deck = new DeckOfCards();
    }

    //@Test class DeckOfCard, getLength() method
    public void testDeckLength()
    {
        assertEquals(deck.getLength(),52);
    }

    //@Test class DeckOfCard, draw() method
    public void testDraw()
    {
        //deck.draw() = deck[Card++]
        assertEquals(deck.draw(),deck.getCard(0));
        assertEquals(deck.draw(), deck.getCard(1));
    }

    //@Test class DeckOfCard, shuffle() method
    public void testShuffle()
    {
        //get first card (A of Clubs)
        Card myCard = deck.getCard(0);
        //shuffle deck
        deck.shuffle();
        //ensure first card in deck is not A of Clubs anymore
        assertNotSame(deck.draw(),myCard);
    }
}