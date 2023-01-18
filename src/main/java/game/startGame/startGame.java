package main.java.game.startGame;

import main.java.game.control.*;

public class startGame {
		
	/**
	 * Main Function
	 * @param args
	 */
	public static void main(String[] args) {
		
		if(args.length <= 0) {
			
			System.out.println("No Argumet ending program");
			System.exit(0);
		}
		
		if(args[0].equals("1")) {
			
			TwoPlayerLimitedControl newGame = new TwoPlayerLimitedControl(Integer.parseInt(args[2]), Integer.parseInt(args[1]));
			newGame.gameLoop();
			
		} else if (args[0].equals("2")) {
			
			TwoPlayerControl newGame = new TwoPlayerControl(Integer.parseInt(args[1]));
			newGame.gameLoop();
		} else if (args[0].equals("3")) {
			
			ThreePlayerControl newGame = new ThreePlayerControl(Integer.parseInt(args[1]));
			newGame.gameLoop();
		} else {
			System.out.println(args[0] + " - is not recognized");
			System.exit(0);
		}
	}
}
