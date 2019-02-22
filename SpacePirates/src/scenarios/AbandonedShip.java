package scenarios;
import java.util.Random;

import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * AbandonedShip class is a Scenario in which the spaceship finds an abandoned
 * spaceship and dismantles it for parts.
 */
public class AbandonedShip extends Scenario {
	Random rand = new Random();
	
	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public AbandonedShip(){
		super("You find an abandoned broken ship in space and dismantle it for parts.");
	}
	
	/**
	 * consequence method adds a random equipment to the ship's spare equipment
	 * inventory and random amount of money to the spaceship's funds
	 * 
	 * @param myShip
	 *            - currentSpaceship
	 */
	public void consequence(Spaceship myShip){
		int index = (int)(Math.random() * equipmentList.size() - 1);
		myShip.getSpareEquipment().add(equipmentList.get(index));
		System.out.println("Nice! You found a " + equipmentList.get(index).toString() + "\n");
		int money = rand.nextInt(100)+10;
		System.out.println("You've found $" + money + "!\n");
		myShip.setMoney(myShip.getMoney()+money);
	} 
}