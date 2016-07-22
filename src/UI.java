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
		getCommand();
	}

	private void printMenu() {
		System.out.println("");
		System.out.println("Choose a command:");
		System.out.println(" r Roll dice (" + roller.DiceCount() + " dice with " + roller.DieSides() + " sides)");
		System.out.println(" s Setup dice");
		System.out.println(" q quit");
		System.out.println("");
	}

	private void getCommand() {

		String command = "";
		while (true) {
			printMenu();
			System.out.print("command: ");
			command = reader.nextLine();
			if (command.equals("q")) {
				System.out.println("Exiting...");
				break;
			} else if (command.equals("r")) {
				rollDice();
			} else if (command.equals("s")) {
				setupDice();
			} else {
				System.out.println("Invalid command!");
				getCommand();
				break;
			}
		}
	}

	private void rollDice() {
		System.out.println("Rolled the dice!");
		System.out.println(roller.roll());
	}

	private void setupDice() {
		System.out.print("Number of dice: ");
		int diceCount = Integer.parseInt(reader.nextLine());
		System.out.print("Number of die sides: ");
		int dieSides = Integer.parseInt(reader.nextLine());
		this.roller = new Roller(diceCount, dieSides);
		System.out.println("");
	}

}