package Dicey;

public class Dice {
	
	//test 
	
	int dieSides = 12;
	int dieRolls[] = new int[13];
	String Graph[][] = new String[dieSides][dieSides] ;
	
	String beNice(String ver) {
		return "Welcome to Roll of a Dice V" + ver + " Please enter the amount of rolls you would like to simulate";
	}
	
	String doMagicalDice(String userS) {
		int rolls = 0;
		
		try {
			rolls = Integer.parseInt(userS);
		} catch (NumberFormatException e) {
			return "'" + userS + "' Was Not a Valid int; We're blaming you";
		}
		
		for(int i=0; i<rolls; i++){
			int tmpRoll = rollDie();
			dieRolls[tmpRoll] = dieRolls[tmpRoll] + 1;
		}
		
		
		String tmpOut = "";
		
		for(int i=0; i<dieRolls.length; i++) {
			tmpOut = tmpOut + " " + i + ": " + dieRolls[i] + ", ";
		}
		return tmpOut;
	}
	
	int rollDie() {
		return ((int)(Math.random() * 6) + (int)(Math.random() * 6) + 2);
	}
}
