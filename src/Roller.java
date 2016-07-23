import java.util.ArrayList;
import java.util.List;

public class Roller {

	private List<Die> dice;

	public Roller() {
		// Roll 2 6-sided dice by default
		this(2, 6);
	}

	public Roller(int diceCount, int dieSides) {
		this.dice = new ArrayList<Die>();

		for (int i = 0; i < diceCount; i++) {
			dice.add(new Die(dieSides));
		}
	}

	public int DiceCount() {
		if (dice.isEmpty()) {
			return 0;
		}
		return dice.size();
	}

	public int DieSides() {
		if (dice.isEmpty()) {
			return 0;
		}
		return dice.get(0).getNumberOfSides();
	}

	public List<Integer> roll() {
		List<Integer> result = new ArrayList<Integer>(DiceCount());
		for (Die die : dice) {
			result.add(die.roll());
		}
		return result;
	}

}
