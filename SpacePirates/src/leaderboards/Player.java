package leaderboards;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Player{
    private String name;
    private int score;
    private ArrayList<Comparable> scores;
    
    /**
     * Constructor to create a player object
     * @param n - name of player
     */
    public Player(String n, int i){
    	scores = new ArrayList<Comparable>();
    	name = n;
        scores.add(i);
    }

	/**
	 * inserts a score for a new player
	 * @param n - score of new player
	 * @param s - name of player
	 */
	public void insertScore(String s, int n){
       try {
    	File f1 = new File("LeaderboardFile");
		FileWriter f = new FileWriter(f1, true);
		f.write(s);
		f.write("\n" + n + "\n");
		f.close();
       } catch (IOException e) {
    	   e.printStackTrace();
       }
    }
	
	/**
	 * adds a new score the the current player
	 * @param n - new score
	 */
	public void addScore(int n) {
		scores.add(n);
	}
    
	/**
	 * Accessor for the name of player
	 * @return name
	 */
    public String getName(){
        return name;
    }
    
    /**
     * Modifier to change name
     * @param str - set the name of the player
     */
    public void setName(String str) {
    	name = str;
    }
    
    /**
     * returns the list of player's scores
     * @return
     */
    public ArrayList<Comparable> getScore() {
    	return scores;
    }
    
    /**
     * gets the score of a player at a certain index
     * @param i - index of desired score
     * @return - score at index i
     */
    public Comparable getScore(int i) {
    	return scores.get(i);
    }
    
    /**
     * gets the top 5 scores of a player from top players
     * @param name of player
     * @return list of top 5 scores
     */
    public ArrayList<Integer> getTopFive(String name) {
    	ArrayList<Integer> allScores = new ArrayList<Integer>();
    	ArrayList<Integer> topFive = new ArrayList<Integer>();
		try {
			File f = new File("LeaderboardFile");
			Scanner in = new Scanner(f);
			while(in.hasNext()) {
				if(in.nextLine().equalsIgnoreCase(name)) {
					allScores.add(in.nextInt());
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Collections.sort(allScores);
		Collections.reverse(allScores);
		if(allScores.size() < 5) {
			for(int i = 0; i < allScores.size(); i++) {
				topFive.add(allScores.get(i));
			}
		}
		if(allScores.size() >= 5) {
			for(int i = 0; i < 5; i++) {
				topFive.add(allScores.get(i));
			}
		}
		return topFive;
    }
    
    /**
     * gets the size of the list
     * @return - amount of times someone's played the game
     */
    public Integer getAmountOfScores() {
    	return scores.size();
    }
	
}