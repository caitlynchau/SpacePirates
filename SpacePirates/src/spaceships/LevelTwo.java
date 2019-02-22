package spaceships;

import java.util.*;
import creatures.*;
import equipment.*;
import food.*;
import scenarios.*;

/**
 * LevelTwo class that sets up characteristics for level two spaceship
 */
public class LevelTwo extends Spaceship {
	Equipment[] partsInUse = new Equipment[7]; // [cannon, barrier, hyperdrive,
												// pfc, fp]
	Scanner in = new Scanner(System.in);

	/**
	 * constructor to initialize all characteristics for level two spaceship
	 * sets one of each equipments to level two
	 * 
	 * @param members
	 *            - list of members
	 * @param food
	 *            - list of foods
	 */
	public LevelTwo(ArrayList<Creature> members, ArrayList<Food> food) {
		super("Level Two", 2, 125, members, food, 50, 200);
		partsInUse[0] = new Cannon(2);
		partsInUse[1] = new Barrier(2);
		partsInUse[2] = new Hyperdrive(2);
		partsInUse[3] = new PowerFluxCapacitator(2);
		partsInUse[4] = new FulstarPlate(2);
		partsInUse[5] = new Laser(2);
		super.setPartsInUse(partsInUse);
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
	 * method to print health of each equipment
	 */
	public void healthReport() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 7; i++) {
			System.out.println("Health of part " + (i + 1) + partsInUse[i].toString() + partsInUse[i].getHealthBar());
		}
	}

	/**
	 * method to replace equipments with spare ones
	 */
	public void fixEquipment() {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
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
	 * @return true if upgradeable, false otherwise
	 */
	public boolean canUpgrade() {
		int cannonCounter = 0;
		int barrierCounter = 0;
		int fpCounter = 0;
		int hdCounter = 0;
		int laserCounter = 0;
		int pfcCounter = 0;
		ArrayList<Equipment> spares = getSpareEquipment();
		for (int i = 0; i < spares.size(); i++) {
			if (spares.get(i) instanceof Cannon) {
				cannonCounter++;
			}
			if (spares.get(i) instanceof Barrier) {
				barrierCounter++;
			}
			if (spares.get(i) instanceof FulstarPlate) {
				fpCounter++;
			}
			if (spares.get(i) instanceof Hyperdrive) {
				hdCounter++;
			}
			if (spares.get(i) instanceof Laser) {
				laserCounter++;
			}
			if (spares.get(i) instanceof PowerFluxCapacitator) {
				pfcCounter++;
			}
		}
		if (cannonCounter >= 2 && barrierCounter >= 2 && fpCounter >= 2 && hdCounter >= 2 && laserCounter >= 2
				&& pfcCounter >= 2) {
			return true;
		}
		return false;
	}

}