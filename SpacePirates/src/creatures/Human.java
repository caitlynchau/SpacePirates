package creatures;

import equipment.*;
import food.*;
import scenarios.*;
import spaceships.*;

/**
 * class that sets up the characteristics for Human
 */

public class Human extends Creature {

	/**
	 * constructor to set name and creature type
	 * 
	 * @param name
	 *            - name of Human
	 */
	public Human(String name) {
		super(name);
		setCreatureType("Human");
	}

	/**
	 * override method to set if Human is dead
	 */
	public void die() {
		setAlive(false);
		System.out.println();
	}

	/**
	 * override method to set Human is not sick
	 */
	public void heal() {
		// TODO Auto-generated method stub
		setSick(false);
		System.out.println();
	}

	/**
	 * override method to set Human is sick
	 */
	public void fallIll() {
		setSick(true);
		System.out.println();
	}

	/**
	 * override method to restore health from consuming food
	 * 
	 * @param f
	 *            - Food object for nourishment
	 */
	public void eat(Food f) {
		setHealthBar(this.getHealthBar() + f.getNourishmentProvided());
		System.out.println();
	}

	/**
	 * override method to breed an offspring
	 * 
	 * @param c
	 *            - Creature object for new creature
	 * @param name
	 *            - name of the creature
	 * @return baby - new creature created
	 */
	public Creature breed(Creature c, String name) {
		Creature baby = null;
		if (c instanceof Human) {
			baby = new Human(name);
		}
		if (c instanceof Gomple) {
			baby = new Humple(name);
		}
		return baby;
	}

}