package scenarios;

import spaceships.*;
import java.util.ArrayList;

/**
 * ScenarioRunner class runs all the scenarios in the Game class.
 */
public class ScenarioRunner {

	/**
	 * Constructor initializes a list of Scenarios. The probability of a raid is
	 * 0.35. The probability of the abandoned ship scenario is 0.15. The
	 * probability of the abandoned cargo, pit stop, and mutiny scenario is 0.1.
	 * The probability of the food poisoning scenario is 0.08. The probability
	 * of an asteroid, fire, and scientific breakthrough is 0.05. The
	 * probability of a black hole is 0.01. A random number is generated and the
	 * scenario description and consequence is printed.
	 * 
	 * @param myShip
	 *            - current spaceship
	 * @return random scenario
	 */
	public Scenario runScenario(Spaceship myShip) {
		ArrayList<Scenario> scenarios = new ArrayList<Scenario>(100);
		for (int i = 0; i < 30; i++) {
			scenarios.add(new Raid());
		}
		for (int i = 0; i < 15; i++) {
			scenarios.add(new AbandonedShip());
		}
		for (int i = 0; i < 10; i++) {
			scenarios.add(new AbandonedCargo());
			scenarios.add(new PitStop());
			scenarios.add(new Mutiny());
		}
		for (int i = 0; i < 8; i++) {
			scenarios.add(new FoodPoisoning());
		}
		for (int i = 0; i < 5; i++) {
			scenarios.add(new Asteroid());
			scenarios.add(new Fire());
			scenarios.add(new ScientificBreakthrough());
		}
		for (int i = 0; i < 2; i++) {
			scenarios.add(new BlackHole());
		}
		int index = (int) (Math.random() * 100); // choose a random integer
													// between 0 and 100
		System.out.println(scenarios.get(index).toString());
		scenarios.get(index).consequence(myShip);
		return scenarios.get(index);
	}
}