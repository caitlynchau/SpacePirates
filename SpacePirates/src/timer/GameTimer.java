package timer;
/**
 * class that implements timer in the game
 */
public class GameTimer extends Timer{
	
	/**
	 * default constructor
	 */
	public GameTimer() {
		super();
	}
	
	/**
	 * constructor to interval and duration of the timer
	 * @param l - interval
	 * @param m - duration
	 */
	public GameTimer(long l, long m) {
		// TODO Auto-generated constructor stub
		super(l, m);
	}
	
	/**
	 *	This method is called periodically with the interval set as the delay between subsequent calls. 
	 */
	@Override
	protected void onTick() {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * This method is called once the timer has run for the specified duration. If the duration was set as infinity, then this method is never called.
	 */
	@Override
	protected void onFinish() {
		// TODO Auto-generated method stub
		
	}

}