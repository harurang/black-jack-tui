/**
 class AggressiveStrategy determines if Player will hit or stand based on the return
 value of method hitOrStand()
 **/
class AggressiveStrategy implements Strategy
{
    /**
     @requires an int parameter that represents the total of hand[] in class Player
     @ensures implementation details and a return value of 1 or 0
     **/
    public int hitOrStand(int total)
    {
        int choice = 0;

        //if parameter is less than 20, reassign choice
        if(total < 20)
            choice = 1;

        return choice;
    }
}