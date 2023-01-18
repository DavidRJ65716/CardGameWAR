package main.java.game.view;

/**
 * Print a Three Player game
 * @author David Jackson
 */
public class ThreePlayerView{

	public ThreePlayerView(int seed) {

		System.out.println("Version 3 is Picked.");
		System.out.println("Seed:" + seed);
	}
	
	public void printNormaBoard(String playerOneRank, String playerOneSuit, String playerTwoRank, 
			String playerTwoSuit, String playerThreeRank, String playerThreeSuit, int winner, int playerOneScore, int playerTwoScore, int playerThreeScore) {
		
		System.out.println("Player 1 plays " + playerOneRank + " of " + playerOneSuit);
		System.out.println("Player 2 plays " + playerTwoRank + " of " + playerTwoSuit);
		System.out.println("Player 3 plays " + playerThreeRank + " of " + playerThreeSuit);
		System.out.println("Player " + winner + " wins the round");
		System.out.println("Player 1 has a score of " + playerOneScore);
		System.out.println("Player 2 has a score of " + playerTwoScore);
		System.out.println("Player 3 has a score of " + playerThreeScore);
	}
	
	public void printPreWarBoard(String playerOneRank, String playerOneSuit, String playerTwoRank, 
			String playerTwoSuit, String playerThreeRank, String playerThreeSuit) {
		System.out.println("Player 1 plays " + playerOneRank + " of " + playerOneSuit);
		System.out.println("Player 2 plays " + playerTwoRank + " of " + playerTwoSuit);
		System.out.println("Player 3 plays " + playerThreeRank + " of " + playerThreeSuit);
	}
	
	public void printWarBoard(String playerOneRank, String playerOneSuit, String playerTwoRank, 
			String playerTwoSuit, String playerThreeRank, String playerThreeSuit, 
			int winner, int playerOneScore, int playerTwoScore, int playerThreeScore) {
		
		System.out.println("*** WAR! ***");
		System.out.println("Player 1 plays " + playerOneRank + " of " + playerOneSuit);
		System.out.println("Player 2 plays " + playerTwoRank + " of " + playerTwoSuit);
		System.out.println("Player 3 plays " + playerThreeRank + " of " + playerThreeSuit);
		System.out.println("Player " + winner + " wins the round");
		System.out.println("Player 1 has a score of " + playerOneScore);
		System.out.println("Player 2 has a score of " + playerTwoScore);
		System.out.println("Player 3 has a score of " + playerThreeScore);
	}
	
	public void printFailedWar() {
		
		System.out.println("*** WAR Failed! ***");
		System.out.println("Cards are returned");
	}

	public void printGameOver(int winner, int playerOneScore, int playerTwoScore, int playerThreeScore) {
		
		System.out.println("Game Over!");
		if(winner == 0) {
			System.out.println("Game is a Tie");
		} else {
			System.out.println("Player " + winner + " wins the Game");
		}
		System.out.println("Player 1 has a score of " + playerOneScore);
		System.out.println("Player 2 has a score of " + playerTwoScore);
		System.out.println("Player 3 has a score of " + playerThreeScore);
		
	}	
}
