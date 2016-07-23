import java.util.Scanner;

public class UI {

	private Scanner reader;
	private Roller roller;

	public UI() {
		this.reader = new Scanner(System.in);
		this.roller = new Roller();
	}

	public void start() {
		System.out.println("Dice Roller");
		System.out.println("");
		printMenu();
		getCommand();
	}

	private void printMenu() {
		System.out.println("Choose a command:");
		System.out.println(" r Roll dice (" + roller.DiceCount() + " dice with " + roller.DieSides() + " sides)");
		System.out.println(" s Setup dice");
		System.out.println(" q quit");
	}

	private void getCommand() {
		System.out.println("");
		String command = "";
		while (true) {
			System.out.print("command: ");
			command = reader.nextLine().toLowerCase();
			if (command.equals("q")) {
				System.out.println("Exiting...");
				break;
			} else if (command.equals("r")) {
				rollDice();
			} else if (command.equals("s")) {
				setupDice();
			} else {
				printMenu();
				getCommand();
				break;
			}
			System.out.println("");
		}
	}

	private void rollDice() {
		System.out.println("Rolled the dice!");
		System.out.println(roller.roll() + " Total: " + roller.getSum());
	}

	private void setupDice() {

		int diceCount = 0;
		int dieSides = 0;
		String input = "";
		while (true) {
			System.out.print("Number of dice: ");
			input = reader.nextLine();
			try {
				diceCount = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a whole number 0 to 2,147,483,647");
				continue;
			}
			if (diceCount > 0) {
				break;
			} else {
				System.out.println("Please enter positive dice count.");
			}
		}
		while (true) {
			System.out.print("Number of die sides: ");
			input = reader.nextLine();
			try {
				dieSides = Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Please enter a whole number 0 to 2,147,483,647");
				continue;
			}
			if (dieSides > 0) {
				break;
			} else {
				System.out.println("Please enter positive number of sides.");
			}
		}

		this.roller = new Roller(diceCount, dieSides);
	}

}