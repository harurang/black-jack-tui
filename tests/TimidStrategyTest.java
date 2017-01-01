import junit.framework.TestCase;

public class TimidStrategyTest extends TestCase {
    //text fixture
    private Strategy myStrategy;

    //instantiate text fixture
    public void setUp()
    {
        myStrategy = new TimidStrategy();
    }

    //@Test class TimidStrategy, hitOrStand() method
    public void testHitOrStand()
    {
        assertTrue(myStrategy.hitOrStand(13) == 1);
        assertTrue(myStrategy.hitOrStand(14) == 0);
    }
}