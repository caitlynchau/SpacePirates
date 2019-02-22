package equipment;

/**
 * Hyperdrive class is a subclass of Equipment
 */
public class Hyperdrive extends Equipment {

	/**
	 * Constructor passes the name of itself, health bar level, and price to
	 * superclass constructor. A newly constructed hyperdrive's health bar
	 * starts at the maximum level. The price of all equipment is $250
	 * 
	 * @param level
	 *            - level of spaceship
	 */
	public Hyperdrive(int level) {
		super("Hyperdrive", healthBarLevel(level), healthBarLevel(level), 250);
	}

	/**
	 * Default constructor passes the name of itself, health bar of level one
	 * ship equipment, and price to the superclass constructor. A newly
	 * constructed hyperdrive's health bar for a level one ship starts at the
	 * maximum level of 100. The price of all equipment is $250
	 */
	public Hyperdrive() {
		super("Hyper Drive", healthBarLevel(1), healthBarLevel(1), 250);
	}

	/**
	 * healthBarLevel method determines the max level of health of the hyper
	 * drive. All levels have a different max health bar level. The max level of
	 * a level one ship is 100, 150 for level two, and 200 for level three
	 * 
	 * @param level
	 *            - level of ship
	 * @return health bar level for that ship
	 */
	public static int healthBarLevel(int level) {
		if (level == 1) {
			return 100;
		}
		if (level == 2) {
			return 150;
		}
		return 200;
	}
}