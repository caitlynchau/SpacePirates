package scenarios;
import java.util.*;
import creatures.*;
import equipment.*;
import food.*;
import spaceships.*;

/**
 * Scenario class - abstract class for all scenarios. Scenarios are random
 * situations that occur during the game. Each scenario has a different action
 * that may require the user to do something, or the scenario will simply play
 * out by itself. They may help or delay the spaceship in its mission to Pluto
 */
public abstract class Scenario{
	private String description; //description of scenario
	protected ArrayList<Food> foodList; //list of all available food items
	protected ArrayList<Equipment> equipmentList; //list of all available equipment
	
	/**
	 * Constructor to initialize description of scenario and lists of food and
	 * equipment for some scenarios that require an addition or remove of a
	 * random object
	 * 
	 * @param d
	 *            - description of scenario
	 */
	public Scenario(String d){
		description = d;
		initializeFoods();
		initializeEquipment();
	}
	
	/**
	 * toString method returns the description of the scenario
	 */
	public String toString(){
		return description; 
	}
	
	/**
	 * consequence method - abstract method that displays the results of that
	 * scenario. Consequences remove or damage existing items in spaceship or
	 * add items and money to it
	 * 
	 * @param myShip
	 *            - Spaceship
	 */
	public abstract void consequence(Spaceship myShip);

	/**
	 * initializeFoods - helper method that puts all the food objects in the
	 * game into a single list for scenarios that require picking a random food
	 * item
	 */
	private void initializeFoods(){
		foodList = new ArrayList<Food>();
		foodList.add(new PickleJuiceJar());
		foodList.add(new GranolaBar());
		foodList.add(new AlienMeat());
	}
	
	/**
	 * initializeEquipment - helper method that puts all the equipment objects
	 * in the game into a single list for scenarios that require picking a
	 * random equipment
	 */
	private void initializeEquipment(){ //change parameters 
		equipmentList = new ArrayList<Equipment>();
		equipmentList.add(new Laser());
		equipmentList.add(new Cannon());
		equipmentList.add(new Hyperdrive());
		equipmentList.add(new Barrier());
		equipmentList.add(new FulstarPlate());
		equipmentList.add(new PowerFluxCapacitator());
	}
}