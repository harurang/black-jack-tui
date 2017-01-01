import junit.framework.TestCase;

public class BlackJackTest extends TestCase {
    //src.tests fixtures
    BlackJack game;

    //instantiate src.tests fixture
    public void setUp()
    {
        game = new BlackJack();
    }

    //@Test class BlackJack, method determineWinner()
    public void testDetermineWinner()
    {
        //arguments represent possible points for two players
        assertTrue(game.determineWinner(22,1).contains("Player one bust."));
        assertTrue(game.determineWinner(1,22).contains("Dealer bust."));
        assertTrue(game.determineWinner(15,14).contains("Player one won."));
        assertTrue(game.determineWinner(14,15).contains("Dealer won."));
        assertTrue(game.determineWinner(15,15).contains("Players tied."));
        assertEquals(game.determineWinner(25,25),("\nPlayer one bust.\n\nDealer bust.\n"));
    }
}