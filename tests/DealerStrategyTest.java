import junit.framework.TestCase;

class DealerStrategyTest extends TestCase {
    //text fixture
    private Strategy myStrategy;

    //instantiate text fixture
    public void setUp()
    {
        myStrategy = new DealerStrategy();
    }

    //@Test class DealerStrategy, hitOrStand() method
    public void testHitOrStand()
    {
        assertTrue(myStrategy.hitOrStand(16) == 1);
        assertTrue(myStrategy.hitOrStand(17) == 0);
    }

}