package scenarios;
import java.util.Random;

import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * AbandonedCargo class is a Scenario in which the spaceship finds a cargo hold
 * in space and searches it to find more food and perhaps money.
 */
public class AbandonedCargo extends Scenario {
	Random rand = new Random();
	
	/**
	 * Constructor passes the description to the Scenario superclass
	 */
	public AbandonedCargo() {
		super("You run into an abandoned cargo hold in space and obtain more food");
	}
	
	/**
	 * consequence method adds a random food to the ship's inventory and random
	 * amount of money to the spaceship's funds
	 * 
	 * @param myShip
	 *            - current spaceship
	 */
	public void consequence(Spaceship myShip){
		int index = (int)(Math.random() * foodList.size() - 1); //pick a random food from list
		myShip.getFoodInv().add(foodList.get(index)); //add that food to inventory
		System.out.println("Nice! You found one " + foodList.get(index).toString() + "\n");
		int money = rand.nextInt(100)+10;
		System.out.println("You've found $" + money + "!\n");
		myShip.setMoney(myShip.getMoney()+money);
	}

}