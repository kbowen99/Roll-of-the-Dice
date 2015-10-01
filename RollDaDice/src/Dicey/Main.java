package Dicey;

import java.util.Scanner;

public class Main {

	//Test
	private static Scanner in = new Scanner(System.in);
	static String versionNum = "0.0.3";
	
	public static void main(String[] args) {

		Dice dies = new Dice(); //Make some dice
		
		System.out.println(dies.beNice(versionNum)); //greet the user
		
		String userStatement = in.nextLine(); //listen to what the user is saying
		
		//Do Things till Nothing is entered
		while (!userStatement.equalsIgnoreCase("")) {
			System.out.println(dies.doMagicalDice(userStatement));
			userStatement = in.nextLine();
		}
	}

}
