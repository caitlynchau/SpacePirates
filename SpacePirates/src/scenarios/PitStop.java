package scenarios;

import java.util.Scanner;
import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * PitStop is a Scenario in which the spaceship stops on a planet and find some
 * friendly enhabitants who agree to repair the ship in exchange for one crew
 * member. The user can decide whether to trade or not
 */
public class PitStop extends Scenario {

	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public PitStop() {
		super("You have decided to land on Planet X for a pit stop. The friendly enhabitants agree to repair \nyour"
				+ " ship in exchange for one crew member");
	}

	/**
	 * consequence method asks the user if her or she would lie to trade. If
	 * yes, then a broken equipment is repaired to full health and a random crew
	 * member is removed from the spaceship. If no, then print a message
	 */
	public void consequence(Spaceship myShip) {
		Scanner input = new Scanner(System.in);
		System.out.print("Do you accept their trade? ");
		String answer = input.next().toLowerCase();
		int brokenItem = 0, healthBar = 0, maxHealth = 0;
		while (!(answer.equals("no")) && !(answer.equals("yes"))) {
			System.out.print("Enter yes or no. Do you agree to trade? ");
			answer = input.next();
			answer = answer.toLowerCase();
		}
		if (answer.equals("yes")) {
			boolean needsRepairs = false;
			for (int i = 0; i < myShip.getPartsInUse().length - 1; i++) {
				healthBar = myShip.getPartsInUse()[i].getHealthBar();
				maxHealth = myShip.getPartsInUse()[i].getMaxHealth();
				if (healthBar < maxHealth) {
					needsRepairs = true;
					brokenItem = i;
					break;
				}
			}
			if (needsRepairs) {
				myShip.getPartsInUse()[brokenItem].setHealthBar(healthBar + 15);
				if (healthBar > maxHealth) {
					myShip.getPartsInUse()[brokenItem].setHealthBar(maxHealth);
				}
				int randomMember = (int) (Math.random() * myShip.getCrewMembers().size() - 1);
				System.out.println("Bye bye " + myShip.getCrewMembers().get(randomMember).getMyName()
						+ ". You get your " + myShip.getPartsInUse()[brokenItem].toString() + " fixed.\n");
				myShip.getCrewMembers().remove(randomMember);
			} else {
				System.out.println("Your ship does not need repairs. You all sing kumbaya around a campfire instead\n");
			}

		} else {
			System.out.println("You kindly decline their offer. Instead you all sing kumbaya around a campfire.\n");
		}
	}

}