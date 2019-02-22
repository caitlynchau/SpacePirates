package scenarios;
import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * FoodPoisoning is a Scenario in which one of the crew members dies from a
 * contaminated alien meat
 */
public class FoodPoisoning extends Scenario {

	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public FoodPoisoning() {
		super("Oh no! One of your crew members has died from contaminated alien meat.\n");
	}

	/**
	 * consequence method removes one person from the crew and prints out the
	 * remaining crew
	 * 
	 * @param myShip
	 *            - current spaceship
	 */
	public void consequence(Spaceship myShip) {
		myShip.getCrewMembers().remove(myShip.getCrewMembers().size()-1);
		System.out.print("Your remaining crew: ");
		if(myShip.getCrewMembers().size() > 0) {
			for (int i = 0; i < myShip.getCrewMembers().size() - 1; i++){
				System.out.print(myShip.getCrewMembers().get(i).getMyName() + ", ");
			}
		}
		System.out.println(myShip.getCrewMembers().get(myShip.getCrewMembers().size() - 1).getMyName());

	}

}