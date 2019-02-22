package leaderboards;
import java.io.File;
import java.util.*;

public class Leaderboard {
	private ArrayList<Player> highScores;

	/**
	 * Constructor initializing highScores
	 */
	public Leaderboard() {
		highScores = new ArrayList<Player>();
	}

	/**
	 * fills highScores list with the file
	 */
	public void addToList() {
		try {
			File f = new File("LeaderboardFile");
			Scanner in = new Scanner(f);
			while (in.hasNext()) {
				String name = in.next();
				int score = in.nextInt();
				Player tester = new Player(name, score);
				highScores.add(tester);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}
	 /**
	  * gets the highest score within the file
	  * @return the highest score
	  */
	public int getTopScore() {
		int max = 0;
		for (int i = 0; i < highScores.size(); i++) {
			if (highScores.get(i).getScore(0).compareTo(max) > 0) {
				max = (int) highScores.get(i).getScore(0);
			}

		}
		return max;
	}

	/**
	 * gets the all the people who've acheived the top score
	 * @return names of people with top score
	 */
	public String getTopScorers() {
		String names = "";
		int highest = getTopScore();
		for (int i = 0; i < highScores.size(); i++) {
			for (int j = 0; j < highScores.get(i).getAmountOfScores(); j++) {
				if (highScores.get(i).getScore(0).compareTo(highest) == 0
						&& names.indexOf(highScores.get(i).getName()) == -1) {
					names += highScores.get(i).getName() + " ";
				}
			}
		}
		return names;
	}

	/**
	 * Prints out the top scorers
	 */
	public void printScores() {
		System.out.println("Leaderboards: ");
		System.out.println("People with top score -> " + getTopScorers());
		System.out.println("Top score -> " + getTopScore());				
	}
}