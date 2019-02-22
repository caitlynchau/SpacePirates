package scenarios;
import java.util.Random;

import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * Asteroid is a Scenario in which an asteroid crashes into the ship and damages
 * it
 */
public class Asteroid extends Scenario {

	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public Asteroid() {
		super("What was that? An asteroid has just crashed into the ship.");
	}
	
	/**
	 * consequence method damages the ship with a random severity
	 * 
	 * @param myShip
	 *            - current spaceship
	 */
	public void consequence(Spaceship myShip) {
		Random rand = new Random();
		int severity = rand.nextInt(4);
		myShip.damageShip(severity);
	}

}