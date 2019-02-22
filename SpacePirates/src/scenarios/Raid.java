package scenarios;

import java.util.Random;
import java.util.Scanner;
import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * Raid is a Scenario in which the Spaceship can decide to raid another ship or
 * not. The other ship encountered depends on the current spaceship's level. If
 * the spaceship is broken, the user cannot engage in the raid. A random number
 * generator generates three numbers. If all numbers are less than the success
 * rate of the spaceship, then the raid is successful and the spaceship's
 * success rate increases and the spaceship gains equipment and money.
 * Otherwise, the raid is not successful and the spaceship's success rate
 * decreases.
 */
public class Raid extends Scenario {
	private int successRate; // success rate of the spaceship
	private int level; // spaceship level

	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public Raid() {
		super("You have encountered another ship!\n");
	}

	/**
	 * consequence method prints a message of the type of ship encountered
	 * depending on the spaceship's level. For level one, it is a scouting ship,
	 * level two is a cargo ship, and level three is a battleship. The user can
	 * decide to engage in the raid or not. If the ship is broken, it cannot
	 * engage in the raid. Otherwise, the spaceship raids. If it is successful
	 * it gains a random amount of equipment, food, and money. Even if the
	 * spaceship is successful, it may still get damaged in the raid. If the
	 * raid is not successful, the spaceship gets damaged.
	 * 
	 * @param myShip
	 *            - current spaceship
	 */
	public void consequence(Spaceship myShip) {
		Scanner input = new Scanner(System.in);
		successRate = myShip.getSuccessRate();
		level = myShip.getLevel();
		String ship = "";

		if (level == 1) {
			ship = "scouting ship";
		} else if (level == 2) {
			ship = "cargo ship";
		} else if (level == 3) {
			ship = "battleship";
		}
		System.out.print("Your radar has picked up a " + ship + " close by. Do you wish to raid it? \n");
		String answer = input.next().toLowerCase();
		while (!(answer.equals("no")) && !(answer.equals("yes"))) {
			System.out.print("Enter yes or no. Do you wish to raid? ");
			answer = input.next();
			answer = answer.toLowerCase();
		}
		if (answer.equals("yes")) {
			// dont raid if ship is broken
			if (myShip.isBroken()) {
				System.out.println("Your ship is broken. You cannot raid.");
			} else {
				if (isSuccessful()) { // add random equipment and food
					Random rand = new Random();
					for (int i = 0; i < rand.nextInt(3); i++) {
						int index = (int) (Math.random() * equipmentList.size() - 1);
						myShip.getSpareEquipment().add(equipmentList.get(index));
						System.out.println("Raid successful! You gained " + equipmentList.get(index).toString() + "\n"); // print
																															// item
					}
					for (int i = 0; i < rand.nextInt(3); i++) {
						int index = (int) (Math.random() * foodList.size() - 1);
						myShip.getFoodInv().add(foodList.get(index));
						System.out.println("Raid successful! You gained " + foodList.get(index).toString() + "\n"); // print
																													// item
					}
					int money = rand.nextInt(250) + 50;
					System.out.println("You've earned $" + money + "!\n");
					myShip.setMoney(myShip.getMoney() + money);
					myShip.damageShip();
				} else { // damage random equipment
					System.out.println("\nYour raid was unsuccessful!\n");
					Random rand = new Random();
					int severity = rand.nextInt(4);
					myShip.damageShip(severity);
				}
			}
		} else {
			System.out.println("Your ship will cruise by the " + ship);
		}
	}

	/**
	 * isSuccessful method returns true if all random numbers are less than the
	 * sucessRate of the spaceship. The raid is successful. Otherwise, false.
	 * The number of rolls is equal to the level of the spaceship.
	 * 
	 * @return true if the random numbers are less than the successRate of the
	 *         spaceship. False otherwise.
	 */
	private boolean isSuccessful() {
		int numberOfSuccesses = 0;
		for (int i = 0; i < level; i++) {
			int n = (int) (Math.random() * 100) + 1;
			if (n < successRate) {
				numberOfSuccesses++;
			}
		}
		return (numberOfSuccesses == level);
	}

}