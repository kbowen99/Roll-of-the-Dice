package Dicey;

public class Dice {
	
	
	
	int dieSides = 12;
	int dieRolls[] = new int[13];
	String Graph[][] = new String[dieSides][dieSides] ;
	
	String beNice(String ver) {
		return "Welcome to Roll of a Dice V" + ver + " Please enter the amount of rolls you would like to simulate";
	}
	
	String doMagicalDice(String userS) {
		
		dumpDaGraph1();
		
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

		
		int highest = 0;
		
		for (int i =0; i< dieRolls.length; i++) {
			if(dieRolls[i] > highest) {
				highest = dieRolls[i];
			}
		}
		
		//int divisidor = (int)(rolls / highest);
		
		double[] doMagic = new double[13];
		
		for (int i=0; i<dieRolls.length; i++) {
			doMagic[i] = (int)(((double)dieRolls[i] / (double)highest) * 100.0);
		}

		for(int i = 0; i < dieRolls.length; i++) {
			System.out.print(i + ": ");
			for(int j = 0; j < ((int)doMagic[i]); j++) {
				System.out.print("X");
			}
			System.out.println("");
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
	
	void dumpDaGraph1() {
		for(int i=0; i<dieRolls.length; i++){
			dieRolls[i] = 0;
	}
}
}
