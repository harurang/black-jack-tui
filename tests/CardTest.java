import junit.framework.TestCase;

public class CardTest extends TestCase {
    //src.tests fixture
    private Card card;

    //instantiation of src.tests fixture
    public void setUp()
    {
        //arguments represent indices for RANKS[] and SUITS[]
        card = new Card(0,0);
    }

    //@Test class Card, RANKS[] length
    public void ranksLength()
    {
        assertEquals(card.getRanksLength(), 12);
    }

    //@Test class Card, SUITS[] length
    public void suitsLength()
    {
        assertEquals(card.getSuitsLength(), 4);
    }

    //@Test class of Card, getRank() method
    public void testGetRank()
    {
        assertTrue(card.getRank().equals("A"));
    }

    //@Test class of Card, getSuit() method
    public void testGetSuit()
    {
        assertTrue(card.getSuit().equals("Clubs"));
    }

    //@Test class of Card, toString() method
    public void testToString()
    {
        assertTrue(card.toString().equals("A of Clubs\n"));
    }
}