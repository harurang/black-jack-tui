/**
 interface Strategy allows a Stragegy Pattern to be used for the classes that implement it;
 AggressiveStrategy, TimidStrategy and DealerStrategy
 **/
interface Strategy
{
    //@requires an int parameter that represents the total of hand[] in class Player
    public int hitOrStand(int total);
}