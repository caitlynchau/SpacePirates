package scenarios;

import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * Fire is a scenario in which a fire somehow starts in space and burns 75% of
 * the food supply
 */
public class Fire extends Scenario {

	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public Fire() {
		super("A fire has started inside your ship! 75% of your food supply has been burned.\n");
	}

	/**
	 * consequence method removes 75% of the spaceship's food inventory
	 * 
	 * @param myShip
	 *            - current spaceship
	 */
	public void consequence(Spaceship myShip) {
		int foodLeft = (int) (myShip.getFoodInv().size() * .25);
		for (int i = myShip.getFoodInv().size() - 1; i > foodLeft; i--) {
			myShip.getFoodInv().remove(i);
		}
	}
}