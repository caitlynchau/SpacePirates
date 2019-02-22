package scenarios;

import java.util.Random;
import java.util.Scanner;

import spaceships.*;
import timer.*;

/**
 * ScientificBreakthrough is a Scenario in which a crew member is having a
 * scientific breakthrough and the user must answer 6 math questions in 10
 * seconds.
 */
public class ScientificBreakthrough extends Scenario {

	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public ScientificBreakthrough() {
		super("One of your crew members is on the brink of a scientific breakthrough!\n"
				+ "Assist him by solving these equations! (You have 10 seconds to solve these 6 questions)\n");
	}

	/**
	 * consequence method makes the user answer 6 math questions. Two random
	 * numbers are chosen to be the two numbers in the problem. A random number
	 * from one to four is chosen to represent either addition, subtraction,
	 * multiplication, or division. If all six questions are answered corrected,
	 * the spaceship gains random food and equipment. Otherwise the spaceship
	 * gets damaged.
	 * 
	 * @param myShip
	 *            - current spaceship
	 */
	public void consequence(Spaceship myShip) {
		Random rand = new Random();
		Scanner in = new Scanner(System.in);
		boolean successful;
		int equationsCompleted = 0;
		GameTimer timer = new GameTimer((long) 1000, (long) 10 * 1000);
		System.out.println("Start now!!!\n");
		timer.start();
		while (timer.getRemainingTime() > 0) {
			for (int i = 0; i < 6; i++) {
				int number1 = rand.nextInt(11);
				int number2 = rand.nextInt(11);
				int symbol = rand.nextInt(4); // 0 for +, 1 for -, 2 for *, 3
												// for /
				if (symbol == 0) {
					System.out.print(number1 + " + " + number2 + " = ");
					if (in.nextInt() == number1 + number2) {
						equationsCompleted++;
					}
				}
				if (symbol == 1) {
					System.out.print(number1 + " - " + number2 + " = ");
					if (in.nextInt() == number1 - number2) {
						equationsCompleted++;
					}
				}
				if (symbol == 2) {
					System.out.print(number1 + " * " + number2 + " = ");
					if (in.nextInt() == number1 * number2) {
						equationsCompleted++;
					}
				}
				if (symbol == 3) {
					System.out.print(number1 + " / " + number2 + " = ");
					if (in.nextInt() == number1 / number2) {
						equationsCompleted++;
					}
				}
			}
		}
		timer.cancel();
		if (equationsCompleted == 6) {
			System.out.println("\nCongrats on 6/6, you will be heftily rewarded\n"
					+ "because of your crews scientific breakthrough!\n");
			for (int i = 0; i < rand.nextInt(3); i++) {
				int index = (int) (Math.random() * equipmentList.size() - 1);
				myShip.getSpareEquipment().add(equipmentList.get(index));
				System.out.println("You gained " + equipmentList.get(index).toString() + "\n"); // print
																								// item
			}
			for (int i = 0; i < rand.nextInt(3); i++) {
				int index = (int) (Math.random() * foodList.size() - 1);
				myShip.getFoodInv().add(foodList.get(index));
				System.out.println("You gained " + foodList.get(index).toString() + "\n"); // print
																							// item
			}
		} else {
			System.out.println("\nYou got " + equationsCompleted + "/6 and "
					+ "it went terribly, the experiment went haywire and caused some damage\n");
			myShip.damageShip();
		}

	}

}
