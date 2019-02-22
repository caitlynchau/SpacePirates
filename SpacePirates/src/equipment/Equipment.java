package equipment;

import creatures.*;
import food.*;
import spaceships.*;
import scenarios.*;

/**
 * abstract class that sets up the characteristics for different equipments
 */
public abstract class Equipment {
	private int healthBar; // current status of health bar
	private int maxHealth; // maximum health bar from the start of the game
	private int price; // price of the equipment
	private String name; // name of the equipment

	/**
	 * constructor to set name, status for health bar, maximum health, and price
	 * 
	 * @param n
	 *            - name of the equipment
	 * @param myHealthBar
	 *            - health status
	 * @param maxHealth
	 *            - maximum health
	 * @param price
	 *            - price of the equipment
	 */
	public Equipment(String n, int myHealthBar, int maxHealth, int price) {
		name = n;
		healthBar = myHealthBar;
		this.maxHealth = maxHealth;
		this.price = price;
	}

	/**
	 * method to set health bar
	 * 
	 * @param healthBar
	 *            - health status of the equipment
	 */
	public void setHealthBar(int healthBar) {
		this.healthBar = healthBar;
	}

	/**
	 * method to return health bar
	 * 
	 * @return health status
	 */
	public int getHealthBar() {
		return healthBar;
	}

	/**
	 * method to return maximum health
	 * 
	 * @return maximum health
	 */
	public int getMaxHealth() {
		return maxHealth;
	}

	/**
	 * method to set the name of the equipment
	 * 
	 * @param n
	 *            - name of the equipment
	 */
	public void setName(String n) {
		name = n;
	}

	/**
	 * method to return the name of the equipment
	 * 
	 * @return name of the equipment
	 */
	public String toString() {
		return name;
	}

	/**
	 * method to set price of the equipment
	 * 
	 * @param p
	 *            - price of the equipment
	 */
	public void setPrice(int p) {
		price = p;
	}

	/**
	 * method to return the price of the equipment
	 * 
	 * @return price of the equipment
	 */
	public int getPrice() {
		return price;
	}
}