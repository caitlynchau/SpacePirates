package spaceships;

import java.util.*;
import creatures.*;
import equipment.*;
import food.*;
import scenarios.*;

/**
 * LevelThree class that sets up characteristics for level three of spaceship
 */
public class LevelThree extends Spaceship {
	Equipment[] partsInUse = new Equipment[7]; // [cannon, barrier, hyperdrive,
												// pfc, fp]
	Scanner in = new Scanner(System.in);

	/**
	 * constructor to initialize all characteristics for level three spaceship
	 * sets one of each equipments to level three
	 * 
	 * @param members
	 *            - list of members
	 * @param food
	 *            - list of foods
	 */
	public LevelThree(ArrayList<Creature> members, ArrayList<Food> food) {
		super("Level Three", 3, 150, members, food, 75, 300);
		partsInUse[0] = new Cannon(3);
		partsInUse[1] = new Barrier(3);
		partsInUse[2] = new Hyperdrive(3);
		partsInUse[3] = new PowerFluxCapacitator(3);
		partsInUse[4] = new FulstarPlate(3);
		partsInUse[5] = new Laser(3);
		super.setPartsInUse(partsInUse);
	}

	/**
	 * method to return success rate
	 * 
	 * @return win rate after each level
	 */
	public int getSuccessRate() {
		int winRate = 0;
		for (int i = 0; i < crewMembers.size(); i++) {
			winRate += 5 * getLevel();
		}
		return winRate;
	}

	/**
	 * method to return equipments in use
	 * 
	 * @return parts being used in spaceship
	 */
	public Equipment[] getPartsInUse() {
		return partsInUse;
	}

	/**
	 * method to print health of each equipment
	 */
	public void healthReport() {
		for (int i = 0; i < 7; i++) {
			System.out.println("Health of part " + (i + 1) + partsInUse[i].toString() + partsInUse[i].getHealthBar());
		}
	}

	/**
	 * method to replace equipments with spare ones
	 */
	public void fixEquipment() {
		boolean found;
		ArrayList<Equipment> spares = getSpareEquipment();
		System.out.println("Would you like to fix a part?\n");
		String yesOrNo = in.next();
		while (!yesOrNo.equalsIgnoreCase("yes") && !yesOrNo.equalsIgnoreCase("no")) {
			System.out.println("Enter 'yes' or 'no'.");
			yesOrNo = in.next();
		}
		if (yesOrNo.equalsIgnoreCase("yes")) {
			System.out.println("Which part?");
			int choice = 999;
			while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {
				System.out.println("Please enter a number from 1 to 6");
				while (!in.hasNextInt()) {
					in.next();
					System.out.println("Please enter a number from 1 to 6");
				}
				choice = in.nextInt();
			}
			while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {
				System.out.println("Please enter a choice from 1 to 6");
				choice = in.nextInt();
			}
			if (choice == 1) {
				found = false;
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof Cannon) {
						found = true;
					}
				}
				if (found == true) {
					partsInUse[0].setHealthBar(partsInUse[0].getMaxHealth());
				}
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof Cannon) {
						spares.remove(i);
					}
				}
			}
			if (choice == 2) {
				found = false;
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof Barrier) {
						found = true;
					}
				}
				if (found == true) {
					partsInUse[1].setHealthBar(partsInUse[1].getMaxHealth());
				}
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof Barrier) {
						spares.remove(i);
					}
				}
			}
			if (choice == 3) {
				found = false;
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof Hyperdrive) {
						found = true;
					}
				}
				if (found == true) {
					partsInUse[2].setHealthBar(partsInUse[2].getMaxHealth());
				}
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof Hyperdrive) {
						spares.remove(i);
					}
				}
			}
			if (choice == 4) {
				found = false;
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof PowerFluxCapacitator) {
						found = true;
					}
				}
				if (found == true) {
					partsInUse[3].setHealthBar(partsInUse[3].getMaxHealth());
				}
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof PowerFluxCapacitator) {
						spares.remove(i);
					}
				}
			}
			if (choice == 5) {
				found = false;
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof FulstarPlate) {
						found = true;
					}
				}
				if (found == true) {
					partsInUse[4].setHealthBar(partsInUse[4].getMaxHealth());
				}
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof FulstarPlate) {
						spares.remove(i);
					}
				}
			}
			if (choice == 6) {
				found = false;
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof Laser) {
						found = true;
					}
				}
				if (found == true) {
					partsInUse[5].setHealthBar(partsInUse[4].getMaxHealth());
				}
				for (int i = 0; i < spares.size(); i++) {
					if (spares.get(i) instanceof Laser) {
						spares.remove(i);
					}
				}
			}
		} else if (yesOrNo.equalsIgnoreCase("no")) {
			System.out.println("\nContinue on...\n");
		}
	}

	/**
	 * method to determine the severity of damage on the ship after an attack
	 * 
	 * @param severity
	 *            - severity of the damage generated by a random number
	 */
	public void damageShip(int severity) {
		Random rand = new Random();
		if (severity == 0) {
			int index = rand.nextInt(crewMembers.size());
			System.out.println("You made it out with no ship damage, but " + crewMembers.get(index).getMyName()
					+ " died. Sad face.\n");
			crewMembers.remove(index);
			return;
		}
		if (severity == 1) {
			int index = rand.nextInt(6);
			System.out.println(partsInUse[index].toString() + " got damaged!\n");
			partsInUse[index].setHealthBar(partsInUse[index].getHealthBar() - rand.nextInt(75) + 25);
			if (partsInUse[index].getHealthBar() < 0) {
				partsInUse[index].setHealthBar(0);
			}
		}
		if (severity == 2) {
			for (int i = 0; i < 2; i++) {
				int index = rand.nextInt(6);
				System.out.println(partsInUse[index].toString() + " got damaged!\n");
				partsInUse[index].setHealthBar(partsInUse[index].getHealthBar() - rand.nextInt(75) + 25);
				if (partsInUse[index].getHealthBar() < 0) {
					partsInUse[index].setHealthBar(0);
				}
			}
		}
		if (severity == 3) {
			for (int i = 0; i < 3; i++) {
				int index = rand.nextInt(6);
				int damage = rand.nextInt(75) + 25;
				System.out.println(partsInUse[index].toString() + " got damaged by " + damage + " points!\n");
				partsInUse[index].setHealthBar(partsInUse[index].getHealthBar() - damage);
				if (partsInUse[index].getHealthBar() < 0) {
					partsInUse[index].setHealthBar(0);
				}
			}
		}

	}

	/**
	 * method to determine if crew members were damaged after an attack
	 */
	public void damageShip() {
		Random rand = new Random();
		int severity = rand.nextInt(4);
		System.out.println("\nYou may have been successful but might not be unscathed.\n");
		if (severity == 0) {
			int index = rand.nextInt(crewMembers.size());
			System.out.println(
					"\nYou made it out with no ship damage, but " + crewMembers.get(index).getMyName() + " died.\n");
			crewMembers.remove(index);
			return;
		}
		if (severity == 1) {
			int index = rand.nextInt(6);
			int damage = rand.nextInt(75) + 25;
			System.out.println(partsInUse[index].toString() + " got damaged by " + damage + " points!\n");
			partsInUse[index].setHealthBar(partsInUse[index].getHealthBar() - damage);
			if (partsInUse[index].getHealthBar() < 0) {
				partsInUse[index].setHealthBar(0);
			}
		}
		if (severity == 2) {
			for (int i = 0; i < 2; i++) {
				int index = rand.nextInt(6);
				int damage = rand.nextInt(75) + 25;
				System.out.println(partsInUse[index].toString() + " got damaged by " + damage + " points!\n");
				partsInUse[index].setHealthBar(partsInUse[index].getHealthBar() - damage);
				if (partsInUse[index].getHealthBar() < 0) {
					partsInUse[index].setHealthBar(0);
				}
			}
		}
		if (severity == 3) {
			for (int i = 0; i < 3; i++) {
				int index = rand.nextInt(6);
				int damage = rand.nextInt(75) + 25;
				System.out.println(partsInUse[index].toString() + " got damaged by " + damage + " points!\n");
				partsInUse[index].setHealthBar(partsInUse[index].getHealthBar() - damage);
				if (partsInUse[index].getHealthBar() < 0) {
					partsInUse[index].setHealthBar(0);
				}
			}
		}

	}

	/**
	 * method to determine whether equipment is broken
	 * 
	 * @return true if broken, false otherwise
	 */
	public boolean isBroken() {
		boolean check = false;
		for (int k = 0; k < 5; k++) {
			if (partsInUse[k].getHealthBar() == 0) {
				check = true;
			}
		}
		return check;
	}

	/**
	 * method to determine if unbroken equipment can be upgraded
	 * 
	 * @return false - nonupgradeable
	 */
	public boolean canUpgrade() {
		return false;
	}

}