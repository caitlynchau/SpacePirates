package scenarios;
import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * Mutiny is a Scenario in which there has been a revolt between crew members on
 * the ship. A random number of members die and prints out the remaining members
 */
public class Mutiny extends Scenario{

	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public Mutiny() {
		super("Mutiny! There has been a revolt between crew members!");
	}

	/**
	 * Consequence method removes a random number of crew members from the
	 * spaceship and prints out the remaining members
	 */
	public void consequence(Spaceship myShip){
		int numDeath = (int)(Math.random() * myShip.getCrewMembers().size()) + 1;
		System.out.println(numDeath + " crew members have died");
		for (int i = 0; i < numDeath; i++){
			myShip.getCrewMembers().remove(myShip.getCrewMembers().size()-1);
		}
		System.out.print("Your remaining crew: ");
		for (int i = 0; i < myShip.getCrewMembers().size() - 1; i++){
			System.out.print(myShip.getCrewMembers().get(i).getMyName() + ", ");
		}
		if(myShip.getCrewMembers().size() > 0) {
			System.out.println(myShip.getCrewMembers().get(myShip.getCrewMembers().size() - 1).getMyName() + "\n");
		}else {
			System.out.println("Wait... They've all died...");
		}
	}
}