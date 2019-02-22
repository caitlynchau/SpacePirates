package scenarios;
import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * BlackHole is a Scenario in which the spaceship gets sucked into a black hole.
 * The spaceship loses all its crew members, food, and equipment. The game is
 * basically over.
 */
public class BlackHole extends Scenario{

	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public BlackHole() {
		super("You have run straight into a black hole. Everyone has died. Your ship and\n"
				+ " everything in it has been reduced to dust.\n");
	}
	
	/**
	 * consequence method removes all of the ship's crew members, equipment, and
	 * food.
	 * 
	 * @param myShip
	 *            - current spaceship
	 */
	public void consequence(Spaceship myShip){
		//delete all inventory and crew members
		myShip.getCrewMembers().clear();
		myShip.getSpareEquipment().clear();
		myShip.getFoodInv().clear();
	}
}