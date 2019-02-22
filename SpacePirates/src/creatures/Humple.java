package creatures;

import equipment.*;
import food.*;
import scenarios.*;
import spaceships.*;

/**
 * class that sets up characteristics for Humple
 */
public class Humple extends Creature {

	/**
	 * constructor to set name and creature type
	 * 
	 * @param name
	 *            - name of Humple
	 */
	public Humple(String name) {
		super(name);
		setCreatureType("Humple");
	}

	/**
	 * override method to set if Humple is dead
	 */
	public void die() {
		setAlive(false);
		System.out.println();
	}

	/**
	 * override method to set Humple is not sick
	 */
	public void heal() {
		setSick(false);
		System.out.println();
	}

	/**
	 * override method to set Humple is sick
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
	 * override method that creates a new Humple
	 * 
	 * @param c
	 *            - Creature object for new Humple
	 * @param name
	 *            - name of Humple
	 * @return baby - new Humple created
	 */
	public Creature breed(Creature c, String name) {
		// TODO Auto-generated method stub
		Creature baby = new Humple(name);
		return baby;
	}

}