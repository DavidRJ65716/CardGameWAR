package main.java.game.view;
/**
 * Prints 2 Player game
 * @author David Jackosn
 */
public class TwoPlayerView{

	public TwoPlayerView(int seed) {

		System.out.println("Version 2 is Picked.");
		System.out.println("Seed:" + seed);
	}
	
	public void printNormaBoard(String playerOneRank, String playerOneSuit, String playerTwoRank, 
			String playerTwoSuit, int winner, int playerOneScore, int playerTwoScore) {
		
		System.out.println("Player 1 plays " + playerOneRank + " of " + playerOneSuit);
		System.out.println("Player 2 plays " + playerTwoRank + " of " + playerTwoSuit);
		System.out.println("Player " + winner + " wins the round");
		System.out.println("Player 1 has a score of " + playerOneScore);
		System.out.println("Player 2 has a score of " + playerTwoScore);
	}
	
	public void printPreWarBoard(String playerOneRank, String playerOneSuit, String playerTwoRank, 
			String playerTwoSuit) {
		System.out.println("Player 1 plays " + playerOneRank + " of " + playerOneSuit);
		System.out.println("Player 2 plays " + playerTwoRank + " of " + playerTwoSuit);
	}
	
	public void printWarBoard(String playerOneRank, String playerOneSuit, String playerTwoRank, 
			String playerTwoSuit, int winner, int playerOneScore, int playerTwoScore) {
		
		System.out.println("*** WAR! ***");
		System.out.println("Player 1 plays " + playerOneRank + " of " + playerOneSuit);
		System.out.println("Player 2 plays " + playerTwoRank + " of " + playerTwoSuit);
		System.out.println("Player " + winner + " wins the round");
		System.out.println("Player 1 has a score of " + playerOneScore);
		System.out.println("Player 2 has a score of " + playerTwoScore);
	}
	
	public void printFailedWar() {
		
		System.out.println("*** WAR Failed! ***");
		System.out.println("Cards are returned");
	}

	public void printGameOver(int winner, int playerOneScore, int playerTwoScore) {
		
		System.out.println("Game Over!");
		if (winner == 0) {
			System.out.println("The Game is a Tie");
		} else {
			System.out.println("Player " + winner + " wins the Game");
		}
		System.out.println("Player 1 has a score of " + playerOneScore);
		System.out.println("Player 2 has a score of " + playerTwoScore);
	}	
}


