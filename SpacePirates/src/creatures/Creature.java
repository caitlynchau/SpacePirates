package creatures;

import equipment.*;
import food.*;
import scenarios.*;
import spaceships.*;

/**
 * abstract class that sets up the characteristics for different creatures
 */
public abstract class Creature {
	private String myName; // name of the creature
	private String creatureType;
	private boolean isAlive; // records if it is alive
	private boolean isSick; // records if creature is sick
	private int healthBar; // records health of creature

	/**
	 * constructor to set name, isAlive to true, isSick to false, and make the
	 * creature's health to 70
	 * 
	 * @param name
	 *            - name of the creature
	 */
	public Creature(String name) {
		myName = name;
		isAlive = true;
		isSick = false;
		setHealthBar(70);
	}

	/**
	 * abstract method to set if the creature is dead
	 */
	public abstract void die();

	/**
	 * abstract method to set the creature is not sick
	 */
	public abstract void heal();

	/**
	 * abstract method to set the creature is sick
	 */
	public abstract void fallIll();

	/**
	 * abstract method to restore health from consuming food
	 * 
	 * @param f
	 *            - Food object for nourishment
	 */
	public abstract void eat(Food f);

	/**
	 * abstract method to breed an offspring
	 * 
	 * @param c
	 *            - Creature object c for new creature
	 * @param name
	 *            - name of the creature
	 * @return baby - new creature created
	 */
	public abstract Creature breed(Creature c, String name);

	/**
	 * method to return name
	 * 
	 * @return myName - name of the creature
	 */
	public String getMyName() {
		return myName;
	}

	/**
	 * method to set name
	 * 
	 * @param myName
	 *            - name of the creature
	 */
	public void setMyName(String myName) {
		this.myName = myName;
	}

	/**
	 * method to check if the creature is alive
	 * 
	 * @return isAlive - true if alive, false otherwise
	 */
	public boolean isAlive() {
		return isAlive;
	}

	/**
	 * method to set if the creature is alive
	 * 
	 * @param isAlive
	 *            - true if alive, false otherwise
	 */
	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}

	/**
	 * method to check if the creature is sick
	 * 
	 * @return isSick - true if sick, false otherwise
	 */
	public boolean isSick() {
		return isSick;
	}

	/**
	 * method to set if the creature is sick
	 * 
	 * @param isSick
	 *            - true if sick, false, otherwise
	 */
	public void setSick(boolean isSick) {
		this.isSick = isSick;
	}

	/**
	 * method to return health bar
	 * 
	 * @return healthbar - health of the creature
	 */
	public int getHealthBar() {
		return healthBar;
	}

	/**
	 * method to set health bar from the nourishment
	 * 
	 * @param nourishmentLevel
	 *            - health gained from nourishment
	 */
	public void setHealthBar(int nourishmentLevel) {
		this.healthBar = nourishmentLevel;
	}

	/**
	 * method to return the name of the creature
	 * 
	 * @return name of creature
	 */
	public String toString() {
		return creatureType;
	}

	/**
	 * method to set the creature type
	 * 
	 * @param str
	 *            - creature type
	 */
	public void setCreatureType(String str) {
		creatureType = str;
	}

}