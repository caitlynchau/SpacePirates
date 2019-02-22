import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

import creatures.*;
import equipment.*;
import food.*;
import scenarios.*;
import spaceships.*;

/**
 * class that creates a merchant that allows the player to buy food when the player
 * encounters a merchant during game
 */
public class Merchant {
	Scanner in;

	/**
	 * constructor to create merchant from user input
	 */
	public Merchant() {
		in = new Scanner(System.in);
	}

	/**
	 * method to buy randomized food and equipments
	 * @param myShip - spaceship
	 */
	public void buy(Spaceship myShip){
		//only has 5 random items (2 food and 3 equipment)
		Random rand = new Random();
		if(rand.nextInt(2) == 1) {
			ArrayList<Food> food = initializeFoods();
			ArrayList<Equipment> equip = initializeEquipment();
			Food f1 = food.get((int)(Math.random() * food.size()));
			Food f2 = food.get((int)(Math.random() * food.size()));
			Equipment e1 = equip.get((int)(Math.random() * equip.size()));
			Equipment e2 = equip.get((int)(Math.random() * equip.size()));
			Equipment e3 = equip.get((int)(Math.random() * equip.size()));
			Object[] forSale = {f1, f2, e1, e2, e3};
			System.out.println("\nYou have encountered a merchant cruiser.\n"
					+ "\nWould you like to buy anything?");
			String answer = in.next();
			answer = answer.toLowerCase();
			while (!(answer.equals("no")) && !(answer.equals("yes"))){
				System.out.println("Enter yes or no. Would you like to buy anything? ");
				answer = in.next();
				answer = answer.toLowerCase();
			}
			if (answer.equals("no")){
				System.out.println("\nYou do not buy anything.");
			}else if (answer.equals("yes")){
				System.out.println("\nYou have $" + myShip.getMoney());
				System.out.println("(1) " + f1.toString() + " - $" + f1.getPrice());
				System.out.println("(2) " + f2.toString() + " - $" + f2.getPrice());
				System.out.println("(3) " + e1.toString() + " - $" + e1.getPrice());
				System.out.println("(4) " + e2.toString() + " - $" + e2.getPrice());
				System.out.println("(5) " + e3.toString() + " - $" + e3.getPrice());
				System.out.println("0 to exit");
				System.out.print("You can only buy one item. What would you like to buy? (Enter the number) ");
				int item = 999;
				while (item != 1 && item != 2 && item != 3 && item != 4 && item != 5 && item != 0){
					System.out.println("Please enter a number from 0 to 5");
					while (!in.hasNextInt()){
						in.next();
						System.out.println("Please enter a number from 0 to 5");
					}
					item = in.nextInt();
				}
				if (item == 0){
					System.out.println("Goodbye");
				}else if (item == 1 || item == 2){ 
					int price = ((Food)forSale[item - 1]).getPrice(); //downcasting
					String name = ((Food)forSale[item - 1]).toString();
					if (myShip.getMoney() >= price){
						myShip.setMoney(myShip.getMoney() - price);
						myShip.getFoodInv().add(((Food)forSale[item - 1]));
						System.out.println("\nYou purchased a " + name + ". You have $" + myShip.getMoney() + " left");
					}else{
						System.out.println("\nYou cannot afford that item.");
					}
				}else if (item == 3 || item == 4 || item == 5){
					int price = ((Equipment)forSale[item - 1]).getPrice();
					String name = ((Equipment)forSale[item - 1]).toString();
					if (myShip.getMoney() >= price){
						myShip.setMoney(myShip.getMoney() - price);
						myShip.addSpareEquipment((Equipment) forSale[item - 1]);
						System.out.println("\nYou purchased a " + name + ". You have $" + myShip.getMoney() + " left");
					}else{
						System.out.println("\nYou cannot afford that item.");
					}

				}
			}
		}
	}

	/**
	 * method to initialize list of food to buy
	 * @return list of food
	 */
	private ArrayList<Food> initializeFoods(){
		ArrayList<Food> foodList = new ArrayList<Food>();
		foodList.add(new PickleJuiceJar());
		foodList.add(new GranolaBar());
		foodList.add(new AlienMeat());
		return foodList;
	}

	/**
	 * method to initialize list of equipments to buy
	 * @return list of equipments
	 */
	private ArrayList<Equipment> initializeEquipment(){  
		ArrayList<Equipment> equipmentList = new ArrayList<Equipment>();
		equipmentList.add(new Laser(1));
		equipmentList.add(new Cannon(1));
		equipmentList.add(new Hyperdrive(1));
		equipmentList.add(new Barrier(1));
		equipmentList.add(new FulstarPlate(1));
		equipmentList.add(new PowerFluxCapacitator(1));
		return equipmentList;
	}

}