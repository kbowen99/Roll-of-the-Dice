package Dicey;

import java.math.BigInteger;

public class Dice {
	
	//Variables
	int dieSides = 12;
	int dieRolls[] = new int[13];
	String Graph[][] = new String[dieSides][dieSides] ;
	
	String beNice(String ver) {
		//Be Nice to user
		return "Welcome to Roll of a Dice V" + ver + " Please enter the amount of rolls you would like to simulate";
	}
	
	String doMagicalDice(String userS) {
		
		dumpDaGraph1(); //Clear array so code can be ran multiple times
		
		BigInteger rolls = new BigInteger(Integer.toString(0)); //init tmp roll var
		
		//Dumb User Check/Protection
		try {
			rolls = new BigInteger(userS);
		} catch (NumberFormatException e) {
			return "'" + userS + "' Was Not a Valid int; We're blaming you";
		}
		
		//Actual Rolling of dice
		for(BigInteger i = new BigInteger(Integer.toString(0)); i.compareTo(rolls) < 0; i=i.add(new BigInteger("1"))){
			int tmpRoll = rollDie();
			dieRolls[tmpRoll] = dieRolls[tmpRoll] + 1;
			//System.out.println(i.toString());
		}

		//Find Highest amount of rolls
		int highest = 0;
		for (int i =0; i< dieRolls.length; i++) {
			if(dieRolls[i] > highest) {
				highest = dieRolls[i];
			}
		}
		
		//Calculate percentages for graph
		double[] doMagic = new double[13];
		for (int i=0; i<dieRolls.length; i++) {
			doMagic[i] = (int)(((double)dieRolls[i] / (double)highest) * 100.0);
		}

		//print the graph (Sloppy but works)
		for(int i = 0; i < dieRolls.length; i++) {
			//Proper spacing
			if (i<10){
				System.out.print(i + ":  ");
			} else {
				System.out.print(i + ": ");
			}
			for(int j = 0; j < ((int)doMagic[i]); j++) {
				System.out.print("X");
			}
			System.out.println("");
		}
		
		//Simple Debug with actual Numbers
		String tmpOut = "";
		for(int i=0; i<dieRolls.length; i++) {
			tmpOut = tmpOut + " " + i + ": " + dieRolls[i] + ", ";
		}
		return tmpOut;
	}
	
	int rollDie() {
		//Guess What this Does. it Rolls 2 Die
		return ((int)(Math.random() * 6) + (int)(Math.random() * 6) + 2);
	}
	
	void dumpDaGraph1() {
		//dumps da Rolls
		for(int i=0; i<dieRolls.length; i++){
			dieRolls[i] = 0;
		}
	}
}
