import java.util.Random;

public class Die {
    private Random random;
    private int numberOfSides;

    public Die(int numberOfSides){
        this.numberOfSides = numberOfSides;
        random = new Random();
    }

    public int roll() {
          // we'll get a random number in the range 1 - numberOfSides
        int result = random.nextInt(numberOfSides + 1);
        if (result > 0){
            return result;
        } else
            return roll();
    }
    
    public int getNumberOfSides() {
		return numberOfSides;
	}
    
}