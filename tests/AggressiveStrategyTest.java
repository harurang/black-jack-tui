import junit.framework.TestCase;

public class AggressiveStrategyTest extends TestCase {
    //text fixture
    private Strategy myStrategy;

    //instantiate text fixture
    public void setUp()
    {
        myStrategy = new AggressiveStrategy();
    }

    //@Test class AgressiveStrategy, hitOrStand() method
    public void testHitOrStand()
    {
        assertEquals(myStrategy.hitOrStand(19),1);
        //assertEquals(myStrategy.hitOrStand(20), 0);
    }
}